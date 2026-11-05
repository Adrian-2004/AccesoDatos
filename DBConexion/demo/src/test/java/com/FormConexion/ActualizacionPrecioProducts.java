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
    // Comprobamos si la conexión es válida antes de usarla
    try {
        if (this.conexion == null || this.conexion.isClosed()) {
            JOptionPane.showMessageDialog(this, "La conexión con la base de datos está cerrada.", "Error de conexión", JOptionPane.ERROR_MESSAGE);
            return;
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    inicio();
    getCategorias();
    setTitle("Actualización de precios");
    setSize(480,320);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
    PorcentajeField = new JTextField();
    

    panelActualizar.add(categoria);
    panelActualizar.add(Categorias);
    panelActualizar.add(porcentaje);
    panelActualizar.add(PorcentajeField);
    

    JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
    panelBoton.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
    
    actualizar = new JButton("ACTUALIZAR PRECIOS CATEGORÍA");
    
    actualizar.addActionListener(this); 
    
    panelBoton.add(actualizar);

    
    container.add(panelActualizar, BorderLayout.CENTER);
    container.add(panelBoton, BorderLayout.SOUTH);
}

public ArrayList<String> getCategorias() {
        ArrayList<String> cats = new ArrayList<>();
        Categorias.removeAllItems();

        // Consulta con JOIN para cargar solo categorías que tienen productos asociados, con formato "ID - Nombre"
        String sql = "SELECT DISTINCT c.CategoryID, c.CategoryName " +
                     "FROM Categories c " +
                     "JOIN Products p ON c.CategoryID = p.CategoryID";

        try (PreparedStatement prepStatement = this.conexion.prepareStatement(sql);
             ResultSet rs = prepStatement.executeQuery()) {

            while (rs.next()) {
                int idCat = rs.getInt("CategoryID");
                String nombreCat = rs.getString("CategoryName");
                String itemCombo = idCat + " - " + nombreCat;
                
                cats.add(itemCombo);
                Categorias.addItem(itemCombo);  
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, 
                "Error al cargar las categorías: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
        return cats;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == actualizar) {
            // 1. Validar que haya una categoría seleccionada
            String categoriaSeleccionada = (String) Categorias.getSelectedItem();
            if (categoriaSeleccionada == null || categoriaSeleccionada.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione una categoría.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 2. Validar el porcentaje (que no esté vacío, que sea un número válido)
            String porcentajeStr = PorcentajeField.getText().trim();
            if (porcentajeStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un porcentaje válido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double porcentajeVal;
            try {
                porcentajeVal = Double.parseDouble(porcentajeStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "El porcentaje debe ser un número válido.", "Error de formato", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validar si es negativo
            if (porcentajeVal < 0) {
                JOptionPane.showMessageDialog(this, "El porcentaje no puede ser negativo.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Si es 0, informar de que no habrá cambios
            if (porcentajeVal == 0) {
                JOptionPane.showMessageDialog(this, "El porcentaje es 0, no se realizarán cambios en los precios.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            // 3. Solicitar confirmación indicando la categoría y el porcentaje
            int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Desea actualizar los precios de la categoría '" + categoriaSeleccionada + "' un " + porcentajeVal + "%?",
                "Confirmar actualización",
                JOptionPane.YES_NO_OPTION);

            if (confirmacion != JOptionPane.YES_OPTION) {
                return; // Si el usuario cancela, no se modifica nada
            }

            // 4. Extraer el ID de la categoría seleccionada (lo que está antes del " - ")
            int categoryId = Integer.parseInt(categoriaSeleccionada.split(" - ")[0]);

            // 5. Desactivar botón durante la operación (requisito técnico)
            actualizar.setEnabled(false);

            // 6. Ejecutar la actualización en la base de datos con PreparedStatement
            String sql = "UPDATE Products SET UnitPrice = ROUND(UnitPrice * (1 + ? / 100), 2) WHERE CategoryID = ?";

            try (PreparedStatement stmt = this.conexion.prepareStatement(sql)) {
                stmt.setDouble(1, porcentajeVal);
                stmt.setInt(2, categoryId);

                int filasAfectadas = stmt.executeUpdate();

                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(this,
                        "Se han actualizado los precios de " + filasAfectadas + " productos.",
                        "Actualización exitosa",
                        JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this,
                        "No se ha modificado ningún producto en esta categoría.",
                        "Información",
                        JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this,
                    "Error al actualizar los precios en la base de datos: " + ex.getMessage(),
                    "Error SQL",
                    JOptionPane.ERROR_MESSAGE);
            } finally {
                // Volver a activar el botón al finalizar
                actualizar.setEnabled(true);
            }
        }
    }
}


