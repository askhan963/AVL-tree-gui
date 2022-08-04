/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AvlTreeInGui;

/**
 *
 * @author AS KHAN
 */
public class Run {
    public static void main(String[] args) {
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                AVLFrame.getFrame();
                new Instructions().setVisible(true);
            }
        });
    }
}
