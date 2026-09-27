package com.miniproject_car;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Register extends JFrame implements ActionListener {

    private JLabel title;
    private JLabel emailLabel;
    private JLabel passwordLabel;

    private JTextField emailField;
    private JPasswordField passwordField;

    private JButton registerButton;
    private JButton clearButton;
    private JButton backButton;

    public Register() {

        title = new JLabel("CREATE ACCOUNT");

        emailLabel = new JLabel("Email:");
        passwordLabel = new JLabel("Password:");

        emailField = new JTextField();
        passwordField = new JPasswordField();

        registerButton = new JButton("REGISTER");
        clearButton = new JButton("CLEAR");
        backButton = new JButton("BACK");

        setLayout(null);

        // TITLE

        title.setFont(
                new Font("Arial", Font.BOLD, 28)
        );

        title.setForeground(Color.WHITE);

        title.setHorizontalAlignment(
                JLabel.CENTER
        );

        title.setBounds(
                150, 60, 500, 40
        );

        // EMAIL

        emailLabel.setFont(
                new Font("Arial", Font.BOLD, 16)
        );

        emailLabel.setForeground(Color.WHITE);

        emailLabel.setBounds(
                200, 160, 100, 30
        );

        emailField.setBounds(
                300, 160, 250, 35
        );

        // PASSWORD

        passwordLabel.setFont(
                new Font("Arial", Font.BOLD, 16)
        );

        passwordLabel.setForeground(Color.WHITE);

        passwordLabel.setBounds(
                200, 220, 100, 30
        );

        passwordField.setBounds(
                300, 220, 250, 35
        );

        // REGISTER BUTTON

        registerButton.setBounds(
                180, 310, 130, 40
        );

        registerButton.setBackground(
                new Color(0, 128, 0)
        );

        registerButton.setForeground(Color.WHITE);

        registerButton.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        // CLEAR BUTTON

        clearButton.setBounds(
                335, 310, 120, 40
        );

        clearButton.setBackground(
                new Color(100, 100, 100)
        );

        clearButton.setForeground(Color.WHITE);

        clearButton.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        // BACK BUTTON

        backButton.setBounds(
                480, 310, 120, 40
        );

        backButton.setBackground(
                new Color(0, 102, 204)
        );

        backButton.setForeground(Color.WHITE);

        backButton.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        // ADD COMPONENTS

        add(title);

        add(emailLabel);
        add(emailField);

        add(passwordLabel);
        add(passwordField);

        add(registerButton);
        add(clearButton);
        add(backButton);

        // ACTION LISTENERS

        registerButton.addActionListener(this);
        clearButton.addActionListener(this);
        backButton.addActionListener(this);

        // BACKGROUND IMAGE

        try {

            java.net.URL imageURL =
                    getClass().getResource(
                            "/com/miniproject_car/car_background.jpg"
                    );

            if (imageURL != null) {

                ImageIcon icon =
                        new ImageIcon(imageURL);

                Image image =
                        icon.getImage().getScaledInstance(
                                800,
                                500,
                                Image.SCALE_SMOOTH
                        );

                JLabel background =
                        new JLabel(
                                new ImageIcon(image)
                        );

                background.setBounds(
                        0, 0, 800, 500
                );

                add(background);

            } else {

                getContentPane().setBackground(
                        new Color(40, 40, 40)
                );
            }

        } catch (Exception e) {

            getContentPane().setBackground(
                    new Color(40, 40, 40)
            );
        }

        setTitle("Register");

        setSize(800, 500);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        // REGISTER

        if (ae.getSource() == registerButton) {

            String email =
                    emailField.getText().trim();

            String password =
                    new String(
                            passwordField.getPassword()
                    );

            if (email.isEmpty() ||
                password.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please fill all fields"
                );

                return;
            }

            try {

                Class.forName(
                        "com.mysql.cj.jdbc.Driver"
                );

                Connection con =
                        DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/car_project",
                                "root",
                                "thrisha"
                        );

                // Database columns:
                // email and pass

                String sql =
                        "INSERT INTO users " +
                        "(email, pass) " +
                        "VALUES (?, ?)";

                PreparedStatement pst =
                        con.prepareStatement(sql);

                pst.setString(
                        1,
                        email
                );

                pst.setString(
                        2,
                        password
                );

                int result =
                        pst.executeUpdate();

                if (result > 0) {

                    JOptionPane.showMessageDialog(
                            this,
                            "REGISTRATION SUCCESSFUL"
                    );

                    new Login();

                    this.dispose();
                }

                pst.close();
                con.close();

            } catch (Exception e) {

                e.printStackTrace();

                JOptionPane.showMessageDialog(
                        this,
                        "Database Error: " +
                        e.getMessage()
                );
            }
        }

        // CLEAR

        else if (ae.getSource() == clearButton) {

            emailField.setText("");

            passwordField.setText("");

            emailField.requestFocus();
        }

        // BACK

        else if (ae.getSource() == backButton) {

            new Login();

            this.dispose();
        }
    }
}