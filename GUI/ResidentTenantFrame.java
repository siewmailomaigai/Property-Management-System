import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ResidentTenantFrame extends JFrame implements ActionListener { 
    // Login panel
    JPanel loginPanel = new JPanel();
    JLabel UserIdLabel = new JLabel("User ID:");
    JLabel PasswordLabel = new JLabel("Password:");
    JTextField UserIdField = new JTextField();
    JPasswordField PasswordField = new JPasswordField();
    JButton loginButton = new JButton("Login");
    JButton returnButton = new JButton("Return");

    public ResidentTenantFrame() { 
        // Login Label  
        JLabel loginLabel = new JLabel("Login Page");
        loginLabel.setFont(new Font("Arial", Font.BOLD, 30)); // set font size and style
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER); // center horizontally
        add(loginLabel, BorderLayout.NORTH);  
            
        // Login panel components
        loginPanel.setLayout(new GridLayout(3, 2));
        UserIdLabel.setFont(new Font("Arial", Font.BOLD, 20));
        loginPanel.add(UserIdLabel);
        UserIdLabel.setHorizontalAlignment(SwingConstants.CENTER); // center horizontally
        loginPanel.add(UserIdField);
        PasswordLabel.setFont(new Font("Arial", Font.BOLD, 20));
        loginPanel.add(PasswordLabel);
        PasswordLabel.setHorizontalAlignment(SwingConstants.CENTER); // center horizontally
        loginPanel.add(PasswordField);
        loginPanel.add(new JLabel());
        loginPanel.add(loginButton);
        loginPanel.setPreferredSize(new Dimension(500, 300));
        
        // Center Login Panel
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.add(loginPanel);
        
        // Add return button to center panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10,0,0,0);
        centerPanel.add(returnButton, gbc);
        
        add(centerPanel, BorderLayout.CENTER);

        // Add action listeners to buttons
        loginButton.addActionListener(this);
        
        // Add action listener to back button
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // dispose the current frame
                SecondFrame secondFrame = new SecondFrame(); // create new instance of the previous frame
                secondFrame.setVisible(true); // make the previous frame visible
            }
        });

        pack();
        setTitle("Login page");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        // Get the username and password entered by the user
        String userId = UserIdField.getText();
        String password = new String(PasswordField.getPassword());

        // Validate the user's credentials
        if (LoginResident.validateCredentials(userId, password)) {
            // Display a success message
            JOptionPane.showMessageDialog(null, "Login successful!");
            // Open new frame after login is successful
            ResTent2 restent = new ResTent2();
            restent.setVisible(true);
            dispose();
        } else {
            // Display an error message
            JOptionPane.showMessageDialog(null, "Invalid username or password");
        }
    }

    static class LoginResident {
        private static boolean validateCredentials(String userId, String password) {
            try (BufferedReader br = new BufferedReader(new FileReader("residentfile.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split("\\|");
                    if (parts[0].equals(userId) && parts[3].equals(password)) {
                        return true;
                    }
                }
            } catch (IOException e) {
               
            e.printStackTrace();
        }
        return false;
        }
    }
}

