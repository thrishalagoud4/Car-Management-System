package com.miniproject_car;

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
}