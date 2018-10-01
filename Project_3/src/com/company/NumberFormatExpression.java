package com.company;

// Created by JClayton on 09/20/2018

import javax.swing.JOptionPane;

class NumberFormatExpression extends Exception {

    static void getError() {        // Method to give error message for non numeric entered data
        JOptionPane.showMessageDialog(null, "Error: Non-Numeric Input");
    }
}
