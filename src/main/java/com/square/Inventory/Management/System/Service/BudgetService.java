package com.square.Inventory.Management.System.Service;


import com.square.Inventory.Management.System.Entity.Budget;
import com.square.Inventory.Management.System.ExcelHepler.BudgetDTO;
import java.util.List;

public interface BudgetService {

    List<BudgetDTO> getAllBudgetFromExcel();

    List<Budget> addBudgetFromExcel();

}
