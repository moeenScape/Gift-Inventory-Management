package com.square.Inventory.Management.System.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DEPOT {

    private long budgetId;

    private String sapCode;

    private String productName;

    private int productionUnit;

    private int packageSize;

    private String category;


    private String fieldColleagueID;

    private String fieldColleagues;

    private int quantity;

    private String month;

    private int year;
}
