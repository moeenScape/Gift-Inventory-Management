package com.square.Inventory.Management.System.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor


public class SSU {

    private long budgetId;

    private String sapCode;

    private String productName;

    private int productionUnit;

    private int packageSize;

    private String category;

    private String fieldColleagueID;

    private String fieldColleagues;

    private int quantity;

    private String depotID;

    private String depotName;

    private String month;

    private int year;

//    long, java.lang.String, java.lang.String, int, int, java.lang.String,
//    java.lang.String, java.lang.String, int, java.lang.String,
//    java.lang.String, java.lang.String, int
//    s,s,i,i,s,s,s,i,s,s,s,i
//    b.budgetID,b.sapCode," +
//            "b.productName,b.productionUnit,b.packageSize,b.category,
//            b.fieldColleagueID,b.fieldColleagueName," +
//            "b.quantity,b.DepotID,b.depotName,b.month,b.year


    public SSU(long budgetId, String sapCode, String productName, int productionUnit,
               int packageSize, String category, String fieldColleagueID,
               String fieldColleagues, int quantity, String depotID,
               String depotName, String month, int year) {
        this.budgetId = budgetId;
        this.sapCode = sapCode;
        this.productName = productName;
        this.productionUnit = productionUnit;
        this.packageSize = packageSize;
        this.category = category;
        this.fieldColleagueID = fieldColleagueID;
        this.fieldColleagues = fieldColleagues;
        this.quantity = quantity;
        this.depotID = depotID;
        this.depotName = depotName;
        this.month = month;
        this.year = year;
    }
}
