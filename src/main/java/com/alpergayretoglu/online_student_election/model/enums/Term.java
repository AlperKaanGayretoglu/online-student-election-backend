package com.alpergayretoglu.online_student_election.model.enums;

import java.time.LocalDate;
import java.time.LocalDateTime;

public enum Term {
    SPRING(15, 1, 15, 8),
    FALL(15, 8, 15, 1);

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
        return getTermOfDate(LocalDateTime.now());
    }

    public static Term getTermOfDate(LocalDateTime date) {
        int year = date.getYear();
        for (Term term : Term.values()) {
            LocalDate startDate = term.getStartDateForYear(year);
            LocalDate endDate = term.getEndDateForYear(year);
            if (date.isAfter(startDate.atStartOfDay()) && date.isBefore(endDate.atStartOfDay())) {
                return term;
            }
        }
        return null;
    }

    public LocalDate getStartDateForYear(int year) {
        return LocalDate.of(year, startMonth, startDay);
    }

    public LocalDate getEndDateForYear(int year) {
        return LocalDate.of(year, endMonth, endDay);
    }

}
