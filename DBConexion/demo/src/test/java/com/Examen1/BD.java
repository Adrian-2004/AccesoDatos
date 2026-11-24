package com.Examen1;
import java.sql.*;
public class BD {
public static Connection abrir() throws SQLException {
    String url = "jdbc:mysql://localhost:3306/northwind";
    String usuario = "root";
    String contraseña = "";
    return DriverManager.getConnection(url, usuario, contraseña);
}
}
