package com.miniproject_car;

import javax.swing.JFrame;
import javax.swing.JLabel;
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

public class CarHome extends JFrame implements ActionListener {

    private JLabel title;
    private JLabel welcome;

    private JButton viewCars;
    private JButton addCar;
    private JButton logout;

    private BackgroundPanel backgroundPanel;

    public CarHome() {

        // ==============================
        // BACKGROUND PANEL
        // ==============================

        backgroundPanel = new BackgroundPanel(
                "C:\\Users\\thris\\OneDrive\\Desktop\\car.jpg"
        );

        backgroundPanel.setLayout(null);

        setContentPane(backgroundPanel);

        // ==============================
        // LABELS
        // ==============================

        title = new JLabel("CAR MANAGEMENT SYSTEM");

        welcome = new JLabel("WELCOME TO CAR MANAGEMENT");

        // ==============================
        // BUTTONS
        // ==============================

        viewCars = new JButton("VIEW CARS");

        addCar = new JButton("ADD CAR");

        logout = new JButton("LOGOUT");

        // ==============================
        // TITLE
        // ==============================

        title.setFont(
                new Font("Serif", Font.BOLD, 30)
        );

        title.setForeground(
                new Color(255, 215, 0)
        );

        title.setHorizontalAlignment(
                JLabel.CENTER
        );

        title.setBounds(
                150,
                60,
                500,
                45
        );

        // ==============================
        // WELCOME
        // ==============================

        welcome.setFont(
                new Font("SansSerif", Font.BOLD, 20)
        );

        welcome.setForeground(
                Color.WHITE
        );

        welcome.setHorizontalAlignment(
                JLabel.CENTER
        );

        welcome.setBounds(
                180,
                115,
                440,
                35
        );

        // ==============================
        // VIEW CARS BUTTON
        // ==============================

        viewCars.setBounds(
                250,
                200,
                300,
                50
        );

        viewCars.setFont(
                new Font("SansSerif", Font.BOLD, 16)
        );

        viewCars.setForeground(
                Color.WHITE
        );

        viewCars.setBackground(
                new Color(0, 102, 204)
        );

        viewCars.setFocusPainted(false);

        viewCars.setBorderPainted(false);

        // ==============================
        // ADD CAR BUTTON
        // ==============================

        addCar.setBounds(
                250,
                270,
                300,
                50
        );

        addCar.setFont(
                new Font("SansSerif", Font.BOLD, 16)
        );

        addCar.setForeground(
                Color.WHITE
        );

        addCar.setBackground(
                new Color(0, 140, 70)
        );

        addCar.setFocusPainted(false);

        addCar.setBorderPainted(false);

        // ==============================
        // LOGOUT BUTTON
        // ==============================

        logout.setBounds(
                250,
                340,
                300,
                50
        );

        logout.setFont(
                new Font("SansSerif", Font.BOLD, 16)
        );

        logout.setForeground(
                Color.WHITE
        );

        logout.setBackground(
                new Color(170, 30, 30)
        );

        logout.setFocusPainted(false);

        logout.setBorderPainted(false);

        // ==============================
        // ADD COMPONENTS
        // ==============================

        backgroundPanel.add(title);

        backgroundPanel.add(welcome);

        backgroundPanel.add(viewCars);

        backgroundPanel.add(addCar);

        backgroundPanel.add(logout);

        // ==============================
        // ACTION LISTENERS
        // ==============================

        viewCars.addActionListener(this);

        addCar.addActionListener(this);

        logout.addActionListener(this);

        // ==============================
        // FRAME SETTINGS
        // ==============================

        setTitle("CAR MANAGEMENT SYSTEM");

        setSize(800, 550);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        setResizable(false);

        setVisible(true);
    }

    // =====================================================
    // BUTTON ACTIONS
    // =====================================================

    @Override
    public void actionPerformed(ActionEvent ae) {

        // ==============================
        // VIEW CARS
        // ==============================

        if (ae.getSource() == viewCars) {

            new CarDetails();

            this.dispose();
        }

        // ==============================
        // ADD CAR
        // ==============================

        else if (ae.getSource() == addCar) {

            new Addcar();

            this.dispose();
        }

        // ==============================
        // LOGOUT
        // ==============================

        else if (ae.getSource() == logout) {

            int choice = JOptionPane.showConfirmDialog(
                    this,
                    "Do you want to logout?",
                    "Logout",
                    JOptionPane.YES_NO_OPTION
            );

            if (choice == JOptionPane.YES_OPTION) {

                new Login();

                this.dispose();
            }
        }
    }
}


// =========================================================
// BACKGROUND PANEL CLASS
// =========================================================

class BackgroundPanel extends JPanel {

    private Image backgroundImage;

    public BackgroundPanel(String imagePath) {

        try {

            ImageIcon icon =
                    new ImageIcon(imagePath);

            if (icon.getIconWidth() == -1) {

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

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 =
                (Graphics2D) g;

        // Smooth image
        g2.setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR
        );

        // ==============================
        // DRAW BACKGROUND IMAGE
        // ==============================

        if (backgroundImage != null) {

            g2.drawImage(
                    backgroundImage,
                    0,
                    0,
                    getWidth(),
                    getHeight(),
                    this
            );

        } else {

            g2.setColor(
                    new Color(30, 30, 30)
            );

            g2.fillRect(
                    0,
                    0,
                    getWidth(),
                    getHeight()
            );
        }

        // ==============================
        // DARK OVERLAY
        // ==============================

        g2.setColor(
                new Color(0, 0, 0, 110)
        );

        g2.fillRect(
                0,
                0,
                getWidth(),
                getHeight()
        );

        // ==============================
        // MANAGEMENT CARD
        // ==============================

        g2.setColor(
                new Color(0, 0, 0, 160)
        );

        g2.fillRoundRect(
                150,
                30,
                500,
                420,
                30,
                30
        );

        // ==============================
        // GOLD BORDER
        // ==============================

        g2.setColor(
                new Color(255, 215, 0, 200)
        );

        g2.drawRoundRect(
                150,
                30,
                500,
                420,
                30,
                30
        );
    }
}