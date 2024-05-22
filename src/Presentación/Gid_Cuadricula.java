package Presentación;

import javax.swing.*;

import Lógica.Calculadora;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gid_Cuadricula extends JFrame implements ActionListener {
    private JTextField pantalla;
    private Calculadora operaciones;

    public  Gid_Cuadricula() {
        operaciones = new Calculadora();
        setTitle("Calculadora");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        pantalla = new JTextField("0");
        pantalla.setEditable(false);
        pantalla.setHorizontalAlignment(SwingConstants.RIGHT);
        add(pantalla, BorderLayout.NORTH);

        JPanel pBotones = new JPanel();
        pBotones.setLayout(new GridLayout(4, 4));

        String[] botones = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                ".", "0", "=", "+"
        };

        for (String texto : botones) {
            JButton boton = new JButton(texto);
            boton.setFont(new Font("Arial", Font.PLAIN, 24));
            boton.addActionListener(this);
            pBotones.add(boton);
        }

        add(pBotones, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        operaciones.realizarOperacion(comando, pantalla.getText());

        if ("0123456789.".contains(comando)) {
            if (operaciones.isNuevaOperacion()) {
                pantalla.setText(comando);
                operaciones.setNuevaOperacion(false);
            } else {
                pantalla.setText(pantalla.getText() + comando);
            }
        } else if (comando.equals("=")) {
            pantalla.setText(String.valueOf(operaciones.getResultado()));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Gid_Cuadricula calculadora = new Gid_Cuadricula();
            calculadora.setVisible(true);
        });
    }
}
