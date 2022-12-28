package com.square.Inventory.Management.System.Controller;

import com.square.Inventory.Management.System.ExcelHepler.BudgetDTO;
import com.square.Inventory.Management.System.Entity.Budget;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/budget")
public interface BudgetController {
    @GetMapping("/showAll")
    public ResponseEntity<List<BudgetDTO>> getAllEmployeesFromExcel();

    @PostMapping("/addBudgetFromExcel")
    public ResponseEntity<List<Budget>> addBudgetDTOFromExcel();
}
