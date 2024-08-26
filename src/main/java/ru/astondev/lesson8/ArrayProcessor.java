package ru.astondev.lesson8;

public class ArrayProcessor extends ArrayHandler{
    private static final int ARRAY_SIZE = 4;

    @Override
    protected void validateArraySize(String[][] array) throws MyArraySizeException {
        if (array.length != ARRAY_SIZE || array[0].length != ARRAY_SIZE) {
            throw new MyArraySizeException("Массив должен иметь размер 4 на 4");
        }
    }

    @Override
    protected int parseElement(String element, int row, int col) throws MyArrayDataException {
        try {
            return Integer.parseInt(element);
        } catch (NumberFormatException e){
            throw new MyArrayDataException("Неверные данные в (строке: " + row + ", столбце:" + col + "): " + element);
        }
    }
}
