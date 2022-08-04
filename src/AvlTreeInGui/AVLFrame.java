/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AvlTreeInGui;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle;
/**
 *
 * @author AS KHAN
 */

public class AVLFrame extends javax.swing.JFrame {
     
    private static AVLFrame generalFrame = new AVLFrame();
    private static AvlTree tree = new AvlTree();
    private static final int SIDE_OUTER_SQUARE = 54;
    private static final int SIDE_SQUARE = 50;
      public String inorder="";
   
//AVL Frame NON-Argumented Constractor
    public AVLFrame() {
        initComponents();
        setVisible(true);
      //  setLocation(50, 50);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        MenuPanel = new javax.swing.JPanel();
        inputValue = new javax.swing.JTextField();
        addNode = new javax.swing.JButton();
        inputLabel = new javax.swing.JLabel();
         NameLabel = new javax.swing.JLabel();
        deleteNode = new javax.swing.JButton();
         searchNode = new javax.swing.JButton();
        outputMsg = new javax.swing.JLabel();
        visualPanel = new javax.swing.JPanel();
        inOrder = new javax.swing.JTextArea();
      
    randomValue = new javax.swing.JButton();
    treverseBt = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AVL Tree");
        setBackground(new java.awt.Color(204, 204, 204));
        setName("AVL Tree");
        setPreferredSize(new java.awt.Dimension(1366, 768));
        setResizable(false);
      
//a textField to input data from User
        inputValue.setFont(new java.awt.Font("Times New Roman", 1, 20));
        inputValue.setColumns(15);
        inputValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
//Add Button to Insert Values in AVL Tree
        addNode.setText("Add Node");
        addNode.setBackground(Color.GREEN);
        addNode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNodeActionPerformed(evt);
            }
        });
        //search button to Search Key in the AVL Tree
searchNode.setText("Search");
searchNode.setBackground(Color.yellow);
        searchNode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              searchNodeActionPerformed( evt);
            }
        });
          NameLabel.setFont(new java.awt.Font("Times New Roman", 3, 20)); 
        NameLabel.setText("AVL TREE");
        inputLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); 
        inputLabel.setText("Enter value:");
// delete button to delete nodes from  AVL tree
        deleteNode.setText("Delete");
        deleteNode.setBackground(Color.red);
        deleteNode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteNodeActionPerformed(evt);
            }
        });
        //A button To Treverse The Tree
        treverseBt.setText("Treverse");
        treverseBt.setBackground(Color.ORANGE);
        treverseBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              treverseActionPerformed(evt);
            }
        });
        //textArea for Treversal
             inOrder.setColumns(20);
        inOrder.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        inOrder.setRows(1);
       
        
    
 //button to Insert Random Value in AVL Tree
        randomValue.setText("Add Random Value");
        randomValue.setBackground(Color.MAGENTA);
        randomValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               addRandomActionPerformed(evt);
            }
        });
 
 //all buttons adding to frame 


      
        javax.swing.GroupLayout MenuPanelLayout = new javax.swing.GroupLayout(MenuPanel);
        MenuPanel.setLayout(MenuPanelLayout);
        MenuPanelLayout.setHorizontalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup().addComponent(NameLabel).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputValue, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addNode, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteNode).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(searchNode, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(randomValue, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(treverseBt)
            )
        );
        MenuPanelLayout.setVerticalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addNode)
                        .addComponent(inputValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(NameLabel,javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputLabel,javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deleteNode,javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchNode,javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(randomValue,javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(treverseBt)
            )))
        );
        // PAnel where Tree Will be Drawn in Frame
         javax.swing.GroupLayout visualPanelLayout = new javax.swing.GroupLayout(visualPanel);
        visualPanel.setBackground(new java.awt.Color(255, 255, 255));
        visualPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        visualPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        visualPanel.setPreferredSize(new java.awt.Dimension(50, 50));
          
        visualPanelLayout.setHorizontalGroup(
            visualPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(visualPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inOrder))
        );
        visualPanelLayout.setVerticalGroup(
            visualPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, visualPanelLayout.createSequentialGroup()
                .addContainerGap(310, Short.MAX_VALUE).addGap(200)
                .addComponent(inOrder))
        );
        visualPanel.setLayout(visualPanelLayout);
       
       


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(visualPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addComponent(MenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                )
            )
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(visualPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            )
        );

        pack();
        
    }
