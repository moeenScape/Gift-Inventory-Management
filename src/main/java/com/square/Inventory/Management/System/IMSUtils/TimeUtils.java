package com.square.Inventory.Management.System.IMSUtils;

import java.time.LocalDate;

public class TimeUtils {

    public static String getCurrentMonth() {
        LocalDate localDate = LocalDate.now();
        return localDate.getMonth().toString();
    }

    public static Integer getCurrentYear() {
        LocalDate localDate = LocalDate.now();
        return localDate.getYear();
    }
}
