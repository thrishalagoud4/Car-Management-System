package com.miniproject_car;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CarDetails extends JFrame implements ActionListener {

    private JComboBox<String> typeCombo;
    private JTextField searchField;

    private JTable table;
    private DefaultTableModel model;

    private JTextArea details;

    private JButton search;
    private JButton refresh;
    private JButton book;
    private JButton edit;
    private JButton delete;
    private JButton back;

    private JLabel selectedCarLabel;
    private JLabel priceLabel;
    private JLabel statusLabel;

    private int selectedId = -1;

    private static final Color BG =
            new Color(10, 13, 20);

    private static final Color PANEL =
            new Color(22, 27, 38);

    private static final Color PANEL2 =
            new Color(28, 34, 47);

    private static final Color GOLD =
            new Color(255, 193, 7);

    private static final Color TEXT =
            new Color(230, 234, 240);

    private static final Color MUTED =
            new Color(155, 164, 180);

    public CarDetails() {

        setTitle(
                "THRISHA CARZONE - Premium Car Showroom");

        setSize(1200, 760);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setResizable(false);

        JPanel main =
                new JPanel(null);

        main.setBackground(BG);

        setContentPane(main);

        // =================================================
        // HEADER
        // =================================================

        JLabel logo =
                new JLabel("TC");

        logo.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        17));

        logo.setForeground(BG);

        logo.setBackground(GOLD);

        logo.setOpaque(true);

        logo.setHorizontalAlignment(
                SwingConstants.CENTER);

        logo.setBounds(
                30, 22, 50, 50);

        main.add(logo);

        JLabel title =
                new JLabel(
                        "THRISHA CARZONE");

        title.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        29));

        title.setForeground(GOLD);

        title.setBounds(
                95, 20, 400, 35);

        main.add(title);

        JLabel subtitle =
                new JLabel(
                        "PREMIUM CAR SHOWROOM");

        subtitle.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        12));

        subtitle.setForeground(MUTED);

        subtitle.setBounds(
                97, 50, 350, 25);

        main.add(subtitle);

        JLabel inventory =
                new JLabel(
                        "CAR INVENTORY");

        inventory.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        15));

        inventory.setForeground(TEXT);

        inventory.setHorizontalAlignment(
                SwingConstants.RIGHT);

        inventory.setBounds(
                850, 30, 300, 30);

        main.add(inventory);

        // =================================================
        // SEARCH PANEL
        // =================================================

        JPanel searchPanel =
                new JPanel(null);

        searchPanel.setBackground(PANEL);

        searchPanel.setBorder(
                BorderFactory.createLineBorder(
                        new Color(
                                48, 56, 72)));

        searchPanel.setBounds(
                30, 90, 1120, 80);

        main.add(searchPanel);

        JLabel typeLabel =
                new JLabel("CAR TYPE");

        typeLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        11));

        typeLabel.setForeground(MUTED);

        typeLabel.setBounds(
                18, 10, 100, 20);

        searchPanel.add(typeLabel);

        typeCombo =
                new JComboBox<>(
                        new String[]{
                                "ALL",
                                "SUV",
                                "XUV",
                                "SEDAN",
                                "MUV",
                                "HATCHBACK",
                                "LUXURY"
                        });

        typeCombo.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        13));

        typeCombo.setBounds(
                18, 34, 160, 32);

        searchPanel.add(typeCombo);

        JLabel searchLabel =
                new JLabel("SEARCH VEHICLE");

        searchLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        11));

        searchLabel.setForeground(MUTED);

        searchLabel.setBounds(
                200, 10, 150, 20);

        searchPanel.add(searchLabel);

        searchField =
                new JTextField();

        searchField.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        13));

        searchField.setBounds(
                200, 34, 420, 32);

        searchField.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(
                                        65, 73, 90)),
                        BorderFactory.createEmptyBorder(
                                4, 10, 4, 10)));

        searchPanel.add(searchField);

        search =
                smallButton(
                        "SEARCH",
                        new Color(
                                35, 105, 190));

        search.setBounds(
                640, 34, 110, 32);

        searchPanel.add(search);

        refresh =
                smallButton(
                        "RESET",
                        new Color(
                                80, 85, 100));

        refresh.setBounds(
                765, 34, 110, 32);

        searchPanel.add(refresh);

        statusLabel =
                new JLabel(
                        "● READY");

        statusLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        11));

        statusLabel.setForeground(
                new Color(
                        55, 210, 125));

        statusLabel.setHorizontalAlignment(
                SwingConstants.RIGHT);

        statusLabel.setBounds(
                920, 34, 170, 32);

        searchPanel.add(statusLabel);

        // =================================================
        // TABLE
        // =================================================

        model =
                new DefaultTableModel(
                        new Object[]{
                                "ID",
                                "BRAND",
                                "MODEL",
                                "PRICE",
                                "FUEL",
                                "TYPE",
                                "YEAR"
                        }, 0) {

                    @Override
                    public boolean isCellEditable(
                            int row,
                            int column) {

                        return false;
                    }
                };

        table =
                new JTable(model);

        table.setRowHeight(32);

        table.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        12));

        table.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION);

        table.setAutoCreateRowSorter(true);

        table.setBackground(
                new Color(
                        20, 25, 35));

        table.setForeground(TEXT);

        table.setGridColor(
                new Color(
                        43, 50, 65));

        table.setSelectionBackground(
                new Color(
                        90, 72, 20));

        table.setSelectionForeground(
                Color.WHITE);

        JTableHeader header =
                table.getTableHeader();

        header.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        11));

        header.setBackground(
                new Color(
                        35, 41, 55));

        header.setForeground(Color.WHITE);

        header.setPreferredSize(
                new Dimension(
                        0, 36));

        JScrollPane scroll =
                new JScrollPane(table);

        scroll.setBounds(
                30, 185, 1120, 260);

        scroll.setBorder(
                BorderFactory.createLineBorder(
                        new Color(
                                48, 56, 72)));

        main.add(scroll);

        // =================================================
        // SELECTED CAR PANEL
        // =================================================

        JLabel selectedTitle =
                new JLabel(
                        "SELECTED VEHICLE");

        selectedTitle.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        16));

        selectedTitle.setForeground(GOLD);

        selectedTitle.setBounds(
                30, 465, 250, 30);

        main.add(selectedTitle);

        JPanel carPanel =
                new JPanel(null);

        carPanel.setBackground(PANEL);

        carPanel.setBorder(
                BorderFactory.createLineBorder(
                        new Color(
                                55, 63, 80)));

        carPanel.setBounds(
                30, 500, 1120, 145);

        main.add(carPanel);

        selectedCarLabel =
                new JLabel(
                        "NO VEHICLE SELECTED");

        selectedCarLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        18));

        selectedCarLabel.setForeground(
                Color.WHITE);

        selectedCarLabel.setBounds(
                20, 12, 400, 30);

        carPanel.add(selectedCarLabel);

        priceLabel =
                new JLabel(
                        "₹ --");

        priceLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        20));

        priceLabel.setForeground(GOLD);

        priceLabel.setBounds(
                850, 12, 230, 30);

        priceLabel.setHorizontalAlignment(
                SwingConstants.RIGHT);

        carPanel.add(priceLabel);

        details =
                new JTextArea();

        details.setEditable(false);

        details.setFont(
                new Font(
                        "Monospaced",
                        Font.PLAIN,
                        12));

        details.setForeground(TEXT);

        details.setBackground(PANEL);

        details.setBorder(
                BorderFactory.createEmptyBorder(
                        5, 10, 5, 5));

        details.setText(
                "Select a vehicle from the table to view complete details.");

        JScrollPane detailScroll =
                new JScrollPane(details);

        detailScroll.setBorder(null);

        detailScroll.setBounds(
                10, 45, 680, 85);

        carPanel.add(detailScroll);

        // =================================================
        // BUTTONS
        // =================================================

        book =
                premiumButton(
                        "BOOK CAR",
                        new Color(
                                25, 145, 90));

        book.setBounds(
                715, 55, 125, 42);

        carPanel.add(book);

        edit =
                premiumButton(
                        "EDIT",
                        new Color(
                                35, 105, 190));

        edit.setBounds(
                855, 55, 125, 42);

        carPanel.add(edit);

        delete =
                premiumButton(
                        "DELETE",
                        new Color(
                                160, 45, 55));

        delete.setBounds(
                995, 55, 105, 42);

        carPanel.add(delete);

        back =
                premiumButton(
                        "BACK",
                        new Color(
                                75, 82, 95));

        back.setBounds(
                995, 105, 105, 28);

        carPanel.add(back);

        // =================================================
        // EVENTS
        // =================================================

        typeCombo.addActionListener(this);

        search.addActionListener(this);

        refresh.addActionListener(this);

        book.addActionListener(this);

        edit.addActionListener(this);

        delete.addActionListener(this);

        back.addActionListener(this);

        searchField.addActionListener(e ->
                loadCars());

        table.getSelectionModel()
                .addListSelectionListener(e -> {

                    if (!e.getValueIsAdjusting()) {

                        loadSelectedRow();
                    }
                });

        // =================================================
        // LOAD DATA
        // =================================================

        loadCars();

        setVisible(true);
    }

    // =====================================================
    // SMALL BUTTON
    // =====================================================

    private JButton smallButton(
            String text,
            Color color) {

        JButton b =
                new JButton(text);

        b.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        11));

        b.setForeground(Color.WHITE);

        b.setBackground(color);

        b.setFocusPainted(false);

        b.setBorderPainted(false);

        b.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR));

        return b;
    }

    // =====================================================
    // PREMIUM BUTTON
    // =====================================================

    private JButton premiumButton(
            String text,
            Color color) {

        JButton b =
                new JButton(text);

        b.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        11));

        b.setForeground(Color.WHITE);

        b.setBackground(color);

        b.setFocusPainted(false);

        b.setBorderPainted(false);

        b.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR));

        b.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseEntered(
                            MouseEvent e) {

                        b.setBackground(
                                color.brighter());
                    }

                    @Override
                    public void mouseExited(
                            MouseEvent e) {

                        b.setBackground(color);
                    }
                });

        return b;
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
    // LOAD CARS
    // =====================================================

    private void loadCars() {

        model.setRowCount(0);

        selectedId = -1;

        selectedCarLabel.setText(
                "NO VEHICLE SELECTED");

        priceLabel.setText("₹ --");

        details.setText(
                "Select a vehicle from the table to view complete details.");

        String type =
                typeCombo
                        .getSelectedItem()
                        .toString();

        String text =
                searchField
                        .getText()
                        .trim();

        String sql =
                "SELECT car_id, brand, model, price, " +
                "fuel, car_type, year " +
                "FROM cars WHERE 1=1 ";

        if (!type.equals("ALL")) {

            sql +=
                    "AND UPPER(car_type)=UPPER(?) ";
        }

        if (!text.isEmpty()) {

            sql +=
                    "AND (" +
                    "CAST(car_id AS CHAR) LIKE ? " +
                    "OR brand LIKE ? " +
                    "OR model LIKE ? " +
                    "OR fuel LIKE ? " +
                    "OR car_type LIKE ?" +
                    ") ";
        }

        sql +=
                "ORDER BY car_id";

        try {

            try (
                    Connection con =
                            getConnection();

                    PreparedStatement pst =
                            con.prepareStatement(sql)
            ) {

                int p = 1;

                if (!type.equals("ALL")) {

                    pst.setString(
                            p++,
                            type);
                }

                if (!text.isEmpty()) {

                    String like =
                            "%" + text + "%";

                    pst.setString(p++, like);

                    pst.setString(p++, like);

                    pst.setString(p++, like);

                    pst.setString(p++, like);

                    pst.setString(p++, like);
                }

                try (
                        ResultSet rs =
                                pst.executeQuery()
                ) {

                    while (rs.next()) {

                        model.addRow(
                                new Object[]{

                                        rs.getInt(
                                                "car_id"),

                                        rs.getString(
                                                "brand"),

                                        rs.getString(
                                                "model"),

                                        "₹" +
                                        rs.getDouble(
                                                "price"),

                                        rs.getString(
                                                "fuel"),

                                        rs.getString(
                                                "car_type"),

                                        rs.getInt(
                                                "year")
                                });
                    }
                }
            }

            int count =
                    model.getRowCount();

            statusLabel.setText(
                    "● " +
                    count +
                    " VEHICLES FOUND");

            if (count == 0) {

                statusLabel.setForeground(
                        new Color(
                                240, 90, 90));

            } else {

                statusLabel.setForeground(
                        new Color(
                                55, 210, 125));
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Database Error:\n\n" +
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // =====================================================
    // SELECTED ROW
    // =====================================================

    private void loadSelectedRow() {

        int row =
                table.getSelectedRow();

        if (row < 0) {

            return;
        }

        int actual =
                table.convertRowIndexToModel(
                        row);

        selectedId =
                Integer.parseInt(
                        model.getValueAt(
                                actual,
                                0)
                        .toString());

        loadDetails(selectedId);
    }

    // =====================================================
    // LOAD FULL DETAILS
    // =====================================================

    private void loadDetails(
            int id) {

        String sql =
                "SELECT * FROM cars " +
                "WHERE car_id=?";

        try {

            try (
                    Connection con =
                            getConnection();

                    PreparedStatement pst =
                            con.prepareStatement(sql)
            ) {

                pst.setInt(
                        1,
                        id);

                try (
                        ResultSet rs =
                                pst.executeQuery()
                ) {

                    if (rs.next()) {

                        String brand =
                                rs.getString(
                                        "brand");

                        String modelName =
                                rs.getString(
                                        "model");

                        double price =
                                rs.getDouble(
                                        "price");

                        selectedCarLabel.setText(
                                brand +
                                " " +
                                modelName);

                        priceLabel.setText(
                                "₹ " +
                                String.format(
                                        "%.2f",
                                        price));

                        details.setText(

                                "ID: " +
                                rs.getInt(
                                        "car_id") +

                                "    |    FUEL: " +
                                rs.getString(
                                        "fuel") +

                                "    |    TRANSMISSION: " +
                                rs.getString(
                                        "transmission") +

                                "    |    YEAR: " +
                                rs.getInt(
                                        "year") +

                                "\n\n" +

                                "COLOR: " +
                                rs.getString(
                                        "color") +

                                "    |    MILEAGE: " +
                                rs.getDouble(
                                        "mileage") +
                                " km/l" +

                                "    |    ENGINE: " +
                                rs.getString(
                                        "engine") +

                                "\n\n" +

                                "SEATS: " +
                                rs.getInt(
                                        "seats") +

                                "    |    TYPE: " +
                                rs.getString(
                                        "car_type")
                        );
                    }
                }
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // =====================================================
    // BOOK CAR
    // =====================================================

    private void bookCar() {

        if (selectedId == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select a car first.",
                    "Select Vehicle",
                    JOptionPane.WARNING_MESSAGE);

            return;
        }

        String customer =
                JOptionPane.showInputDialog(
                        this,
                        "Enter customer name:",
                        "Customer Details",
                        JOptionPane.QUESTION_MESSAGE);

        if (customer == null ||
                customer.trim().isEmpty()) {

            return;
        }

        String phone =
                JOptionPane.showInputDialog(
                        this,
                        "Enter 10-digit phone number:",
                        "Customer Details",
                        JOptionPane.QUESTION_MESSAGE);

        if (phone == null ||
                phone.trim().isEmpty()) {

            return;
        }

        phone =
                phone.trim();

        if (!phone.matches(
                "\\d{10}")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid 10-digit phone number.",
                    "Invalid Phone",
                    JOptionPane.WARNING_MESSAGE);

            return;
        }

        String sql =
                "INSERT INTO bookings " +
                "(car_id, customer_name, phone, booking_date) " +
                "VALUES (?, ?, ?, CURRENT_TIMESTAMP)";

        try {

            try (
                    Connection con =
                            getConnection();

                    PreparedStatement pst =
                            con.prepareStatement(
                                    sql,
                                    Statement.RETURN_GENERATED_KEYS)
            ) {

                pst.setInt(
                        1,
                        selectedId);

                pst.setString(
                        2,
                        customer.trim());

                pst.setString(
                        3,
                        phone);

                pst.executeUpdate();

                int bookingId = -1;

                try (
                        ResultSet keys =
                                pst.getGeneratedKeys()
                ) {

                    if (keys.next()) {

                        bookingId =
                                keys.getInt(1);
                    }
                }

                JOptionPane.showMessageDialog(
                        this,
                        "BOOKING CONFIRMED!\n\n" +
                        "Booking ID : " +
                        bookingId +
                        "\nCustomer   : " +
                        customer +
                        "\nPhone      : " +
                        phone +
                        "\nCar ID     : " +
                        selectedId,
                        "THRISHA CARZONE",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Booking failed:\n\n" +
                    ex.getMessage(),
                    "Booking Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // =====================================================
    // EDIT
    // =====================================================

    private void editCar() {

        if (selectedId == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select a car first.",
                    "Edit Car",
                    JOptionPane.WARNING_MESSAGE);

            return;
        }

        JOptionPane.showMessageDialog(
                this,
                "Selected Car ID: " +
                selectedId +
                "\n\nEdit functionality can be connected to Addcar.java.",
                "Edit Vehicle",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // =====================================================
    // DELETE
    // =====================================================

    private void deleteCar() {

        if (selectedId == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select a car first.",
                    "Delete Car",
                    JOptionPane.WARNING_MESSAGE);

            return;
        }

        int choice =
                JOptionPane.showConfirmDialog(
                        this,
                        "Are you sure you want to delete\n" +
                        "Car ID: " +
                        selectedId +
                        "?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);

        if (choice !=
                JOptionPane.YES_OPTION) {

            return;
        }

        try {

            try (
                    Connection con =
                            getConnection();

                    PreparedStatement pst =
                            con.prepareStatement(
                                    "DELETE FROM cars " +
                                    "WHERE car_id=?")
            ) {

                pst.setInt(
                        1,
                        selectedId);

                int result =
                        pst.executeUpdate();

                if (result > 0) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Vehicle deleted successfully.",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);

                    loadCars();
                }
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Delete failed:\n\n" +
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // =====================================================
    // EVENTS
    // =====================================================

    @Override
    public void actionPerformed(
            ActionEvent e) {

        if (e.getSource() ==
                typeCombo) {

            loadCars();
        }

        else if (e.getSource() ==
                search) {

            loadCars();
        }

        else if (e.getSource() ==
                refresh) {

            searchField.setText("");

            typeCombo.setSelectedIndex(0);

            loadCars();
        }

        else if (e.getSource() ==
                book) {

            bookCar();
        }

        else if (e.getSource() ==
                edit) {

            editCar();
        }

        else if (e.getSource() ==
                delete) {

            deleteCar();
        }

        else if (e.getSource() ==
                back) {

            new CarHome();

            dispose();
        }
    }

    // =====================================================
    // MAIN
    // =====================================================

    public static void main(
            String[] args) {

        SwingUtilities.invokeLater(
                CarDetails::new);
    }
}










/*package com.miniproject_car;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CarDetails extends JFrame implements ActionListener {

    private JComboBox<String> typeCombo;
    private JTextField searchField;
    private JTable table;
    private DefaultTableModel model;
    private JTextArea details;

    private JButton search, refresh, book, edit, delete, back;

    private int selectedId = -1;

    private static final Color BG = new Color(12, 15, 23);
    private static final Color PANEL = new Color(25, 30, 42);
    private static final Color GOLD = new Color(255, 193, 7);

    public CarDetails() {

        setTitle("THRISHA CARZONE - Car Inventory");
        setSize(1100, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel main = new JPanel(null);
        main.setBackground(BG);
        setContentPane(main);

        JLabel title = new JLabel("THRISHA CARZONE");
        title.setFont(new Font("SansSerif", Font.BOLD, 28));
        title.setForeground(GOLD);
        title.setBounds(35, 15, 450, 40);
        main.add(title);

        JLabel sub = new JLabel("CAR INVENTORY  •  Search, filter and manage cars");
        sub.setForeground(new Color(180, 188, 205));
        sub.setFont(new Font("SansSerif", Font.PLAIN, 13));
        sub.setBounds(38, 52, 500, 25);
        main.add(sub);

        JLabel filter = new JLabel("CAR TYPE");
        filter.setForeground(Color.WHITE);
        filter.setFont(new Font("SansSerif", Font.BOLD, 12));
        filter.setBounds(35, 92, 100, 25);
        main.add(filter);

        typeCombo = new JComboBox<>(new String[]{
                "ALL", "SUV", "XUV", "SEDAN",
                "MUV", "HATCHBACK", "LUXURY"
        });

        typeCombo.setBounds(35, 117, 150, 35);
        main.add(typeCombo);

        JLabel searchLabel = new JLabel("SEARCH");
        searchLabel.setForeground(Color.WHITE);
        searchLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        searchLabel.setBounds(205, 92, 100, 25);
        main.add(searchLabel);

        searchField = new JTextField();
        searchField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        searchField.setBounds(205, 117, 300, 35);
        main.add(searchField);

        search = button("SEARCH", new Color(35, 105, 190));
        search.setBounds(520, 117, 110, 35);
        main.add(search);

        refresh = button("REFRESH", new Color(85, 75, 145));
        refresh.setBounds(640, 117, 110, 35);
        main.add(refresh);

        model = new DefaultTableModel(
                new Object[]{
                        "ID", "BRAND", "MODEL",
                        "PRICE", "FUEL", "TYPE", "YEAR"
                }, 0) {

            @Override
            public boolean isCellEditable(int r, int c) {
                return false;
            }
        };

        table = new JTable(model);
        table.setRowHeight(30);
        table.setFont(new Font("SansSerif", Font.PLAIN, 13));
        table.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION);
        table.setAutoCreateRowSorter(true);

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("SansSerif", Font.BOLD, 12));
        header.setBackground(new Color(35, 40, 55));
        header.setForeground(Color.WHITE);
        header.setPreferredSize(new Dimension(0, 32));

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(35, 165, 1015, 250);
        main.add(scroll);

        JLabel detailsTitle = new JLabel("SELECTED CAR DETAILS");
        detailsTitle.setFont(new Font("SansSerif", Font.BOLD, 15));
        detailsTitle.setForeground(GOLD);
        detailsTitle.setBounds(35, 430, 300, 25);
        main.add(detailsTitle);

        details = new JTextArea();
        details.setEditable(false);
        details.setFont(new Font("Monospaced", Font.PLAIN, 13));
        details.setBackground(PANEL);
        details.setForeground(Color.WHITE);
        details.setBorder(
                BorderFactory.createEmptyBorder(
                        10, 12, 10, 12));

        JScrollPane detailScroll = new JScrollPane(details);
        detailScroll.setBounds(35, 460, 700, 150);
        main.add(detailScroll);

        book = button("BOOK CAR", new Color(25, 145, 90));
        book.setBounds(770, 460, 130, 40);
        main.add(book);

        edit = button("EDIT", new Color(35, 105, 190));
        edit.setBounds(920, 460, 130, 40);
        main.add(edit);

        delete = button("DELETE", new Color(160, 45, 55));
        delete.setBounds(770, 515, 130, 40);
        main.add(delete);

        back = button("BACK", new Color(80, 85, 98));
        back.setBounds(920, 515, 130, 40);
        main.add(back);

        typeCombo.addActionListener(this);
        search.addActionListener(this);
        refresh.addActionListener(this);
        book.addActionListener(this);
        edit.addActionListener(this);
        delete.addActionListener(this);
        back.addActionListener(this);

        table.getSelectionModel().addListSelectionListener(e -> {

            if (!e.getValueIsAdjusting()) {
                loadSelectedRow();
            }
        });

        loadCars();

        setVisible(true);
    }

    private JButton button(String text, Color color) {

        JButton b = new JButton(text);

        b.setFont(new Font(
                "SansSerif",
                Font.BOLD,
                12));

        b.setForeground(Color.WHITE);
        b.setBackground(color);
        b.setFocusPainted(false);
        b.setBorderPainted(false);
        b.setCursor(
                new Cursor(Cursor.HAND_CURSOR));

        return b;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == typeCombo ||
                e.getSource() == search) {

            loadCars();

        } else if (e.getSource() == refresh) {

            searchField.setText("");
            typeCombo.setSelectedIndex(0);
            loadCars();

        } else if (e.getSource() == book) {

            bookCar();

        } else if (e.getSource() == edit) {

            editCar();

        } else if (e.getSource() == delete) {

            deleteCar();

        } else if (e.getSource() == back) {

            new CarHome();
            dispose();
        }
    }

    private Connection getConnection()
            throws Exception {

        Class.forName(
                "com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/car_project",
                "root",
                "thrisha");
    }

    private void loadCars() {

        model.setRowCount(0);
        selectedId = -1;
        details.setText("");

        String type =
                typeCombo.getSelectedItem().toString();

        String text =
                searchField.getText().trim();

        String sql =
                "SELECT car_id, brand, model, price, fuel, " +
                "car_type, year FROM cars WHERE 1=1 ";

        if (!type.equals("ALL")) {

            sql +=
                    "AND UPPER(car_type)=UPPER(?) ";
        }

        if (!text.isEmpty()) {

            sql +=
                    "AND (CAST(car_id AS CHAR) LIKE ? " +
                    "OR brand LIKE ? OR model LIKE ?) ";
        }

        sql += "ORDER BY car_id";

        try {

            try (Connection con = getConnection();
                 PreparedStatement pst =
                         con.prepareStatement(sql)) {

                int p = 1;

                if (!type.equals("ALL")) {

                    pst.setString(p++, type);
                }

                if (!text.isEmpty()) {

                    String like = "%" + text + "%";

                    pst.setString(p++, like);
                    pst.setString(p++, like);
                    pst.setString(p++, like);
                }

                try (ResultSet rs =
                             pst.executeQuery()) {

                    while (rs.next()) {

                        model.addRow(new Object[]{

                                rs.getInt("car_id"),

                                rs.getString("brand"),

                                rs.getString("model"),

                                "₹" + rs.getDouble("price"),

                                rs.getString("fuel"),

                                rs.getString("car_type"),

                                rs.getInt("year")
                        });
                    }
                }
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Database Error:\n" +
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadSelectedRow() {

        int row = table.getSelectedRow();

        if (row < 0) {
            return;
        }

        int actual =
                table.convertRowIndexToModel(row);

        selectedId =
                Integer.parseInt(
                        model.getValueAt(
                                actual, 0).toString());

        loadDetails(selectedId);
    }

    private void loadDetails(int id) {

        String sql =
                "SELECT * FROM cars WHERE car_id=?";

        try {

            try (Connection con = getConnection();
                 PreparedStatement pst =
                         con.prepareStatement(sql)) {

                pst.setInt(1, id);

                try (ResultSet rs =
                             pst.executeQuery()) {

                    if (rs.next()) {

                        details.setText(

                                "CAR ID        : " +
                                rs.getInt("car_id") + "\n" +

                                "BRAND         : " +
                                rs.getString("brand") + "\n" +

                                "MODEL         : " +
                                rs.getString("model") + "\n" +

                                "PRICE         : ₹" +
                                rs.getDouble("price") + "\n" +

                                "FUEL          : " +
                                rs.getString("fuel") + "\n" +

                                "TRANSMISSION  : " +
                                rs.getString("transmission") + "\n" +

                                "YEAR          : " +
                                rs.getInt("year") + "\n" +

                                "COLOR         : " +
                                rs.getString("color") + "\n" +

                                "MILEAGE       : " +
                                rs.getDouble("mileage") +
                                " km/l\n" +

                                "ENGINE        : " +
                                rs.getString("engine") + "\n" +

                                "SEATS         : " +
                                rs.getInt("seats") + "\n" +

                                "CAR TYPE      : " +
                                rs.getString("car_type")
                        );
                    }
                }
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void bookCar() {

        if (selectedId == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select a car first.",
                    "Select Car",
                    JOptionPane.WARNING_MESSAGE);

            return;
        }

        String customer =
                JOptionPane.showInputDialog(
                        this,
                        "Enter customer name:",
                        "Customer Details",
                        JOptionPane.QUESTION_MESSAGE);

        if (customer == null ||
                customer.trim().isEmpty()) {

            return;
        }

        String phone =
                JOptionPane.showInputDialog(
                        this,
                        "Enter phone number:",
                        "Customer Details",
                        JOptionPane.QUESTION_MESSAGE);

        if (phone == null ||
                phone.trim().isEmpty()) {

            return;
        }

        if (!phone.matches("\\d{10}")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid 10-digit phone number.",
                    "Invalid Phone",
                    JOptionPane.WARNING_MESSAGE);

            return;
        }

        try {

            try (Connection con = getConnection()) {

                String insert =
                        "INSERT INTO bookings " +
                        "(car_id, customer_name, phone, booking_date) " +
                        "VALUES (?, ?, ?, CURRENT_TIMESTAMP)";

                int bookingId = -1;

                try (PreparedStatement pst =
                             con.prepareStatement(
                                     insert,
                                     Statement.RETURN_GENERATED_KEYS)) {

                    pst.setInt(1, selectedId);
                    pst.setString(
                            2,
                            customer.trim());
                    pst.setString(
                            3,
                            phone.trim());

                    pst.executeUpdate();

                    try (ResultSet keys =
                                 pst.getGeneratedKeys()) {

                        if (keys.next()) {

                            bookingId =
                                    keys.getInt(1);
                        }
                    }
                }

                showBookingConfirmation(
                        bookingId,
                        customer.trim(),
                        phone.trim(),
                        selectedId);
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Booking failed.\n\n" +
                    ex.getMessage(),
                    "Booking Error",
                    JOptionPane.ERROR_MESSAGE);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showBookingConfirmation(
            int bookingId,
            String customer,
            String phone,
            int carId) {

        JFrame confirmation =
                new JFrame(
                        "THRISHA CARZONE - Booking Confirmation");

        confirmation.setSize(750, 650);
        confirmation.setLocationRelativeTo(this);
        confirmation.setResizable(false);

        JPanel panel = new JPanel(null);
        panel.setBackground(BG);
        confirmation.setContentPane(panel);

        JLabel title =
                new JLabel("THRISHA CARZONE");

        title.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        30));

        title.setForeground(GOLD);
        title.setHorizontalAlignment(
                SwingConstants.CENTER);

        title.setBounds(
                50, 25, 650, 45);

        panel.add(title);

        JLabel success =
                new JLabel("✓ BOOKING CONFIRMED");

        success.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        20));

        success.setForeground(
                new Color(50, 205, 120));

        success.setHorizontalAlignment(
                SwingConstants.CENTER);

        success.setBounds(
                50, 72, 650, 35);

        panel.add(success);

        JPanel card =
                new JPanel(null);

        card.setBackground(PANEL);
        card.setBounds(50, 120, 650, 430);

        panel.add(card);

        JLabel customerTitle =
                sectionTitle("CUSTOMER DETAILS");

        customerTitle.setBounds(
                25, 15, 300, 25);

        card.add(customerTitle);

        JLabel customerName =
                infoLabel(
                        "CUSTOMER NAME : " +
                        customer);

        customerName.setBounds(
                25, 50, 590, 28);

        card.add(customerName);

        JLabel customerPhone =
                infoLabel(
                        "PHONE NUMBER  : " +
                        phone);

        customerPhone.setBounds(
                25, 80, 590, 28);

        card.add(customerPhone);

        JLabel carTitle =
                sectionTitle("CAR DETAILS");

        carTitle.setBounds(
                25, 120, 300, 25);

        card.add(carTitle);

        JTextArea carInfo =
                new JTextArea();

        carInfo.setEditable(false);
        carInfo.setFont(
                new Font(
                        "Monospaced",
                        Font.PLAIN,
                        13));

        carInfo.setForeground(Color.WHITE);
        carInfo.setBackground(PANEL);

        carInfo.setText(
                getCarBookingDetails(carId));

        carInfo.setBounds(
                25, 150, 590, 145);

        card.add(carInfo);

        JLabel bookingTitle =
                sectionTitle("BOOKING INFORMATION");

        bookingTitle.setBounds(
                25, 305, 300, 25);

        card.add(bookingTitle);

        JLabel bookingIdLabel =
                infoLabel(
                        "BOOKING ID    : " +
                        bookingId);

        bookingIdLabel.setBounds(
                25, 335, 590, 28);

        card.add(bookingIdLabel);

        JLabel dateLabel =
                infoLabel(
                        "BOOKING DATE  : " +
                        getBookingDate(bookingId));

        dateLabel.setBounds(
                25, 365, 590, 28);

        card.add(dateLabel);

        JButton close =
                button(
                        "DONE",
                        new Color(
                                25, 145, 90));

        close.setBounds(
                275, 570, 200, 42);

        panel.add(close);

        close.addActionListener(e ->
                confirmation.dispose());

        confirmation.setVisible(true);
    }

    private JLabel sectionTitle(String text) {

        JLabel label =
                new JLabel(text);

        label.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        14));

        label.setForeground(GOLD);

        return label;
    }

    private JLabel infoLabel(String text) {

        JLabel label =
                new JLabel(text);

        label.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        14));

        label.setForeground(Color.WHITE);

        return label;
    }

    private String getCarBookingDetails(int id) {

        String result = "";

        String sql =
                "SELECT * FROM cars WHERE car_id=?";

        try {

            try (Connection con = getConnection();
                 PreparedStatement pst =
                         con.prepareStatement(sql)) {

                pst.setInt(1, id);

                try (ResultSet rs =
                             pst.executeQuery()) {

                    if (rs.next()) {

                        result =
                                "CAR ID        : " +
                                rs.getInt("car_id") + "\n" +

                                "BRAND         : " +
                                rs.getString("brand") + "\n" +

                                "MODEL         : " +
                                rs.getString("model") + "\n" +

                                "PRICE         : ₹" +
                                rs.getDouble("price") + "\n" +

                                "FUEL          : " +
                                rs.getString("fuel") + "\n" +

                                "TRANSMISSION  : " +
                                rs.getString("transmission") + "\n" +

                                "YEAR          : " +
                                rs.getInt("year") + "\n" +

                                "COLOR         : " +
                                rs.getString("color") + "\n" +

                                "MILEAGE       : " +
                                rs.getDouble("mileage") +
                                " km/l\n" +

                                "ENGINE        : " +
                                rs.getString("engine") + "\n" +

                                "SEATS         : " +
                                rs.getInt("seats") + "\n" +

                                "CAR TYPE      : " +
                                rs.getString("car_type");
                    }
                }
            }

        } catch (Exception ex) {

            result =
                    "Unable to load car details.";
        }

        return result;
    }

    private String getBookingDate(int bookingId) {

        String date = "";

        String sql =
                "SELECT booking_date " +
                "FROM bookings WHERE booking_id=?";

        try {

            try (Connection con = getConnection();
                 PreparedStatement pst =
                         con.prepareStatement(sql)) {

                pst.setInt(1, bookingId);

                try (ResultSet rs =
                             pst.executeQuery()) {

                    if (rs.next()) {

                        date =
                                rs.getTimestamp(
                                        "booking_date")
                                .toString();
                    }
                }
            }

        } catch (Exception ex) {

            date = "N/A";
        }

        return date;
    }

    private void editCar() {

        if (selectedId == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select a car first.");

            return;
        }

        JOptionPane.showMessageDialog(
                this,
                "Selected Car ID: " +
                selectedId +
                "\n\nEdit feature can be connected to Add Car form.",
                "Edit Feature",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void deleteCar() {

        if (selectedId == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select a car first.");

            return;
        }

        int choice =
                JOptionPane.showConfirmDialog(
                        this,
                        "Delete Car ID " +
                        selectedId +
                        " permanently?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);

        if (choice != JOptionPane.YES_OPTION) {
            return;
        }

        try {

            try (Connection con = getConnection();
                 PreparedStatement pst =
                         con.prepareStatement(
                                 "DELETE FROM cars " +
                                 "WHERE car_id=?")) {

                pst.setInt(1, selectedId);

                int result =
                        pst.executeUpdate();

                if (result > 0) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Car deleted successfully.",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);

                    loadCars();
                }
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Delete failed:\n" +
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}


/*package com.miniproject_car;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.Font;
import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CarDetails extends JFrame implements ActionListener {

    // =========================================================
    // COLORS
    // =========================================================

    private Color darkBlue = new Color(20, 45, 78);
    private Color blue = new Color(0, 102, 204);
    private Color green = new Color(0, 140, 70);
    private Color red = new Color(190, 40, 40);

    private Color darkGray = new Color(55, 55, 55);

    private Color fieldColor =
            new Color(248, 250, 253);

    // =========================================================
    // BACKGROUND IMAGE PATH
    // =========================================================

    private String imagePath =
            "C:\\Users\\thris\\OneDrive\\Desktop\\car.jpg";

    // =========================================================
    // TITLE
    // =========================================================

    private JLabel title;
    private JLabel subtitle;

    // =========================================================
    // SEARCH COMPONENTS
    // =========================================================

    private JLabel typeLabel;
    private JLabel idLabel;

    private JComboBox<String> typeCombo;

    private JTextField idField;

    private JButton searchButton;
    private JButton bookButton;
    private JButton backButton;

    // =========================================================
    // TABLE
    // =========================================================

    private JTable carTable;
    private JScrollPane tableScroll;

    // =========================================================
    // SECTION TITLES
    // =========================================================

    private JLabel detailsTitle;
    private JLabel specificationTitle;

    // =========================================================
    // CAR LABELS
    // =========================================================

    private JLabel carIdLabel;
    private JLabel brandLabel;
    private JLabel modelLabel;
    private JLabel priceLabel;
    private JLabel fuelLabel;
    private JLabel transmissionLabel;

    private JLabel yearLabel;
    private JLabel colorLabel;
    private JLabel mileageLabel;
    private JLabel engineLabel;
    private JLabel seatsLabel;
    private JLabel carTypeLabel;

    // =========================================================
    // CAR TEXT FIELDS
    // =========================================================

    private JTextField carIdField;
    private JTextField brandField;
    private JTextField modelField;
    private JTextField priceField;
    private JTextField fuelField;
    private JTextField transmissionField;

    private JTextField yearField;
    private JTextField colorField;
    private JTextField mileageField;
    private JTextField engineField;
    private JTextField seatsField;
    private JTextField carTypeField;

    // =========================================================
    // BACKGROUND PANEL
    // =========================================================

    private BackgroundPanel backgroundPanel;

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public CarDetails() {

        // =====================================================
        // BACKGROUND
        // =====================================================

        backgroundPanel =
                new BackgroundPanel(imagePath);

        setContentPane(backgroundPanel);

        setLayout(null);

        // =====================================================
        // TITLE
        // =====================================================

        title =
                new JLabel("CAR DETAILS");

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        30
                )
        );

        title.setForeground(Color.WHITE);

        title.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        title.setBounds(
                250,
                20,
                660,
                40
        );

        add(title);

        // =====================================================
        // SUBTITLE
        // =====================================================

        subtitle =
                new JLabel(
                        "Search, View and Book Your Favourite Car"
                );

        subtitle.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        15
                )
        );

        subtitle.setForeground(Color.WHITE);

        subtitle.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        subtitle.setBounds(
                250,
                58,
                660,
                25
        );

        add(subtitle);

        // =====================================================
        // SEARCH PANEL
        // =====================================================

        JPanel searchPanel =
                new JPanel();

        searchPanel.setLayout(null);

        searchPanel.setBackground(
                new Color(
                        255,
                        255,
                        255,
                        235
                )
        );

        searchPanel.setBorder(
                BorderFactory.createLineBorder(
                        new Color(
                                210,
                                220,
                                235
                        ),
                        1
                )
        );

        searchPanel.setBounds(
                40,
                95,
                1080,
                75
        );

        add(searchPanel);

        // =====================================================
        // TYPE LABEL
        // =====================================================

        typeLabel =
                new JLabel(
                        "SELECT CAR TYPE"
                );

        typeLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        typeLabel.setForeground(
                darkGray
        );

        typeLabel.setBounds(
                25,
                10,
                160,
                25
        );

        searchPanel.add(typeLabel);

        // =====================================================
        // TYPE COMBO
        // =====================================================

        typeCombo =
                new JComboBox<String>();

        typeCombo.addItem(
                "SELECT TYPE"
        );

        typeCombo.addItem(
                "SUV"
        );

        typeCombo.addItem(
                "XUV"
        );

        typeCombo.addItem(
                "SEDAN"
        );

        typeCombo.addItem(
                "MUV"
        );

        typeCombo.addItem(
                "HATCHBACK"
        );

        typeCombo.addItem(
                "LUXURY"
        );

        typeCombo.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        typeCombo.setBounds(
                25,
                37,
                220,
                30
        );

        searchPanel.add(typeCombo);

        // =====================================================
        // ID LABEL
        // =====================================================

        idLabel =
                new JLabel(
                        "ENTER CAR ID"
                );

        idLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        idLabel.setForeground(
                darkGray
        );

        idLabel.setBounds(
                300,
                10,
                150,
                25
        );

        searchPanel.add(idLabel);

        // =====================================================
        // ID FIELD
        // =====================================================

        idField =
                new JTextField();

        idField.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        idField.setBounds(
                300,
                37,
                220,
                30
        );

        idField.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(
                                        190,
                                        200,
                                        215
                                )
                        ),
                        BorderFactory.createEmptyBorder(
                                2,
                                8,
                                2,
                                8
                        )
                )
        );

        searchPanel.add(idField);

        // =====================================================
        // SEARCH BUTTON
        // =====================================================

        searchButton =
                new JButton(
                        "SEARCH"
                );

        searchButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        13
                )
        );

        searchButton.setForeground(
                Color.WHITE
        );

        searchButton.setBackground(
                blue
        );

        searchButton.setFocusPainted(
                false
        );

        searchButton.setBorder(
                BorderFactory.createEmptyBorder()
        );

        searchButton.setBounds(
                560,
                36,
                130,
                34
        );

        searchPanel.add(searchButton);

        // =====================================================
        // TABLE PANEL
        // =====================================================

        JPanel tablePanel =
                new JPanel();

        tablePanel.setLayout(null);

        tablePanel.setBackground(
                new Color(
                        255,
                        255,
                        255,
                        240
                )
        );

        tablePanel.setBorder(
                BorderFactory.createLineBorder(
                        new Color(
                                210,
                                220,
                                235
                        ),
                        1
                )
        );

        tablePanel.setBounds(
                40,
                185,
                1080,
                150
        );

        add(tablePanel);

        // =====================================================
        // TABLE
        // =====================================================

        carTable =
                new JTable();

        carTable.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        carTable.setRowHeight(
                30
        );

        carTable.setGridColor(
                new Color(
                        220,
                        225,
                        230
                )
        );

        carTable.setSelectionBackground(
                new Color(
                        210,
                        230,
                        250
                )
        );

        carTable.setSelectionForeground(
                Color.BLACK
        );

        carTable.setShowGrid(
                true
        );

        carTable.setIntercellSpacing(
                new Dimension(
                        1,
                        1
                )
        );

        tableScroll =
                new JScrollPane(
                        carTable
                );

        tableScroll.setBounds(
                15,
                15,
                1050,
                120
        );

        tablePanel.add(
                tableScroll
        );

        // =====================================================
        // DETAILS PANEL
        // =====================================================

        JPanel detailsPanel =
                new JPanel();

        detailsPanel.setLayout(null);

        detailsPanel.setBackground(
                new Color(
                        255,
                        255,
                        255,
                        245
                )
        );

        detailsPanel.setBorder(
                BorderFactory.createLineBorder(
                        new Color(
                                210,
                                220,
                                235
                        ),
                        1
                )
        );

        detailsPanel.setBounds(
                40,
                350,
                520,
                310
        );

        add(detailsPanel);

        // =====================================================
        // DETAILS TITLE
        // =====================================================

        detailsTitle =
                new JLabel(
                        "CAR INFORMATION"
                );

        detailsTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18
                )
        );

        detailsTitle.setForeground(
                darkBlue
        );

        detailsTitle.setBounds(
                20,
                10,
                300,
                30
        );

        detailsPanel.add(
                detailsTitle
        );

        // =====================================================
        // DETAILS LABELS
        // =====================================================

        carIdLabel =
                new JLabel("Car ID:");

        brandLabel =
                new JLabel("Brand:");

        modelLabel =
                new JLabel("Model:");

        priceLabel =
                new JLabel("Price:");

        fuelLabel =
                new JLabel("Fuel:");

        transmissionLabel =
                new JLabel("Transmission:");

        carIdLabel.setBounds(
                20,
                50,
                110,
                25
        );

        brandLabel.setBounds(
                20,
                90,
                110,
                25
        );

        modelLabel.setBounds(
                20,
                130,
                110,
                25
        );

        priceLabel.setBounds(
                20,
                170,
                110,
                25
        );

        fuelLabel.setBounds(
                20,
                210,
                110,
                25
        );

        transmissionLabel.setBounds(
                20,
                250,
                110,
                25
        );

        addDetailLabel(
                detailsPanel,
                carIdLabel
        );

        addDetailLabel(
                detailsPanel,
                brandLabel
        );

        addDetailLabel(
                detailsPanel,
                modelLabel
        );

        addDetailLabel(
                detailsPanel,
                priceLabel
        );

        addDetailLabel(
                detailsPanel,
                fuelLabel
        );

        addDetailLabel(
                detailsPanel,
                transmissionLabel
        );

        // =====================================================
        // DETAILS FIELDS
        // =====================================================

        carIdField =
                createField();

        brandField =
                createField();

        modelField =
                createField();

        priceField =
                createField();

        fuelField =
                createField();

        transmissionField =
                createField();

        carIdField.setBounds(
                135,
                50,
                340,
                27
        );

        brandField.setBounds(
                135,
                90,
                340,
                27
        );

        modelField.setBounds(
                135,
                130,
                340,
                27
        );

        priceField.setBounds(
                135,
                170,
                340,
                27
        );

        fuelField.setBounds(
                135,
                210,
                340,
                27
        );

        transmissionField.setBounds(
                135,
                250,
                340,
                27
        );

        detailsPanel.add(
                carIdField
        );

        detailsPanel.add(
                brandField
        );

        detailsPanel.add(
                modelField
        );

        detailsPanel.add(
                priceField
        );

        detailsPanel.add(
                fuelField
        );

        detailsPanel.add(
                transmissionField
        );

        // =====================================================
        // SPECIFICATION PANEL
        // =====================================================

        JPanel specificationPanel =
                new JPanel();

        specificationPanel.setLayout(null);

        specificationPanel.setBackground(
                new Color(
                        255,
                        255,
                        255,
                        245
                )
        );

        specificationPanel.setBorder(
                BorderFactory.createLineBorder(
                        new Color(
                                210,
                                220,
                                235
                        ),
                        1
                )
        );

        specificationPanel.setBounds(
                580,
                350,
                540,
                310
        );

        add(specificationPanel);

        // =====================================================
        // SPECIFICATION TITLE
        // =====================================================

        specificationTitle =
                new JLabel(
                        "CAR SPECIFICATIONS"
                );

        specificationTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18
                )
        );

        specificationTitle.setForeground(
                darkBlue
        );

        specificationTitle.setBounds(
                20,
                10,
                300,
                30
        );

        specificationPanel.add(
                specificationTitle
        );

        // =====================================================
        // SPECIFICATION LABELS
        // =====================================================

        yearLabel =
                new JLabel("Year:");

        colorLabel =
                new JLabel("Color:");

        mileageLabel =
                new JLabel("Mileage:");

        engineLabel =
                new JLabel("Engine:");

        seatsLabel =
                new JLabel("Seats:");

        carTypeLabel =
                new JLabel("Car Type:");

        yearLabel.setBounds(
                20,
                50,
                110,
                25
        );

        colorLabel.setBounds(
                20,
                90,
                110,
                25
        );

        mileageLabel.setBounds(
                20,
                130,
                110,
                25
        );

        engineLabel.setBounds(
                20,
                170,
                110,
                25
        );

        seatsLabel.setBounds(
                20,
                210,
                110,
                25
        );

        carTypeLabel.setBounds(
                20,
                250,
                110,
                25
        );

        addDetailLabel(
                specificationPanel,
                yearLabel
        );

        addDetailLabel(
                specificationPanel,
                colorLabel
        );

        addDetailLabel(
                specificationPanel,
                mileageLabel
        );

        addDetailLabel(
                specificationPanel,
                engineLabel
        );

        addDetailLabel(
                specificationPanel,
                seatsLabel
        );

        addDetailLabel(
                specificationPanel,
                carTypeLabel
        );

        // =====================================================
        // SPECIFICATION FIELDS
        // =====================================================

        yearField =
                createField();

        colorField =
                createField();

        mileageField =
                createField();

        engineField =
                createField();

        seatsField =
                createField();

        carTypeField =
                createField();

        yearField.setBounds(
                135,
                50,
                360,
                27
        );

        colorField.setBounds(
                135,
                90,
                360,
                27
        );

        mileageField.setBounds(
                135,
                130,
                360,
                27
        );

        engineField.setBounds(
                135,
                170,
                360,
                27
        );

        seatsField.setBounds(
                135,
                210,
                360,
                27
        );

        carTypeField.setBounds(
                135,
                250,
                360,
                27
        );

        specificationPanel.add(
                yearField
        );

        specificationPanel.add(
                colorField
        );

        specificationPanel.add(
                mileageField
        );

        specificationPanel.add(
                engineField
        );

        specificationPanel.add(
                seatsField
        );

        specificationPanel.add(
                carTypeField
        );

        // =====================================================
        // READ ONLY FIELDS
        // =====================================================

        carIdField.setEditable(false);
        brandField.setEditable(false);
        modelField.setEditable(false);
        priceField.setEditable(false);
        fuelField.setEditable(false);
        transmissionField.setEditable(false);

        yearField.setEditable(false);
        colorField.setEditable(false);
        mileageField.setEditable(false);
        engineField.setEditable(false);
        seatsField.setEditable(false);
        carTypeField.setEditable(false);

        // =====================================================
        // BOOK BUTTON
        // =====================================================

        bookButton =
                new JButton(
                        "BOOK CAR"
                );

        bookButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        bookButton.setForeground(
                Color.WHITE
        );

        bookButton.setBackground(
                green
        );

        bookButton.setFocusPainted(
                false
        );

        bookButton.setBorder(
                BorderFactory.createEmptyBorder()
        );

        bookButton.setBounds(
                760,
                680,
                160,
                40
        );

        add(bookButton);

        // =====================================================
        // BACK BUTTON
        // =====================================================

        backButton =
                new JButton(
                        "BACK"
                );

        backButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        backButton.setForeground(
                Color.WHITE
        );

        backButton.setBackground(
                red
        );

        backButton.setFocusPainted(
                false
        );

        backButton.setBorder(
                BorderFactory.createEmptyBorder()
        );

        backButton.setBounds(
                940,
                680,
                160,
                40
        );

        add(backButton);

        // =====================================================
        // BUTTON HOVER EFFECT
        // =====================================================

        addHoverEffect(
                searchButton,
                blue,
                new Color(
                        0,
                        75,
                        160
                )
        );

        addHoverEffect(
                bookButton,
                green,
                new Color(
                        0,
                        100,
                        50
                )
        );

        addHoverEffect(
                backButton,
                red,
                new Color(
                        145,
                        20,
                        20
                )
        );

        // =====================================================
        // ACTION LISTENERS
        // =====================================================

        typeCombo.addActionListener(
                this
        );

        searchButton.addActionListener(
                this
        );

        bookButton.addActionListener(
                this
        );

        backButton.addActionListener(
                this
        );

        // =====================================================
        // FRAME SETTINGS
        // =====================================================

        setTitle(
                "Car Management System - Car Details"
        );

        setSize(
                1160,
                770
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

    // =========================================================
    // CREATE TEXT FIELD
    // =========================================================

    public JTextField createField() {

        JTextField field =
                new JTextField();

        field.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        field.setBackground(
                fieldColor
        );

        field.setForeground(
                darkGray
        );

        field.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(
                                        205,
                                        215,
                                        225
                                )
                        ),
                        BorderFactory.createEmptyBorder(
                                2,
                                8,
                                2,
                                8
                        )
                )
        );

        return field;
    }

    // =========================================================
    // LABEL DESIGN
    // =========================================================

    public void addDetailLabel(
            JPanel panel,
            JLabel label) {

        label.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        label.setForeground(
                darkGray
        );

        panel.add(
                label
        );
    }

    // =========================================================
    // HOVER EFFECT
    // =========================================================

    public void addHoverEffect(
            JButton button,
            Color normalColor,
            Color hoverColor) {

        button.addMouseListener(
                new MouseAdapter() {

                    public void mouseEntered(
                            MouseEvent e) {

                        button.setBackground(
                                hoverColor
                        );
                    }

                    public void mouseExited(
                            MouseEvent e) {

                        button.setBackground(
                                normalColor
                        );
                    }
                }
        );
    }

    // =========================================================
    // ACTION PERFORMED
    // =========================================================

    public void actionPerformed(
            ActionEvent ae) {

        // =====================================================
        // SELECT TYPE
        // =====================================================

        if (ae.getSource() ==
                typeCombo) {

            String carType =
                    typeCombo
                            .getSelectedItem()
                            .toString();

            if (!carType.equals(
                    "SELECT TYPE")) {

                showCarsByType(
                        carType
                );
            }
        }

        // =====================================================
        // SEARCH
        // =====================================================

        else if (ae.getSource() ==
                searchButton) {

            String id =
                    idField
                            .getText()
                            .trim();

            if (id.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter Car ID",
                        "Input Required",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            searchCar(
                    id
            );
        }

        // =====================================================
        // BOOK CAR
        // =====================================================

        else if (ae.getSource() ==
                bookButton) {

            bookCar();
        }

        // =====================================================
        // BACK
        // =====================================================

        else if (ae.getSource() ==
                backButton) {

            new CarHome();

            this.dispose();
        }
    }

    // =========================================================
    // SHOW CARS BY TYPE
    // =========================================================

    public void showCarsByType(
            String carType) {

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

            String sql =
                    "SELECT car_id, brand, model " +
                    "FROM cars " +
                    "WHERE UPPER(TRIM(car_type)) " +
                    "= UPPER(TRIM(?))";

            PreparedStatement pst =
                    con.prepareStatement(
                            sql
                    );

            pst.setString(
                    1,
                    carType
            );

            ResultSet rs =
                    pst.executeQuery();

            DefaultTableModel tableModel =
                    new DefaultTableModel();

            tableModel.addColumn(
                    "CAR ID"
            );

            tableModel.addColumn(
                    "BRAND"
            );

            tableModel.addColumn(
                    "MODEL"
            );

            boolean found =
                    false;

            while (rs.next()) {

                found = true;

                tableModel.addRow(
                        new Object[] {

                                rs.getInt(
                                        "car_id"
                                ),

                                rs.getString(
                                        "brand"
                                ),

                                rs.getString(
                                        "model"
                                )
                        }
                );
            }

            carTable.setModel(
                    tableModel
            );

            // =================================================
            // TABLE HEADER
            // =================================================

            carTable.getTableHeader()
                    .setFont(
                            new Font(
                                    "Arial",
                                    Font.BOLD,
                                    14
                            )
                    );

            carTable.getTableHeader()
                    .setBackground(
                            darkBlue
                    );

            carTable.getTableHeader()
                    .setForeground(
                            Color.WHITE
                    );

            carTable.getTableHeader()
                    .setPreferredSize(
                            new Dimension(
                                    0,
                                    32
                            )
                    );

            // =================================================
            // CENTER ALIGN TABLE
            // =================================================

            DefaultTableCellRenderer
                    centerRenderer =
                    new DefaultTableCellRenderer();

            centerRenderer
                    .setHorizontalAlignment(
                            SwingConstants.CENTER
                    );

            for (int i = 0;
                    i < carTable
                            .getColumnCount();
                    i++) {

                carTable
                        .getColumnModel()
                        .getColumn(i)
                        .setCellRenderer(
                                centerRenderer
                        );
            }

            // =================================================
            // COLUMN WIDTH
            // =================================================

            carTable
                    .getColumnModel()
                    .getColumn(0)
                    .setPreferredWidth(
                            100
                    );

            carTable
                    .getColumnModel()
                    .getColumn(1)
                    .setPreferredWidth(
                            200
                    );

            carTable
                    .getColumnModel()
                    .getColumn(2)
                    .setPreferredWidth(
                            300
                    );

            // =================================================
            // NO RESULT
            // =================================================

            if (!found) {

                JOptionPane.showMessageDialog(
                        this,
                        "No cars found for "
                                + carType,
                        "No Cars",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }

            rs.close();

            pst.close();

            con.close();

        } catch (Exception e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(
                    this,
                    "Database Error: "
                            + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // =========================================================
    // SEARCH CAR
    // =========================================================

    public void searchCar(
            String id) {

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

            String sql =
                    "SELECT * FROM cars " +
                    "WHERE car_id=?";

            PreparedStatement pst =
                    con.prepareStatement(
                            sql
                    );

            pst.setInt(
                    1,
                    Integer.parseInt(id)
            );

            ResultSet rs =
                    pst.executeQuery();

            if (rs.next()) {

                // =================================================
                // CAR ID
                // =================================================

                carIdField.setText(
                        String.valueOf(
                                rs.getInt(
                                        "car_id"
                                )
                        )
                );

                // =================================================
                // BRAND
                // =================================================

                brandField.setText(
                        rs.getString(
                                "brand"
                        )
                );

                // =================================================
                // MODEL
                // =================================================

                modelField.setText(
                        rs.getString(
                                "model"
                        )
                );

                // =================================================
                // PRICE
                // =================================================

                priceField.setText(
                        String.valueOf(
                                rs.getDouble(
                                        "price"
                                )
                        )
                );

                // =================================================
                // FUEL
                // =================================================

                fuelField.setText(
                        rs.getString(
                                "fuel"
                        )
                );

                // =================================================
                // TRANSMISSION
                // =================================================

                transmissionField.setText(
                        rs.getString(
                                "transmission"
                        )
                );

                // =================================================
                // YEAR
                // =================================================

                yearField.setText(
                        String.valueOf(
                                rs.getInt(
                                        "year"
                                )
                        )
                );

                // =================================================
                // COLOR
                // =================================================

                colorField.setText(
                        rs.getString(
                                "color"
                        )
                );

                // =================================================
                // MILEAGE
                // =================================================

                mileageField.setText(
                        String.valueOf(
                                rs.getDouble(
                                        "mileage"
                                )
                        )
                );

                // =================================================
                // ENGINE
                // =================================================

                engineField.setText(
                        rs.getString(
                                "engine"
                        )
                );

                // =================================================
                // SEATS
                // =================================================

                seatsField.setText(
                        String.valueOf(
                                rs.getInt(
                                        "seats"
                                )
                        )
                );

                // =================================================
                // CAR TYPE
                // =================================================

                String type =
                        rs.getString(
                                "car_type"
                        );

                carTypeField.setText(
                        type
                );

                // =================================================
                // SELECT TYPE
                // =================================================

                typeCombo.setSelectedItem(
                        type
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "No car found with ID: "
                                + id,
                        "Car Not Found",
                        JOptionPane.WARNING_MESSAGE
                );

                clearDetails();
            }

            rs.close();

            pst.close();

            con.close();

        } catch (
                NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Car ID must be a number",
                    "Invalid Car ID",
                    JOptionPane.WARNING_MESSAGE
            );

        } catch (Exception e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(
                    this,
                    "Database Error: "
                            + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // =========================================================
    // BOOK CAR
    // =========================================================

    public void bookCar() {

        String carId =
                carIdField
                        .getText()
                        .trim();

        if (carId.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please search for a car first!",
                    "Car Selection Required",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        String brand =
                brandField.getText();

        String model =
                modelField.getText();

        String price =
                priceField.getText();

        String fuel =
                fuelField.getText();

        String transmission =
                transmissionField.getText();

        String year =
                yearField.getText();

        String color =
                colorField.getText();

        String mileage =
                mileageField.getText();

        String engine =
                engineField.getText();

        String seats =
                seatsField.getText();

        String carType =
                carTypeField.getText();

        // =====================================================
        // CONFIRM BOOKING
        // =====================================================

        int choice =
                JOptionPane.showConfirmDialog(

                        this,

                        "Are you sure you want to book this car?\n\n"
                                +

                                "Car ID : "
                                + carId
                                + "\n"

                                +

                                "Brand  : "
                                + brand
                                + "\n"

                                +

                                "Model  : "
                                + model
                                + "\n"

                                +

                                "Price  : ₹"
                                + price,

                        "Confirm Car Booking",

                        JOptionPane.YES_NO_OPTION,

                        JOptionPane.QUESTION_MESSAGE
                );

        // =====================================================
        // SUCCESS MESSAGE
        // =====================================================

        if (choice ==
                JOptionPane.YES_OPTION) {

            JOptionPane.showMessageDialog(

                    this,

                    "CONGRATULATIONS ON YOUR NEW CAR!\n\n"

                            +

                            "========== CAR DETAILS ==========\n\n"

                            +

                            "Car ID          : "
                            + carId
                            + "\n"

                            +

                            "Brand           : "
                            + brand
                            + "\n"

                            +

                            "Model           : "
                            + model
                            + "\n"

                            +

                            "Price           : ₹"
                            + price
                            + "\n"

                            +

                            "Fuel            : "
                            + fuel
                            + "\n"

                            +

                            "Transmission    : "
                            + transmission
                            + "\n"

                            +

                            "Year            : "
                            + year
                            + "\n"

                            +

                            "Color           : "
                            + color
                            + "\n"

                            +

                            "Mileage         : "
                            + mileage
                            + " km/l\n"

                            +

                            "Engine          : "
                            + engine
                            + "\n"

                            +

                            "Seats           : "
                            + seats
                            + "\n"

                            +

                            "Car Type        : "
                            + carType
                            + "\n\n"

                            +

                            "================================\n\n"

                            +

                            "Thank you for choosing us!\n"

                            +

                            "Enjoy your new "
                            + brand
                            + " "
                            + model
                            + "!",

                    "BOOKING SUCCESSFUL",

                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    // =========================================================
    // CLEAR DETAILS
    // =========================================================

    public void clearDetails() {

        carIdField.setText("");

        brandField.setText("");

        modelField.setText("");

        priceField.setText("");

        fuelField.setText("");

        transmissionField.setText("");

        yearField.setText("");

        colorField.setText("");

        mileageField.setText("");

        engineField.setText("");

        seatsField.setText("");

        carTypeField.setText("");
    }

    // =========================================================
    // BACKGROUND PANEL
    // =========================================================

    class BackgroundPanel extends JPanel {

        private Image backgroundImage;

        public BackgroundPanel(
                String imagePath) {

            ImageIcon icon =
                    new ImageIcon(
                            imagePath
                    );

            backgroundImage =
                    icon.getImage();
        }

        protected void paintComponent(
                Graphics g) {

            super.paintComponent(g);

            Graphics2D g2 =
                    (Graphics2D) g;

            g2.setRenderingHint(
                    RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR
            );

            // =================================================
            // DRAW IMAGE
            // =================================================

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

                // =================================================
                // FALLBACK BACKGROUND
                // =================================================

                g2.setColor(
                        new Color(
                                225,
                                235,
                                245
                        )
                );

                g2.fillRect(
                        0,
                        0,
                        getWidth(),
                        getHeight()
                );
            }

            // =================================================
            // TRANSPARENT DARK OVERLAY
            // =================================================

            g2.setColor(
                    new Color(
                            0,
                            0,
                            0,
                            75
                    )
            );

            g2.fillRect(
                    0,
                    0,
                    getWidth(),
                    getHeight()
            );
        }
    }

    // =========================================================
    // MAIN METHOD
    // =========================================================

    public static void main(
            String[] args) {

        new CarDetails();
    }
}



/*package com.miniproject_car;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CarDetails extends JFrame implements ActionListener {

    private JLabel title;

    private JLabel typeLabel;
    private JLabel idLabel;

    private JComboBox<String> typeCombo;

    private JTextField idField;

    private JButton searchButton;
    private JButton bookButton;
    private JButton backButton;

    private JTable carTable;
    private JScrollPane tableScroll;

    private JLabel carIdLabel;
    private JLabel brandLabel;
    private JLabel modelLabel;
    private JLabel priceLabel;
    private JLabel fuelLabel;
    private JLabel transmissionLabel;
    private JLabel yearLabel;
    private JLabel colorLabel;
    private JLabel mileageLabel;
    private JLabel engineLabel;
    private JLabel seatsLabel;
    private JLabel carTypeLabel;

    private JTextField carIdField;
    private JTextField brandField;
    private JTextField modelField;
    private JTextField priceField;
    private JTextField fuelField;
    private JTextField transmissionField;
    private JTextField yearField;
    private JTextField colorField;
    private JTextField mileageField;
    private JTextField engineField;
    private JTextField seatsField;
    private JTextField carTypeField;

    public CarDetails() {

        title = new JLabel("CAR DETAILS");

        typeLabel = new JLabel("Select Car Type:");
        idLabel = new JLabel("Enter Car ID:");

        typeCombo = new JComboBox<String>();

        typeCombo.addItem("SELECT TYPE");
        typeCombo.addItem("SUV");
        typeCombo.addItem("XUV");
        typeCombo.addItem("SEDAN");
        typeCombo.addItem("MUV");
        typeCombo.addItem("HATCHBACK");
        typeCombo.addItem("LUXURY");

        idField = new JTextField();

        searchButton = new JButton("SEARCH");
        bookButton = new JButton("BOOK CAR");
        backButton = new JButton("BACK");

        carTable = new JTable();

        tableScroll = new JScrollPane(carTable);

        carIdLabel = new JLabel("Car ID:");
        brandLabel = new JLabel("Brand:");
        modelLabel = new JLabel("Model:");
        priceLabel = new JLabel("Price:");
        fuelLabel = new JLabel("Fuel:");
        transmissionLabel = new JLabel("Transmission:");

        yearLabel = new JLabel("Year:");
        colorLabel = new JLabel("Color:");
        mileageLabel = new JLabel("Mileage:");
        engineLabel = new JLabel("Engine:");
        seatsLabel = new JLabel("Seats:");
        carTypeLabel = new JLabel("Car Type:");

        carIdField = new JTextField();
        brandField = new JTextField();
        modelField = new JTextField();
        priceField = new JTextField();
        fuelField = new JTextField();
        transmissionField = new JTextField();

        yearField = new JTextField();
        colorField = new JTextField();
        mileageField = new JTextField();
        engineField = new JTextField();
        seatsField = new JTextField();
        carTypeField = new JTextField();

        setLayout(null);

        // =====================================================
        // TITLE
        // =====================================================

        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setForeground(new Color(0, 102, 204));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(250, 15, 300, 40);

        add(title);

        // =====================================================
        // SELECT CAR TYPE
        // =====================================================

        typeLabel.setFont(new Font("Arial", Font.BOLD, 15));
        typeLabel.setBounds(50, 70, 130, 30);

        typeCombo.setBounds(180, 70, 180, 30);

        add(typeLabel);
        add(typeCombo);

        // =====================================================
        // CAR ID
        // =====================================================

        idLabel.setFont(new Font("Arial", Font.BOLD, 15));
        idLabel.setBounds(400, 70, 100, 30);

        idField.setBounds(500, 70, 120, 30);

        add(idLabel);
        add(idField);

        // =====================================================
        // SEARCH BUTTON
        // =====================================================

        searchButton.setBounds(640, 70, 100, 30);

        searchButton.setBackground(new Color(0, 102, 204));
        searchButton.setForeground(Color.WHITE);
        searchButton.setFont(new Font("Arial", Font.BOLD, 13));

        add(searchButton);

        // =====================================================
        // TABLE
        // =====================================================

        tableScroll.setBounds(50, 115, 690, 130);

        add(tableScroll);

        // =====================================================
        // LEFT LABELS
        // =====================================================

        carIdLabel.setBounds(50, 270, 100, 25);
        brandLabel.setBounds(50, 310, 100, 25);
        modelLabel.setBounds(50, 350, 100, 25);
        priceLabel.setBounds(50, 390, 100, 25);
        fuelLabel.setBounds(50, 430, 100, 25);
        transmissionLabel.setBounds(50, 470, 100, 25);

        // =====================================================
        // RIGHT LABELS
        // =====================================================

        yearLabel.setBounds(400, 270, 100, 25);
        colorLabel.setBounds(400, 310, 100, 25);
        mileageLabel.setBounds(400, 350, 100, 25);
        engineLabel.setBounds(400, 390, 100, 25);
        seatsLabel.setBounds(400, 430, 100, 25);
        carTypeLabel.setBounds(400, 470, 100, 25);

        // =====================================================
        // LEFT FIELDS
        // =====================================================

        carIdField.setBounds(150, 270, 180, 25);
        brandField.setBounds(150, 310, 180, 25);
        modelField.setBounds(150, 350, 180, 25);
        priceField.setBounds(150, 390, 180, 25);
        fuelField.setBounds(150, 430, 180, 25);
        transmissionField.setBounds(150, 470, 180, 25);

        // =====================================================
        // RIGHT FIELDS
        // =====================================================

        yearField.setBounds(500, 270, 180, 25);
        colorField.setBounds(500, 310, 180, 25);
        mileageField.setBounds(500, 350, 180, 25);
        engineField.setBounds(500, 390, 180, 25);
        seatsField.setBounds(500, 430, 180, 25);
        carTypeField.setBounds(500, 470, 180, 25);

        // =====================================================
        // ADD LABELS
        // =====================================================

        add(carIdLabel);
        add(brandLabel);
        add(modelLabel);
        add(priceLabel);
        add(fuelLabel);
        add(transmissionLabel);

        add(yearLabel);
        add(colorLabel);
        add(mileageLabel);
        add(engineLabel);
        add(seatsLabel);
        add(carTypeLabel);

        // =====================================================
        // ADD TEXT FIELDS
        // =====================================================

        add(carIdField);
        add(brandField);
        add(modelField);
        add(priceField);
        add(fuelField);
        add(transmissionField);

        add(yearField);
        add(colorField);
        add(mileageField);
        add(engineField);
        add(seatsField);
        add(carTypeField);

        // =====================================================
        // MAKE DETAILS READ ONLY
        // =====================================================

        carIdField.setEditable(false);
        brandField.setEditable(false);
        modelField.setEditable(false);
        priceField.setEditable(false);
        fuelField.setEditable(false);
        transmissionField.setEditable(false);

        yearField.setEditable(false);
        colorField.setEditable(false);
        mileageField.setEditable(false);
        engineField.setEditable(false);
        seatsField.setEditable(false);
        carTypeField.setEditable(false);

        // =====================================================
        // BOOK CAR BUTTON
        // =====================================================

        bookButton.setBounds(490, 520, 130, 35);

        bookButton.setBackground(new Color(0, 128, 0));
        bookButton.setForeground(Color.WHITE);
        bookButton.setFont(new Font("Arial", Font.BOLD, 13));

        add(bookButton);

        // =====================================================
        // BACK BUTTON
        // =====================================================

        backButton.setBounds(640, 520, 100, 35);

        backButton.setBackground(new Color(150, 0, 0));
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Arial", Font.BOLD, 13));

        add(backButton);

        // =====================================================
        // ACTION LISTENERS
        // =====================================================

        typeCombo.addActionListener(this);

        searchButton.addActionListener(this);

        bookButton.addActionListener(this);

        backButton.addActionListener(this);

        // =====================================================
        // FRAME
        // =====================================================

        setTitle("Car Details");

        setSize(800, 620);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setVisible(true);
    }

    // =========================================================
    // ACTION PERFORMED
    // =========================================================

    public void actionPerformed(ActionEvent ae) {

        // =====================================================
        // SELECT TYPE
        // =====================================================

        if (ae.getSource() == typeCombo) {

            String carType =
                    typeCombo.getSelectedItem().toString();

            if (!carType.equals("SELECT TYPE")) {

                showCarsByType(carType);
            }
        }

        // =====================================================
        // SEARCH
        // =====================================================

        else if (ae.getSource() == searchButton) {

            String id = idField.getText().trim();

            if (id.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter Car ID"
                );

                return;
            }

            searchCar(id);
        }

        // =====================================================
        // BOOK CAR
        // =====================================================

        else if (ae.getSource() == bookButton) {

            bookCar();
        }

        // =====================================================
        // BACK
        // =====================================================

        else if (ae.getSource() == backButton) {

            new CarHome();

            this.dispose();
        }
    }

    // =========================================================
    // SHOW CARS BY TYPE
    // =========================================================

    public void showCarsByType(String carType) {

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

            String sql =
                    "SELECT car_id, brand, model " +
                    "FROM cars " +
                    "WHERE UPPER(TRIM(car_type)) = UPPER(TRIM(?))";

            PreparedStatement pst =
                    con.prepareStatement(sql);

            pst.setString(1, carType);

            ResultSet rs =
                    pst.executeQuery();

            DefaultTableModel tableModel =
                    new DefaultTableModel();

            tableModel.addColumn("CAR ID");
            tableModel.addColumn("BRAND");
            tableModel.addColumn("MODEL");

            boolean found = false;

            while (rs.next()) {

                found = true;

                tableModel.addRow(
                        new Object[] {
                                rs.getInt("car_id"),
                                rs.getString("brand"),
                                rs.getString("model")
                        }
                );
            }

            carTable.setModel(tableModel);

            if (!found) {

                JOptionPane.showMessageDialog(
                        this,
                        "No cars found for " + carType
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

    // =========================================================
    // SEARCH CAR
    // =========================================================

    public void searchCar(String id) {

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

            String sql =
                    "SELECT * FROM cars WHERE car_id=?";

            PreparedStatement pst =
                    con.prepareStatement(sql);

            pst.setInt(
                    1,
                    Integer.parseInt(id)
            );

            ResultSet rs =
                    pst.executeQuery();

            if (rs.next()) {

                carIdField.setText(
                        String.valueOf(
                                rs.getInt("car_id")
                        )
                );

                brandField.setText(
                        rs.getString("brand")
                );

                modelField.setText(
                        rs.getString("model")
                );

                priceField.setText(
                        String.valueOf(
                                rs.getDouble("price")
                        )
                );

                fuelField.setText(
                        rs.getString("fuel")
                );

                transmissionField.setText(
                        rs.getString("transmission")
                );

                yearField.setText(
                        String.valueOf(
                                rs.getInt("year")
                        )
                );

                colorField.setText(
                        rs.getString("color")
                );

                mileageField.setText(
                        String.valueOf(
                                rs.getDouble("mileage")
                        )
                );

                engineField.setText(
                        rs.getString("engine")
                );

                seatsField.setText(
                        String.valueOf(
                                rs.getInt("seats")
                        )
                );

                carTypeField.setText(
                        rs.getString("car_type")
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "No car found with ID: " + id
                );

                clearDetails();
            }

            rs.close();

            pst.close();

            con.close();

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Car ID must be a number"
            );

        } catch (Exception e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(
                    this,
                    "Database Error: " +
                    e.getMessage()
            );
        }
    }

    // =========================================================
    // BOOK CAR
    // =========================================================

    public void bookCar() {

        String carId = carIdField.getText().trim();

        if (carId.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please search for a car first!"
            );

            return;
        }

        String brand = brandField.getText();
        String model = modelField.getText();
        String price = priceField.getText();
        String fuel = fuelField.getText();
        String transmission = transmissionField.getText();
        String year = yearField.getText();
        String color = colorField.getText();
        String mileage = mileageField.getText();
        String engine = engineField.getText();
        String seats = seatsField.getText();
        String carType = carTypeField.getText();

        int choice = JOptionPane.showConfirmDialog(
                this,

                "Are you sure you want to book this car?\n\n" +
                "Car ID: " + carId + "\n" +
                "Brand: " + brand + "\n" +
                "Model: " + model,

                "Confirm Car Booking",

                JOptionPane.YES_NO_OPTION
        );

        if (choice == JOptionPane.YES_OPTION) {

            JOptionPane.showMessageDialog(
                    this,

                    "🎉 CONGRATULATIONS ON YOUR NEW CAR! 🎉\n\n" +

                    "========== CAR DETAILS ==========\n\n" +

                    "Car ID          : " + carId + "\n" +
                    "Brand           : " + brand + "\n" +
                    "Model           : " + model + "\n" +
                    "Price           : ₹" + price + "\n" +
                    "Fuel            : " + fuel + "\n" +
                    "Transmission    : " + transmission + "\n" +
                    "Year            : " + year + "\n" +
                    "Color           : " + color + "\n" +
                    "Mileage         : " + mileage + " km/l\n" +
                    "Engine          : " + engine + "\n" +
                    "Seats           : " + seats + "\n" +
                    "Car Type        : " + carType + "\n\n" +

                    "================================\n\n" +

                    "Thank you for choosing us!\n" +
                    "Enjoy your new " + brand + " " + model + "!",

                    "BOOKING SUCCESSFUL",

                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    // =========================================================
    // CLEAR DETAILS
    // =========================================================

    public void clearDetails() {

        carIdField.setText("");
        brandField.setText("");
        modelField.setText("");
        priceField.setText("");
        fuelField.setText("");
        transmissionField.setText("");

        yearField.setText("");
        colorField.setText("");
        mileageField.setText("");
        engineField.setText("");
        seatsField.setText("");
        carTypeField.setText("");
    }
}*/