package com.FormConexion;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class FormConexion extends JFrame implements ActionListener {

    private Container container;
    private JLabel user, pw, port, adress;
    private JTextField userField, pwField, portField, adressField;
    private JButton connect, muestraTabla, btnActualizar;
    private JComboBox<String> comboBasesDatos;

    public FormConexion() {
        inicio();
        setTitle("Conexión bases de datos");
        setSize(480, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
    }

    private void inicio() {
        container = this.getContentPane();
        container.setLayout(new BorderLayout(10, 10));

        JPanel panelFormulario = new JPanel(new GridLayout(5, 2, 10, 10));
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        user = new JLabel("Usuario:");
        userField = new JTextField("root");
        panelFormulario.add(user);
        panelFormulario.add(userField);

        pw = new JLabel("Contraseña:");
        pwField = new JTextField();
        panelFormulario.add(pw);
        panelFormulario.add(pwField);

        port = new JLabel("Puerto:");
        portField = new JTextField("3306");
        panelFormulario.add(port);
        panelFormulario.add(portField);

        adress = new JLabel("Servidor:");
        adressField = new JTextField("localhost");
        panelFormulario.add(adress);
        panelFormulario.add(adressField);

        JLabel lblComboBD = new JLabel("Base de Datos:");
        comboBasesDatos = new JComboBox<>();
        comboBasesDatos.addItem("Northwind");
        comboBasesDatos.addItem("EmpresaDB");
        panelFormulario.add(lblComboBD);
        panelFormulario.add(comboBasesDatos);

        JPanel panelBotones = new JPanel(new GridLayout(2, 2, 10, 10));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));

        connect = new JButton("Conectar");
        muestraTabla = new JButton("Mostrar Tablas");
        btnActualizar = new JButton("Actualizar Precios");
        btnActualizar.setEnabled(false);

        panelBotones.add(connect);
        panelBotones.add(muestraTabla);
        panelBotones.add(btnActualizar);

        container.add(panelFormulario, BorderLayout.CENTER);
        container.add(panelBotones, BorderLayout.SOUTH);

        connect.addActionListener(this);
        muestraTabla.addActionListener(this);
        btnActualizar.addActionListener(this);
        comboBasesDatos.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comboBasesDatos) {
            String seleccion = (String) comboBasesDatos.getSelectedItem();
            if ("northwind".equals(seleccion)) {
                btnActualizar.setEnabled(true);
            } else {
                btnActualizar.setEnabled(false);
            }
        }

        if (e.getSource() == connect) {
            probarConexion();
        }

        if (e.getSource() == muestraTabla) {
            String dbSeleccionada = (String) comboBasesDatos.getSelectedItem();
            if (dbSeleccionada == null || dbSeleccionada.equals("Selecciona una BD...")) {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona una base de datos del desplegable.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            abrirVentanaTablas(dbSeleccionada);
        }

      if (e.getSource() == btnActualizar) {
    String dbSeleccionada = (String) comboBasesDatos.getSelectedItem();
    if (dbSeleccionada == null || !dbSeleccionada.equalsIgnoreCase("northwind")) {
        JOptionPane.showMessageDialog(this, "Por favor, selecciona una base de datos del desplegable.", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    try {
        // Quita el try de aquí y deja la conexión limpia:
        Connection conexionUnica = obtenerConexion(dbSeleccionada);
        
        ActualizacionPrecioProducts ventanaActualizar = new ActualizacionPrecioProducts(conexionUnica);
        ventanaActualizar.setVisible(true); 
        
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error al abrir la conexión:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    }

    private void probarConexion() {
        String servidor = adressField.getText().trim();
        String puerto = portField.getText().trim();
        String usuario = userField.getText().trim();

        if (servidor.isEmpty() || puerto.isEmpty() || usuario.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce las credenciales de acceso.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String dbSeleccionada = (String) comboBasesDatos.getSelectedItem();

        if (dbSeleccionada == null || dbSeleccionada.equals("Selecciona una BD...")) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una base de datos del desplegable.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            Connection conexion = obtenerConexion(dbSeleccionada);
            JOptionPane.showMessageDialog(this, "¡Conexión exitosa a " + dbSeleccionada + "!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            conexion.close();

            cargarBasesDeDatos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de conexión:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarBasesDeDatos() {
        try (Connection conexion = obtenerConexion("");
             PreparedStatement stmt = conexion.prepareStatement("SHOW DATABASES");
             ResultSet rs = stmt.executeQuery()) {

            comboBasesDatos.removeAllItems();
            comboBasesDatos.addItem("Selecciona una BD...");

            while (rs.next()) {
                String nombreDb = rs.getString(1);
                if (!nombreDb.equals("information_schema") && !nombreDb.equals("mysql") && 
                    !nombreDb.equals("performance_schema") && !nombreDb.equals("sys")) {
                    comboBasesDatos.addItem(nombreDb);
                }
            }
        } catch (SQLException ex) {
            System.err.println("No se pudieron cargar las bases de datos: " + ex.getMessage());
        }
    }

    private void abrirVentanaTablas(String db) {
        JFrame ventanaTablas = new JFrame("Tablas de: " + db);
        ventanaTablas.setSize(600, 450);
        ventanaTablas.setLocationRelativeTo(this);
        ventanaTablas.setResizable(true);
        ventanaTablas.setLayout(new BorderLayout());

        JComboBox<String> comboTablas = new JComboBox<>();
        comboTablas.addItem("Selecciona una tabla...");

        JTextArea areaDatos = new JTextArea();
        areaDatos.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaDatos);

        // Reutilizamos nuestro método centralizado aquí también
        try (Connection conexion = obtenerConexion(db);
             PreparedStatement stmt = conexion.prepareStatement("SHOW TABLES");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                comboTablas.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al obtener las tablas:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        comboTablas.addActionListener(e -> {
            String tablaSeleccionada = (String) comboTablas.getSelectedItem();

            if (tablaSeleccionada == null || tablaSeleccionada.equals("Selecciona una tabla...")) {
                areaDatos.setText("");
                return;
            }

            areaDatos.setText("");

            try (Connection conexion = obtenerConexion(db);
                 PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM `" + tablaSeleccionada + "`");
                 ResultSet rs = stmt.executeQuery()) {

                ResultSetMetaData metaData = rs.getMetaData();
                int numCols = metaData.getColumnCount();

                for (int i = 1; i <= numCols; i++) {
                    areaDatos.append(metaData.getColumnName(i) + "\t");
                }
                areaDatos.append("\n------------------------------------------------------------\n");

                while (rs.next()) {
                    for (int i = 1; i <= numCols; i++) {
                        areaDatos.append(rs.getString(i) + "\t");
                    }
                    areaDatos.append("\n");
                }

            } catch (SQLException ex) {
                areaDatos.setText("Error al cargar los datos: " + ex.getMessage());
            }
        });

        JPanel panelNorte = new JPanel(new BorderLayout());
        panelNorte.setBorder(BorderFactory.createEmptyBorder(15, 15, 10, 15));
        panelNorte.add(comboTablas, BorderLayout.CENTER);

        JPanel panelCentro = new JPanel(new BorderLayout());
        panelCentro.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));
        panelCentro.add(scrollPane, BorderLayout.CENTER);

        ventanaTablas.add(panelNorte, BorderLayout.NORTH);
        ventanaTablas.add(panelCentro, BorderLayout.CENTER);

        ventanaTablas.setVisible(true);
    }

    public Connection obtenerConexion(String nombreDb) throws SQLException {
        String servidor = adressField.getText().trim();
        String puerto = portField.getText().trim();
        String usuario = userField.getText().trim();
        String password = pwField.getText().trim();
        
        String url;
        if (nombreDb == null || nombreDb.isEmpty()) {
            url = "jdbc:mysql://" + servidor + ":" + puerto + "?useSSL=false&serverTimezone=UTC";
        } else {
            url = "jdbc:mysql://" + servidor + ":" + puerto + "/" + nombreDb + "?useSSL=false&serverTimezone=UTC";
        }
        
        return DriverManager.getConnection(url, usuario, password);
    }
}