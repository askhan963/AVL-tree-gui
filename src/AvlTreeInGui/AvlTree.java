/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AvlTreeInGui;
/**
 *
 * @author AS KHAN
 */
import java.awt.Point;
import java.util.ArrayList;

public class AvlTree {
    public boolean isPresent=false;
    private Node root; 
    private static final Point START_CNDS = new Point(683, 125);
    private static final int STEP_BY_X = 40;
    private static final int STEP_BY_Y = 80;
    private static final int BIG_STEP_BY_X = 90;
    //to note the record of new Node
    private static ArrayList<Node> list = new ArrayList<Node>();

    protected static ArrayList<Node> getList() {
        return list;
    }
    
    protected Node getRoot() {
        return root;
    }
    
 //method to add value to node
    public void add(int key) {
        Node node = new Node(key);
        list.add(node);
        addNodeToTree(root, node);
        extendTree(root);
    }
  //Adding Node to Tree
    private void addNodeToTree(Node currentRoot, Node nodeNew) {
        if(root == null) {
            root = nodeNew;
             nodeNew.point = START_CNDS;
            AVLFrame.drawSquare(nodeNew);
        }
        else {
                if(nodeNew.key < currentRoot.key) {
                    if(currentRoot.left == null) {
                        currentRoot.left = nodeNew;
                        nodeNew.parent = currentRoot;
                        nodeNew.point = new Point(currentRoot.point.x - STEP_BY_X, currentRoot.point.y + STEP_BY_Y);
                        balanceTree(currentRoot);
                    } 
                    else {
                        addNodeToTree(currentRoot.left, nodeNew);
                    }
                } 
                else {
                    if(currentRoot.right == null) {
                        currentRoot.right = nodeNew;
                        nodeNew.parent = currentRoot;
                        nodeNew.point = new Point(
                                currentRoot.point.x + STEP_BY_X,
                                currentRoot.point.y + STEP_BY_Y);
                        balanceTree(currentRoot);
                    }
                    else {
                        addNodeToTree(currentRoot.right, nodeNew);
                    }
                } 
            
        }
    }
//method for Balance Tree
    private void balanceTree(Node current) {
        setBalance(current);
        int balance = current.balance;
        if(balance == -2) {
            if(height(current.left.left) >= height(current.left.right)) {
                current = rotateRight(current);
            }
            else {current = doubleRotateLeftRight(current);}
        }
        else {
            if(balance == 2) {
                if(height(current.right.right) >= height(current.right.left)) {
                    current = rotateLeft(current);
                }
                else {
                    current = doubleRotateRightLeft(current);
                }
            }
        }
        if(current.parent != null) {balanceTree(current.parent);}
        else {
            root = current;
            AVLFrame.cleanSquare(current);
            if(current.left != null) {AVLFrame.cleanLine(current, current.left);}
            if(current.right != null) {AVLFrame.cleanLine(current, current.right);}
            current.point = START_CNDS;
            if(current.left != null) {
                AVLFrame.drawLine(current, current.left);
                AVLFrame.drawSquare(current.left);
            }
            if(current.right != null) {
                AVLFrame.drawLine(current, current.right);
                AVLFrame.drawSquare(current.right);
            }
            AVLFrame.drawSquare(current);
        }
    }
    //method To Expand Tree After Balancing
    private void extendTree(Node node) {
        if(node == null) {return;}
        if(node.left != null && node.right != null) {
            if(node.left.left !=null ||
                    node.left.right != null ||
                    node.right.left != null ||
                    node.right.right != null) {
                cleanTree(node);
                if(node != root) {
                    if(node.parent.right == node) {
                        AVLFrame.cleanSquare(node);
                        AVLFrame.cleanLine(node.parent, node);
                        node.point = new Point(
                                node.point.x + BIG_STEP_BY_X,
                                node.point.y);
                        AVLFrame.drawLine(node.parent, node);
                        AVLFrame.drawSquare(node.parent);
                        AVLFrame.drawSquare(node);
                    }
                    if(node.parent.left == node) {
                        AVLFrame.cleanSquare(node);
                        AVLFrame.cleanLine(node.parent, node);
                        node.point = new Point(
                                node.point.x - BIG_STEP_BY_X,
                                node.point.y);
                        AVLFrame.drawLine(node.parent, node);
                        AVLFrame.drawSquare(node.parent);
                        AVLFrame.drawSquare(node);
                    }
                }
                node.left.point = new Point(
                        node.point.x - BIG_STEP_BY_X,
                        node.left.point.y);
                node.right.point = new Point(
                        node.point.x + BIG_STEP_BY_X,
                        node.right.point.y);
                AVLFrame.drawLine(node, node.left);
                AVLFrame.drawLine(node, node.right);
                AVLFrame.drawSquare(node.left);
                AVLFrame.drawSquare(node.right);
                AVLFrame.drawSquare(node);
                drawTree(node.left);
                drawTree(node.right);
                extendTree(node.left);
                extendTree(node.right);
                if(root.left != null) {
                    AVLFrame.drawLine(root, root.left);
                    AVLFrame.drawSquare(root.left);
                }
                if(root.right != null) {
                    AVLFrame.drawLine(root, root.right);
                    AVLFrame.drawSquare(root.right);
                }
                AVLFrame.drawSquare(root);
            }
        }
    }
    
