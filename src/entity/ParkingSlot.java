package entity;

public class ParkingSlot {
    private int id;
    private Vehicle vehicles;

    private static int idCounter = 0;

    public ParkingSlot() {
        this.id = ++idCounter;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vehicle getVehicles() {
        return vehicles;
    }

    public void setVehicles(Vehicle vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "id=" + id +
                ", vehicles=" + vehicles +
                '}';
    }
}

