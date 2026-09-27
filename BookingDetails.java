package com.miniproject_car;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookingDetails extends JFrame implements ActionListener {

    private JTable table;
    private DefaultTableModel model;

    private JTextField searchField;

    private JButton search;
    private JButton refresh;
    private JButton view;
    private JButton back;

    private JLabel bookingCount;
    private JLabel selectedBooking;

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

    public BookingDetails() {

        setTitle(
                "THRISHA CARZONE - Booking Management");

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
                        "BOOKING MANAGEMENT  •  CUSTOMER HISTORY");

        subtitle.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        12));

        subtitle.setForeground(MUTED);

        subtitle.setBounds(
                97, 50, 500, 25);

        main.add(subtitle);

        bookingCount =
                new JLabel(
                        "0 BOOKINGS");

        bookingCount.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        13));

        bookingCount.setForeground(
                new Color(
                        55, 210, 125));

        bookingCount.setHorizontalAlignment(
                SwingConstants.RIGHT);

        bookingCount.setBounds(
                850, 30, 300, 30);

        main.add(bookingCount);

        // =================================================
        // SEARCH PANEL
        // =================================================

        JPanel searchPanel =
                new JPanel(null);

        searchPanel.setBackground(PANEL);

        searchPanel.setBorder(
                BorderFactory.createLineBorder(
                        new Color(
                                50, 58, 73)));

        searchPanel.setBounds(
                30, 90, 1120, 75);

        main.add(searchPanel);

        JLabel searchLabel =
                new JLabel(
                        "SEARCH BOOKINGS");

        searchLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        11));

        searchLabel.setForeground(MUTED);

        searchLabel.setBounds(
                20, 10, 180, 20);

        searchPanel.add(searchLabel);

        searchField =
                new JTextField();

        searchField.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        13));

        searchField.setBounds(
                20, 34, 500, 32);

        searchField.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(
                                        65, 73, 90)),

                        BorderFactory.createEmptyBorder(
                                5, 10, 5, 10)));

        searchPanel.add(searchField);

        search =
                premiumButton(
                        "SEARCH",
                        new Color(
                                35, 105, 190));

        search.setBounds(
                540, 34, 120, 32);

        searchPanel.add(search);

        refresh =
                premiumButton(
                        "RESET",
                        new Color(
                                80, 85, 100));

        refresh.setBounds(
                675, 34, 120, 32);

        searchPanel.add(refresh);

        JLabel searchInfo =
                new JLabel(
                        "Name • Phone • Car • Booking ID");

        searchInfo.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        11));

        searchInfo.setForeground(MUTED);

        searchInfo.setBounds(
                835, 34, 250, 30);

        searchPanel.add(searchInfo);

        // =================================================
        // TABLE
        // =================================================

        model =
                new DefaultTableModel(
                        new Object[]{
                                "BOOKING ID",
                                "CUSTOMER",
                                "PHONE",
                                "CAR ID",
                                "BRAND",
                                "MODEL",
                                "PRICE",
                                "TYPE",
                                "YEAR",
                                "BOOKING DATE"
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

        table.setRowHeight(34);

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
                        0, 38));

        JScrollPane scroll =
                new JScrollPane(table);

        scroll.setBounds(
                30, 185, 1120, 325);

        scroll.setBorder(
                BorderFactory.createLineBorder(
                        new Color(
                                50, 58, 73)));

        main.add(scroll);

        // =================================================
        // SELECTED BOOKING PANEL
        // =================================================

        JPanel bottomPanel =
                new JPanel(null);

        bottomPanel.setBackground(PANEL);

        bottomPanel.setBorder(
                BorderFactory.createLineBorder(
                        new Color(
                                50, 58, 73)));

        bottomPanel.setBounds(
                30, 530, 1120, 90);

        main.add(bottomPanel);

        selectedBooking =
                new JLabel(
                        "Select a booking to view details");

        selectedBooking.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        15));

        selectedBooking.setForeground(
                Color.WHITE);

        selectedBooking.setBounds(
                20, 15, 650, 25);

        bottomPanel.add(selectedBooking);

        JLabel info =
                new JLabel(
                        "View customer, vehicle and booking information");

        info.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        11));

        info.setForeground(MUTED);

        info.setBounds(
                20, 45, 600, 20);

        bottomPanel.add(info);

        view =
                premiumButton(
                        "VIEW DETAILS",
                        new Color(
                                25, 145, 90));

        view.setBounds(
                750, 23, 160, 40);

        bottomPanel.add(view);

        back =
                premiumButton(
                        "BACK",
                        new Color(
                                160, 45, 55));

        back.setBounds(
                930, 23, 150, 40);

        bottomPanel.add(back);

        // =================================================
        // FOOTER
        // =================================================

        JLabel footer =
                new JLabel(
                        "© 2026 THRISHA CARZONE  •  PREMIUM BOOKING MANAGEMENT");

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
                300, 655, 600, 25);

        main.add(footer);

        // =================================================
        // EVENTS
        // =================================================

        search.addActionListener(this);

        refresh.addActionListener(this);

        view.addActionListener(this);

        back.addActionListener(this);

        searchField.addActionListener(e ->
                loadBookings());

        table.getSelectionModel()
                .addListSelectionListener(e -> {

                    if (!e.getValueIsAdjusting()) {

                        updateSelectedBooking();
                    }
                });

        // =================================================
        // LOAD BOOKINGS
        // =================================================

        loadBookings();

        setVisible(true);
    }

    // =====================================================
    // BUTTON
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
    // LOAD BOOKINGS
    // =====================================================

    private void loadBookings() {

        model.setRowCount(0);

        String text =
                searchField
                        .getText()
                        .trim();

        String sql =
                "SELECT b.booking_id, " +
                "b.customer_name, " +
                "b.phone, " +
                "c.car_id, " +
                "c.brand, " +
                "c.model, " +
                "c.price, " +
                "c.car_type, " +
                "c.year, " +
                "b.booking_date " +

                "FROM bookings b " +

                "INNER JOIN cars c " +
                "ON b.car_id = c.car_id ";

        if (!text.isEmpty()) {

            sql +=
                    "WHERE CAST(b.booking_id AS CHAR) LIKE ? " +
                    "OR b.customer_name LIKE ? " +
                    "OR b.phone LIKE ? " +
                    "OR c.brand LIKE ? " +
                    "OR c.model LIKE ? ";
        }

        sql +=
                "ORDER BY b.booking_id DESC";

        try {

            try (
                    Connection con =
                            getConnection();

                    PreparedStatement pst =
                            con.prepareStatement(sql)
            ) {

                if (!text.isEmpty()) {

                    String like =
                            "%" + text + "%";

                    pst.setString(
                            1, like);

                    pst.setString(
                            2, like);

                    pst.setString(
                            3, like);

                    pst.setString(
                            4, like);

                    pst.setString(
                            5, like);
                }

                try (
                        ResultSet rs =
                                pst.executeQuery()
                ) {

                    while (rs.next()) {

                        model.addRow(
                                new Object[]{

                                        rs.getInt(
                                                "booking_id"),

                                        rs.getString(
                                                "customer_name"),

                                        rs.getString(
                                                "phone"),

                                        rs.getInt(
                                                "car_id"),

                                        rs.getString(
                                                "brand"),

                                        rs.getString(
                                                "model"),

                                        "₹" +
                                        String.format(
                                                "%.2f",
                                                rs.getDouble(
                                                        "price")),

                                        rs.getString(
                                                "car_type"),

                                        rs.getInt(
                                                "year"),

                                        rs.getTimestamp(
                                                "booking_date")
                                });
                    }
                }
            }

            bookingCount.setText(
                    model.getRowCount() +
                    " BOOKINGS");

            selectedBooking.setText(
                    "Select a booking to view details");

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
    // SELECTED BOOKING
    // =====================================================

    private void updateSelectedBooking() {

        int row =
                table.getSelectedRow();

        if (row < 0) {

            return;
        }

        int actual =
                table.convertRowIndexToModel(
                        row);

        String bookingId =
                model.getValueAt(
                        actual,
                        0).toString();

        String customer =
                model.getValueAt(
                        actual,
                        1).toString();

        String car =
                model.getValueAt(
                        actual,
                        4).toString()
                        + " " +
                        model.getValueAt(
                                actual,
                                5).toString();

        selectedBooking.setText(
                "BOOKING #" +
                bookingId +
                "    •    " +
                customer +
                "    •    " +
                car);
    }

    // =====================================================
    // VIEW DETAILS
    // =====================================================

    private void viewDetails() {

        int row =
                table.getSelectedRow();

        if (row < 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select a booking first.",
                    "Select Booking",
                    JOptionPane.WARNING_MESSAGE);

            return;
        }

        int actual =
                table.convertRowIndexToModel(
                        row);

        int bookingId =
                Integer.parseInt(
                        model.getValueAt(
                                actual,
                                0).toString());

        showBookingDetails(
                bookingId);
    }

    // =====================================================
    // BOOKING DETAILS POPUP
    // =====================================================

    private void showBookingDetails(
            int bookingId) {

        String sql =
                "SELECT " +
                "b.booking_id, " +
                "b.customer_name, " +
                "b.phone, " +
                "b.booking_date, " +
                "c.car_id, " +
                "c.brand, " +
                "c.model, " +
                "c.price, " +
                "c.fuel, " +
                "c.transmission, " +
                "c.year, " +
                "c.color, " +
                "c.mileage, " +
                "c.engine, " +
                "c.seats, " +
                "c.car_type " +

                "FROM bookings b " +

                "INNER JOIN cars c " +
                "ON b.car_id = c.car_id " +

                "WHERE b.booking_id=?";

        try {

            try (
                    Connection con =
                            getConnection();

                    PreparedStatement pst =
                            con.prepareStatement(sql)
            ) {

                pst.setInt(
                        1,
                        bookingId);

                try (
                        ResultSet rs =
                                pst.executeQuery()
                ) {

                    if (rs.next()) {

                        JFrame dialog =
                                new JFrame(
                                        "Booking Confirmation");

                        dialog.setSize(
                                700, 620);

                        dialog.setLocationRelativeTo(
                                this);

                        dialog.setResizable(false);

                        JPanel panel =
                                new JPanel(null);

                        panel.setBackground(BG);

                        dialog.setContentPane(
                                panel);

                        // ==============================
                        // TITLE
                        // ==============================

                        JLabel title =
                                new JLabel(
                                        "THRISHA CARZONE");

                        title.setFont(
                                new Font(
                                        "SansSerif",
                                        Font.BOLD,
                                        28));

                        title.setForeground(GOLD);

                        title.setHorizontalAlignment(
                                SwingConstants.CENTER);

                        title.setBounds(
                                40, 20, 620, 40);

                        panel.add(title);

                        JLabel confirmed =
                                new JLabel(
                                        "✓ BOOKING CONFIRMED");

                        confirmed.setFont(
                                new Font(
                                        "SansSerif",
                                        Font.BOLD,
                                        17));

                        confirmed.setForeground(
                                new Color(
                                        55, 210, 125));

                        confirmed.setHorizontalAlignment(
                                SwingConstants.CENTER);

                        confirmed.setBounds(
                                40, 60, 620, 30);

                        panel.add(confirmed);

                        // ==============================
                        // CARD
                        // ==============================

                        JPanel card =
                                new JPanel(null);

                        card.setBackground(PANEL);

                        card.setBorder(
                                BorderFactory.createLineBorder(
                                        new Color(
                                                55, 63, 80)));

                        card.setBounds(
                                45, 105, 610, 410);

                        panel.add(card);

                        // ==============================
                        // CUSTOMER
                        // ==============================

                        JLabel customerTitle =
                                section(
                                        "CUSTOMER INFORMATION");

                        customerTitle.setBounds(
                                20, 15, 300, 25);

                        card.add(customerTitle);

                        addInfo(
                                card,
                                "CUSTOMER NAME",
                                rs.getString(
                                        "customer_name"),
                                20,
                                45);

                        addInfo(
                                card,
                                "PHONE NUMBER",
                                rs.getString(
                                        "phone"),
                                20,
                                75);

                        // ==============================
                        // CAR
                        // ==============================

                        JLabel carTitle =
                                section(
                                        "VEHICLE INFORMATION");

                        carTitle.setBounds(
                                20, 115, 300, 25);

                        card.add(carTitle);

                        addInfo(
                                card,
                                "CAR",
                                rs.getString(
                                        "brand") +
                                " " +
                                rs.getString(
                                        "model"),
                                20,
                                145);

                        addInfo(
                                card,
                                "CAR ID",
                                String.valueOf(
                                        rs.getInt(
                                                "car_id")),
                                20,
                                175);

                        addInfo(
                                card,
                                "PRICE",
                                "₹" +
                                String.format(
                                        "%.2f",
                                        rs.getDouble(
                                                "price")),
                                20,
                                205);

                        addInfo(
                                card,
                                "TYPE",
                                rs.getString(
                                        "car_type"),
                                320,
                                145);

                        addInfo(
                                card,
                                "FUEL",
                                rs.getString(
                                        "fuel"),
                                320,
                                175);

                        addInfo(
                                card,
                                "TRANSMISSION",
                                rs.getString(
                                        "transmission"),
                                320,
                                205);

                        addInfo(
                                card,
                                "YEAR",
                                String.valueOf(
                                        rs.getInt(
                                                "year")),
                                20,
                                235);

                        addInfo(
                                card,
                                "COLOR",
                                rs.getString(
                                        "color"),
                                320,
                                235);

                        // ==============================
                        // BOOKING
                        // ==============================

                        JLabel bookingTitle =
                                section(
                                        "BOOKING INFORMATION");

                        bookingTitle.setBounds(
                                20, 280, 300, 25);

                        card.add(bookingTitle);

                        addInfo(
                                card,
                                "BOOKING ID",
                                String.valueOf(
                                        rs.getInt(
                                                "booking_id")),
                                20,
                                310);

                        addInfo(
                                card,
                                "BOOKING DATE",
                                rs.getTimestamp(
                                        "booking_date")
                                        .toString(),
                                20,
                                340);

                        JButton close =
                                premiumButton(
                                        "DONE",
                                        new Color(
                                                25, 145, 90));

                        close.setBounds(
                                255, 530, 190, 40);

                        panel.add(close);

                        close.addActionListener(
                                e ->
                                        dialog.dispose());

                        dialog.setVisible(true);
                    }
                }
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Unable to load booking details.\n\n" +
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // =====================================================
    // SECTION LABEL
    // =====================================================

    private JLabel section(
            String text) {

        JLabel label =
                new JLabel(text);

        label.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        13));

        label.setForeground(GOLD);

        return label;
    }

    // =====================================================
    // INFO LABEL
    // =====================================================

    private void addInfo(
            JPanel panel,
            String name,
            String value,
            int x,
            int y) {

        JLabel label =
                new JLabel(
                        name +
                        " : " +
                        value);

        label.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        12));

        label.setForeground(TEXT);

        label.setBounds(
                x,
                y,
                280,
                25);

        panel.add(label);
    }

    // =====================================================
    // ACTIONS
    // =====================================================

    @Override
    public void actionPerformed(
            ActionEvent e) {

        if (e.getSource() ==
                search) {

            loadBookings();
        }

        else if (e.getSource() ==
                refresh) {

            searchField.setText("");

            loadBookings();
        }

        else if (e.getSource() ==
                view) {

            viewDetails();
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
                BookingDetails::new);
    }
}




