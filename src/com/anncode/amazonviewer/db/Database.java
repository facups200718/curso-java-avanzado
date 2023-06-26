package com.anncode.amazonviewer.db;

public class Database {
    public static final String URL = "jdbc:mysql://localhost:3306/";
    public static final String DB = "amazonviewer";
    public static final String USER = "amazonviewer";
    public static final String PASSWORD = "amazonviewer";

    public static final String MOVIE_TABLE = "movie";
    public static final String MOVIE_ID = "id";
    public static final String MOVIE_TITLE = "title";
    public static final String MOVIE_GENRE = "genre";
    public static final String MOVIE_DIRECTOR = "director";
    public static final String MOVIE_DURATION = "duration";
    public static final String MOVIE_YEAR = "year";

    public static final String MATERIAL_TABLE = "material";
    public static final int[] MATERIAL_IDS = {1, 2, 3, 4, 5};

    public static final String USER_TABLE = "user";
    public static final int USER_ID = 1;

    public static final String VIEWED_TABLE = "viewed";
    public static final String VIEWED_MATERIAL_ID = "id_material";
    public static final String VIEWED_ELEMENT_ID = "id_element";
    public static final String VIEWED_USER_ID = "id_user";

}
