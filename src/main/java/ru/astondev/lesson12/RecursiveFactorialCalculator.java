package ru.astondev.lesson12;

public class RecursiveFactorialCalculator implements FactorialCalculator{
    @Override
    public long calculate(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Число должно быть положительным");
        }
        return (n<=1) ? 1 : n* calculate(n-1);
    }
}
