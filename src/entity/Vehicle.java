package entity;

import constant.EType;

public class Vehicle {
    private int id;
    private String numberPlate;
    private String color;
    private EType type;

    private static int idCounter = 0;

    public Vehicle(String numberPlate, String color, EType type) {
        this.numberPlate = numberPlate;
        this.color = color;
        this.type = type;
    }

    {
        this.id = ++idCounter;
    }

    public Vehicle() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public EType getType() {
        return type;
    }

    public void setType(EType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "vehicle{" +
                "id=" + id +
                ", numberPlate='" + numberPlate + '\'' +
                ", color='" + color + '\'' +
                ", type=" + type +
                '}';
    }
}
