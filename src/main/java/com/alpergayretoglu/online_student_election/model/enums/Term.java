package com.alpergayretoglu.online_student_election.model.enums;

import java.time.LocalDate;

public enum Term {
    FALL(15, 9, 15, 1),
    SPRING(15, 2, 15, 6);

    private final int startDay;
    private final int startMonth;
    private final int endDay;
    private final int endMonth;

    Term(int startDay, int startMonth, int endDay, int endMonth) {
        this.startDay = startDay;
        this.startMonth = startMonth;
        this.endDay = endDay;
        this.endMonth = endMonth;
    }

    public static Term getCurrentTerm() {
        LocalDate now = LocalDate.now();
        int month = now.getMonthValue();
        if (month >= 9 && month <= 12) {
            return FALL;
        } else {
            return SPRING;
        }
    }

    public LocalDate getStartDate(int year) {
        return LocalDate.of(year, startMonth, startDay);
    }

    public LocalDate getEndDate(int year) {
        return LocalDate.of(year, endMonth, endDay);
    }


}
