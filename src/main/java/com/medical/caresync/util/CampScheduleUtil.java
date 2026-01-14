package com.medical.caresync.util;

import com.medical.caresync.entities.CampScheduleTemplates;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.temporal.TemporalAdjusters;

public class CampScheduleUtil {

    public static LocalDate deriveNextDateForSchedule(CampScheduleTemplates schedule, LocalDate today) {
        YearMonth start = YearMonth.from(today);
        for (int i = 0; i < 12; i++) {
            YearMonth ym = start.plusMonths(i);
            Month month = ym.getMonth();
            if (!isMonthEnabled(schedule, month)) {
                continue;
            }
            LocalDate candidate = getNthWeekdayOfMonth(
                    ym.getYear(),
                    month,
                    DayOfWeek.valueOf(schedule.getDayOfWeek().name()),
                    schedule.getWeekOfMonth()
            );
            if (candidate != null && !candidate.isBefore(today)) {
                return candidate;
            }
        }
        return null;
    }

    private static boolean isMonthEnabled(CampScheduleTemplates s, Month month) {
        return switch (month) {
            case JANUARY -> s.getMonthJanuary();
            case FEBRUARY -> s.getMonthFebruary();
            case MARCH -> s.getMonthMarch();
            case APRIL -> s.getMonthApril();
            case MAY -> s.getMonthMay();
            case JUNE -> s.getMonthJune();
            case JULY -> s.getMonthJuly();
            case AUGUST -> s.getMonthAugust();
            case SEPTEMBER -> s.getMonthSeptember();
            case OCTOBER -> s.getMonthOctober();
            case NOVEMBER -> s.getMonthNovember();
            case DECEMBER -> s.getMonthDecember();
        };
    }
    private static LocalDate getNthWeekdayOfMonth(
            int year,
            Month month,
            DayOfWeek dayOfWeek,
            int weekOfMonth) {

        LocalDate firstDay = LocalDate.of(year, month, 1);

        LocalDate firstMatchingDay = firstDay.with(
                TemporalAdjusters.nextOrSame(dayOfWeek)
        );

        LocalDate result = firstMatchingDay.plusWeeks(weekOfMonth - 1);

        return result.getMonth() == month ? result : null;
    }
}
