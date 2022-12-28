package com.square.Inventory.Management.System.Controller;

import com.square.Inventory.Management.System.DTO.BudgetSummary;
import com.square.Inventory.Management.System.DTO.DEPOT;
import com.square.Inventory.Management.System.DTO.SSU;
import com.square.Inventory.Management.System.ExcelHepler.BudgetDTO;
import com.square.Inventory.Management.System.Entity.Budget;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/budget")
public interface BudgetController {
    @GetMapping("/showAll")
    public ResponseEntity<List<BudgetDTO>> getAllEmployeesFromExcel();

    @PostMapping("/addBudgetFromExcel")
    public ResponseEntity<List<Budget>> addBudgetDTOFromExcel();

    @GetMapping(path = "/budget/for/ssu/{ssuName}")
    ResponseEntity<List<SSU>> getBudgetBySSU(@PathVariable String ssuName);

    @GetMapping(path = "/budget/for/depot/{id}")
    ResponseEntity<List<DEPOT>> getBudgetByDepotID(@PathVariable String id);

    @GetMapping(path = "/budget/by/{month}")
    ResponseEntity<Budget> viewAllBudgetByMonth(@PathVariable("month") String month);

    @GetMapping(path = "/budget/all")
    ResponseEntity<List<Budget>> getAllBudget();

    @GetMapping(path = "/summary")
    ResponseEntity<List<BudgetSummary>>  getSummary();


}
