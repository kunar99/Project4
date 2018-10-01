package com.company;

// Created by JClayton on 09/20/2018

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class program_3 extends JFrame {


    private static BinarySearchTree binarySearchTree;       // New binary search tree class instance


    private static String sortList = "";        // String to hold the sort list


    private JLabel listLabel;           // Labels to be used
    private JLabel sortListLabel;


    private static JTextField textList;         // Text fields to be used
    private static JTextField sortTextList;


    private static JButton sortButton;      // Sort button to be used


    private static JRadioButton ascendRadioButton;      // The radio button that will be used
    private static JRadioButton descendRadioButton;
    private static JRadioButton integerRadioButton;
    private static JRadioButton fractionRadioButton;


    private ButtonGroup sortOrderButtonGroup;       // Creating the button group to be used
    private ButtonGroup numericTypeButtonGroup;


    private JPanel mainPanel;               // Naming the panels
    private JPanel sortedListPanel;
    private JPanel performSortButtonPanel;
    private JPanel buttonGroupPanel;
    private JPanel sortOrderPanel;
    private JPanel numericTypePanel;


    private Container sortOrderContainer;       //Naming the containers
    private Container numericTypeContainer;
    private Container allPanels;

    private program_3() {


        super("Binary Search Tree Sort");           // Title for the main window


        listLabel = new JLabel("Original List");            // Creates to the titles to be used with the labels
        sortListLabel = new JLabel("  Sorted List");


        textList = new JTextField(30);              // Creating the dimensions for the text fields
        sortTextList = new JTextField(30);
        sortTextList.setEditable(false);                    // If the fields are editable or not

        sortButton = new JButton("Perform Sort");       // Creating the title for the sort button to be seen

        ascendRadioButton = new JRadioButton("Ascending");      // Sets the title for the radio button
        descendRadioButton = new JRadioButton("Descending");
        integerRadioButton = new JRadioButton("Integer");
        fractionRadioButton = new JRadioButton("Fraction");
        integerRadioButton.setSelected(true);                       // Creates the conditions for the user to click on it
        ascendRadioButton.setSelected(true);

        sortOrderButtonGroup = new ButtonGroup();       // Adding radio buttons to the group
        sortOrderButtonGroup.add(ascendRadioButton);
        sortOrderButtonGroup.add(descendRadioButton);
        numericTypeButtonGroup = new ButtonGroup();
        numericTypeButtonGroup.add(integerRadioButton);
        numericTypeButtonGroup.add(fractionRadioButton);

        mainPanel = new JPanel();                   // Main panel is created
        addComponent(mainPanel, listLabel);         // Adding components to main panel
        addComponent(mainPanel, textList);

        sortedListPanel = new JPanel();                 // Creating the sort list panel
        addComponent(sortedListPanel, sortListLabel);   // Adding the components to the panel
        addComponent(sortedListPanel, sortTextList);

        performSortButtonPanel = new JPanel();          // Creating the perform sort button panel
        addComponent(performSortButtonPanel, sortButton);       // Adding the components

        sortOrderContainer = new Container();                       // Creating the container for the sort order
        sortOrderContainer.setLayout(new BoxLayout(sortOrderContainer, BoxLayout.Y_AXIS));
        addComponent(sortOrderContainer, ascendRadioButton);        // Adding the components
        addComponent(sortOrderContainer, descendRadioButton);

        numericTypeContainer = new Container();             // Creating the container for numeric type
        numericTypeContainer.setLayout(new BoxLayout(numericTypeContainer, BoxLayout.Y_AXIS));
        addComponent(numericTypeContainer, integerRadioButton);     // Adding the components
        addComponent(numericTypeContainer, fractionRadioButton);

        sortOrderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));       // Sort order panel and numeric type panel
        setUpPanel(sortOrderPanel, sortOrderContainer, "Sort Order");       // Set it up and name it
        numericTypePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        setUpPanel(numericTypePanel, numericTypeContainer, "Numeric Type");

        buttonGroupPanel = new JPanel();                    // Button group panel
        buttonGroupPanel.add(sortOrderPanel, BorderLayout.CENTER);
        buttonGroupPanel.add(numericTypePanel, BorderLayout.CENTER);

        allPanels = new Container();            // Adding the containers to the panel
        allPanels.setLayout(new BoxLayout(allPanels, BoxLayout.Y_AXIS));
        allPanels.add(mainPanel);
        allPanels.add(sortedListPanel);
        allPanels.add(performSortButtonPanel);
        allPanels.add(buttonGroupPanel);

        setPreferredSize(new Dimension(500, 350));      // Setting the dimensions for the frame
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(allPanels);
        pack();
        setVisible(true);

    }

    private void setUpPanel(JPanel p, Container c, String title) {               // Method to setup panels on the frame
        p.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED), title));
        p.setPreferredSize(new Dimension(230, 85));
        p.add(c);
    }

    private void addComponent(Container c, Component c2) {  // Method to add components to container
        c.add(c2);
    }

    private void addComponent(JPanel p, Component c) {   // Method to add components to panel
        p.add(c, BorderLayout.CENTER);
    }

    private static void validateFraction(String[] input) throws NumberFormatExpression {     // Validates the fraction is valid


        for (int i = 0; i < input.length; i++) {        // Runs to elements in the array

            if (input.length > 2)                   // Throw exception if fraction has more than two parts
                throw new NumberFormatExpression();

            try {                               // Convert elements to an integer
                Integer.parseInt(input[i]);

            } catch (NumberFormatException f) {

                throw new NumberFormatExpression();  // Throw exception if not an integer
            }

        }

    }

    private static void displayResult(Tree data) {           // Method to display sort order results

        if (ascendRadioButton.isSelected())                 // Lists in ascending order
            sortTextList.setText(binarySearchTree.inOrderTreeTraversal(data));

        else if (descendRadioButton.isSelected())           // Lists in descending order
            sortTextList.setText(binarySearchTree.reverseOrderTreeTraversal(data));
    }

    public static void main(String[] args) {
        new program_3();

        sortButton.addActionListener(new ActionListener() {     // Action listener for perform button
            public void actionPerformed(ActionEvent a) {

                String originalList = textList.getText();   // Holds the entered list

                String splitList[] = originalList.split(" ");   // Stores into array

                if (integerRadioButton.isSelected()) {      // Runs if integer radio button is clicked

                    try {

                        Integer integerArray[] = new Integer[splitList.length];     // Array to hold the integers

                        binarySearchTree = new BinarySearchTree<Integer>();         // New instance of the binary search tree

                        for (int i = 0; i < splitList.length; i++)              // Runs through each element in the array
                            integerArray[i] = Integer.parseInt(splitList[i]);

                        Tree<Integer> tree = binarySearchTree.initializeTree(integerArray);     // New tree object

                        displayResult(tree);            // Displays the results

                    } catch (NumberFormatException e) {

                        NumberFormatExpression.getError();      // Prints out error message to user
                    }
                }

                else        // Runs if fractions radio button is selected

                    try {

                        Fraction fractionArray[] = new Fraction[splitList.length];      // Array for fractions

                        binarySearchTree = new BinarySearchTree<Fraction>();            // New instance of search tree for type fractions

                        for (int i = 0; i < splitList.length; i++) {        // Runs through elements in the list

                            String[] fractionNumbers = splitList[i].split("/");     // Stores fractions to the array

                            validateFraction(fractionNumbers);          // Performs validate fraction method

                            Fraction input = new Fraction(splitList[i]);            //New instance of the fraction class

                            fractionArray[i] = input;           // stores valid fractions to new element in array
                        }

                        Tree<Fraction> tree = binarySearchTree.initializeTree(fractionArray);   // Create new tree object

                        displayResult(tree);        // Displays results

                    } catch (NumberFormatExpression f) {

                        NumberFormatExpression.getError();      // Prints out error message
                    }
            }
        });

    }
}