package ru.astondev.lesson6;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
// Создаём класс Park
public class Park {
    // Объявляем переменную name для названия парка
    private String name;

    // При помощи конструктора инициализируем переменную
    public Park (String name) {
        this.name = name;
    }

    //В классе Park создаём внутренний класс для аттракционов
    public class Attraction {
        // Во внутреннем классе объявляем пять переменных: название аттракциона, время открытия, время закрытия, цену билета и формат времени
        private String attractionName;
        private Date openingTime;
        private Date closingTime;
        private double price;
        // При помощи класса SimpleDateFormat мы задаём формат времени для openingTime и closingTime
        private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

        // Создаём конструктор для инициализации переменных
        public Attraction(String attractionName, String openingTimeStr, String closingTimeStr, double price) {
            this.attractionName = attractionName;
            this.openingTime = parseTime(openingTimeStr);
            this.closingTime = parseTime(closingTimeStr);
            this.price = price;
        }

        // Создаём метод типа Date который конвертирует переменные openingTime и closingTime для заданного
        // формата timeFormat. Используем конструкцию try/catch для обработки ошибок
        private Date parseTime(String timeStr) {
            try {
                return timeFormat.parse(timeStr);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

        // Метод для вывода информации
        public void printInfo() {
            System.out.println("Аттракцион: " + attractionName);
            System.out.println("Время работы: " + getFormattedTime(openingTime) + " - " + getFormattedTime(closingTime));
            System.out.println("Стоимость: " + price);
        }

        // Метод для форматирования времени под заданный формат timeFormat и проверки на null;
        // Если time равен null, метод возвращает строку "Invalid Time".
        private String getFormattedTime(Date time) {
            return time != null ? timeFormat.format(time) : "Invalid Time";
        }
    }
}
