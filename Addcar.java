package com.miniproject_car;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.*;

public class Addcar extends JFrame {

    private JTextField txtId, txtBrand, txtModel, txtPrice, txtYear;
    private JTextField txtColor, txtMileage, txtEngine, txtSeats;

    private JComboBox<String> cmbFuel;
    private JComboBox<String> cmbTransmission;
    private JComboBox<String> cmbType;

    private JButton btnSave, btnClear, btnBack;

    private boolean editMode = false;
    private int originalCarId;

    private final Color BG = new Color(12, 12, 15);
    private final Color CARD = new Color(25, 25, 30);
    private final Color GOLD = new Color(212, 175, 55);
    private final Color WHITE = new Color(245, 245, 245);
    private final Color MUTED = new Color(175, 175, 180);

    private final String DB_URL =
            "jdbc:mysql://localhost:3306/car_project";

    private final String DB_USER = "root";
    private final String DB_PASS = "thrisha";

    public Addcar() {
        this(false, null);
    }

    // Constructor for Edit Mode
    public Addcar(Car car) {
        this(true, car);
    }

    private Addcar(boolean editMode, Car car) {

        this.editMode = editMode;

        if (car != null) {
            this.originalCarId = car.getCarId();
        }

        setTitle(editMode ? "Edit Car - THRISHA CARZONE"
                          : "Add Car - THRISHA CARZONE");

        setSize(1100, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        createUI();

        if (editMode && car != null) {
            fillCarDetails(car);
        }
    }

    private void createUI() {

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(BG);

        // ================= HEADER =================

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(BG);
        header.setBorder(new EmptyBorder(20, 30, 15, 30));

        JLabel logo = new JLabel("TC");
        logo.setFont(new Font("Arial", Font.BOLD, 28));
        logo.setForeground(GOLD);

        JLabel title = new JLabel(
                editMode ? "EDIT CAR" : "ADD NEW CAR"
        );

        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setForeground(WHITE);

        JLabel subtitle = new JLabel(
                editMode
                        ? "UPDATE VEHICLE INFORMATION"
                        : "ADD VEHICLE TO SHOWROOM"
        );

        subtitle.setFont(new Font("Arial", Font.PLAIN, 11));
        subtitle.setForeground(MUTED);

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setBackground(BG);

        titlePanel.add(title);
        titlePanel.add(Box.createVerticalStrut(4));
        titlePanel.add(subtitle);

        header.add(logo, BorderLayout.WEST);
        header.add(titlePanel, BorderLayout.CENTER);

        mainPanel.add(header, BorderLayout.NORTH);

        // ================= FORM =================

        JPanel form = new JPanel(new GridLayout(4, 3, 20, 18));
        form.setBackground(CARD);
        form.setBorder(new EmptyBorder(30, 35, 30, 35));

        txtId = createField();
        txtBrand = createField();
        txtModel = createField();
        txtPrice = createField();

        txtYear = createField();
        txtColor = createField();
        txtMileage = createField();
        txtEngine = createField();
        txtSeats = createField();

        cmbFuel = new JComboBox<>(
                new String[]{
                        "Petrol",
                        "Diesel",
                        "Electric",
                        "Hybrid",
                        "CNG"
                });

        cmbTransmission = new JComboBox<>(
                new String[]{
                        "Manual",
                        "Automatic",
                        "AMT",
                        "CVT",
                        "DCT"
                });

        cmbType = new JComboBox<>(
                new String[]{
                        "SUV",
                        "XUV",
                        "SEDAN",
                        "MUV",
                        "HATCHBACK",
                        "LUXURY"
                });

        addField(form, "CAR ID", txtId);
        addField(form, "BRAND", txtBrand);
        addField(form, "MODEL", txtModel);

        addField(form, "PRICE", txtPrice);
        addField(form, "FUEL", cmbFuel);
        addField(form, "TRANSMISSION", cmbTransmission);

        addField(form, "YEAR", txtYear);
        addField(form, "COLOR", txtColor);
        addField(form, "MILEAGE", txtMileage);

        addField(form, "ENGINE", txtEngine);
        addField(form, "SEATS", txtSeats);
        addField(form, "CAR TYPE", cmbType);

        mainPanel.add(form, BorderLayout.CENTER);

        // ================= BUTTONS =================

        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 18));
        bottom.setBackground(BG);

        btnSave = createButton(
                editMode ? "UPDATE CAR" : "ADD CAR"
        );

        btnClear = createButton("CLEAR");
        btnBack = createButton("BACK");

        bottom.add(btnSave);
        bottom.add(btnClear);
        bottom.add(btnBack);

        mainPanel.add(bottom, BorderLayout.SOUTH);

        setContentPane(mainPanel);

        // ================= ACTIONS =================

