package com.FormConexion;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class FormConexion extends JFrame implements ActionListener{

private Container container;
private JLabel user, pw, port, adress;
private JTextField userField, pwField, portField, adressField;
private JButton connect, muestraTabla, actualizarPrecioProducto;

public FormConexion(){
    inicio();
    setTitle("Conexión bases de datos");
    setSize(480,320);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(true);
}

private void inicio(){
    container = getContentPane();
    container.setLayout(null);

    // --- COLUMNA IZQUIERDA: LABELS (1 al 4) ---
    user = new JLabel("Usuario:");
    user.setBounds(20, 25, 90, 25); // 1
    container.add(user);

    pw = new JLabel("Contraseña:");
    pw.setBounds(20, 65, 90, 25); // 2
    container.add(pw);

    port = new JLabel("Puerto:");
    port.setBounds(20, 105, 90, 25); // 3
    container.add(port);

    adress = new JLabel("Servidor:");
    adress.setBounds(20, 145, 90, 25); // 4
    container.add(adress);


    // --- COLUMNA DERECHA: TEXTFIELDS (5 al 8) ---
    userField = new JTextField();
    userField.setBounds(120, 25, 155, 25); // 5
    container.add(userField);

    pwField = new JTextField(); // (O JPasswordField)
    pwField.setBounds(120, 65, 155, 25); // 6
    container.add(pwField);

    portField = new JTextField();
    portField.setBounds(120, 105, 155, 25); // 7
    container.add(portField);

    adressField = new JTextField();
    adressField.setBounds(120, 145, 155, 25); // 8
    container.add(adressField);


    // --- PARTE INFERIOR: DESPLEGABLE (9) Y BOTÓN CONECTAR (10) ---
    // (Asegúrate de declarar arriba tu JComboBox, ej: private JComboBox<String> comboBasesDatos;)
    JComboBox<String> comboBasesDatos = new JComboBox<>();
    comboBasesDatos.setBounds(20, 190, 255, 25); // 9
    container.add(comboBasesDatos);

    connect = new JButton("Conectar");
    connect.setBounds(20, 225, 255, 30); // 10
    container.add(connect);


    // --- ZONA LATERAL DERECHA: VENTANA SECUNDARIA (11) Y TABLAS (12) ---
    JButton btnNorthwind = new JButton("Ventana Northwind");
    btnNorthwind.setBounds(295, 190, 150, 30); // 11
    btnNorthwind.setEnabled(false); // Desactivado por defecto hasta que sea Northwind
    container.add(btnNorthwind);

    muestraTabla = new JButton("Mostrar Tablas");
    muestraTabla.setBounds(295, 225, 150, 30); // 12
    container.add(muestraTabla);
}



}