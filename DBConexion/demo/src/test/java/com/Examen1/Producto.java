package com.Examen1;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Producto {
private int id;
private String nombre;
private double precio;
private int existencias;
public Producto(int id, String nombre, double precio, int existencias) {
    this.id = id;
    this.nombre = nombre;
    this.precio = precio;
    this.existencias = existencias;
}
public int getId() {
    return id;
}
public String getNombre() {
    return nombre;
}
public double getPrecio() {
    return precio;
}
public int getExistencias() {
    return existencias;
}
public void setPrecio(double precio) {
    this.precio = precio;
}
public void setExistencias(int existencias) {
    this.existencias = existencias;
}

}
