package com.company;

import javax.swing.*;
import java.awt.*;

public class Swing {
    JButton button ;
    JButton button2;
    JTextField textField;
    JTextField textField2;
    JButton copy;
    JLabel label;
    JLabel label2;
    public void start (){
        JPanel panel =new JPanel();
        GridLayout flowLayout = new GridLayout(3,3);
        panel.setLayout(flowLayout);
        label = new JLabel("Copy from");
        label2 = new JLabel("Copy to");
        button =  new JButton("Brows");
        textField = new JTextField();
        button2 = new JButton("Brows");
        textField2 = new JTextField();
        copy = new JButton("Copy");
        JFrame  frame =new JFrame("Copy and Past");
        panel.add(label);
        panel.add(button);
        panel.add(textField);
        panel.add(label2);
        panel.add(button2);
        panel.add(textField2);
        panel.add(copy);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(650, 150);
        frame.setVisible(true);


        Action action = new Action(this);
        button.addActionListener(action);
        button2.addActionListener(action);
        copy.addActionListener(action);


    }



}
