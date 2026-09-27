package com.miniproject_car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CarHome extends JFrame implements ActionListener {

    private JLabel totalCars;
    private JLabel totalBookings;
    private JLabel totalUsers;

    private JButton viewCars;
    private JButton addCar;
    private JButton bookings;
    private JButton refresh;
    private JButton logout;

    private static final Color BG =
            new Color(10, 13, 20);

    private static final Color CARD =
            new Color(22, 27, 38);

    private static final Color CARD2 =
            new Color(28, 34, 47);

    private static final Color GOLD =
            new Color(255, 193, 7);

    private static final Color TEXT =
            new Color(225, 229, 236);

    private static final Color MUTED =
            new Color(155, 164, 180);

    public CarHome() {

        setTitle("THRISHA CARZONE - Premium Dashboard");

        setSize(1100, 720);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setResizable(false);

        DashboardPanel main =
                new DashboardPanel();

        main.setLayout(null);

        setContentPane(main);

        // ================= HEADER =================

        JLabel logo =
                new JLabel("TC");

        logo.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        18));

        logo.setForeground(BG);

        logo.setBackground(GOLD);

        logo.setOpaque(true);

        logo.setHorizontalAlignment(
                SwingConstants.CENTER);

        logo.setBounds(
                35, 28, 52, 52);

        main.add(logo);

        JLabel title =
                new JLabel(
                        "THRISHA CARZONE");

        title.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        30));

        title.setForeground(GOLD);

        title.setBounds(
                105, 25, 400, 40);

        main.add(title);

        JLabel subtitle =
                new JLabel(
                        "CAR MANAGEMENT SYSTEM");

        subtitle.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        13));

        subtitle.setForeground(MUTED);

        subtitle.setBounds(
                107, 58, 400, 25);

        main.add(subtitle);

        JLabel status =
                new JLabel(
                        "● SYSTEM ONLINE");

        status.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        12));

        status.setForeground(
                new Color(
                        55, 210, 125));

        status.setBounds(
                850, 42, 180, 25);

        main.add(status);

        // ================= WELCOME =================

        JLabel welcome =
                new JLabel(
                        "Welcome to your premium car management dashboard");

        welcome.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        15));

        welcome.setForeground(TEXT);

        welcome.setBounds(
                35, 105, 600, 30);

        main.add(welcome);

        // ================= STAT CARDS =================

        JPanel carCard =
                createStatCard(
                        "TOTAL CARS",
                        "0",
                        "Available vehicles",
                        35);

        JPanel bookingCard =
                createStatCard(
                        "TOTAL BOOKINGS",
                        "0",
                        "Customer bookings",
                        355);

        JPanel userCard =
                createStatCard(
                        "TOTAL USERS",
                        "0",
                        "Registered users",
                        675);

        main.add(carCard);

        main.add(bookingCard);

        main.add(userCard);

        totalCars =
                (JLabel)
                        carCard.getClientProperty(
                                "value");

        totalBookings =
                (JLabel)
                        bookingCard.getClientProperty(
                                "value");

        totalUsers =
                (JLabel)
                        userCard.getClientProperty(
                                "value");

        // ================= SECTION =================

        JLabel section =
                new JLabel(
                        "QUICK ACTIONS");

        section.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        18));

        section.setForeground(
                Color.WHITE);

        section.setBounds(
                35, 235, 300, 30);

        main.add(section);

        JLabel sectionLine =
                new JLabel(
                        "Manage your showroom");

        sectionLine.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        12));

        sectionLine.setForeground(MUTED);

        sectionLine.setBounds(
                35, 260, 300, 25);

        main.add(sectionLine);

        // ================= VIEW CARS =================

        viewCars =
                premiumButton(
                        "VIEW & SEARCH CARS",
                        "Browse showroom inventory",
                        new Color(
                                35, 105, 190));

        viewCars.setBounds(
                35, 300, 325, 85);

        main.add(viewCars);

        // ================= ADD CAR =================

        addCar =
                premiumButton(
                        "ADD NEW CAR",
                        "Add vehicle to inventory",
                        new Color(
                                25, 145, 90));

        addCar.setBounds(
                385, 300, 325, 85);

        main.add(addCar);

        // ================= BOOKINGS =================

        bookings =
                premiumButton(
                        "VIEW BOOKINGS",
                        "Customer booking history",
                        new Color(
                                190, 135, 20));

        bookings.setBounds(
                735, 300, 325, 85);

        main.add(bookings);

        // ================= REFRESH =================

        refresh =
                premiumButton(
                        "REFRESH DASHBOARD",
                        "Update live statistics",
                        new Color(
                                85, 75, 145));

        refresh.setBounds(
                35, 405, 500, 80);

        main.add(refresh);

        // ================= LOGOUT =================

        logout =
                premiumButton(
                        "LOGOUT",
                        "Exit THRISHA CARZONE",
                        new Color(
                                150, 45, 60));

        logout.setBounds(
                560, 405, 500, 80);

        main.add(logout);

        // ================= BOTTOM INFO =================

        JPanel infoPanel =
                new JPanel(null);

        infoPanel.setBackground(
                new Color(
                        18, 22, 31));

        infoPanel.setBorder(
                BorderFactory.createLineBorder(
                        new Color(
                                50, 57, 72)));

        infoPanel.setBounds(
                35, 520, 1025, 80);

        main.add(infoPanel);

        JLabel infoTitle =
                new JLabel(
                        "THRISHA CARZONE");

        infoTitle.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        15));

        infoTitle.setForeground(GOLD);

        infoTitle.setBounds(
                20, 15, 220, 25);

        infoPanel.add(infoTitle);

        JLabel infoText =
                new JLabel(
                        "SMART  •  SIMPLE  •  PREMIUM");

        infoText.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        12));

        infoText.setForeground(MUTED);

        infoText.setBounds(
                20, 40, 300, 20);

        infoPanel.add(infoText);

        JLabel features =
                new JLabel(
                        "Inventory  |  Bookings  |  Customers  |  Management");

        features.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        12));

        features.setForeground(TEXT);

        features.setHorizontalAlignment(
                SwingConstants.RIGHT);

        features.setBounds(
                450, 25, 550, 30);

        infoPanel.add(features);

        // ================= FOOTER =================

        JLabel footer =
                new JLabel(
                        "© 2026 THRISHA CARZONE");

        footer.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        11));

        footer.setForeground(
                new Color(
                        100, 108, 123));

        footer.setHorizontalAlignment(
                SwingConstants.CENTER);

        footer.setBounds(
                350, 630, 400, 20);

        main.add(footer);

        // ================= EVENTS =================

        viewCars.addActionListener(this);

        addCar.addActionListener(this);

        bookings.addActionListener(this);

        refresh.addActionListener(this);

        logout.addActionListener(this);

        // ================= LOAD =================

        loadStats();

        setVisible(true);
    }

    // =====================================================
    // STAT CARD
    // =====================================================

    private JPanel createStatCard(
            String title,
            String value,
            String description,
            int x) {

        JPanel card =
                new JPanel(null);

        card.setBackground(CARD);

        card.setBorder(
                BorderFactory.createLineBorder(
                        new Color(
                                52, 60, 76),
                        1));

        card.setBounds(
                x, 145, 290, 70);

        JLabel titleLabel =
                new JLabel(title);

        titleLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        11));

        titleLabel.setForeground(MUTED);

        titleLabel.setBounds(
                18, 10, 180, 20);

        card.add(titleLabel);

        JLabel valueLabel =
                new JLabel(value);

        valueLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        25));

        valueLabel.setForeground(GOLD);

        valueLabel.setBounds(
                18, 28, 120, 32);

        card.add(valueLabel);

        JLabel desc =
                new JLabel(description);

        desc.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        10));

        desc.setForeground(
                new Color(
                        125, 134, 151));

        desc.setHorizontalAlignment(
                SwingConstants.RIGHT);

        desc.setBounds(
                130, 34, 140, 25);

        card.add(desc);

        card.putClientProperty(
                "value",
                valueLabel);

        return card;
    }

    // =====================================================
    // PREMIUM BUTTON
    // =====================================================

    private JButton premiumButton(
            String title,
            String description,
            Color color) {

        JButton button =
                new JButton();

        button.setLayout(null);

        button.setBackground(color);

        button.setForeground(Color.WHITE);

        button.setFocusPainted(false);

        button.setBorderPainted(false);

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR));

        JLabel titleLabel =
                new JLabel(title);

        titleLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        15));

        titleLabel.setForeground(
                Color.WHITE);

        titleLabel.setBounds(
                20, 15, 285, 25);

        button.add(titleLabel);

        JLabel descLabel =
                new JLabel(description);

        descLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        11));

        descLabel.setForeground(
                new Color(
                        225, 230, 238));

        descLabel.setBounds(
                20, 43, 285, 20);

        button.add(descLabel);

        button.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseEntered(
                            MouseEvent e) {

                        button.setBackground(
                                color.brighter());
                    }

                    @Override
                    public void mouseExited(
                            MouseEvent e) {

                        button.setBackground(
                                color);
                    }
                });

        return button;
    }

    // =====================================================
    // DATABASE CONNECTION
    // =====================================================

    private Connection getConnection()
            throws Exception {

        Class.forName(
                "com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/car_project",
                "root",
                "thrisha");
    }

    // =====================================================
    // LOAD DASHBOARD STATISTICS
    // =====================================================

    private void loadStats() {

        try {

            try (
                    Connection con =
                            getConnection()
            ) {

                totalCars.setText(
                        count(
                                con,
                                "SELECT COUNT(*) FROM cars"));

                totalBookings.setText(
                        count(
                                con,
                                "SELECT COUNT(*) FROM bookings"));

                totalUsers.setText(
                        count(
                                con,
                                "SELECT COUNT(*) FROM users"));
            }

        } catch (Exception e) {

            totalCars.setText("?");

            totalBookings.setText("?");

            totalUsers.setText("?");

            JOptionPane.showMessageDialog(
                    this,
                    "Unable to load dashboard statistics.\n\n"
                            + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // =====================================================
    // COUNT
    // =====================================================

    private String count(
            Connection con,
            String sql)
            throws SQLException {

        try (
                PreparedStatement pst =
                        con.prepareStatement(sql);

                ResultSet rs =
                        pst.executeQuery()
        ) {

            if (rs.next()) {

                return String.valueOf(
                        rs.getInt(1));
            }
        }

        return "0";
    }

    // =====================================================
    // BUTTON ACTIONS
    // =====================================================

    @Override
    public void actionPerformed(
            ActionEvent e) {

        if (e.getSource() ==
                viewCars) {

            new CarDetails();

            dispose();
        }

        else if (e.getSource() ==
                addCar) {

            new Addcar();

            dispose();
        }

        else if (e.getSource() ==
                bookings) {

            new BookingDetails();

            dispose();
        }

        else if (e.getSource() ==
                refresh) {

            loadStats();

            JOptionPane.showMessageDialog(
                    this,
                    "Dashboard updated successfully!",
                    "THRISHA CARZONE",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        else if (e.getSource() ==
                logout) {

            int choice =
                    JOptionPane.showConfirmDialog(
                            this,
                            "Are you sure you want to logout?",
                            "Logout",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);

            if (choice ==
                    JOptionPane.YES_OPTION) {

                new Login();

                dispose();
            }
        }
    }

    // =====================================================
    // PREMIUM DASHBOARD BACKGROUND
    // =====================================================

    static class DashboardPanel
            extends JPanel {

        @Override
        protected void paintComponent(
                Graphics g) {

            super.paintComponent(g);

            Graphics2D g2 =
                    (Graphics2D)
                            g.create();

            // MAIN BACKGROUND

            g2.setColor(BG);

            g2.fillRect(
                    0,
                    0,
                    getWidth(),
                    getHeight());

            // TOP GLOW

            g2.setColor(
                    new Color(
                            255,
                            193,
                            7,
                            20));

            g2.fillOval(
                    720,
                    -250,
                    500,
                    500);

            // GOLD TOP LINE

            g2.setColor(GOLD);

            g2.fillRect(
                    0,
                    0,
                    getWidth(),
                    3);

            // HEADER LINE

            g2.setColor(
                    new Color(
                            40, 46, 60));

            g2.fillRect(
                    35,
                    92,
                    1025,
                    1);

            g2.dispose();
        }
    }

    // =====================================================
    // MAIN
    // =====================================================

    public static void main(
            String[] args) {

        SwingUtilities.invokeLater(
                CarHome::new);
    }
}






/*package com.miniproject_car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CarHome extends JFrame implements ActionListener {

    private JLabel totalCars, totalBookings, totalUsers;

    private JButton viewCars, addCar, bookings, refresh, logout;

    private static final Color BG = new Color(12, 15, 23);
    private static final Color CARD = new Color(27, 32, 45);
    private static final Color GOLD = new Color(255, 193, 7);

    public CarHome() {

        setTitle("THRISHA CARZONE - Dashboard");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel main = new JPanel(null);
        main.setBackground(BG);
        setContentPane(main);

        JLabel title = new JLabel("THRISHA CARZONE");
        title.setFont(new Font("SansSerif", Font.BOLD, 32));
        title.setForeground(GOLD);
        title.setBounds(40, 25, 500, 45);
        main.add(title);

        JLabel welcome = new JLabel("CAR MANAGEMENT SYSTEM");
        welcome.setFont(new Font("SansSerif", Font.PLAIN, 16));
        welcome.setForeground(new Color(190, 198, 215));
        welcome.setBounds(43, 70, 450, 30);
        main.add(welcome);

        JButton[] cards = {
                card("TOTAL CARS", "0", 40),
                card("BOOKINGS", "0", 285),
                card("USERS", "0", 530)
        };

        totalCars =
                (JLabel) cards[0].getClientProperty("value");

        totalBookings =
                (JLabel) cards[1].getClientProperty("value");

        totalUsers =
                (JLabel) cards[2].getClientProperty("value");

        for (JButton b : cards) {
            main.add(b);
        }

        JLabel menu = new JLabel("QUICK ACTIONS");
        menu.setFont(new Font("SansSerif", Font.BOLD, 18));
        menu.setForeground(Color.WHITE);
        menu.setBounds(40, 205, 300, 30);
        main.add(menu);

        viewCars = bigButton(
                "VIEW & SEARCH CARS",
                new Color(35, 105, 190));

        viewCars.setBounds(40, 250, 430, 60);
        main.add(viewCars);

        addCar = bigButton(
                "ADD NEW CAR",
                new Color(25, 145, 90));

        addCar.setBounds(500, 250, 430, 60);
        main.add(addCar);

        bookings = bigButton(
                "VIEW BOOKINGS",
                new Color(190, 135, 20));

        bookings.setBounds(40, 330, 430, 60);
        main.add(bookings);

        refresh = bigButton(
                "REFRESH DASHBOARD",
                new Color(85, 75, 145));

        refresh.setBounds(500, 330, 430, 60);
        main.add(refresh);

        logout = bigButton(
                "LOGOUT",
                new Color(160, 45, 55));

        logout.setBounds(40, 410, 890, 60);
        main.add(logout);

        JLabel info = new JLabel(
                "<html><center>" +
                "Search cars • Filter by type • " +
                "Book cars • View customer bookings • " +
                "Manage inventory" +
                "</center></html>");

        info.setFont(
                new Font("SansSerif", Font.PLAIN, 15));

        info.setForeground(
                new Color(180, 188, 205));

        info.setHorizontalAlignment(
                SwingConstants.CENTER);

        info.setBounds(200, 505, 600, 55);
        main.add(info);

        JLabel footer =
                new JLabel("© 2026 THRISHA CARZONE");

        footer.setFont(
                new Font("SansSerif", Font.PLAIN, 12));

        footer.setForeground(
                new Color(120, 130, 150));

        footer.setHorizontalAlignment(
                SwingConstants.CENTER);

        footer.setBounds(300, 600, 400, 25);
        main.add(footer);

        viewCars.addActionListener(this);
        addCar.addActionListener(this);
        bookings.addActionListener(this);
        refresh.addActionListener(this);
        logout.addActionListener(this);

        loadStats();

        setVisible(true);
    }

    private JButton card(
            String title,
            String value,
            int x) {

        JButton panel = new JButton();

        panel.setLayout(null);
        panel.setBounds(x, 115, 210, 70);
        panel.setBackground(CARD);

        panel.setBorder(
                BorderFactory.createLineBorder(
                        new Color(65, 73, 92), 1));

        panel.setFocusPainted(false);

        JLabel t = new JLabel(title);

        t.setForeground(
                new Color(175, 184, 202));

        t.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        11));

        t.setBounds(15, 8, 180, 20);
        panel.add(t);

        JLabel v = new JLabel(value);

        v.setForeground(GOLD);

        v.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        25));

        v.setBounds(15, 28, 180, 32);
        panel.add(v);

        panel.putClientProperty("value", v);

        return panel;
    }

    private JButton bigButton(
            String text,
            Color color) {

        JButton b = new JButton(text);

        b.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        15));

        b.setForeground(Color.WHITE);
        b.setBackground(color);
        b.setFocusPainted(false);
        b.setBorderPainted(false);

        b.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR));

        return b;
    }

    private void loadStats() {

        try {

            Class.forName(
                    "com.mysql.cj.jdbc.Driver");

            try (Connection con =
                         DriverManager.getConnection(
                                 "jdbc:mysql://localhost:3306/car_project",
                                 "root",
                                 "thrisha")) {

                totalCars.setText(
                        count(
                                con,
                                "SELECT COUNT(*) FROM cars"));

                try {

                    totalBookings.setText(
                            count(
                                    con,
                                    "SELECT COUNT(*) FROM bookings"));

                } catch (SQLException ex) {

                    totalBookings.setText("0");
                }

                totalUsers.setText(
                        count(
                                con,
                                "SELECT COUNT(*) FROM users"));
            }

        } catch (Exception e) {

            totalCars.setText("?");
            totalBookings.setText("?");
            totalUsers.setText("?");
        }
    }

    private String count(
            Connection con,
            String sql)
            throws SQLException {

        try (
                PreparedStatement pst =
                        con.prepareStatement(sql);

                ResultSet rs =
                        pst.executeQuery()
        ) {

            return rs.next()
                    ? String.valueOf(rs.getInt(1))
                    : "0";
        }
    }

    @Override
    public void actionPerformed(
            ActionEvent e) {

        if (e.getSource() == viewCars) {

            new CarDetails();
            dispose();

        } else if (e.getSource() == addCar) {

            new Addcar();
            dispose();

        } else if (e.getSource() == bookings) {

            new BookingDetails();
            dispose();

        } else if (e.getSource() == refresh) {

            loadStats();

            JOptionPane.showMessageDialog(
                    this,
                    "Dashboard refreshed.",
                    "THRISHA CARZONE",
                    JOptionPane.INFORMATION_MESSAGE);

        } else if (e.getSource() == logout) {

            int c =
                    JOptionPane.showConfirmDialog(
                            this,
                            "Do you want to logout?",
                            "Logout",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);

            if (c == JOptionPane.YES_OPTION) {

                new Login();
                dispose();
            }
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                CarHome::new);
    }
}

/*package com.miniproject_car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CarHome extends JFrame implements ActionListener {

    private JLabel totalCars, totalBookings, totalUsers;
    private JButton viewCars, addCar, refresh, logout;

    private static final Color BG = new Color(12, 15, 23);
    private static final Color CARD = new Color(27, 32, 45);
    private static final Color GOLD = new Color(255, 193, 7);

    public CarHome() {
        setTitle("Car Management System - Dashboard");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel main = new JPanel(null);
        main.setBackground(BG);
        setContentPane(main);

        JLabel title = new JLabel("CAR MANAGEMENT SYSTEM");
        title.setFont(new Font("SansSerif", Font.BOLD, 30));
        title.setForeground(GOLD);
        title.setBounds(40, 25, 500, 45);
        main.add(title);

        JLabel welcome = new JLabel("Premium Car Management Dashboard");
        welcome.setFont(new Font("SansSerif", Font.PLAIN, 16));
        welcome.setForeground(new Color(190, 198, 215));
        welcome.setBounds(43, 70, 450, 30);
        main.add(welcome);

        JButton[] cards = {
                card("TOTAL CARS", "0", 40),
                card("BOOKINGS", "0", 285),
                card("USERS", "0", 530)
        };
        totalCars = (JLabel) cards[0].getClientProperty("value");
        totalBookings = (JLabel) cards[1].getClientProperty("value");
        totalUsers = (JLabel) cards[2].getClientProperty("value");

        for (JButton b : cards) main.add(b);

        JLabel menu = new JLabel("QUICK ACTIONS");
        menu.setFont(new Font("SansSerif", Font.BOLD, 18));
        menu.setForeground(Color.WHITE);
        menu.setBounds(40, 205, 300, 30);
        main.add(menu);

        viewCars = bigButton("🚗  VIEW & SEARCH CARS", new Color(35, 105, 190));
        viewCars.setBounds(40, 250, 430, 65);
        main.add(viewCars);

        addCar = bigButton("➕  ADD NEW CAR", new Color(25, 145, 90));
        addCar.setBounds(500, 250, 430, 65);
        main.add(addCar);

        refresh = bigButton("↻  REFRESH DASHBOARD", new Color(85, 75, 145));
        refresh.setBounds(40, 335, 430, 65);
        main.add(refresh);

        logout = bigButton("⎋  LOGOUT", new Color(160, 45, 55));
        logout.setBounds(500, 335, 430, 65);
        main.add(logout);

        JLabel info = new JLabel("<html><center>Search cars • Filter by type • Book cars • Manage inventory</center></html>");
        info.setFont(new Font("SansSerif", Font.PLAIN, 15));
        info.setForeground(new Color(180, 188, 205));
        info.setBounds(200, 455, 600, 55);
        main.add(info);

        viewCars.addActionListener(this);
        addCar.addActionListener(this);
        refresh.addActionListener(this);
        logout.addActionListener(this);

        loadStats();
        setVisible(true);
    }

    private JButton card(String title, String value, int x) {
        JButton panel = new JButton();
        panel.setLayout(null);
        panel.setBounds(x, 115, 210, 70);
        panel.setBackground(CARD);
        panel.setBorder(BorderFactory.createLineBorder(new Color(65, 73, 92), 1));
        panel.setFocusPainted(false);

        JLabel t = new JLabel(title);
        t.setForeground(new Color(175, 184, 202));
        t.setFont(new Font("SansSerif", Font.BOLD, 11));
        t.setBounds(15, 8, 180, 20);
        panel.add(t);

        JLabel v = new JLabel(value);
        v.setForeground(GOLD);
        v.setFont(new Font("SansSerif", Font.BOLD, 25));
        v.setBounds(15, 28, 180, 32);
        panel.add(v);

        panel.putClientProperty("value", v);
        return panel;
    }

    private JButton bigButton(String text, Color color) {
        JButton b = new JButton(text);
        b.setFont(new Font("SansSerif", Font.BOLD, 15));
        b.setForeground(Color.WHITE);
        b.setBackground(color);
        b.setFocusPainted(false);
        b.setBorderPainted(false);
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return b;
    }

    private void loadStats() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/car_project", "root", "thrisha")) {

                totalCars.setText(count(con, "SELECT COUNT(*) FROM cars"));

                try {
                    totalBookings.setText(count(con, "SELECT COUNT(*) FROM bookings"));
                } catch (SQLException ex) {
                    totalBookings.setText("0");
                }

                totalUsers.setText(count(con, "SELECT COUNT(*) FROM users"));
            }
        } catch (Exception e) {
            totalCars.setText("?");
            totalBookings.setText("?");
            totalUsers.setText("?");
        }
    }

    private String count(Connection con, String sql) throws SQLException {
        try (PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            return rs.next() ? String.valueOf(rs.getInt(1)) : "0";
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewCars) {
            new CarDetails();
            dispose();
        } else if (e.getSource() == addCar) {
            new Addcar();
            dispose();
        } else if (e.getSource() == refresh) {
            loadStats();
            JOptionPane.showMessageDialog(this, "Dashboard refreshed.");
        } else if (e.getSource() == logout) {
            int c = JOptionPane.showConfirmDialog(this,
                    "Do you want to logout?", "Logout",
                    JOptionPane.YES_NO_OPTION);
            if (c == JOptionPane.YES_OPTION) {
                new Login();
                dispose();
            }
        }
    }
}

/*package com.miniproject_car;

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
}*/