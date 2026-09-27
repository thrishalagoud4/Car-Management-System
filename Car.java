package com.miniproject_car;

public class Car {

    private int carId;
    private String brand;
    private String model;
    private double price;
    private String fuel;
    private String transmission;
    private int year;
    private String color;
    private double mileage;
    private String engine;
    private int seats;
    private String carType;

    // Default Constructor
    public Car() {
    }

    // Parameterized Constructor
    public Car(int carId, String brand, String model, double price,
               String fuel, String transmission, int year,
               String color, double mileage, String engine,
               int seats, String carType) {

        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.fuel = fuel;
        this.transmission = transmission;
        this.year = year;
        this.color = color;
        this.mileage = mileage;
        this.engine = engine;
        this.seats = seats;
        this.carType = carType;
    }

    // Getters and Setters

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    // toString Method
    @Override
    public String toString() {
        return "Car ID       : " + carId +
                "\nBrand        : " + brand +
                "\nModel        : " + model +
                "\nPrice        : " + price +
                "\nFuel         : " + fuel +
                "\nTransmission : " + transmission +
                "\nYear         : " + year +
                "\nColor        : " + color +
                "\nMileage      : " + mileage +
                "\nEngine       : " + engine +
                "\nSeats        : " + seats +
                "\nCar Type     : " + carType;
    }

    // Main Method
    public static void main(String[] args) {

        Car car = new Car(
                101,
                "Toyota",
                "Fortuner",
                3500000,
                "Diesel",
                "Automatic",
                2025,
                "Black",
                14.2,
                "2.8L",
                7,
                "SUV"
        );

        System.out.println("=================================");
        System.out.println("       THRISHA CARZONE");
        System.out.println("=================================");
        System.out.println(car);
        System.out.println("=================================");
    }
}

/*package com.miniproject_car;

public class Car {

    public static void main(String[] args) {

        Login l = new Login();

    }

}*/