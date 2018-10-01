package com.company;

// Created by JClayton on 09/20/2018

public class Tree<BST> {
 
    Tree<BST> leftSubTree;   // Holds left child
    Tree<BST> rightSubTree;  // Holds right child
    BST key;        // Holds the key

    Tree(BST key) {     // Creating constructor
        this.key = key;
        this.leftSubTree = null;
        this.rightSubTree = null;
    }

    public Tree<BST> getRightNode() {   // Method to return the right node
        return rightSubTree;
    }
    
    public Tree<BST> getLeftNode() {    // Method to return the left node
        return leftSubTree;
    }

    @Override       // Tostring method
    public String toString() {
        return key + " ";
    }

}
