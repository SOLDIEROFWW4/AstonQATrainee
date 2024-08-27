package ru.astondev.lesson8;

// Создаём абстрактный класс ArrayHandler, который задаёт методы для проверки размера массива и обработки элементов.
public abstract class ArrayHandler {
    // Абстрактный метод для проверки размера массива, который включает в себя класс исключения MyArraySizeException
    protected abstract void validateArraySize(String[][] array) throws MyArraySizeException;

    // Абстрактный метод для обработки элементов массива, который включает в себя класс исключения MyDataSizeException
    protected abstract int parseElement(String element, int row, int col) throws MyArrayDataException;
}
