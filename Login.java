package com.miniproject_car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    private JTextField emailField;
    private JPasswordField passwordField;
    private JCheckBox showPassword;
    private JButton loginButton, clearButton, signupButton;

    private static final Color GOLD = new Color(255, 193, 7);
    private static final Color DARK = new Color(18, 20, 28);
    private static final Color CARD = new Color(15, 18, 27, 225);

    public Login() {
        setTitle("Car Management System - Login");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        BackgroundPanel bg = new BackgroundPanel(
                "C:\\Users\\thris\\OneDrive\\Desktop\\car.jpg");
        bg.setLayout(null);
        setContentPane(bg);

        JLabel title = new JLabel("CAR MANAGEMENT SYSTEM");
        title.setFont(new Font("SansSerif", Font.BOLD, 32));
        title.setForeground(GOLD);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds(190, 45, 520, 45);
        bg.add(title);

        JLabel subtitle = new JLabel("SMART • SIMPLE • PREMIUM");
        subtitle.setFont(new Font("SansSerif", Font.PLAIN, 16));
        subtitle.setForeground(Color.WHITE);
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);
        subtitle.setBounds(230, 90, 440, 30);
        bg.add(subtitle);

        JLabel emailLabel = label("EMAIL ADDRESS");
        emailLabel.setBounds(250, 150, 180, 25);
        bg.add(emailLabel);

        emailField = new JTextField();
        styleField(emailField);
        emailField.setBounds(250, 178, 400, 42);
        bg.add(emailField);

        JLabel passLabel = label("PASSWORD");
        passLabel.setBounds(250, 235, 180, 25);
        bg.add(passLabel);

        passwordField = new JPasswordField();
        styleField(passwordField);
        passwordField.setEchoChar('•');
        passwordField.setBounds(250, 263, 400, 42);
        bg.add(passwordField);

        showPassword = new JCheckBox("Show Password");
        showPassword.setFont(new Font("SansSerif", Font.PLAIN, 13));
        showPassword.setForeground(Color.WHITE);
        showPassword.setOpaque(false);
        showPassword.setFocusPainted(false);
        showPassword.setBounds(250, 310, 150, 25);
        showPassword.addActionListener(this);
        bg.add(showPassword);

        loginButton = button("LOGIN", new Color(25, 155, 90));
        loginButton.setBounds(250, 360, 120, 45);
        bg.add(loginButton);

        clearButton = button("CLEAR", new Color(80, 85, 95));
        clearButton.setBounds(390, 360, 120, 45);
        bg.add(clearButton);

        signupButton = button("SIGN UP", new Color(35, 105, 190));
        signupButton.setBounds(530, 360, 120, 45);
        bg.add(signupButton);

        JLabel footer = new JLabel("© 2026 Car Management System");
        footer.setForeground(new Color(230, 230, 230));
        footer.setFont(new Font("SansSerif", Font.PLAIN, 12));
        footer.setHorizontalAlignment(SwingConstants.CENTER);
        footer.setBounds(250, 500, 400, 25);
        bg.add(footer);

        loginButton.addActionListener(this);
        clearButton.addActionListener(this);
        signupButton.addActionListener(this);

        setVisible(true);
    }

    private JLabel label(String text) {
        JLabel l = new JLabel(text);
        l.setFont(new Font("SansSerif", Font.BOLD, 13));
        l.setForeground(Color.WHITE);
        return l;
    }

    private void styleField(JTextField f) {
        f.setFont(new Font("SansSerif", Font.PLAIN, 15));
        f.setBackground(new Color(248, 249, 252));
        f.setForeground(DARK);
        f.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(210, 214, 224), 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
    }

    private JButton button(String text, Color color) {
        JButton b = new JButton(text);
        b.setFont(new Font("SansSerif", Font.BOLD, 13));
        b.setForeground(Color.WHITE);
        b.setBackground(color);
        b.setFocusPainted(false);
        b.setBorderPainted(false);
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return b;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == showPassword) {
            passwordField.setEchoChar(showPassword.isSelected() ? (char) 0 : '•');
        } else if (e.getSource() == clearButton) {
            emailField.setText("");
            passwordField.setText("");
            showPassword.setSelected(false);
            passwordField.setEchoChar('•');
            emailField.requestFocus();
        } else if (e.getSource() == signupButton) {
            try {
                new Register();
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Register.java is required for Sign Up.",
                        "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == loginButton) {
            login();
        }
    }

    private void login() {
        String email = emailField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter email and password.",
                    "Login Required", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/car_project", "root", "thrisha");
                 PreparedStatement pst = con.prepareStatement(
                    "SELECT * FROM users WHERE email=? AND pass=?")) {

                pst.setString(1, email);
                pst.setString(2, password);

                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(this,
                                "Welcome back! Login successful.",
                                "Success", JOptionPane.INFORMATION_MESSAGE);
                        new CarHome();
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(this,
                                "Invalid email or password.",
                                "Login Failed", JOptionPane.ERROR_MESSAGE);
                        passwordField.setText("");
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Database Error:\n" + ex.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    static class BackgroundPanel extends JPanel {
        private Image image;

        BackgroundPanel(String path) {
            ImageIcon icon = new ImageIcon(path);
            if (icon.getIconWidth() > 0) image = icon.getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();

            if (image != null) {
                g2.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            } else {
                g2.setColor(DARK);
                g2.fillRect(0, 0, getWidth(), getHeight());
            }

            g2.setColor(new Color(0, 0, 0, 145));
            g2.fillRect(0, 0, getWidth(), getHeight());

            g2.setColor(CARD);
            g2.fillRoundRect(180, 25, 540, 470, 30, 30);

            g2.setColor(new Color(255, 193, 7, 180));
            g2.setStroke(new BasicStroke(2));
            g2.drawRoundRect(180, 25, 540, 470, 30, 30);

            g2.dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Login::new);
    }
}