/*package com.miniproject_car;


import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookingDetails extends JFrame implements ActionListener {

    private JTable table;
    private DefaultTableModel model;

    private JButton refresh;
    private JButton back;

    private static final Color BG = new Color(12, 15, 23);
    private static final Color PANEL = new Color(25, 30, 42);
    private static final Color GOLD = new Color(255, 193, 7);

    public BookingDetails() {

        setTitle("THRISHA CARZONE - Booking Details");
        setSize(1200, 650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel main = new JPanel(null);
        main.setBackground(BG);
        setContentPane(main);

        JLabel title = new JLabel("THRISHA CARZONE");

        title.setFont(
                new Font("SansSerif", Font.BOLD, 30));

        title.setForeground(GOLD);

        title.setBounds(35, 20, 450, 40);

        main.add(title);

        JLabel sub = new JLabel(
                "BOOKING DETAILS  •  Customer & Car Information");

        sub.setFont(
                new Font("SansSerif", Font.PLAIN, 14));

        sub.setForeground(
                new Color(180, 188, 205));

        sub.setBounds(38, 58, 500, 25);

        main.add(sub);

        model = new DefaultTableModel(

                new Object[]{
                        "BOOKING ID",
                        "CUSTOMER",
                        "PHONE",
                        "CAR ID",
                        "BRAND",
                        "MODEL",
                        "PRICE",
                        "FUEL",
                        "TRANSMISSION",
                        "YEAR",
                        "COLOR",
                        "TYPE",
                        "BOOKING DATE"
                }, 0) {

            @Override
            public boolean isCellEditable(
                    int row,
                    int column) {

                return false;
            }
        };

        table = new JTable(model);

        table.setRowHeight(32);

        table.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        12));

        table.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION);

        table.setAutoCreateRowSorter(true);

        JTableHeader header =
                table.getTableHeader();

        header.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        11));

        header.setBackground(
                new Color(35, 40, 55));

        header.setForeground(Color.WHITE);

        header.setPreferredSize(
                new Dimension(0, 38));

        JScrollPane scroll =
                new JScrollPane(table);

        scroll.setBounds(
                25, 105, 1135, 390);

        main.add(scroll);

        refresh = button(
                "REFRESH",
                new Color(35, 105, 190));

        refresh.setBounds(
                800, 530, 140, 42);

        main.add(refresh);

        back = button(
                "BACK",
                new Color(80, 85, 98));

        back.setBounds(
                960, 530, 140, 42);

        main.add(back);

        refresh.addActionListener(this);
        back.addActionListener(this);

        loadBookings();

        setVisible(true);
    }

    private JButton button(
            String text,
            Color color) {

        JButton b = new JButton(text);

        b.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        12));

        b.setForeground(Color.WHITE);

        b.setBackground(color);

        b.setFocusPainted(false);

        b.setBorderPainted(false);

        b.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR));

        return b;
    }

    @Override
    public void actionPerformed(
            ActionEvent e) {

        if (e.getSource() == refresh) {

            loadBookings();

        } else if (e.getSource() == back) {

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

    private void loadBookings() {

        model.setRowCount(0);

        String sql =
                "SELECT b.booking_id, " +
                "b.customer_name, " +
                "b.phone, " +
                "c.car_id, " +
                "c.brand, " +
                "c.model, " +
                "c.price, " +
                "c.fuel, " +
                "c.transmission, " +
                "c.year, " +
                "c.color, " +
                "c.car_type, " +
                "b.booking_date " +

                "FROM bookings b " +

                "INNER JOIN cars c " +
                "ON b.car_id = c.car_id " +

                "ORDER BY b.booking_id DESC";

        try {

            try (
                    Connection con =
                            getConnection();

                    PreparedStatement pst =
                            con.prepareStatement(sql);

                    ResultSet rs =
                            pst.executeQuery()
            ) {

                while (rs.next()) {

                    model.addRow(
                            new Object[]{

                                    rs.getInt(
                                            "booking_id"),

                                    rs.getString(
                                            "customer_name"),

                                    rs.getString(
                                            "phone"),

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
                                            "transmission"),

                                    rs.getInt(
                                            "year"),

                                    rs.getString(
                                            "color"),

                                    rs.getString(
                                            "car_type"),

                                    rs.getTimestamp(
                                            "booking_date")
                            });
                }

                if (model.getRowCount() == 0) {

                    JOptionPane.showMessageDialog(
                            this,
                            "No bookings found.",
                            "Bookings",
                            JOptionPane.INFORMATION_MESSAGE);
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
}

*/
    