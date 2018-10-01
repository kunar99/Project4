package com.company;

// Created by JClayton on 09/20/2018

class BinarySearchTree<BST> {

    private String output = " ";        // Store sorted string

    Tree<BST> initializeTree(BST inputArray[]) {     // Method used to initialize the tree

        // Root of the tree to be used
        Tree<BST> root = null;
        Tree<BST> insertNode;

        for (int i = 0; i < inputArray.length; i++) {       // Runs through each element in input
            insertNode = new Tree<>(inputArray[i]);         // Stores each node data on the tree
            root = insertNodeToTree(root, insertNode);
        }
        return root;        // Returns value
    }

    //this method is what inserts each node to the tree
    private Tree<BST> insertNodeToTree(Tree<BST> rootNode, Tree<BST> nextNode) {

        //checks if the rootNode is null
        if (rootNode == null)
            return nextNode;

        //executes if the data is an integer
        if (isValidInteger(rootNode.key)) {

            //converts the given nodes to integers and stores them to a variable
            int parentNode = (Integer) rootNode.key;
            int newNode = (Integer) nextNode.key;

            //if the new node is less that the current node, it will store the data to the left node
            if (newNode < parentNode)
                rootNode.leftSubTree = insertNodeToTree(rootNode.leftSubTree, nextNode);

                //if the new node equals the current node, it will store the data to the right node
            else if (newNode == parentNode)
                rootNode.rightSubTree = insertNodeToTree(rootNode.rightSubTree, nextNode);

                //if the new node is greater than the current node, it will store the data to the right side
            else if (newNode > parentNode)
                rootNode.rightSubTree = insertNodeToTree(rootNode.rightSubTree, nextNode);

            return rootNode;
        }

        //executes if data is a fraction
        else {

            //creates a fraction variable and stores the new node data to it
            Fraction newFractionNode = (Fraction) nextNode.key;

            //variable to hold the return value of comparing the two nodes
            int compareNodes = (newFractionNode).compareTo(rootNode.key);

            //if the new node is less that the current node, it will store the data to the left node
            if (compareNodes < 0)
                rootNode.leftSubTree = insertNodeToTree(rootNode.leftSubTree, nextNode);

                //if the new node equals the current node, it will store the data to the right node
            else if (compareNodes == 0)
                rootNode.rightSubTree = insertNodeToTree(rootNode.rightSubTree, nextNode);

                //if the new node is greater than the current node, it will store the data to the right side
            else if (compareNodes > 0)
                rootNode.rightSubTree = insertNodeToTree(rootNode.rightSubTree, nextNode);

            return rootNode;
        }
    }

    //this method checks if an object is an integer
    private boolean isValidInteger(Object node) {

        //if object is an integer, return true
        if (node instanceof Integer)
            return true;

            //otherwise, return false
        else
            return false;
    }

    // this method organizes the output in ascending order
    String inOrderTreeTraversal(Tree<BST> node) {

        //will execute as long as there are nodes remaining
        if (node != null) {

            //starts with the left node
            inOrderTreeTraversal(node.leftSubTree);

            //stores each node to the output string
            output += String.valueOf(node.key + " ");

            //then will traverse to the right node
            inOrderTreeTraversal(node.rightSubTree);
        }
        return output;
    }

    // this method organizes the output in descending order
    String reverseOrderTreeTraversal(Tree<BST> node) {

        //will execute as long as there are nodes remaining
        if (node != null) {

            //starts with the right node
            reverseOrderTreeTraversal(node.rightSubTree);

            //stores each node to the output string
            output += String.valueOf(node.key + " ");

            //then will traverse to the left node
            reverseOrderTreeTraversal(node.leftSubTree);
        }
        return output;
    }
}