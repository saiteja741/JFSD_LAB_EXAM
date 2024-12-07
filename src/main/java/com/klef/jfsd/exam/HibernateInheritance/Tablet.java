package com.klef.jfsd.exam.HibernateInheritance;

import javax.persistence.*;

@Entity
@Table(name = "tablet")
public class Tablet extends Device {

    private double screenSize;
    private double batteryLife;

    // Constructors, Getters, Setters
    public Tablet() {}

    public Tablet(String brand, String model, double price, double screenSize, double batteryLife) {
        super(brand, model, price);
        this.screenSize = screenSize;
        this.batteryLife = batteryLife;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public double getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(double batteryLife) {
        this.batteryLife = batteryLife;
    }
}
