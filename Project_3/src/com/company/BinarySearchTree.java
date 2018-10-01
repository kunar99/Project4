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
    
    private Tree<BST> insertNodeToTree(Tree<BST> rootNode, Tree<BST> nextNode) {    // Insert node to the tree
    
        if (rootNode == null)           // Confirms root node is null
            return nextNode;

        if (isValidInteger(rootNode.key)) {     // Runs data if confirmed integer
           
            int parentNode = (Integer) rootNode.key;    // Changes nodes to integers and stores
            int newNode = (Integer) nextNode.key;
          
            if (newNode < parentNode)           // Stores data to the left node if less than current node
                rootNode.leftSubTree = insertNodeToTree(rootNode.leftSubTree, nextNode);

            else if (newNode == parentNode)      // Stores data in right node if found equal to current node
                rootNode.rightSubTree = insertNodeToTree(rootNode.rightSubTree, nextNode);
          
            else if (newNode > parentNode)      // Stores in right node, if found greater than current node
                rootNode.rightSubTree = insertNodeToTree(rootNode.rightSubTree, nextNode);

            return rootNode;
        
        }else {      // Runs data if fraction is found
          
            Fraction newFractionNode = (Fraction) nextNode.key;     // Creates fraction variable and stores
           
            int compareNodes = (newFractionNode).compareTo(rootNode.key);   // Used to hold the return value of the two nodes
           
            if (compareNodes < 0)                   // New node is less than current node, store data to the left
                rootNode.leftSubTree = insertNodeToTree(rootNode.leftSubTree, nextNode);
               
            else if (compareNodes == 0)             // New node is equal to current node, store to the right
                rootNode.rightSubTree = insertNodeToTree(rootNode.rightSubTree, nextNode);
                
            else if (compareNodes > 0)              // New node is greater than current, store to the right
                rootNode.rightSubTree = insertNodeToTree(rootNode.rightSubTree, nextNode);

            return rootNode;
        }
    }

    private boolean isValidInteger(Object node) {   // Method to confirms object is an integer
     
        if (node instanceof Integer)        // Confirms object is an integer 
            return true;         
        else
            return false;
    }
  
    String inOrderTreeTraversal(Tree<BST> node) {       // Method to sort output in ascending order
      
        if (node != null) {     // If nodes remain, then execute remainder

            inOrderTreeTraversal(node.leftSubTree); // Run in a left to right order
            output += String.valueOf(node.key + " ");   // Stores in an output string
            inOrderTreeTraversal(node.rightSubTree);    // Move left to right
        }
        return output;          // Return the output data
    }

    String reverseOrderTreeTraversal(Tree<BST> node) {      // Method sorts in descending order

        if (node != null) {         // Keep running if there are remaining nodes
    
            reverseOrderTreeTraversal(node.rightSubTree);   // Run from right to left
            output += String.valueOf(node.key + " ");   // Stores node in output string
            reverseOrderTreeTraversal(node.leftSubTree);        // Run right to left
        }
        return output;
    }
}
