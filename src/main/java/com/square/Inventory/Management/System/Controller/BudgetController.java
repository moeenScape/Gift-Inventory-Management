package com.square.Inventory.Management.System.Controller;

import com.square.Inventory.Management.System.DTO.BudgetSummary;
import com.square.Inventory.Management.System.DTO.DEPOT;
import com.square.Inventory.Management.System.DTO.SSU;
import com.square.Inventory.Management.System.ExcelHepler.BudgetDTO;
import com.square.Inventory.Management.System.Entity.Budget;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("/budget")
public interface BudgetController {
    @GetMapping("/showAll")
    public ResponseEntity<List<BudgetDTO>> getAllEmployeesFromExcel();

    @PostMapping("/addBudgetFromExcel")
    public ResponseEntity<List<Budget>> addBudgetDTOFromExcel(@RequestParam("file") MultipartFile file);

    @GetMapping(path = "/budget/for/ssu/{ssuName}")
    ResponseEntity<List<SSU>> getBudgetBySSU(@PathVariable String ssuName);

    @GetMapping(path = "/budget/for/depot/{id}")
    ResponseEntity<List<DEPOT>> getBudgetByDepotID(@PathVariable String id);

    @GetMapping(path = "/budget/by/{month}")
    ResponseEntity<Budget> viewAllBudgetByMonth(@PathVariable("month") String month);

    @GetMapping(path = "/budget/all")
    ResponseEntity<List<Budget>> getAllBudget();

    @GetMapping(path = "/summary")
    ResponseEntity<List<BudgetSummary>> getSummary();

    @PostMapping("/budget/upload")
    ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file);


}
