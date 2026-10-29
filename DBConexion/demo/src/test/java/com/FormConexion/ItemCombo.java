package com.FormConexion;

public class ItemCombo {

    private int id;
    private String nombre;

    public ItemCombo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    // Esto es lo que el JComboBox muestra automáticamente por pantalla
    @Override
    public String toString() {
        return nombre;
    }
}

