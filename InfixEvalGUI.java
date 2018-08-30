/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package infixexpeval;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class InfixEvalGUI extends JFrame {


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        final InfixEval infix = new InfixEval();

        //Set up the frame and panels
        JFrame frame = new JFrame("Infix Evaluation Calculator");
        frame.setSize(400,175);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new GridLayout(3, 1));

        JPanel textPanel = new JPanel(new GridLayout(2, 1));
        textPanel.setPreferredSize(new Dimension (400, 60));
        textPanel.add(new JLabel("Enter Equation:"));
        textPanel.setToolTipText("i.e. (2+3)-((2*4)/9)");

        final JTextField textField = new JTextField();
        textField.setHorizontalAlignment(JTextField.LEFT);
        textPanel.add(textField);
        mainPanel.add(textPanel);


        JPanel resultPanel = new JPanel(new GridLayout(1, 2));
        resultPanel.add(new JLabel("Result: "));
        final JLabel label = new JLabel();
        resultPanel.add(label);
        mainPanel.add(resultPanel);

        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.setSize(300, 600);
        JButton button = new JButton();

        button.setText("Evaluate");
        panel.add(button);
        mainPanel.add(panel);
        frame.getContentPane().add(mainPanel);


        frame.setVisible(true);

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if ("Evaluate".equals(e.getActionCommand())) {
                    String expr = textField.getText();
                    label.setText(Double.toString(infix.infix(expr)));
                }
            }
        });
        button.setActionCommand("Evaluate");
    }

}