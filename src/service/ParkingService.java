package service;

import constant.EType;
import entity.ParkingSlot;
import entity.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingService {

    public List<ParkingSlot> parkingLot;

    public void createParkingLot(int capacity){
        parkingLot = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++){
            parkingLot.add(i, new ParkingSlot());
        }
    }

    public void parkVehicle(Vehicle vehicle){
        boolean isPark = false;
        for (ParkingSlot parkingSlot : parkingLot) {
            if (parkingSlot.getVehicles() == null) {
                parkingSlot.setVehicles(vehicle);
                isPark = true;
                break;
            }
        }

        if(!isPark){
            System.out.println("Sorry, parking lot is full");
        }
    }

    public void leaveParking(int id){
        boolean isLeave = false;
        for (ParkingSlot parkingSlot : parkingLot) {
            if (parkingSlot.getId() == id) {
                if (parkingSlot.getVehicles() != null) {
                    parkingSlot.setVehicles(null);
                    isLeave = true;
                }
            }
        }

        if(!isLeave){
            System.out.println("there are no vehicles in the parking slot");
        }

    }

    public void statusParkingLot(){
        if (parkingLot != null) {
            System.out.printf("%-5s|%-12s|%-10s|%-10s%n", "Slot", "No", "Type", "Color");
            System.out.println("-----------------------------------");
            for (ParkingSlot parkingSlot : parkingLot) {
                if (parkingSlot.getVehicles() != null) {
                    System.out.printf("%-5s|", parkingSlot.getId());
                    System.out.printf("%-12s|", parkingSlot.getVehicles().getNumberPlate());
                    System.out.printf("%-10s|", parkingSlot.getVehicles().getType());
                    System.out.printf("%-10s%n", parkingSlot.getVehicles().getColor());
                }else {
                    System.out.printf("%-5s|", parkingSlot.getId());
                    System.out.print("\t\t" + "No vehicle");
                    System.out.println();
                }
            }
        }else {
            System.out.println("There are no slot");
        }
    }

    public void countByType(String type){
        int count = 0;
        if (parkingLot != null) {
            for (ParkingSlot parkingSlot : parkingLot) {
                if (parkingSlot.getVehicles() != null) {
                    if (parkingSlot.getVehicles().getType() == Enum.valueOf(EType.class, type)) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }

    public void getVehicleByOddNumberPlate(){
        if (parkingLot != null) {
            for (ParkingSlot parkingSlot : parkingLot) {
                if (parkingSlot.getVehicles() != null) {
                    if (Integer.parseInt(parkingSlot.getVehicles().getNumberPlate().split("-")[1]) % 2 == 1){
                        System.out.print(parkingSlot.getVehicles().getNumberPlate());
                        System.out.print(", ");
                    }
                }
            }
        }
    }

    public void getVehicleByEvenNumberPlate(){
        if (parkingLot != null) {
            for (ParkingSlot parkingSlot : parkingLot) {
                if (parkingSlot.getVehicles() != null) {
                    if (Integer.parseInt(parkingSlot.getVehicles().getNumberPlate().split("-")[1]) % 2 == 0){
                        System.out.print(parkingSlot.getVehicles().getNumberPlate());
                        System.out.print(", ");
                    }
                }
            }
        }
    }

    public void getNumberPlateByColor(String color){
        List<String> numberPlates = new ArrayList<>();
        if (parkingLot != null) {
            for (ParkingSlot parkingSlot : parkingLot) {
                if (parkingSlot.getVehicles() != null) {
                    if (parkingSlot.getVehicles().getColor().equals(color)) {
                        numberPlates.add(parkingSlot.getVehicles().getNumberPlate());
                    }
                }
            }
        }

        for (String type : numberPlates) {
            System.out.print(type);
            System.out.print(", ");
        }

    }

    public void getSlotByColor(String color){
        int count = 0;
        List<Integer> id = new ArrayList<>();
        if (parkingLot != null) {
            for (ParkingSlot parkingSlot : parkingLot) {
                if (parkingSlot.getVehicles() != null) {
                    if (parkingSlot.getVehicles().getColor().equals(color)) {
                        id.add(parkingSlot.getId());
                        count++;
                    }
                }
            }
        }

        System.out.println("Number of colored cars " + color + " : " + count);
        for (Integer i : id) {
            System.out.print(i);
            System.out.print(", ");
        }

    }

    public void getSlotByNumberPlat(String numberPlate){
        int slot = -1;
        if (parkingLot != null) {
            for (ParkingSlot parkingSlot : parkingLot) {
                if (parkingSlot.getVehicles() != null) {
                    if (parkingSlot.getVehicles().getNumberPlate().equals(numberPlate)) {
                        slot = parkingSlot.getId();
                    }
                }
            }
        }

        if(slot == -1){
            System.out.println("There are no vehicles in the parking slot");
        }else {
            System.out.println("Mobil plat " + numberPlate + " : " + slot);
        }

    }
}
