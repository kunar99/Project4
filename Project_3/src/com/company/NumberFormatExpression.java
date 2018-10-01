package com.company;

// Created by JClayton on 09/20/2018

import javax.swing.JOptionPane;

class NumberFormatExpression extends Exception {

    //this method displays the error message when it is called
    static void getError() {
        JOptionPane.showMessageDialog(null, "Error: Non-Numeric Input");
    }
}