   //when we Add or delete  Node Every Time This Method is CLLED TO Delete Tree To Make new Tree every time
    private void cleanTree(Node node) {
        if(node == null) {
            return;
        }
        if(node.left != null) {
            AVLFrame.cleanSquare(node.left);
            AVLFrame.cleanLine(node, node.left);
        }
        if(node.right != null) {
            AVLFrame.cleanSquare(node.right);
            AVLFrame.cleanLine(node, node.right);
        }
        cleanTree(node.left);
        cleanTree(node.right);
    }
    
    //Method  for drawing the tree
    private void drawTree(Node node) {
        if(node == null) {return;}
        if(node.left != null && node.left != root.left) {
            node.left.point = new Point(
                    node.left.parent.point.x - STEP_BY_X,
                    node.left.parent.point.y + STEP_BY_Y);
            AVLFrame.drawLine(node, node.left);
            AVLFrame.drawSquare(node);
            AVLFrame.drawSquare(node.left);
        }
        if(node.right != null && node.right != root.right) {
            node.right.point = new Point(
                    node.right.parent.point.x + STEP_BY_X,
                    node.right.parent.point.y + STEP_BY_Y);
            AVLFrame.drawLine(node, node.right);
            AVLFrame.drawSquare(node);
            AVLFrame.drawSquare(node.right);
        }
        drawTree(node.left);
        drawTree(node.right);
    }

    //Method for the maximum depth of the node.
    private int height(Node current) {
        if(current == null) {return -1;}
        if(current.left == null && current.right == null) {return 0;}
        else {
            if(current.left==null) {return 1 + height(current.right);}
            else {
                if(current.right==null) {return 1 + height(current.left);}
                else {return 1 + Math.max(height(current.left), height(current.right));}
            }
        }
    }
//calculate balance Factor
    private void setBalance(Node current) {
        current.balance = height(current.right) - height(current.left);
    }
 //deleting Node Method
    public void remove(int key) {
        removeAvlNode(root,key);
        extendTree(root);
    }
//search Method to See Key is Present Or Not
    public void search(int key){
       searchNode(root,key);
    }
    public void searchNode(Node node,int key){
        if(node==null){
            isPresent=false;
            return;
        }    
        else{
            if(node.key==key){
                isPresent=true;
            }
                    else {
                if(key >= node.key )  {
                    searchNode(node.right,key);
                   
                }
                else {
                    searchNode(node.left,key);
                }
            }
        }
       
    }
    //remove Mathod to delete node
    private void removeAvlNode(Node node,int key) {
        if(node == null) {
            isPresent=false;
           return;}
        else {
         
            list.remove(node);
            if(node.key == key) {
                isPresent=true;
                removeFoundNode(node);
            }
            else {
                if(node.key > key)  {removeAvlNode(node.left,key);}
                else {removeAvlNode(node.right,key);}
            }
        }
    }

