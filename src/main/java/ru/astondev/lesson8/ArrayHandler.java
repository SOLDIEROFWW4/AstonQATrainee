package ru.astondev.lesson8;

public abstract class ArrayHandler {
    protected abstract void validateArraySize(String[][] array) throws MyArraySizeException;

    protected abstract int parseElement(String element, int row, int col) throws MyArrayDataException;
}
