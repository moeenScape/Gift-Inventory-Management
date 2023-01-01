package com.square.Inventory.Management.System.Controller;

import com.square.Inventory.Management.System.DTO.BudgetSummary;
import com.square.Inventory.Management.System.DTO.CategoryWiseSummary;
import com.square.Inventory.Management.System.DTO.DEPOT;
import com.square.Inventory.Management.System.DTO.SSU;
import com.square.Inventory.Management.System.ExcelHepler.BudgetExcelDTO;
import com.square.Inventory.Management.System.Entity.Budget;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("/budget")
public interface BudgetController {
    @GetMapping("/showAll")
    ResponseEntity<List<BudgetExcelDTO>> getAllEmployeesFromExcel();

    @PostMapping("/addBudgetFromExcel")
    ResponseEntity<List<Budget>> addBudgetExcelDTOFromExcel(@RequestParam("file") MultipartFile file);

    @GetMapping(path = "/budget/for/ssu/{ssuName}")
    ResponseEntity<List<SSU>> getBudgetBySSU(@PathVariable String ssuName);

    @GetMapping(path = "/budget/for/depot/{depotID}")
    ResponseEntity<List<DEPOT>> getBudgetByDepotID(@PathVariable String depotID);

    @GetMapping(path = "/budget/by/month")
    ResponseEntity<List<Budget>> viewAllBudgetByMonth();

    @GetMapping(path = "/budget/all")
    ResponseEntity<List<Budget>> getAllBudget();

    @GetMapping(path = "/summary")
    ResponseEntity<List<BudgetSummary>> getSummary();

    @GetMapping(path = "/categoryWiseSummary")
    ResponseEntity<List<CategoryWiseSummary>> getCategoryWiseSummary();

    @GetMapping(path = "/categoryWiseSummaryDepot")
    ResponseEntity<List<CategoryWiseSummary>> getCategoryWiseSummaryDepot();

}
