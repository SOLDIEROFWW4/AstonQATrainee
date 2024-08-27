package ru.astondev.lesson8;

public class Main {
    public static void main(String[] args) {
        String[][] validArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "X", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        ArrayProcessor arrayProcessor = new ArrayProcessor();

        try {
            int sum = arrayProcessor.processArray(validArray);
            System.out.println("Sum: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }

        try {
            int sum = arrayProcessor.processArray(invalidDataArray);
            System.out.println("Sum: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }
    }
}
