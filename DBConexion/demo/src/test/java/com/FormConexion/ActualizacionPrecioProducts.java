package com.FormConexion;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class ActualizacionPrecioProducts extends JFrame implements ActionListener{

private Connection conexion; 

private Container container;
private JLabel categoria, porcentaje;
private JComboBox<String> Categorias;
private JTextField PorcentajeField;
private JButton actualizar;

public ActualizacionPrecioProducts(Connection conexion){
    this.conexion = conexion;
    inicio();
    setTitle("Actualización de precios");
    setSize(480,320);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(true);
}
public void inicio(){
    container = this.getContentPane();
    container.setLayout(new BorderLayout(10,10));

    JPanel panelActualizar = new JPanel(new GridLayout(2, 2, 10, 10));
    panelActualizar.setBorder(BorderFactory.createEmptyBorder(20,20,10,20));

    categoria = new JLabel("Categoria: ");
    porcentaje = new JLabel("Porcetanje (%): ");
    
    Categorias = new JComboBox<>();

}

public ArrayList<String> getCategorias(){
    ArrayList <String> cats = new ArrayList<>();
Categorias.removeAllItems();

String sql = "SELECT CategoryName FROM Categories";
try(PreparedStatement prepStatement = this.conexion.prepareStatement(sql);
ResultSet rs = prepStatement.executeQuery()){

while (rs.next()) {
    String categoria = rs.getString(1);
    cats.add(categoria);
    Categorias.addItem(categoria);  
    
}

}catch(SQLException e){
    JOptionPane.showMessageDialog(this, "Error al cargar las categorias: "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
    return cats;
}
//TODO: ActionPerformed ActionListener
}


