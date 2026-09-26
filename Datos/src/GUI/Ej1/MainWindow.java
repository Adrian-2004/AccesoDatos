package GUI.Ej1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class MainWindow extends JFrame implements ActionListener{

private Container container;
private JLabel numerador, denominador, resultado, titulo;
private JTextField campoNumerador, campoDenominador, campoResultado;
private JButton continuar;

public MainWindow(){
    inicio();
    setTitle("Conversion de racional a decimal");//establece el titulo de la ventana
    setSize(480,320);//tamaño de la ventana
    setLocationRelativeTo(null); //Posicion de la ventana, con null se queda en el centro de la pantalla
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//el programa se deja de ejecutar al pulsar la X de la ventana
    setResizable(true); //el tamaño de la ventana se puede cambiar

}

/**
 * Metodo que crea la ventana con sus diferentes componentes 
 * graficos
 */

private void inicio(){
    container = getContentPane(); //obtiene el panel de contenidos de la ventana
    container.setLayout(null);//El panel no tiene asociado ningun layout
    
    //Establecer todos los componentes de la ventana
    titulo = new JLabel();
    titulo.setText("Introduce un numero racional: ");
    titulo.setBounds(30,15, 250, 23);
    
    numerador = new JLabel();
    numerador.setText("Numerador (<100):");
    numerador.setBounds(30,55,130,23);
    campoNumerador = new JTextField();
    campoNumerador.setBounds(160,55,80,23);

    denominador = new JLabel();
    denominador.setText("Denominador (>-5): ");
    denominador.setBounds(30,95,130,23);
    campoDenominador = new JTextField();
    campoDenominador.setBounds(160,95,80,23);

    resultado = new JLabel();
    resultado.setText("Resultado: ");
    resultado.setBounds(70,170,80,23);
    campoResultado = new JTextField();
    campoResultado.setBounds(160,170,80,23);

    continuar = new JButton("Continuar");
    continuar.setBounds(270,75,100,35);
    continuar.addActionListener(this);

    container.add(titulo);
    container.add(numerador);
    container.add(campoNumerador);
    container.add(campoDenominador);
    container.add(denominador);
    container.add(resultado);
    container.add(campoResultado);
    container.add(continuar);
}

@Override 
public void actionPerformed(ActionEvent evento){
if (evento.getSource() == continuar){
    calcular();
}
}

public void calcular(){
try{
    
    double num = Double.parseDouble(campoNumerador.getText());
    double den = Double.parseDouble(campoDenominador.getText());

    if (num>=100 || den <= -5){
        throw new IntervaloIncorrectoException("Numeros fuera del intervalo");
    } 
    if (den == 0) {
        throw new ArithmeticException("División entre 0");
    }
    
    
    double res = num/den;
    campoResultado.setText(res+"");

    JOptionPane.showMessageDialog(this, "Operación realizada");
}catch (NumberFormatException e){
    JOptionPane.showMessageDialog(this, "Se han introducido caracteres no numéricos");
}catch(IntervaloIncorrectoException e){
    JOptionPane.showMessageDialog(this,"Numeros fuera del intervalo");
}catch(ArithmeticException e){
    JOptionPane.showMessageDialog(this,"División entre 0");
    }
}
}
