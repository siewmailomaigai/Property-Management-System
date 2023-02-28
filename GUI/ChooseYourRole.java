/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.experiment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChooseYourRole extends JFrame {
    public ChooseYourRole() {
        // create label as title
        JLabel titleLabel = new JLabel("Choose your role");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30)); // set font size and style
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // center horizontally
        add(titleLabel, BorderLayout.NORTH);

        // create panel for buttons
        JPanel buttonPanel = new JPanel(new GridLayout(2, 8, 10, 10)); // create 2 rows and 8 columns of buttons with 10 pixels of spacing
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50)); // add padding to the panel

        // create buttons with different names
        String[] buttonNames = {"Building Manager", "Account Executive", "Admin Executive", "Building Executive", "Resident/Tenant", "Vendor", "Security Guard", "Visitor"};
        for (int i = 0; i < 8; i++) {
            JButton button = new JButton(buttonNames[i]);
            button.setPreferredSize(new Dimension(100, 50));
            button.setFont(new Font("Arial", Font.BOLD, 15)); // set font of the button
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // switch to appropriate frame and close ChooseYourRole
                    if (button.getText().equals("Building Manager")) {
                        new BuildingManagerFrame();
                    } else if (button.getText().equals("Account Executive")) {
                        new AccountExecutiveFrame();
                    } else if (button.getText().equals("Admin Executive")) {
                        new AdminExecutiveFrame();
                    } else if (button.getText().equals("Building Executive")) {
                        new BuildingExecutiveFrame();
                    } else if (button.getText().equals("Resident/Tenant")) {
                        new ResidentTenantFrame();
                    } else if (button.getText().equals("Vendor")) {
                        new VendorFrame();
                    } else if (button.getText().equals("Security Guard")) {
                        new SecurityGuardFrame();
                    } else if (button.getText().equals("Visitor")) {
                        new VisitorFrame();
                    }
                    dispose();
                }
            });
            buttonPanel.add(button);
        }
        add(buttonPanel, BorderLayout.CENTER);

        setTitle("Roles");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
