package com.anncode.guitarcatalog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GuitarCatalog {
    public static void main(String[] args) {
        // Conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/catalogo";
        String username = "usuario";
        String password = "contraseña";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Consulta con filtro de usuarios y guitarras premium
            String sql = "SELECT * FROM guitarras WHERE usuario = ? AND premium = ?";

            // Crear PreparedStatement
            PreparedStatement statement = connection.prepareStatement(sql);

            // Asignar valores a los parámetros
            String usuario = "usuario1";
            boolean premium = true;
            statement.setString(1, usuario);
            statement.setBoolean(2, premium);

            // Ejecutar la consulta
            ResultSet resultSet = statement.executeQuery();

            // Procesar los resultados
            while (resultSet.next()) {
                // Obtener los datos de cada fila
                int id = resultSet.getInt("id");
                String marca = resultSet.getString("marca");
                // ... obtener otros campos según la estructura de tu tabla
                System.out.println("ID: " + id + ", Marca: " + marca);
            }

            // Cerrar recursos
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
