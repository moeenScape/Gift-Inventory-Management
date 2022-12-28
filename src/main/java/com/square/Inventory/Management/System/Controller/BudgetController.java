package com.square.Inventory.Management.System.Controller;

import com.example.inventory_project.DTO.BudgetDTO;
import com.example.inventory_project.entity.Budget;
import com.example.inventory_project.projection.BudgetProjectionInterface;
import com.example.inventory_project.service.BudgetService;
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

    @GetMapping("/showDepotWiseProductSum")
    public ResponseEntity<List<BudgetProjectionInterface>> showDepotWiseProductSum() {
        return new ResponseEntity<>(budgetService.showDepotWiseProductSum(), HttpStatus.OK);
    }
}
