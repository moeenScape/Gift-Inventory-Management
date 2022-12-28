package com.square.Inventory.Management.System.ExcelHepler;

import com.example.inventory_project.entity.SBU;
import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelRow;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class BudgetDTO {
    @ExcelRow
    private int rowIndex;
    @ExcelCell(0)
    private long budgetID;
    @ExcelCell(1)
    private String sapCode;

    @ExcelCell(2)
    private String productName;
    @ExcelCell(3)
    private int productionUnit;

    @Enumerated(EnumType.STRING)
    @ExcelCell(4)
    private int packageSize;

    @ExcelCell(5)
    private SBU sbu;

    @ExcelCell(6)
    private String fieldColleagueID;

    @ExcelCell(7)
    private String fieldColleagueName;

    @ExcelCell(8)
    private int quantity;

    @ExcelCell(9)
    private String depotName;

    @ExcelCell(10)
    private String depotID;

    @ExcelCell(11)
    private String category;

    @ExcelCell(12)
    private String month;

    @ExcelCell(13)
    private int year;

    @ExcelCell(14)
    private String ssu_id;

    public long getBudgetID() {
        return budgetID;
    }

    public String getSapCode() {
        return sapCode;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductionUnit() {
        return productionUnit;
    }

    public int getPackageSize() {
        return packageSize;
    }

    public SBU getSbu() {
        return sbu;
    }

    public String getFieldColleagueID() {
        return fieldColleagueID;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDepotName() {
        return depotName;
    }

    public String getDepotID() {
        return depotID;
    }

    public String getCategory() {
        return category;
    }

    public String getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getSsu_id() {
        return ssu_id;
    }
    public String getFieldColleagueName() {
        return fieldColleagueName;
    }

}
