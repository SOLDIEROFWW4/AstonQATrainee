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

        // Вызов экземпляра класса ArrayProcessor для работы с массивами
        ArrayProcessor arrayProcessor = new ArrayProcessor();

        // В конструкции try-catch проводим проверку массива validArray и суммируем его элементы
        // В случае ошибке, в блоке catch срабатывает исключение MyArraySizeException или MyArrayDataException
        try {
            int sum = arrayProcessor.processArray(validArray);
            System.out.println("Sum: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }

        // В конструкции try-catch проводим проверку массива invalidArray и суммируем его элементы
        // В случае ошибке, в блоке catch срабатывает исключение MyArraySizeException или MyArrayDataException
        try {
            int sum = arrayProcessor.processArray(invalidDataArray);
            System.out.println("Sum: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }
    }
}
