package com.square.Inventory.Management.System.Controller;

import com.square.Inventory.Management.System.ExcelHepler.BudgetDTO;
import com.square.Inventory.Management.System.Entity.Budget;
import com.square.Inventory.Management.System.Service.BudgetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/budget")
public class BudgetController {
    private final BudgetService budgetService;

    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @GetMapping("/showAll")
    public ResponseEntity<List<BudgetDTO>> getAllEmployeesFromExcel() {
        return new ResponseEntity<List<BudgetDTO>>(budgetService.getAllBudgetFromExcel(), HttpStatus.OK);
    }

    /**
     *
     * @param name
     * @return
     */
    @PostMapping("/addBudgetFromExcel")
    public ResponseEntity<List<Budget>> addBudgetDTOFromExcel(String name) {
        return new ResponseEntity<>(budgetService.addBudgetFromExcel(),HttpStatus.CREATED);
    }

}
