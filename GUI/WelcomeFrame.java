/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.experiment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomeFrame extends JFrame {
    public WelcomeFrame() {
        // create label as title
        JLabel titleLabel = new JLabel("Welcome to Property Management System");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 30)); // set font size and style
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // center horizontally
        add(titleLabel, BorderLayout.CENTER);

        // create label for "click to continue"
        JLabel continueLabel = new JLabel("Click to continue");
        continueLabel.setFont(new Font("Serif", Font.BOLD, 18)); // set font size and style
        
        // create button to open second frame
        JButton openButton = new JButton();
        openButton.add(continueLabel); // add the label to the button
        openButton.setPreferredSize(new Dimension(180, 50));
        openButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // dispose the first frame
                SecondFrame secondFrame = new SecondFrame();
                secondFrame.setVisible(true);
            }
        });

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(openButton);
        add(panel, BorderLayout.SOUTH);

        setTitle("Welcome to Property Management System");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
