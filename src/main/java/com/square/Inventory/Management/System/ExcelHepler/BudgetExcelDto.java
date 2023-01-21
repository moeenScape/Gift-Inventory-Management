package com.square.Inventory.Management.System.ExcelHepler;

import com.square.Inventory.Management.System.Entity.SBU;
import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelRow;
import lombok.Getter;

import javax.validation.constraints.Pattern;

@Getter
public class BudgetExcelDto {
    // todo naming change after FE approval

    @ExcelRow
    private int rowIndex;

    @ExcelCell(0)
    private String budgetID;

    @ExcelCell(1)
    private String sapCode;

    @ExcelCell(2)
    private String productName;

    @ExcelCell(3)
    private String productionUnit;

    @ExcelCell(4)
    private String packageSize;

    @ExcelCell(5)
    private SBU sbu;

    @ExcelCell(6)
    private String fieldColleagueID;

    @ExcelCell(7)
    private String fieldColleagueName;

    @ExcelCell(8)
    private float quantity;

    @ExcelCell(9)
    private String depotName;

    @ExcelCell(10)
    private String depotID;

    @Pattern(regexp = "^(ppm|sample|gift|PPM|SAMPLE|GIFT|Ppm|Sample|Gift)$", message = "unknown category inserted")
    @ExcelCell(11)
    private String category;

    @ExcelCell(12)
    private String month;

    @ExcelCell(13)
    private int year;

    @ExcelCell(14)
    private String ssu_id;

}