/*package com.miniproject_car;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


// ======================================================
// LOGIN CLASS
// ======================================================

public class Login extends JFrame implements ActionListener {

    private JLabel title;
    private JLabel subtitle;

    private JLabel emailLabel;
    private JLabel passwordLabel;

    private JTextField emailField;
    private JPasswordField passwordField;

    private JCheckBox showPassword;

    private JButton loginButton;
    private JButton clearButton;
    private JButton signupButton;

    private BackgroundPanel backgroundPanel;


    // ======================================================
    // CONSTRUCTOR
    // ======================================================

    public Login() {

        // ==================================================
        // BACKGROUND PANEL
        // ==================================================

        backgroundPanel = new BackgroundPanel(
                "C:\\Users\\thris\\OneDrive\\Desktop\\car.jpg"
        );

        backgroundPanel.setLayout(null);

        setContentPane(backgroundPanel);


        // ==================================================
        // CREATE COMPONENTS
        // ==================================================

        title = new JLabel(
                "CAR MANAGEMENT SYSTEM"
        );

        subtitle = new JLabel(
                "WELCOME BACK"
        );

        emailLabel = new JLabel(
                "Email Address"
        );

        passwordLabel = new JLabel(
                "Password"
        );

        emailField = new JTextField();

        passwordField = new JPasswordField();

        showPassword = new JCheckBox(
                "Show Password"
        );

        loginButton = new JButton(
                "LOGIN"
        );

        clearButton = new JButton(
                "CLEAR"
        );

        signupButton = new JButton(
                "SIGN UP"
        );


        // ==================================================
        // TITLE
        // ==================================================

        title.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        30
                )
        );

        title.setForeground(
                new Color(255, 215, 0)
        );

        title.setHorizontalAlignment(
                JLabel.CENTER
        );

        title.setBounds(
                150,
                35,
                500,
                45
        );


        // ==================================================
        // SUBTITLE
        // ==================================================

        subtitle.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        18
                )
        );

        subtitle.setForeground(
                Color.WHITE
        );

        subtitle.setHorizontalAlignment(
                JLabel.CENTER
        );

        subtitle.setBounds(
                180,
                85,
                440,
                35
        );


        // ==================================================
        // EMAIL LABEL
        // ==================================================

        emailLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        15
                )
        );

        emailLabel.setForeground(
                new Color(255, 255, 255)
        );

        emailLabel.setBounds(
                200,
                145,
                150,
                30
        );


        // ==================================================
        // EMAIL FIELD
        // ==================================================

        emailField.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        15
                )
        );

        emailField.setForeground(
                new Color(30, 30, 30)
        );

        emailField.setBackground(
                new Color(245, 245, 245)
        );

        emailField.setBounds(
                200,
                175,
                400,
                38
        );


        // ==================================================
        // PASSWORD LABEL
        // ==================================================

        passwordLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        15
                )
        );

        passwordLabel.setForeground(
                Color.WHITE
        );

        passwordLabel.setBounds(
                200,
                220,
                150,
                30
        );


        // ==================================================
        // PASSWORD FIELD
        // ==================================================

        passwordField.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        15
                )
        );

        passwordField.setForeground(
                new Color(30, 30, 30)
        );

        passwordField.setBackground(
                new Color(245, 245, 245)
        );

        passwordField.setBounds(
                200,
                250,
                400,
                38
        );


        // ==================================================
        // SHOW PASSWORD
        // ==================================================

        showPassword.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        13
                )
        );

        showPassword.setForeground(
                Color.WHITE
        );

        showPassword.setOpaque(
                false
        );

        showPassword.setFocusPainted(
                false
        );

        showPassword.setBounds(
                200,
                290,
                160,
                30
        );


        // ==================================================
        // LOGIN BUTTON
        // ==================================================

        loginButton.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        14
                )
        );

        loginButton.setForeground(
                Color.WHITE
        );

        loginButton.setBackground(
                new Color(0, 153, 76)
        );

        loginButton.setFocusPainted(
                false
        );

        loginButton.setBorderPainted(
                false
        );

        loginButton.setBounds(
                200,
                340,
                120,
                42
        );


        // ==================================================
        // CLEAR BUTTON
        // ==================================================

        clearButton.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        14
                )
        );

        clearButton.setForeground(
                Color.WHITE
        );

        clearButton.setBackground(
                new Color(90, 90, 100)
        );

        clearButton.setFocusPainted(
                false
        );

        clearButton.setBorderPainted(
                false
        );

        clearButton.setBounds(
                340,
                340,
                120,
                42
        );


        // ==================================================
        // SIGN UP BUTTON
        // ==================================================

        signupButton.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        14
                )
        );

        signupButton.setForeground(
                Color.WHITE
        );

        signupButton.setBackground(
                new Color(0, 102, 204)
        );

        signupButton.setFocusPainted(
                false
        );

        signupButton.setBorderPainted(
                false
        );

        signupButton.setBounds(
                480,
                340,
                120,
                42
        );


        // ==================================================
        // ADD COMPONENTS
        // ==================================================

        backgroundPanel.add(title);

        backgroundPanel.add(subtitle);

        backgroundPanel.add(emailLabel);

        backgroundPanel.add(emailField);

        backgroundPanel.add(passwordLabel);

        backgroundPanel.add(passwordField);

        backgroundPanel.add(showPassword);

        backgroundPanel.add(loginButton);

        backgroundPanel.add(clearButton);

        backgroundPanel.add(signupButton);


        // ==================================================
        // ACTION LISTENERS
        // ==================================================

        loginButton.addActionListener(this);

        clearButton.addActionListener(this);

        signupButton.addActionListener(this);

        showPassword.addActionListener(this);


        // ==================================================
        // FRAME SETTINGS
        // ==================================================

        setTitle(
                "Car Management System"
        );

        setSize(
                800,
                500
        );

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(
                null
        );

        setResizable(
                false
        );

        setVisible(
                true
        );
    }


    // ======================================================
    // ACTION PERFORMED
    // ======================================================

    @Override
    public void actionPerformed(
            ActionEvent ae
    ) {


        // ==================================================
        // LOGIN
        // ==================================================

        if (ae.getSource() == loginButton) {

            String email =
                    emailField
                            .getText()
                            .trim();

            String password =
                    new String(
                            passwordField
                                    .getPassword()
                    );


            // Check empty fields

            if (email.isEmpty() ||
                password.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter Email and Password",
                        "Login Required",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }


            try {

                // Load MySQL Driver

                Class.forName(
                        "com.mysql.cj.jdbc.Driver"
                );


                // Database connection

                Connection con =
                        DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/car_project",
                                "root",
                                "thrisha"
                        );


                // SQL query

                String sql =
                        "SELECT * FROM users " +
                        "WHERE email=? AND pass=?";


                PreparedStatement pst =
                        con.prepareStatement(
                                sql
                        );


                // Set values

                pst.setString(
                        1,
                        email
                );

                pst.setString(
                        2,
                        password
                );


                // Execute query

                ResultSet rs =
                        pst.executeQuery();


                // ==================================================
                // LOGIN SUCCESS
                // ==================================================

                if (rs.next()) {

                    JOptionPane.showMessageDialog(
                            this,
                            "LOGIN SUCCESSFUL!",
                            "Welcome",
                            JOptionPane.INFORMATION_MESSAGE
                    );


                    // Open Car Home

                    new CarHome();

                    // Close Login

                    this.dispose();

                } else {

                    // ==================================================
                    // LOGIN FAILED
                    // ==================================================

                    JOptionPane.showMessageDialog(
                            this,
                            "Invalid Email or Password",
                            "Login Failed",
                            JOptionPane.ERROR_MESSAGE
                    );
                }


                // Close resources

                rs.close();

                pst.close();

                con.close();


            } catch (Exception e) {

                e.printStackTrace();

                JOptionPane.showMessageDialog(
                        this,
                        "Database Error:\n"
                                + e.getMessage(),
                        "Database Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }


        // ==================================================
        // CLEAR BUTTON
        // ==================================================

        else if (
                ae.getSource()
                        == clearButton
        ) {

            emailField.setText("");

            passwordField.setText("");

            showPassword.setSelected(
                    false
            );

            passwordField.setEchoChar(
                    '\u2022'
            );

            emailField.requestFocus();
        }


        // ==================================================
        // SIGN UP BUTTON
        // ==================================================

        else if (
                ae.getSource()
                        == signupButton
        ) {

            new Register();

            this.dispose();
        }


        // ==================================================
        // SHOW PASSWORD
        // ==================================================

        else if (
                ae.getSource()
                        == showPassword
        ) {

            if (
                    showPassword.isSelected()
            ) {

                passwordField.setEchoChar(
                        (char) 0
                );

            } else {

                passwordField.setEchoChar(
                        '\u2022'
                );
            }
        }
    }


    // ======================================================
    // MAIN METHOD
    // ======================================================

    public static void main(
            String[] args
    ) {

        new Login();
    }
}


// ==========================================================
// BACKGROUND PANEL
// ==========================================================

class BackgroundPanel extends JPanel {

    private Image backgroundImage;


    // ======================================================
    // CONSTRUCTOR
    // ======================================================

    public BackgroundPanel(
            String imagePath
    ) {

        try {

            // Load image directly from
            // Desktop path

            ImageIcon icon =
                    new ImageIcon(
                            imagePath
                    );


            // Check image

            if (
                    icon.getIconWidth()
                            == -1
            ) {

                System.out.println(
                        "Background image not found!"
                );

            } else {

                backgroundImage =
                        icon.getImage();

                System.out.println(
                        "Background image loaded successfully!"
                );
            }


        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    // ======================================================
    // PAINT BACKGROUND
    // ======================================================

    @Override
    protected void paintComponent(
            Graphics g
    ) {

        super.paintComponent(g);


        Graphics2D g2 =
                (Graphics2D) g;


        // Smooth image

        g2.setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR
        );


        // ==================================================
        // DRAW BACKGROUND IMAGE
        // ==================================================

        if (
                backgroundImage != null
        ) {

            g2.drawImage(
                    backgroundImage,
                    0,
                    0,
                    getWidth(),
                    getHeight(),
                    this
            );

        } else {

            // Fallback color

            g2.setColor(
                    new Color(
                            20,
                            20,
                            30
                    )
            );

            g2.fillRect(
                    0,
                    0,
                    getWidth(),
                    getHeight()
            );
        }


        // ==================================================
        // DARK OVERLAY
        // ==================================================

        g2.setColor(
                new Color(
                        0,
                        0,
                        0,
                        100
                )
        );

        g2.fillRect(
                0,
                0,
                getWidth(),
                getHeight()
        );


        // ==================================================
        // LOGIN CARD
        // ==================================================

        g2.setColor(
                new Color(
                        0,
                        0,
                        0,
                        160
                )
        );

        g2.fillRoundRect(
                160,
                20,
                480,
                390,
                25,
                25
        );


        // ==================================================
        // GOLD BORDER
        // ==================================================

        g2.setColor(
                new Color(
                        255,
                        215,
                        0,
                        200
                )
        );

        g2.drawRoundRect(
                160,
                20,
                480,
                390,
                25,
                25
        );
    }
}










/*package com.miniproject_car;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
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
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    private JLabel title;
    private JLabel subtitle;
    private JLabel emailLabel;
    private JLabel passwordLabel;

    private JTextField emailField;
    private JPasswordField passwordField;

    private JCheckBox showPassword;

    private JButton loginButton;
    private JButton clearButton;
    private JButton signupButton;

    public Login() {

        title = new JLabel("CAR MANAGEMENT SYSTEM");
        subtitle = new JLabel("LOGIN TO YOUR ACCOUNT");

        emailLabel = new JLabel("Email:");
        passwordLabel = new JLabel("Password:");

        emailField = new JTextField();
        passwordField = new JPasswordField();

        showPassword = new JCheckBox("Show Password");

        loginButton = new JButton("LOGIN");
        clearButton = new JButton("CLEAR");
        signupButton = new JButton("SIGN UP");

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
                150, 50, 500, 40
        );

        // SUBTITLE

        subtitle.setFont(
                new Font("Arial", Font.BOLD, 20)
        );

        subtitle.setForeground(Color.WHITE);

        subtitle.setHorizontalAlignment(
                JLabel.CENTER
        );

        subtitle.setBounds(
                180, 100, 440, 35
        );

        // EMAIL

        emailLabel.setFont(
                new Font("Arial", Font.BOLD, 16)
        );

        emailLabel.setForeground(Color.WHITE);

        emailLabel.setBounds(
                200, 170, 100, 30
        );

        emailField.setBounds(
                300, 170, 250, 35
        );

        // PASSWORD

        passwordLabel.setFont(
                new Font("Arial", Font.BOLD, 16)
        );

        passwordLabel.setForeground(Color.WHITE);

        passwordLabel.setBounds(
                200, 225, 100, 30
        );

        passwordField.setBounds(
                300, 225, 250, 35
        );

        // SHOW PASSWORD

        showPassword.setBounds(
                300, 270, 150, 30
        );

        showPassword.setOpaque(false);

        showPassword.setForeground(Color.WHITE);

        // LOGIN BUTTON

        loginButton.setBounds(
                200, 330, 120, 40
        );

        loginButton.setBackground(
                new Color(0, 128, 0)
        );

        loginButton.setForeground(Color.WHITE);

        loginButton.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        // CLEAR BUTTON

        clearButton.setBounds(
                340, 330, 120, 40
        );

        clearButton.setBackground(
                new Color(100, 100, 100)
        );

        clearButton.setForeground(Color.WHITE);

        clearButton.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        // SIGN UP BUTTON

        signupButton.setBounds(
                480, 330, 120, 40
        );

        signupButton.setBackground(
                new Color(0, 102, 204)
        );

        signupButton.setForeground(Color.WHITE);

        signupButton.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        // ADD COMPONENTS

        add(title);
        add(subtitle);

        add(emailLabel);
        add(emailField);

        add(passwordLabel);
        add(passwordField);

        add(showPassword);

        add(loginButton);
        add(clearButton);
        add(signupButton);

        // ACTION LISTENERS

        loginButton.addActionListener(this);
        clearButton.addActionListener(this);
        signupButton.addActionListener(this);
        showPassword.addActionListener(this);

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

        setTitle("Car Management System");

        setSize(800, 500);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        // LOGIN

        if (ae.getSource() == loginButton) {

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
                        "Please enter Email and Password"
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

                // IMPORTANT:
                // Database column is "pass", not "password"

                String sql =
                        "SELECT * FROM users " +
                        "WHERE email=? AND pass=?";

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

                ResultSet rs =
                        pst.executeQuery();

                if (rs.next()) {

                    JOptionPane.showMessageDialog(
                            this,
                            "LOGIN SUCCESSFUL"
                    );

                    new CarHome();

                    this.dispose();

                } else {

                    JOptionPane.showMessageDialog(
                            this,
                            "Invalid Email or Password"
                    );
                }

                rs.close();
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

        // SIGN UP

        else if (ae.getSource() == signupButton) {

            new Register();

            this.dispose();
        }

        // SHOW PASSWORD

        else if (ae.getSource() == showPassword) {

            if (showPassword.isSelected()) {

                passwordField.setEchoChar(
                        (char) 0
                );

            } else {

                passwordField.setEchoChar(
                        '\u2022'
                );
            }
        }
    }
}*/