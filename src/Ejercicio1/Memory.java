/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

import javax.swing.JFrame;

/**
 *
 * @author Diego
 */
public class Memory extends JFrame{
    
    public Memory() {
        add(new NewPanel());
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Memory frame=new Memory();
        frame.setTitle("Memoria");
        frame.setSize(350,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    
}
