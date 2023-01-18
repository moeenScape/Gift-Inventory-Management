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

    private String fieldColleagueId;

    private String fieldColleagueName;

    private int quantity;

    private String depotId;

    private String depotName;

    private String month;

    private int year;

    public SSUDtoForBudget(String budgetId, String sapCode, String productName, String productionUnit,
                           String packageSize, String category, SBU sbu, String fieldColleagueId,
                           String fieldColleagueName, int quantity, String depotId,
                           String depotName, String month, int year) {
        this.budgetId = budgetId;
        this.sapCode = sapCode;
        this.productName = productName;
        this.productionUnit = productionUnit;
        this.packageSize = packageSize;
        this.category = category;
        this.sbu=sbu;
        this.fieldColleagueId = fieldColleagueId;
        this.fieldColleagueName = fieldColleagueName;
        this.quantity = quantity;
        this.depotId = depotId;
        this.depotName = depotName;
        this.month = month;
        this.year = year;
    }
}
