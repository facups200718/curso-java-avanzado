package com.anncode.lambdas;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * NOTA: En la programacion funcional orientado a lambdas, no tenemos iteración. Se maneja con recursividad.
 */
public class ClickableElementExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Clickable Element Example");

        JButton button = new JButton("Click Me");
        button.addActionListener(e -> {
            // Acción a realizar cuando se hace clic en el botón
            System.out.println("¡Has hecho clic en el botón!");
        });

        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