// end of initComponents

    //Button  for adding nodes in the tree
    private void addNodeActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int key = Integer.parseInt(inputValue.getText());
            tree.add(key);
        }
        catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please Enter Integer");
        }
    }
    //Button  for searching nodes in the tree
    private void searchNodeActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int key = Integer.parseInt(inputValue.getText());
          
          tree.search(key);
                if(tree.isPresent){
                     JOptionPane.showMessageDialog(null, key+"   Found."); 
                }
                else{
                    JOptionPane.showMessageDialog(null, key+" Not  Found.");  
                }

 
        }
        catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please Enter Integer");
        }
    }
    //button treversal
          private void treverseActionPerformed(java.awt.event.ActionEvent evt) {
             inorder=tree.getInorder();
              inOrder.setText("Inorder Treversal: "+inorder);
              //  new Instructions().setVisible(true);
    }     
             
    //Button  for removing nodes in the tree
    private void deleteNodeActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int key = Integer.parseInt(this.inputValue.getText());
          tree.remove(key);
   if(tree.isPresent){
                     JOptionPane.showMessageDialog(null, key+"   Deleted."); 
                }
                else{
                    JOptionPane.showMessageDialog(null, key+" Not  Found.");  
                }
        }
        catch(NumberFormatException ex) {
           JOptionPane.showMessageDialog(null, "Please Enter Integer");
        }
    }
    //Button foe adding random values in tree
    private void addRandomActionPerformed(java.awt.event.ActionEvent evt) {
        int val = (int)(0+Math.random()*100);
         tree.add(val);
    }
    
     static AVLFrame getFrame() {
         return generalFrame;}
    
    //Method  for redrawing tree
    private static void reDrawTree(Node node) {
        if(node == null) {return;}
        drawSquare(node);
        if(node.left != null) {
            drawLine(node, node.left);
            drawSquare(node);
            reDrawTree(node.left);
        }
        if(node.right != null) {
            drawLine(node, node.right);
            drawSquare(node);
            reDrawTree(node.right);
        }
    }
    
 //method to draw Node 
    public static void drawSquare(Node node) {
        if(node == null) {return;}
        Graphics2D gr = (Graphics2D)generalFrame.getGraphics();
        gr.setColor(Color.BLACK);
        gr.fillRect(
            node.point.x - SIDE_OUTER_SQUARE/2,
            node.point.y - SIDE_OUTER_SQUARE/2,
            SIDE_OUTER_SQUARE,
            SIDE_OUTER_SQUARE); 
        int x =AvlTree.getList().indexOf(node);
     
        if(AvlTree.getList().indexOf(node) == AvlTree.getList().size()-1) {
            gr.setColor(Color.GREEN);
        }
        else{
            gr.setColor(Color.CYAN);
        }
        gr.fillRect(node.point.x - SIDE_SQUARE/2,   node.point.y - SIDE_SQUARE/2,  SIDE_SQUARE, SIDE_SQUARE);
        gr.setColor(Color.BLACK);
        gr.setFont(new java.awt.Font("Times New Roman", 1, 20));
        gr.drawString( "" + node.key,  node.point.x - 3 - 6 * 2, node.point.y + 5);
    }
    
    //Method i for cleaning square while deleting
    public static void cleanSquare(Node node) {
        if(node == null) {return;}
        Graphics2D gr = (Graphics2D)AVLFrame.getFrame().getGraphics();
        gr.setColor(Color.WHITE);
        gr.fillRect(
            node.point.x - SIDE_OUTER_SQUARE/2,
            node.point.y - SIDE_OUTER_SQUARE/2,
            SIDE_OUTER_SQUARE,
            SIDE_OUTER_SQUARE);
    }
    
    //Method of connecting  two nodes line which adding
    public static void drawLine(Node nodeFirst, Node nodeSecond) {
        Graphics2D gr = (Graphics2D)getFrame().getGraphics();
        gr.setStroke(new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f));
        gr.drawLine(nodeFirst.point.x, nodeFirst.point.y, nodeSecond.point.x, nodeSecond.point.y);
    }
    
    //Method for erasing the line which connects nodes
    public static void cleanLine(Node nodeFirst, Node nodeSecond) {
        Graphics2D gr = (Graphics2D)getFrame().getGraphics();
        gr.setColor(Color.WHITE);
        gr.setStroke(new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f));
        gr.drawLine(nodeFirst.point.x, nodeFirst.point.y, nodeSecond.point.x, nodeSecond.point.y);
    }
    
   
    
    // Variables declaration - do not modify
    private javax.swing.JPanel MenuPanel;
    private javax.swing.JButton addNode;
    private javax.swing.JButton deleteNode;
    private javax.swing.JButton searchNode;
    private javax.swing.JLabel inputLabel;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JTextField inputValue;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel outputMsg;
    private javax.swing.JTextArea inOrder;
    
    private javax.swing.JButton randomValue;
    private javax.swing.JButton treverseBt;
    private javax.swing.JPanel visualPanel;
    
    // End of variables declaration
}
