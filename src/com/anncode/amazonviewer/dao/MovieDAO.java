package com.anncode.amazonviewer.dao;
import com.anncode.amazonviewer.db.IDBConnection;
import com.anncode.amazonviewer.model.Movie;
import com.anncode.util.AmazonUtil;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static com.anncode.amazonviewer.db.Database.*;

/**
 * Es el equivalente a las clases Repository de la actualidad
 */
public interface MovieDAO extends IDBConnection {

    default void setMovieViewedStatus(Movie movie) {
        try (Connection connection = connectToDB()) {
            Statement statement = connection.createStatement();
            String query = "INSERT INTO " + VIEWED_TABLE + "("
                    + VIEWED_MATERIAL_ID + ", " + VIEWED_ELEMENT_ID + ", " + VIEWED_USER_ID + ", " + VIEWED_DATE + ") "
                    + "VALUES(" + MATERIAL_IDS[0] + ", " + movie.getId() + ", " + USER_ID + ", NOW())";
            if (statement.executeUpdate(query) > 0) {
                System.out.println("La película ha sido seteada como vista");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    default ArrayList<Movie> read() {
        ArrayList<Movie> movies = new ArrayList<>();
        try (Connection connection = connectToDB()) {
            String query = "SELECT * FROM " + MOVIE_TABLE;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                var movie = new Movie(rs.getString(MOVIE_TITLE),
                        rs.getString(MOVIE_GENRE),
                        rs.getString(MOVIE_DIRECTOR),
                        Integer.valueOf(rs.getString(MOVIE_DURATION)),
                        Short.valueOf(rs.getString(MOVIE_YEAR)));
                movie.setId(Integer.valueOf(rs.getString(MOVIE_ID)));
                if (getMovieViewedStatus(preparedStatement, connection, movie.getId())) {
                    movie.setViewed(Boolean.TRUE);
                    movie.setDateTimeViewed(getDateTimeViewed(preparedStatement, connection, movie.getId()));
                } else {
                    movie.setViewed(Boolean.FALSE);
                }
                movies.add(movie);
            }
        } catch (SQLException e) {

        }
        return movies;
    }

    private Timestamp getDateTimeViewed(PreparedStatement preparedStatement, Connection connection, int movieId) {
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM " + VIEWED_TABLE + " WHERE " + VIEWED_MATERIAL_ID + " = ? "
                    + "AND " + VIEWED_ELEMENT_ID + " = ? AND " + VIEWED_USER_ID + " = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, MATERIAL_IDS[0]);
            preparedStatement.setInt(2, movieId);
            preparedStatement.setInt(3, USER_ID);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return Timestamp.valueOf(rs.getString(VIEWED_DATE));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Boolean getMovieViewedStatus(PreparedStatement preparedStatement, Connection connection, int movieId) {
        Boolean viewedStatus = Boolean.FALSE;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM " + VIEWED_TABLE + " WHERE " + VIEWED_MATERIAL_ID + " = ? "
                    + "AND " + VIEWED_ELEMENT_ID + " = ? AND " + VIEWED_USER_ID + " = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, MATERIAL_IDS[0]);
            preparedStatement.setInt(2, movieId);
            preparedStatement.setInt(3, USER_ID);
            rs = preparedStatement.executeQuery();
            viewedStatus = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return viewedStatus;
    }
}
