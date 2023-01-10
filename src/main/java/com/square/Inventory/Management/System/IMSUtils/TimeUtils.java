package com.square.Inventory.Management.System.IMSUtils;


import java.time.LocalDate;

public class TimeUtils {

    public static String getCurrentMonth() {
        return LocalDate.now().getMonth().toString();
    }

    public static Integer getCurrentYear() {
        return LocalDate.now().getYear();
    }
}
