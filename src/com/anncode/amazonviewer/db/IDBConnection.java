package com.anncode.amazonviewer.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Objects;

public interface IDBConnection {
    default Connection connectToDB() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                    .getConnection(Database.URL + Database.DB + "?useSSL=false", Database.USER, Database.PASSWORD);
            if (Objects.nonNull(connection)) {
                System.out.println("Se estableció la conexión :)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return connection;
        }
    }
}