 //deleting found node
    public void removeFoundNode(Node nodeDetected) {
        Node nodeTmp1;
        if(nodeDetected.left == null || nodeDetected.right == null) {
            if(nodeDetected.left == null && nodeDetected.right == null) {
                if(nodeDetected.parent == null) {
                    AVLFrame.cleanSquare(nodeDetected);
                    root = null;
                    nodeDetected = null;
                    return;
                }
            }
            nodeTmp1 = nodeDetected;
        } 
        else {
            nodeTmp1 = successor(nodeDetected);
            nodeDetected.key = nodeTmp1.key;
        }
        Node nodeTmp2;
        if(nodeTmp1.left != null) {nodeTmp2 = nodeTmp1.left;}
        else {nodeTmp2 = nodeTmp1.right;}
        if(nodeTmp2 != null) {nodeTmp2.parent = nodeTmp1.parent;}
        if(nodeTmp1.parent == null) {
            AVLFrame.cleanSquare(nodeTmp1);
            AVLFrame.cleanSquare(nodeTmp2);
            AVLFrame.cleanLine(nodeTmp1, nodeTmp2);
            root = nodeTmp2;
            nodeTmp2.point = START_CNDS;
            AVLFrame.drawSquare(nodeTmp2);
        }
        else {
            if(nodeTmp1 == nodeTmp1.parent.left) {
                if(nodeTmp2 == null) {
                    AVLFrame.cleanSquare(nodeTmp1);
                    AVLFrame.cleanLine(nodeTmp1, nodeTmp1.parent);
                    AVLFrame.drawSquare(nodeTmp1.parent);
                }
                else {
                    AVLFrame.cleanLine(nodeTmp1.parent, nodeTmp1);
                    AVLFrame.cleanLine(nodeTmp1, nodeTmp2);
                    AVLFrame.cleanSquare(nodeTmp1);
                    AVLFrame.cleanSquare(nodeTmp2);
                    nodeTmp2.point = new Point(
                            nodeTmp1.point.x,
                            nodeTmp1.point.y);
                    AVLFrame.drawLine(nodeTmp1.parent, nodeTmp2);
                    AVLFrame.drawSquare(nodeTmp1.parent);
                    AVLFrame.drawSquare(nodeTmp2);
                }
                nodeTmp1.parent.left = nodeTmp2;
            }
            else {
                if(nodeTmp2 == null) {
                    AVLFrame.cleanSquare(nodeTmp1);
                    AVLFrame.cleanLine(nodeTmp1, nodeTmp1.parent);
                    AVLFrame.drawSquare(nodeTmp1.parent);
                }
                else {
                    AVLFrame.cleanLine(nodeTmp1.parent, nodeTmp1);
                    AVLFrame.cleanLine(nodeTmp1, nodeTmp2);
                    AVLFrame.cleanSquare(nodeTmp1);
                    AVLFrame.cleanSquare(nodeTmp2);
                    nodeTmp2.point = new Point(
                            nodeTmp1.point.x,
                            nodeTmp1.point.y);
                    AVLFrame.drawLine(nodeTmp1.parent, nodeTmp2);
                    AVLFrame.drawSquare(nodeTmp1.parent);
                    AVLFrame.drawSquare(nodeTmp2);
                }
                nodeTmp1.parent.right = nodeTmp2;
            }
            balanceTree(nodeTmp1.parent);
        }
    }
     
 //finding seccessor of Balance Factor's Node
    public Node successor(Node nodeIncomer) {
        if(nodeIncomer.right != null) {
           Node nodeTmp1 = nodeIncomer.right;
            while(nodeTmp1.left != null) {
                nodeTmp1 = nodeTmp1.left;
            }
            return nodeTmp1;
        }
        else {
            Node nodeTmp2 = nodeIncomer.parent;
            while(nodeTmp2 != null && nodeIncomer == nodeTmp2.right) {
                nodeIncomer = nodeTmp2;
                nodeTmp2 = nodeIncomer.parent;
            }
            return nodeTmp2;
        }     
    }
    
