package com.company;

// Created by JClayton on 09/20/2018

public class Tree<BST> {

    //to hold left child node
    Tree<BST> leftSubTree;

    //to hold right child node
    Tree<BST> rightSubTree;

    //to hold the key
    BST key;

    //constructor
    Tree(BST key) {
        this.key = key;
        this.leftSubTree = null;
        this.rightSubTree = null;
    }

    //this method returns the right node when called
    public Tree<BST> getRightNode() {
        return rightSubTree;
    }

    //this method returns the left node when called
    public Tree<BST> getLeftNode() {
        return leftSubTree;
    }

    //to string method
    @Override
    public String toString() {
        return key + " ";
    }

}