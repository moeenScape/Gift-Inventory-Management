package com.square.Inventory.Management.System.DTO;

import com.square.Inventory.Management.System.Entity.SBU;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SSUDtoForBudget {

    private String budgetId;

    private String sapCode;

    private String productName;

    private String productionUnit;

    private String packageSize;

    private String category;

    private SBU sbu;
    private String fieldColleagueID;

    private String fieldColleagues;

    private int quantity;

    private String depotID;

    private String depotName;

    private String month;

    private int year;

    public SSUDtoForBudget(String budgetId, String sapCode, String productName, String productionUnit,
                           String packageSize, String category, SBU sbu, String fieldColleagueID,
                           String fieldColleagues, int quantity, String depotID,
                           String depotName, String month, int year) {
        this.budgetId = budgetId;
        this.sapCode = sapCode;
        this.productName = productName;
        this.productionUnit = productionUnit;
        this.packageSize = packageSize;
        this.category = category;
        this.sbu=sbu;
        this.fieldColleagueID = fieldColleagueID;
        this.fieldColleagues = fieldColleagues;
        this.quantity = quantity;
        this.depotID = depotID;
        this.depotName = depotName;
        this.month = month;
        this.year = year;
    }
}
