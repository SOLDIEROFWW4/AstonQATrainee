package ru.astondev.lesson2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Utility.printTask(1, "printThreeWords");

        Tasks.printThreeWords();

        Utility.printTask(2, "checkSumSign");
        Tasks.checkSumSign();

        Utility.printTask(3, "printColor");
        Tasks.printColor();

        Utility.printTask(4, "compareNumbers");
        Tasks.compareNumbers();

        Utility.printTask(5, "isSumInRange");
        int a = Utility.getIntInput(scanner, "Введите первое число: ");
        int b = Utility.getIntInput(scanner, "Введите второе число: ");
        System.out.println(Tasks.isSumInRange(a, b));

        Utility.printTask(6, "printPositiveOrNegativeNumber");
        int number = Utility.getIntInput(scanner, "Введите число: ");
        Tasks.printPositiveOrNegativeNumber(number);

        Utility.printTask(7, "isNegativeNumber");
        number = Utility.getIntInput(scanner, "Введите число: ");
        System.out.println(Tasks.isNegativeNumber(number));

        Utility.printTask(8, "printStringMultipleTimes");
        scanner.nextLine(); // consume newline
        String str = Utility.getStringInput(scanner, "Введите строку: ");
        int count = Utility.getIntInput(scanner, "Введите количество повторений: ");
        Tasks.printStringMultipleTimes(str, count);

        Utility.printTask(9, "isLeapYear");
        int year = Utility.getIntInput(scanner, "Введите год: ");
        System.out.println(Tasks.isLeapYear(year));

        Utility.printTask(10, "invertBinaryArray");
        int size = Utility.getIntInput(scanner, "Введите размер массива: ");
        int[] binaryArray = Tasks.createBinaryArray(size);
        Tasks.invertBinaryArray(binaryArray);
        Utility.printResult();
        Tasks.printArray(binaryArray);

        Utility.printTask(11, "fillArray");
        int[] fillArray = Tasks.fillArray();
        Utility.printResult();
        Tasks.printArray(fillArray);

        Utility.printTask(12, "processArray");
        Utility.printResult();
        Tasks.printArray(Tasks.processArray());

        Utility.printTask(13, "fillDiagonals");
        int size2DArray = Utility.getIntInput(scanner, "Введите размер двумерного массива: ");
        int[][] array = new int[size2DArray][size2DArray];
        Tasks.fillDiagonals(array);
        Utility.printResult();
        Tasks.print2DArray(array);

        Utility.printTask(14, "initializeArray");
        int len = Utility.getIntInput(scanner, "Введите длину массива: ");
        int initialValue = Utility.getIntInput(scanner, "Введите начальное значение: ");
        Utility.printResult();
        Tasks.printArray(Tasks.initializeArray(len, initialValue));

        scanner.close();
    }
}