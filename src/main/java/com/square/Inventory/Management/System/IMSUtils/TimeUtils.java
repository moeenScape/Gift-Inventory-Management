package com.square.Inventory.Management.System.IMSUtils;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

public class TimeUtils {

    public static String getCurrentMonth() {
        LocalDate localDate = LocalDate.now();
        String currentMonth = localDate.getMonth().toString();
        return currentMonth;
    }

    public static Integer getCurrentYear() {
        LocalDate localDate = LocalDate.now();
        Integer currentYear = localDate.getYear();
        return currentYear;
    }
}
