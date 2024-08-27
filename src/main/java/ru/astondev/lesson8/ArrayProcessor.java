package ru.astondev.lesson8;

// Создаём класс ArrayProcessor для того, чтобы задать логику поведения массива; наследуется от абстрактного класса ArrayHandler
public class ArrayProcessor extends ArrayHandler {
    // Объявляем переменную для размера массива (по ТЗ)
    private static final int ARRAY_SIZE = 4;

    // Переопределённый метод validateArraySize для проверки размерности массива
    @Override
    protected void validateArraySize(String[][] array) throws MyArraySizeException {
        if (array.length != ARRAY_SIZE || array[0].length != ARRAY_SIZE) {
            throw new MyArraySizeException("Массив должен иметь размер 4 на 4");
        }
    }

    // Переопределённый метод parseElement для обработки элементов массива
    @Override
    protected int parseElement(String element, int row, int col) throws MyArrayDataException {
        // Используем конструкцию try-catch для обработки элементов массива
        try {
            // В успешном случае идёт преобразование String в int
            return Integer.parseInt(element);
        } catch (NumberFormatException e) {
            // В случае ошибки вызываем класс исключения MyArrayDataException и выводим сообщение, в каком столбце и в какой строке находится некорректный элемент и выводим его значение
            throw new MyArrayDataException("Неверные данные в (строке: " + row + ", столбце:" + col + "): " + element);
        }
    }

    // Метод processArray для инициализации элементов двумерного массива и суммирования их значений
    // содержит в себе классы исключения MyArraySizeException и MyArrayDataException
    public int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        // Вызываем метод для проверки размерности массива
        validateArraySize(array);

        // Переменная типа int для суммы
        int sum = 0;
        for (int i = 0; i < ARRAY_SIZE; i++) {
            for (int j = 0; j < ARRAY_SIZE; j++) {
                // Суммируем все элементы двумерного массива типа String преобразовывая его в int при помощи parseElement
                sum += parseElement(array[i][j], i, j);
            }
        }
        return sum;
    }
}
