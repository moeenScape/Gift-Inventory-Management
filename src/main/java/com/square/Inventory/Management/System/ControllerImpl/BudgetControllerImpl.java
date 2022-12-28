package com.square.Inventory.Management.System.ControllerImpl;

import com.square.Inventory.Management.System.Controller.BudgetController;
import com.square.Inventory.Management.System.Entity.Budget;
import com.square.Inventory.Management.System.ExcelHepler.BudgetDTO;
import com.square.Inventory.Management.System.Service.BudgetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BudgetControllerImpl implements BudgetController {
    private final BudgetService budgetService;

    public BudgetControllerImpl(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @Override
    public ResponseEntity<List<BudgetDTO>> getAllEmployeesFromExcel() {
        return new ResponseEntity<List<BudgetDTO>>(budgetService.getAllBudgetFromExcel(), HttpStatus.OK);
    }

    /**
     * writing comments
     *
     * @return a list which contains all the rows of the excel
     */
    @Override
    public ResponseEntity<List<Budget>> addBudgetDTOFromExcel() {
        return new ResponseEntity<>(budgetService.addBudgetFromExcel(),HttpStatus.CREATED);
    }
}
