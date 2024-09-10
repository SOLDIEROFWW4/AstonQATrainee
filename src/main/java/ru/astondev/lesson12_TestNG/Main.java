package ru.astondev.lesson12_TestNG;

public class Main {
    public static void main(String[] args) {
        FactorialCalculator calculator = new RecursiveFactorialCalculator();
        int number = 5;
        long result = calculator.calculate(number);
        System.out.println("Факториал " + number + " = " + result);
    }
}
