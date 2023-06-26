package com.anncode.amazonviewer.dao;

import com.anncode.amazonviewer.db.Database;
import com.anncode.amazonviewer.db.IDBConnection;
import com.anncode.amazonviewer.model.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Es el equivalente a las clases Repository de la actualidad
 */
public interface MovieDAO extends IDBConnection {
    default Movie setMovieViewedStatus(Movie movie) {
        movie.setViewed(Boolean.TRUE);
        return movie;
    }

    default ArrayList<Movie> read() {
        ArrayList<Movie> movies = new ArrayList<>();
        try (Connection connection = connectToDB()) {
            String query = "SELECT * FROM " + Database.MOVIE_TABLE;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                var movie = new Movie(rs.getString(Database.MOVIE_TITLE),
                        rs.getString(Database.MOVIE_GENRE),
                        rs.getString(Database.MOVIE_DIRECTOR),
                        Integer.valueOf(rs.getString(Database.MOVIE_DURATION)),
                        Short.valueOf(rs.getString(Database.MOVIE_YEAR)));
                movie.setId(Integer.valueOf(rs.getString(Database.MOVIE_ID)));
                movies.add(movie);
            }
        } catch (SQLException e) {

        }
        return movies;
    }

    private Boolean getMovieViewedStatus() {
        return Boolean.FALSE;
    }
}
