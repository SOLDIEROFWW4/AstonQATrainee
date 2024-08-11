package org.example;

import java.util.Scanner;

public class Utility {
    public static void printTask(int taskNumber, String methodName) {
        System.out.printf("Задача %d: %s%n", taskNumber, methodName);
    }

    public static void printResult() {
        System.out.println("Результат работы задачи:\n");
    }

    public static int getIntInput(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextInt();
    }

    public static String getStringInput(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
}
