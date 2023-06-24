package com.anncode.spotify;

public class Album {
    private String name;
    private String artistName;
    private Integer year;
    private String genre;
    private Album.Song[] songs;

    public Album(String name, String artistName, Integer year, String genre, Album.Song[] songs) {
        this.name = name;
        this.artistName = artistName;
        this.year = year;
        this.genre = genre;
        this.songs = songs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Song[] getSongs() {
        return songs;
    }

    public void setSongs(Song[] songs) {
        this.songs = songs;
    }

    public static class Song {
        private String name;
        private Integer lengthInSeconds;
        private String lyrics;

        public Song(String name, Integer lengthInSeconds, String lyrics) {
            this.name = name;
            this.lengthInSeconds = lengthInSeconds;
            this.lyrics = lyrics;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getLengthInSeconds() {
            return lengthInSeconds;
        }

        public void setLengthInSeconds(Integer lengthInSeconds) {
            this.lengthInSeconds = lengthInSeconds;
        }

        public String getLyrics() {
            return lyrics;
        }

        public void setLyrics(String lyrics) {
            this.lyrics = lyrics;
        }
    }
}
