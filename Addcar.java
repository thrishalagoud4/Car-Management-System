package com.miniproject_car;

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
}