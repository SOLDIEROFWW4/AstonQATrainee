package ru.astondev.lesson6;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Park {
    private String name;

    public Park (String name) {
        this.name = name;
    }

    public class Attraction {
        private String attractionName;
        private Date openingTime;
        private Date closingTime;
        private double price;
        private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

        public Attraction(String attractionName, String openingTimeStr, String closingTimeStr, double price) {
            this.attractionName = attractionName;
            this.openingTime = parseTime(openingTimeStr);
            this.closingTime = parseTime(closingTimeStr);
            this.price = price;
        }

        private Date parseTime(String timeStr) {
            try {
                return timeFormat.parse(timeStr);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

        public void printInfo() {
            System.out.println("Аттракцион: " + attractionName);
            System.out.println("Время работы: " + getFormattedTime(openingTime) + " - " + getFormattedTime(closingTime));
            System.out.println("Стоимость: " + price);
        }

        private String getFormattedTime(Date time) {
            return time != null ? timeFormat.format(time) : "Invalid Time";
        }


    }
}