        btnSave.addActionListener(e -> saveCar());

        btnClear.addActionListener(e -> clearFields());

        btnBack.addActionListener(e -> {

            new CarDetails().setVisible(true);
            dispose();

        });
    }

    // ================= CREATE FIELD =================

    private JTextField createField() {

        JTextField field = new JTextField();

        field.setFont(new Font("Arial", Font.PLAIN, 15));
        field.setForeground(WHITE);
        field.setBackground(new Color(35, 35, 40));
        field.setCaretColor(GOLD);
        field.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(70, 70, 75)
                        ),
                        BorderFactory.createEmptyBorder(
                                8, 10, 8, 10
                        )
                )
        );

        return field;
    }

    // ================= ADD FIELD =================

    private void addField(
            JPanel panel,
            String labelText,
            JComponent component) {

        JPanel p = new JPanel(new BorderLayout(5, 5));
        p.setBackground(CARD);

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.BOLD, 11));
        label.setForeground(GOLD);

        p.add(label, BorderLayout.NORTH);
        p.add(component, BorderLayout.CENTER);

        panel.add(p);
    }

    // ================= BUTTON =================

    private JButton createButton(String text) {

        JButton button = new JButton(text);

        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setForeground(BG);
        button.setBackground(GOLD);
        button.setFocusPainted(false);
        button.setBorder(
                BorderFactory.createEmptyBorder(
                        12, 25, 12, 25
                )
        );

        return button;
    }

    // ================= FILL DATA =================

    private void fillCarDetails(Car car) {

        txtId.setText(String.valueOf(car.getCarId()));
        txtBrand.setText(car.getBrand());
        txtModel.setText(car.getModel());
        txtPrice.setText(String.valueOf(car.getPrice()));

        cmbFuel.setSelectedItem(car.getFuel());
        cmbTransmission.setSelectedItem(
                car.getTransmission()
        );

        txtYear.setText(String.valueOf(car.getYear()));
        txtColor.setText(car.getColor());
        txtMileage.setText(
                String.valueOf(car.getMileage())
        );

        txtEngine.setText(car.getEngine());
        txtSeats.setText(String.valueOf(car.getSeats()));

        cmbType.setSelectedItem(car.getCarType());

        // ID should not change during edit
        txtId.setEditable(false);
    }

    // ================= SAVE =================

    private void saveCar() {

        if (!validateFields()) {
            return;
        }

        try {

            int id = Integer.parseInt(txtId.getText().trim());

            String brand = txtBrand.getText().trim();
            String model = txtModel.getText().trim();

            double price =
                    Double.parseDouble(
                            txtPrice.getText().trim()
                    );

            String fuel =
                    cmbFuel.getSelectedItem().toString();

            String transmission =
                    cmbTransmission
                            .getSelectedItem()
                            .toString();

            int year =
                    Integer.parseInt(
                            txtYear.getText().trim()
                    );

            String color =
                    txtColor.getText().trim();

            double mileage =
                    Double.parseDouble(
                            txtMileage.getText().trim()
                    );

            String engine =
                    txtEngine.getText().trim();

            int seats =
                    Integer.parseInt(
                            txtSeats.getText().trim()
                    );

            String carType =
                    cmbType.getSelectedItem().toString();

            Class.forName(
                    "com.mysql.cj.jdbc.Driver"
            );

            Connection con =
                    DriverManager.getConnection(
                            DB_URL,
                            DB_USER,
                            DB_PASS
                    );

            if (editMode) {

                String sql =
                        "UPDATE cars SET " +
                        "brand=?, model=?, price=?, fuel=?, " +
                        "transmission=?, year=?, color=?, " +
                        "mileage=?, engine=?, seats=?, car_type=? " +
                        "WHERE car_id=?";

                PreparedStatement ps =
                        con.prepareStatement(sql);

                ps.setString(1, brand);
                ps.setString(2, model);
                ps.setDouble(3, price);
                ps.setString(4, fuel);
                ps.setString(5, transmission);
                ps.setInt(6, year);
                ps.setString(7, color);
                ps.setDouble(8, mileage);
                ps.setString(9, engine);
                ps.setInt(10, seats);
                ps.setString(11, carType);
                ps.setInt(12, originalCarId);

                int result = ps.executeUpdate();

                if (result > 0) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Car details updated successfully!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                    new CarDetails().setVisible(true);
                    dispose();
                }

                ps.close();

            } else {

                String sql =
                        "INSERT INTO cars " +
                        "(car_id, brand, model, price, fuel, " +
                        "transmission, year, color, mileage, " +
                        "engine, seats, car_type) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement ps =
                        con.prepareStatement(sql);

                ps.setInt(1, id);
                ps.setString(2, brand);
                ps.setString(3, model);
                ps.setDouble(4, price);
                ps.setString(5, fuel);
                ps.setString(6, transmission);
                ps.setInt(7, year);
                ps.setString(8, color);
                ps.setDouble(9, mileage);
                ps.setString(10, engine);
                ps.setInt(11, seats);
                ps.setString(12, carType);

                ps.executeUpdate();

                JOptionPane.showMessageDialog(
                        this,
                        "New car added successfully!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );

                ps.close();
            }

            con.close();

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid numbers.",
                    "Invalid Input",
                    JOptionPane.WARNING_MESSAGE
            );

        } catch (SQLIntegrityConstraintViolationException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Car ID already exists.",
                    "Duplicate ID",
                    JOptionPane.WARNING_MESSAGE
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Database Error:\n" + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // ================= VALIDATION =================

    private boolean validateFields() {

        JTextField[] fields = {
                txtId,
                txtBrand,
                txtModel,
                txtPrice,
                txtYear,
                txtColor,
                txtMileage,
                txtEngine,
                txtSeats
        };

        for (JTextField field : fields) {

            if (field.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please fill all fields.",
                        "Missing Information",
                        JOptionPane.WARNING_MESSAGE
                );

                field.requestFocus();
                return false;
            }
        }

        try {

            int year =
                    Integer.parseInt(
                            txtYear.getText().trim()
                    );

            double mileage =
                    Double.parseDouble(
                            txtMileage.getText().trim()
                    );

            int seats =
                    Integer.parseInt(
                            txtSeats.getText().trim()
                    );

            double price =
                    Double.parseDouble(
                            txtPrice.getText().trim()
                    );

            if (year < 1900 || year > 2030) {

                JOptionPane.showMessageDialog(
                        this,
                        "Enter a valid year.",
                        "Invalid Year",
                        JOptionPane.WARNING_MESSAGE
                );

                return false;
            }

            if (mileage <= 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Mileage must be greater than 0.",
                        "Invalid Mileage",
                        JOptionPane.WARNING_MESSAGE
                );

                return false;
            }

            if (price <= 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Price must be greater than 0.",
                        "Invalid Price",
                        JOptionPane.WARNING_MESSAGE
                );

                return false;
            }

            if (seats < 1 || seats > 20) {

                JOptionPane.showMessageDialog(
                        this,
                        "Seats must be between 1 and 20.",
                        "Invalid Seats",
                        JOptionPane.WARNING_MESSAGE
                );

                return false;
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid numeric values.",
                    "Invalid Input",
                    JOptionPane.WARNING_MESSAGE
            );

            return false;
        }

        return true;
    }

    // ================= CLEAR =================

    private void clearFields() {

        if (!editMode) {
            txtId.setText("");
        }

        txtBrand.setText("");
        txtModel.setText("");
        txtPrice.setText("");
        txtYear.setText("");
        txtColor.setText("");
        txtMileage.setText("");
        txtEngine.setText("");
        txtSeats.setText("");

        cmbFuel.setSelectedIndex(0);
        cmbTransmission.setSelectedIndex(0);
        cmbType.setSelectedIndex(0);
    }

    // ================= MAIN =================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            new Addcar().setVisible(true);

        });
    }
}




