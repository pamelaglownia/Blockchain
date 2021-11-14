package pl.glownia.pamela;

import java.util.Scanner;

class Input {
    private final Scanner scanner = new Scanner(System.in);

    int takeNumberFromUser() {
        System.out.print("Enter how many zeros the hash must start with: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Wrong input. Try again.");
            scanner.next();
        }
        int number = scanner.nextInt();
        if (number < 0) {
            System.out.println("Number can't be lower than zero.");
            return takeNumberFromUser();
        }
        System.out.println();
        return number;
    }
}