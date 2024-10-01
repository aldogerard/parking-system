package Console;

import constant.EType;
import entity.ParkingSlot;
import entity.Vehicle;
import service.ParkingService;
import utils.InputHandler;

public class App {

    private static final ParkingService parkingService = new ParkingService();
    private static final InputHandler inputHandler = new InputHandler();

    public static void Run(){
        while (true){
            showMenu();
            int choice = inputHandler.getInt("Masukkan Pilihan");
            switch (choice){
                case 1 :
                    createParkingLot();
                    break;
                case 2 :
                    parkVehicle();
                    break;
                case 3 :
                    leaveParking();
                    break;
                case 4 :
                    statusParking();
                    break;
                case 5 :
                    countByType();
                    break;
                case 6 :
                    getVehicleByOddNumberPlate();
                    break;
                case 7 :
                    getVehicleByEvenNumberPlate();
                    break;
                case 8 :
                    getNumberPlateByColor();
                    break;
                case 9 :
                    getSlotByColor();
                    break;
                case 10 :
                    getSlotByNumberPlat();
                    break;
                case 11 :
                    return;
                default:
                    System.out.println("Pilihan Tidak Valid");
                    break;
            }
            System.out.println();
        }
    }

    public static void showMenu(){
        System.out.println("MENU");
        System.out.println("1. Create Parking Lot");
        System.out.println("2. Park Vehicle");
        System.out.println("3. Leave Parking");
        System.out.println("4. Status Parking");
        System.out.println("5. Count By Type");
        System.out.println("6. Get Vehicle By Odd Number Plate");
        System.out.println("7. Get Vehicle By Even Number Plate");
        System.out.println("8. Get Number Plate By Color");
        System.out.println("9. Get Slot By Color");
        System.out.println("10. Get Slot By Number Plate");
        System.out.println("11. Exit");
    }

    public static void createParkingLot(){
        int choice = inputHandler.getInt("Masukkan maksimal kapasitas");
        parkingService.createParkingLot(choice);
        System.out.println("\n");
    }

    public static void parkVehicle(){
        String plate = inputHandler.getString("Masukkan nomor plat kendaraan");
        String color = inputHandler.getString("Masukkan warna kendaraan");
        String type = inputHandler.getString("Masukkan jenis kendaraan (Mobil / Motor)");

        Vehicle vehicle = new Vehicle();
        vehicle.setNumberPlate(plate);
        vehicle.setColor(color);
        vehicle.setType(Enum.valueOf(EType.class, type.toUpperCase()));

        parkingService.parkVehicle(vehicle);
        System.out.println("\n");
    }

    public static void leaveParking(){
        int id = inputHandler.getInt("Masukkan nomor slot parkir");
        parkingService.leaveParking(id);
        System.out.println("\n");
    }

    public static void statusParking(){
        parkingService.statusParkingLot();
        System.out.println("\n");

    }

    public static void countByType(){
        String type = inputHandler.getString("Masukkan type kendaraan (Mobil / Motor)");
        parkingService.countByType(type.toUpperCase());
        System.out.println("\n");

    }

    public static void getVehicleByOddNumberPlate(){
        parkingService.getVehicleByOddNumberPlate();
        System.out.println("\n");
    }

    public static void getVehicleByEvenNumberPlate(){
        parkingService.getVehicleByEvenNumberPlate();
        System.out.println("\n");
    }

    public static void getNumberPlateByColor(){
        String color = inputHandler.getString("Masukkan warna kendaraan");
        parkingService.getNumberPlateByColor(color);
        System.out.println("\n");
    }

    public static void getSlotByColor(){
        String color = inputHandler.getString("Masukkan warna kendaraan");
        parkingService.getSlotByColor(color);
        System.out.println("\n");
    }

    public static void getSlotByNumberPlat(){
        String numberPlate = inputHandler.getString("Masukkan nomor plat kendaraan");
        parkingService.getSlotByNumberPlat(numberPlate);
        System.out.println("\n");

    }
}