/*package com.miniproject_car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Addcar extends JFrame implements ActionListener {

    private JTextField idField;
    private JTextField brandField;
    private JTextField modelField;
    private JTextField priceField;
    private JTextField yearField;
    private JTextField colorField;
    private JTextField mileageField;
    private JTextField engineField;
    private JTextField seatsField;

    private JComboBox<String> fuelCombo;
    private JComboBox<String> transmissionCombo;
    private JComboBox<String> typeCombo;

    private JButton addButton;
    private JButton clearButton;
    private JButton backButton;

    private static final Color BG =
            new Color(10, 13, 20);

    private static final Color PANEL =
            new Color(22, 27, 38);

    private static final Color GOLD =
            new Color(255, 193, 7);

    private static final Color TEXT =
            new Color(230, 234, 240);

    private static final Color MUTED =
            new Color(155, 164, 180);

    public Addcar() {

        setTitle(
                "THRISHA CARZONE - Add New Car");

        setSize(1100, 720);

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
                        "ADD NEW VEHICLE  •  PREMIUM INVENTORY");

        subtitle.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        12));

        subtitle.setForeground(MUTED);

        subtitle.setBounds(
                97, 50, 400, 25);

        main.add(subtitle);

        // =================================================
        // FORM PANEL
        // =================================================

        JPanel form =
                new JPanel(null);

        form.setBackground(PANEL);

        form.setBorder(
                BorderFactory.createLineBorder(
                        new Color(
                                52, 60, 76)));

        form.setBounds(
                30, 95, 1040, 500);

        main.add(form);

        // =================================================
        // SECTION 1
        // =================================================

        JLabel basicTitle =
                sectionTitle(
                        "BASIC VEHICLE INFORMATION");

        basicTitle.setBounds(
                25, 20, 350, 25);

        form.add(basicTitle);

        // ID

        addLabel(
                form,
                "CAR ID",
                25,
                55);

        idField =
                field();

        idField.setBounds(
                25, 80, 300, 38);

        form.add(idField);

        // BRAND

        addLabel(
                form,
                "BRAND",
                355,
                55);

        brandField =
                field();

        brandField.setBounds(
                355, 80, 300, 38);

        form.add(brandField);

        // MODEL

        addLabel(
                form,
                "MODEL",
                685,
                55);

        modelField =
                field();

        modelField.setBounds(
                685, 80, 300, 38);

        form.add(modelField);

        // =================================================
        // SECTION 2
        // =================================================

        JLabel specificationTitle =
                sectionTitle(
                        "VEHICLE SPECIFICATIONS");

        specificationTitle.setBounds(
                25, 140, 350, 25);

        form.add(specificationTitle);

        // PRICE

        addLabel(
                form,
                "PRICE (₹)",
                25,
                175);

        priceField =
                field();

        priceField.setBounds(
                25, 200, 300, 38);

        form.add(priceField);

        // FUEL

        addLabel(
                form,
                "FUEL TYPE",
                355,
                175);

        fuelCombo =
                combo(
                        new String[]{
                                "Petrol",
                                "Diesel",
                                "Electric",
                                "Hybrid",
                                "CNG"
                        });

        fuelCombo.setBounds(
                355, 200, 300, 38);

        form.add(fuelCombo);

        // TRANSMISSION

        addLabel(
                form,
                "TRANSMISSION",
                685,
                175);

        transmissionCombo =
                combo(
                        new String[]{
                                "Manual",
                                "Automatic",
                                "AMT",
                                "CVT",
                                "DCT"
                        });

        transmissionCombo.setBounds(
                685, 200, 300, 38);

        form.add(transmissionCombo);

        // =================================================
        // SECTION 3
        // =================================================

        JLabel detailsTitle =
                sectionTitle(
                        "ADDITIONAL DETAILS");

        detailsTitle.setBounds(
                25, 260, 350, 25);

        form.add(detailsTitle);

        // YEAR

        addLabel(
                form,
                "YEAR",
                25,
                295);

        yearField =
                field();

        yearField.setBounds(
                25, 320, 180, 38);

        form.add(yearField);

        // COLOR

        addLabel(
                form,
                "COLOR",
                225,
                295);

        colorField =
                field();

        colorField.setBounds(
                225, 320, 180, 38);

        form.add(colorField);

        // MILEAGE

        addLabel(
                form,
                "MILEAGE (KM/L)",
                425,
                295);

        mileageField =
                field();

        mileageField.setBounds(
                425, 320, 180, 38);

        form.add(mileageField);

        // ENGINE

        addLabel(
                form,
                "ENGINE",
                625,
                295);

        engineField =
                field();

        engineField.setBounds(
                625, 320, 180, 38);

        form.add(engineField);

        // SEATS

        addLabel(
                form,
                "SEATS",
                825,
                295);

        seatsField =
                field();

        seatsField.setBounds(
                825, 320, 160, 38);

        form.add(seatsField);

        // =================================================
        // CAR TYPE
        // =================================================

        addLabel(
                form,
                "CAR TYPE",
                25,
                380);

        typeCombo =
                combo(
                        new String[]{
                                "SUV",
                                "XUV",
                                "SEDAN",
                                "MUV",
                                "HATCHBACK",
                                "LUXURY"
                        });

        typeCombo.setBounds(
                25, 405, 300, 38);

        form.add(typeCombo);

        // =================================================
        // BUTTONS
        // =================================================

        addButton =
                premiumButton(
                        "ADD CAR",
                        new Color(
                                25, 145, 90));

        addButton.setBounds(
                355, 405, 180, 42);

        form.add(addButton);

        clearButton =
                premiumButton(
                        "CLEAR",
                        new Color(
                                80, 85, 100));

        clearButton.setBounds(
                550, 405, 180, 42);

        form.add(clearButton);

        backButton =
                premiumButton(
                        "BACK",
                        new Color(
                                160, 45, 55));

        backButton.setBounds(
                745, 405, 180, 42);

        form.add(backButton);

        // =================================================
        // FOOTER
        // =================================================

        JLabel footer =
                new JLabel(
                        "Enter complete vehicle information before adding it to the showroom.");

        footer.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        11));

        footer.setForeground(MUTED);

        footer.setHorizontalAlignment(
                SwingConstants.CENTER);

        footer.setBounds(
                250, 625, 600, 25);

        main.add(footer);

        // =================================================
        // EVENTS
        // =================================================

        addButton.addActionListener(this);

        clearButton.addActionListener(this);

        backButton.addActionListener(this);

        setVisible(true);
    }

    // =====================================================
    // LABEL
    // =====================================================

    private void addLabel(
            JPanel panel,
            String text,
            int x,
            int y) {

        JLabel label =
                new JLabel(text);

        label.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        11));

        label.setForeground(MUTED);

        label.setBounds(
                x, y, 200, 20);

        panel.add(label);
    }

    // =====================================================
    // SECTION TITLE
    // =====================================================

    private JLabel sectionTitle(
            String text) {

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

    // =====================================================
    // TEXT FIELD
    // =====================================================

    private JTextField field() {

        JTextField field =
                new JTextField();

        field.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        13));

        field.setBackground(
                new Color(
                        245, 247, 250));

        field.setForeground(
                new Color(
                        20, 23, 30));

        field.setCaretColor(
                new Color(
                        20, 23, 30));

        field.setBorder(
                BorderFactory.createCompoundBorder(

                        BorderFactory.createLineBorder(
                                new Color(
                                        65, 73, 90)),

                        BorderFactory.createEmptyBorder(
                                5, 10, 5, 10)));

        return field;
    }

    // =====================================================
    // COMBO BOX
    // =====================================================

    private JComboBox<String> combo(
            String[] values) {

        JComboBox<String> box =
                new JComboBox<>(values);

        box.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        13));

        box.setBackground(
                new Color(
                        245, 247, 250));

        box.setForeground(
                new Color(
                        20, 23, 30));

        return box;
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
                        12));

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
    // ADD CAR
    // =====================================================

    private void addCar() {

        String idText =
                idField.getText().trim();

        String brand =
                brandField.getText().trim();

        String model =
                modelField.getText().trim();

        String priceText =
                priceField.getText().trim();

        String yearText =
                yearField.getText().trim();

        String color =
                colorField.getText().trim();

        String mileageText =
                mileageField.getText().trim();

        String engine =
                engineField.getText().trim();

        String seatsText =
                seatsField.getText().trim();

        String fuel =
                fuelCombo
                        .getSelectedItem()
                        .toString();

        String transmission =
                transmissionCombo
                        .getSelectedItem()
                        .toString();

        String carType =
                typeCombo
                        .getSelectedItem()
                        .toString();

        // =================================================
        // VALIDATION
        // =================================================

        if (idText.isEmpty() ||
                brand.isEmpty() ||
                model.isEmpty() ||
                priceText.isEmpty() ||
                yearText.isEmpty() ||
                color.isEmpty() ||
                mileageText.isEmpty() ||
                engine.isEmpty() ||
                seatsText.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill all vehicle details.",
                    "Missing Information",
                    JOptionPane.WARNING_MESSAGE);

            return;
        }

        try {

            int id =
                    Integer.parseInt(idText);

            double price =
                    Double.parseDouble(
                            priceText);

            int year =
                    Integer.parseInt(
                            yearText);

            double mileage =
                    Double.parseDouble(
                            mileageText);

            int seats =
                    Integer.parseInt(
                            seatsText);

            if (id <= 0) {

                throw new NumberFormatException(
                        "Invalid ID");
            }

            if (price <= 0) {

                throw new NumberFormatException(
                        "Invalid price");
            }

            if (year < 1900 ||
                    year > 2030) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter a valid vehicle year.",
                        "Invalid Year",
                        JOptionPane.WARNING_MESSAGE);

                return;
            }

            if (mileage <= 0) {

                throw new NumberFormatException(
                        "Invalid mileage");
            }

            if (seats <= 0 ||
                    seats > 20) {

                JOptionPane.showMessageDialog(
                        this,
                        "Seats must be between 1 and 20.",
                        "Invalid Seats",
                        JOptionPane.WARNING_MESSAGE);

                return;
            }

            // =================================================
            // DATABASE INSERT
            // =================================================

            String sql =
                    "INSERT INTO cars " +
                    "(car_id, brand, model, price, fuel, " +
                    "transmission, year, color, mileage, " +
                    "engine, seats, car_type) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (
                    Connection con =
                            getConnection();

                    PreparedStatement pst =
                            con.prepareStatement(sql)
            ) {

                pst.setInt(
                        1, id);

                pst.setString(
                        2, brand);

                pst.setString(
                        3, model);

                pst.setDouble(
                        4, price);

                pst.setString(
                        5, fuel);

                pst.setString(
                        6, transmission);

                pst.setInt(
                        7, year);

                pst.setString(
                        8, color);

                pst.setDouble(
                        9, mileage);

                pst.setString(
                        10, engine);

                pst.setInt(
                        11, seats);

                pst.setString(
                        12, carType);

                pst.executeUpdate();

                JOptionPane.showMessageDialog(
                        this,
                        "VEHICLE ADDED SUCCESSFULLY!\n\n" +
                        "Car ID   : " + id +
                        "\nBrand    : " + brand +
                        "\nModel    : " + model +
                        "\nPrice    : ₹" + price +
                        "\nType     : " + carType,
                        "THRISHA CARZONE",
                        JOptionPane.INFORMATION_MESSAGE);

                clearFields();
            }

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid numeric values.",
                    "Invalid Input",
                    JOptionPane.WARNING_MESSAGE);

        } catch (SQLIntegrityConstraintViolationException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Car ID already exists.\nPlease use a different ID.",
                    "Duplicate Car ID",
                    JOptionPane.WARNING_MESSAGE);

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
    // CLEAR
    // =====================================================

    private void clearFields() {

        idField.setText("");

        brandField.setText("");

        modelField.setText("");

        priceField.setText("");

        yearField.setText("");

        colorField.setText("");

        mileageField.setText("");

        engineField.setText("");

        seatsField.setText("");

        fuelCombo.setSelectedIndex(0);

        transmissionCombo.setSelectedIndex(0);

        typeCombo.setSelectedIndex(0);

        idField.requestFocus();
    }

    // =====================================================
    // ACTION
    // =====================================================

    @Override
    public void actionPerformed(
            ActionEvent e) {

        if (e.getSource() ==
                addButton) {

            addCar();
        }

        else if (e.getSource() ==
                clearButton) {

            clearFields();
        }

        else if (e.getSource() ==
                backButton) {

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
                Addcar::new);
    }
}






/*package com.miniproject_car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Addcar extends JFrame implements ActionListener {

    private JTextField id, brand, model, price, year, color, mileage, engine, seats;
    private JComboBox<String> fuel, transmission, carType;
    private JButton add, clear, back;

    private static final Color BG = new Color(12, 15, 23);
    private static final Color CARD = new Color(27, 32, 45);
    private static final Color GOLD = new Color(255, 193, 7);

    public Addcar() {
        setTitle("Car Management System - Add Car");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel main = new JPanel(null);
        main.setBackground(BG);
        setContentPane(main);

        JLabel title = new JLabel("ADD NEW CAR");
        title.setFont(new Font("SansSerif", Font.BOLD, 28));
        title.setForeground(GOLD);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds(250, 20, 400, 40);
        main.add(title);

        JLabel sub = new JLabel("Enter complete vehicle information");
        sub.setForeground(new Color(180, 188, 205));
        sub.setHorizontalAlignment(SwingConstants.CENTER);
        sub.setBounds(250, 58, 400, 25);
        main.add(sub);

        JPanel card = new JPanel(null);
        card.setBackground(CARD);
        card.setBorder(BorderFactory.createLineBorder(new Color(60, 70, 90)));
        card.setBounds(40, 95, 820, 430);
        main.add(card);

        id = field(card, "Car ID", 25, 25);
        brand = field(card, "Brand", 280, 25);
        model = field(card, "Model", 535, 25);

        price = field(card, "Price", 25, 100);
        year = field(card, "Year", 280, 100);
        color = field(card, "Color", 535, 100);

        mileage = field(card, "Mileage", 25, 175);
        engine = field(card, "Engine", 280, 175);
        seats = field(card, "Seats", 535, 175);

        fuel = combo(card, "Fuel", new String[]{"PETROL", "DIESEL", "CNG", "ELECTRIC", "HYBRID"}, 25, 250);
        transmission = combo(card, "Transmission", new String[]{"MANUAL", "AUTOMATIC", "AMT", "CVT", "DCT"}, 280, 250);
        carType = combo(card, "Car Type", new String[]{"SUV", "XUV", "SEDAN", "MUV", "HATCHBACK", "LUXURY"}, 535, 250);

        add = button("ADD CAR", new Color(25, 145, 90));
        add.setBounds(250, 545, 130, 42);
        main.add(add);

        clear = button("CLEAR", new Color(85, 85, 98));
        clear.setBounds(395, 545, 130, 42);
        main.add(clear);

        back = button("BACK", new Color(160, 45, 55));
        back.setBounds(540, 545, 110, 42);
        main.add(back);

        add.addActionListener(this);
        clear.addActionListener(this);
        back.addActionListener(this);

        setVisible(true);
    }

    private JTextField field(JPanel p, String text, int x, int y) {
        JLabel l = label(text);
        l.setBounds(x, y, 220, 22);
        p.add(l);

        JTextField f = new JTextField();
        style(f);
        f.setBounds(x, y + 24, 220, 35);
        p.add(f);
        return f;
    }

    private JComboBox<String> combo(JPanel p, String text, String[] items, int x, int y) {
        JLabel l = label(text);
        l.setBounds(x, y, 220, 22);
        p.add(l);

        JComboBox<String> c = new JComboBox<>(items);
        c.setFont(new Font("SansSerif", Font.PLAIN, 14));
        c.setBounds(x, y + 24, 220, 35);
        p.add(c);
        return c;
    }

    private JLabel label(String s) {
        JLabel l = new JLabel(s.toUpperCase());
        l.setFont(new Font("SansSerif", Font.BOLD, 12));
        l.setForeground(Color.WHITE);
        return l;
    }

    private void style(JTextField f) {
        f.setFont(new Font("SansSerif", Font.PLAIN, 14));
        f.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(210, 214, 224)),
                BorderFactory.createEmptyBorder(4, 8, 4, 8)));
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
        if (e.getSource() == add) addCar();
        else if (e.getSource() == clear) clearFields();
        else if (e.getSource() == back) {
            new CarHome();
            dispose();
        }
    }

    private void addCar() {
        if (id.getText().trim().isEmpty() ||
            brand.getText().trim().isEmpty() ||
            model.getText().trim().isEmpty() ||
            price.getText().trim().isEmpty() ||
            year.getText().trim().isEmpty() ||
            color.getText().trim().isEmpty() ||
            mileage.getText().trim().isEmpty() ||
            engine.getText().trim().isEmpty() ||
            seats.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Please fill all fields.",
                    "Validation", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int carId = Integer.parseInt(id.getText().trim());
            double p = Double.parseDouble(price.getText().trim());
            int y = Integer.parseInt(year.getText().trim());
            double m = Double.parseDouble(mileage.getText().trim());
            int s = Integer.parseInt(seats.getText().trim());

            Class.forName("com.mysql.cj.jdbc.Driver");

            String sql = "INSERT INTO cars " +
                    "(car_id, brand, model, price, fuel, transmission, year, color, mileage, engine, seats, car_type) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/car_project", "root", "thrisha");
                 PreparedStatement pst = con.prepareStatement(sql)) {

                pst.setInt(1, carId);
                pst.setString(2, brand.getText().trim());
                pst.setString(3, model.getText().trim());
                pst.setDouble(4, p);
                pst.setString(5, fuel.getSelectedItem().toString());
                pst.setString(6, transmission.getSelectedItem().toString());
                pst.setInt(7, y);
                pst.setString(8, color.getText().trim());
                pst.setDouble(9, m);
                pst.setString(10, engine.getText().trim());
                pst.setInt(11, s);
                pst.setString(12, carType.getSelectedItem().toString());

                pst.executeUpdate();

                JOptionPane.showMessageDialog(this,
                        "Car added successfully!",
                        "Success", JOptionPane.INFORMATION_MESSAGE);
                clearFields();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Car ID, Price, Year, Mileage and Seats must be valid numbers.",
                    "Invalid Input", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Could not add car.\n" + ex.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Error: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        id.setText("");
        brand.setText("");
        model.setText("");
        price.setText("");
        year.setText("");
        color.setText("");
        mileage.setText("");
        engine.setText("");
        seats.setText("");
        fuel.setSelectedIndex(0);
        transmission.setSelectedIndex(0);
        carType.setSelectedIndex(0);
        id.requestFocus();
    }
}


/*package com.miniproject_car;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Addcar extends JFrame implements ActionListener {

    private JLabel jl1;
    private JLabel jl2, jl3, jl4, jl5, jl6, jl7;
    private JLabel jl8, jl9, jl10, jl11, jl12;

    private JTextField jt1, jt2, jt3, jt4, jt5, jt6;
    private JTextField jt7, jt8, jt9, jt10, jt11;

    private JButton jb1, jb2;

    public Addcar() {

        jl1 = new JLabel("ADD CAR");

        jl2 = new JLabel("Car ID:");
        jl3 = new JLabel("Brand:");
        jl4 = new JLabel("Model:");
        jl5 = new JLabel("Price:");
        jl6 = new JLabel("Fuel:");
        jl7 = new JLabel("Transmission:");

        jl8 = new JLabel("Year:");
        jl9 = new JLabel("Color:");
        jl10 = new JLabel("Mileage:");
        jl11 = new JLabel("Engine:");
        jl12 = new JLabel("Seats:");

        jt1 = new JTextField();
        jt2 = new JTextField();
        jt3 = new JTextField();
        jt4 = new JTextField();
        jt5 = new JTextField();
        jt6 = new JTextField();

        jt7 = new JTextField();
        jt8 = new JTextField();
        jt9 = new JTextField();
        jt10 = new JTextField();
        jt11 = new JTextField();

        jb1 = new JButton("ADD CAR");

        jb2 = new JButton("BACK");

        setLayout(null);

        jl1.setBounds(350, 20, 150, 40);

        // LEFT SIDE

        jl2.setBounds(80, 90, 100, 30);
        jt1.setBounds(180, 90, 180, 30);

        jl3.setBounds(80, 140, 100, 30);
        jt2.setBounds(180, 140, 180, 30);

        jl4.setBounds(80, 190, 100, 30);
        jt3.setBounds(180, 190, 180, 30);

        jl5.setBounds(80, 240, 100, 30);
        jt4.setBounds(180, 240, 180, 30);

        jl6.setBounds(80, 290, 100, 30);
        jt5.setBounds(180, 290, 180, 30);

        jl7.setBounds(80, 340, 100, 30);
        jt6.setBounds(180, 340, 180, 30);

        // RIGHT SIDE

        jl8.setBounds(430, 90, 100, 30);
        jt7.setBounds(530, 90, 180, 30);

        jl9.setBounds(430, 140, 100, 30);
        jt8.setBounds(530, 140, 180, 30);

        jl10.setBounds(430, 190, 100, 30);
        jt9.setBounds(530, 190, 180, 30);

        jl11.setBounds(430, 240, 100, 30);
        jt10.setBounds(530, 240, 180, 30);

        jl12.setBounds(430, 290, 100, 30);
        jt11.setBounds(530, 290, 180, 30);

        jb1.setBounds(250, 430, 120, 40);

        jb2.setBounds(400, 430, 100, 40);

        // ADD LABELS

        add(jl1);

        add(jl2);
        add(jl3);
        add(jl4);
        add(jl5);
        add(jl6);
        add(jl7);

        add(jl8);
        add(jl9);
        add(jl10);
        add(jl11);
        add(jl12);

        // ADD TEXTFIELDS

        add(jt1);
        add(jt2);
        add(jt3);
        add(jt4);
        add(jt5);
        add(jt6);

        add(jt7);
        add(jt8);
        add(jt9);
        add(jt10);
        add(jt11);

        // ADD BUTTONS

        add(jb1);
        add(jb2);

        jb1.addActionListener(this);
        jb2.addActionListener(this);

        setTitle("Add Car");

        setSize(800, 550);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        // ADD CAR BUTTON

        if (ae.getSource() == jb1) {

            String carId = jt1.getText().trim();
            String brand = jt2.getText().trim();
            String model = jt3.getText().trim();
            String price = jt4.getText().trim();
            String fuel = jt5.getText().trim();
            String transmission = jt6.getText().trim();

            String year = jt7.getText().trim();
            String color = jt8.getText().trim();
            String mileage = jt9.getText().trim();
            String engine = jt10.getText().trim();
            String seats = jt11.getText().trim();

            // CHECK EMPTY

            if (carId.isEmpty() ||
                brand.isEmpty() ||
                model.isEmpty() ||
                price.isEmpty() ||
                fuel.isEmpty() ||
                transmission.isEmpty() ||
                year.isEmpty() ||
                color.isEmpty() ||
                mileage.isEmpty() ||
                engine.isEmpty() ||
                seats.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please fill all fields"
                );

                return;
            }

            try {

                String sql =
                        "INSERT INTO cars " +
                        "(car_id, brand, model, price, fuel, " +
                        "transmission, year, color, mileage, " +
                        "engine, seats) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement pst =
                        con.prepareStatement(sql);

                pst.setInt(
                        1,
                        Integer.parseInt(carId)
                );

                pst.setString(
                        2,
                        brand
                );

                pst.setString(
                        3,
                        model
                );

                pst.setDouble(
                        4,
                        Double.parseDouble(price)
                );

                pst.setString(
                        5,
                        fuel
                );

                pst.setString(
                        6,
                        transmission
                );

                pst.setInt(
                        7,
                        Integer.parseInt(year)
                );

                pst.setString(
                        8,
                        color
                );

                pst.setDouble(
                        9,
                        Double.parseDouble(mileage)
                );

                pst.setString(
                        10,
                        engine
                );

                pst.setInt(
                        11,
                        Integer.parseInt(seats)
                );

                int result =
                        pst.executeUpdate();

                if (result > 0) {

                    JOptionPane.showMessageDialog(
                            this,
                            "CAR ADDED SUCCESSFULLY"
                    );

                    clearFields();
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

        // BACK BUTTON

        else if (ae.getSource() == jb2) {

            new CarHome();

            this.dispose();
        }
    }

    public void clearFields() {

        jt1.setText("");
        jt2.setText("");
        jt3.setText("");
        jt4.setText("");
        jt5.setText("");
        jt6.setText("");

        jt7.setText("");
        jt8.setText("");
        jt9.setText("");
        jt10.setText("");
        jt11.setText("");

        jt1.requestFocus();
    }
}*/