  //rotaite left Method
      private Node rotateLeft(Node current) {
        AVLFrame.cleanSquare(current);
        AVLFrame.cleanSquare(current.right);
        AVLFrame.cleanLine(current, current.right);
        if(current.right.right != null) {
            AVLFrame.cleanSquare(current.right.right);
            AVLFrame.cleanLine(current.right, current.right.right);
            if(current.right.right.right != null) {
                AVLFrame.cleanLine(current.right.right, current.right.right.right);
            }
            if(current.right.right.left != null) {
                AVLFrame.cleanLine(current.right.right, current.right.right.left);
            }
        }
        Node result = current.right;
        result.parent = current.parent;
        current.right = result.left;
        if(result.left != null) {
            AVLFrame.cleanLine(result, result.left);
            AVLFrame.cleanSquare(result.left);
            if(result.left.left != null) {
                AVLFrame.cleanLine(result.left.left, result.left);
            }
            if(result.left.right != null) {
                AVLFrame.cleanLine(result.left.right, result.left);
            }
        }
        current.point = new Point(
                current.point.x - STEP_BY_X,
                current.point.y + STEP_BY_Y);
        result.point = new Point(
                current.point.x + STEP_BY_X,
                current.point.y - STEP_BY_Y);
        if(result.right != null) {
            result.right.point = new Point(
                    result.right.point.x - STEP_BY_X,
                    result.right.point.y - STEP_BY_Y);
        }
        AVLFrame.drawLine(current, result);
        if(current.right != null) {
            current.right.parent = current;
            current.right.point = new Point(
                    current.point.x + STEP_BY_X,
                    current.point.y + STEP_BY_Y);
        }
        result.left = current;
        current.parent = result;
        if(result.parent != null) {
            if(result.parent.right == current) {result.parent.right = result;}
            else {
                if(result.parent.left == current) {result.parent.left = result;}
            }
        }
        return result;
    }
    
//rotaite Right
    private Node rotateRight(Node current) {
        AVLFrame.cleanSquare(current);
        AVLFrame.cleanSquare(current.left);
        AVLFrame.cleanLine(current, current.left);
        if(current.left.left != null) {
            AVLFrame.cleanSquare(current.left.left);
            AVLFrame.cleanLine(current.left, current.left.left);
            if(current.left.left.left != null) {
                AVLFrame.cleanSquare(current.left.left.left);
                AVLFrame.cleanLine(current.left.left, current.left.left.left);
            }
            if(current.left.left.right != null) {
                AVLFrame.cleanSquare(current.left.left.right);
                AVLFrame.cleanLine(current.left.left, current.left.left.right);
            }
        }
        if(current.left.right != null) {
            AVLFrame.cleanSquare(current.left.right);
            AVLFrame.cleanLine(current.left, current.left.right);
            if(current.left.right.left != null) {
                AVLFrame.cleanSquare(current.left.right.left);
                AVLFrame.cleanLine(current.left.right, current.left.right.left);
            }
            if(current.left.right.right != null) {
                AVLFrame.cleanSquare(current.left.right.right);
                AVLFrame.cleanLine(current.left.right, current.left.right.right);
            }
        }
        Node result = current.left;
        result.parent = current.parent;
        current.left = result.right;
        if(current.right != null) {
            current.point = new Point(
                current.right.point.x,
                current.right.point.y);
            current.right.point = new Point(
                    current.point.x + STEP_BY_X,
                    current.point.y + STEP_BY_Y);
        }
        else {
            current.point = new Point(
                current.point.x + STEP_BY_X,
                current.point.y + STEP_BY_Y);
        }
        result.point = new Point(
                current.point.x - STEP_BY_X,
                current.point.y - STEP_BY_Y);
        if(result.left != null) {
                result.left.point = new Point(
                result.left.point.x + STEP_BY_X,
                result.left.point.y - STEP_BY_Y);
        }
        if(current.left != null) {
            current.left.parent = current;
            current.left.point = new Point(
                    current.left.parent.point.x - STEP_BY_X,
                    current.left.parent.point.y + STEP_BY_Y);
        }
        result.right = current;
        current.parent = result;
        if(result.parent != null) {
            if(result.parent.right == current) {result.parent.right = result;}
            else {
                if(result.parent.left == current) {result.parent.left = result;}
            }
        }
        return result;
    }
    
    //inorder Triversal
    public String inorder(Node n){
        String order="";
        if(n==null){
            return "";
        }
            order+=inorder(n.left);
            order+=" "+n.key;   
           order+=  inorder(n.right);
       return order;
    }
     public String getInorder(){
        return inorder(root);
    }
    //preorder Triversal
      public String preorder(Node n){
        String order="";
        if(n==null){
            return "";
        }
        order+=" "+n.key;
          order+=  inorder(n.left);  
            order+= inorder(n.right);
             
       return order;
    }
     public String getPreorder(){
        return inorder(root);
    }
     //postOrder Triversal
         public String postorder(Node n){
        String order="";
        if(n==null){
            return "";
        }
     
           order+= inorder(n.left);  
           order+=  inorder(n.right);
                order+=" "+n.key;
             
       return order;
    }
     public String getPostorder(){
        return inorder(root);
    }
  
    private Node doubleRotateLeftRight(Node current) {
        current.left = rotateLeft(current.left);
        return rotateRight(current);
    }

    private Node doubleRotateRightLeft(Node current) {
        current.right = rotateRight(current.right);
        return rotateLeft(current);
    }
    
  
}
