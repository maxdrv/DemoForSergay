package org.example.demo;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Map;

public class DayMonth {

    @Test
    void dayMonth() {
        LocalDate date = LocalDate.now();  // получили текущую дату

        DayOfWeek dayOfWeek = date.getDayOfWeek();
        switch (dayOfWeek) {
            case MONDAY -> System.out.println("Понедельник");
            case TUESDAY -> System.out.println("Вторник");
            case WEDNESDAY -> System.out.println("Среда");
            case THURSDAY -> System.out.println("Четверг");
            case FRIDAY -> System.out.println("Пятница");
            case SATURDAY -> System.out.println("Суббота");
            case SUNDAY -> System.out.println("Воскресенье");
        }

        Month month = date.getMonth();
        switch (month) {
            case JANUARY -> System.out.println("январь");
            case FEBRUARY -> System.out.println("фев");
            case MARCH -> System.out.println("март");
            case APRIL -> System.out.println("апр");
            case MAY -> System.out.println("май");
            case JUNE -> System.out.println("июнь");
            case JULY -> System.out.println("июль");
            case AUGUST -> System.out.println("август");
            case SEPTEMBER -> System.out.println("сент");
            case OCTOBER -> System.out.println("окт");
            case NOVEMBER -> System.out.println("ноябр");
            case DECEMBER -> System.out.println("дек");
        }
    }

    @Test
    void dayMonthV2() {
        LocalDate date = LocalDate.now();

        String dayOfWeak = switch (date.getDayOfWeek()) {
            case MONDAY -> "Понедельник";
            case TUESDAY -> "Вторник";
            case WEDNESDAY -> "Среда";
            case THURSDAY -> "Четверг";
            case FRIDAY -> "Пятница";
            case SATURDAY -> "Суббота";
            case SUNDAY -> "Воскресенье";
        };
        String month = switch (date.getMonth()) {
            case JANUARY -> "январь";
            case FEBRUARY -> "фев";
            case MARCH -> "март";
            case APRIL -> "апр";
            case MAY -> "май";
            case JUNE -> "июнь";
            case JULY -> "июль";
            case AUGUST -> "август";
            case SEPTEMBER -> "сент";
            case OCTOBER -> "окт";
            case NOVEMBER -> "ноябр";
            case DECEMBER -> "дек";
        };
        System.out.println(dayOfWeak);
        System.out.println(month);
    }

    @Test
    void dayMonthV3() {
        LocalDate date = LocalDate.now();

        Locale russianLocale = new Locale("ru");

        String dayOfWeek = date.getDayOfWeek().getDisplayName(TextStyle.FULL_STANDALONE, russianLocale);
        String month = date.getMonth().getDisplayName(TextStyle.FULL_STANDALONE, russianLocale);

        System.out.println(dayOfWeek);
        System.out.println(month);
    }

    @Test
    void username() {
        Map<String, String> environment = System.getenv();
        String user = environment.get("USER");
        System.out.println(user);
    }
}
