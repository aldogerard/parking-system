package utils;

import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public int getInt (String prompt) {
        System.out.println(prompt);
        System.out.print("> ");
        while (!scanner.hasNextInt()){
            System.out.println("Input harus berupa angka");
            scanner.nextLine();
            System.out.println(prompt);
            System.out.print("> ");
        }
        int result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }

    public String getString(String prompt){
        System.out.println(prompt);
        System.out.print("> ");
        return scanner.nextLine();
    }
}
