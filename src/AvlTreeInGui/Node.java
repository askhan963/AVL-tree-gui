/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AvlTreeInGui;

import java.awt.Point;

/**
 *
 * @author AS KHAN
 */
public class Node {
    protected Node left;
    protected Node right;
    protected Node parent;
    protected int key;
    protected int balance;
    protected Point point;
    
    public Node() {}

    public Node(int key) {
        left=null;
        right=null;
        parent=null;
        this.key=key;
    }

 

}
