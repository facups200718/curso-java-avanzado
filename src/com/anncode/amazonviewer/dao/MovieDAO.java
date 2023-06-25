package com.anncode.amazonviewer.dao;

import com.anncode.amazonviewer.model.Movie;

import java.util.ArrayList;

public interface MovieDAO {
    default Movie setMovieViewedStatus(Movie movie) {
        movie.setViewed(Boolean.TRUE);
        return movie;
    }

    default ArrayList<Movie> read() {
        ArrayList<Movie> movies = new ArrayList<>();
        return movies;
    }

    private Boolean getMovieViewedStatus() {
        return Boolean.FALSE;
    }
}
