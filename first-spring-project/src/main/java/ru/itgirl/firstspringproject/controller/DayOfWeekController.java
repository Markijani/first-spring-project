package ru.itgirl.firstspringproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DayOfWeekController {

    @GetMapping("/dayOfWeek")
    public String DayOfWeek(@RequestParam(value = "name") String name) {
        try {
            DayOfWeek dayOfWeek = DayOfWeek.valueOf(name.toUpperCase());
            return "Сегодня" + " " + dayOfWeek.getRussianName();
        } catch (IllegalArgumentException e) {
            return "Wrong day of week";
        }
    }

    public enum DayOfWeek {

        SUNDAY("Воскресенье"),
        MONDAY("Понедельник"),
        TUESDAY("Вторник"),
        WEDNESDAY("Среда"),
        THURSDAY("Четверг"),
        FRIDAY("Пятница"),
        SATURDAY("Суббота");

        private final String russianName;

        DayOfWeek(String russianName) {
            this.russianName = russianName;
        }

        public String getRussianName() {
            return russianName;
        }
    }
}