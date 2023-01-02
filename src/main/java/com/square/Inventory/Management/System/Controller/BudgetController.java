package com.square.Inventory.Management.System.Controller;

import com.square.Inventory.Management.System.DTO.BudgetSummary;
import com.square.Inventory.Management.System.DTO.CategoryWiseSummary;
import com.square.Inventory.Management.System.DTO.DEPOT;
import com.square.Inventory.Management.System.DTO.SSU;
import com.square.Inventory.Management.System.ExcelHepler.BudgetExcelDTO;
import com.square.Inventory.Management.System.Entity.Budget;
import com.square.Inventory.Management.System.Projection.BudgetSSUSummaryProjection;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("/budget")
public interface BudgetController {

    @GetMapping("/showAll")
    ResponseEntity<List<BudgetExcelDTO>> getAllEmployeesFromExcel();

    ResponseEntity<List<Budget>> addBudgetDTOFromExcel(MultipartFile file);

    @PostMapping("/addBudgetFromExcel")
    ResponseEntity<List<Budget>> addBudgetExcelDTOFromExcel(@RequestParam("file") MultipartFile file);

    @GetMapping(path = "/for/ssu/{ssuName}")
    ResponseEntity<List<SSU>> getBudgetBySSU(@PathVariable String ssuName);

    @GetMapping(path = "/for/depot/{depotID}")
    ResponseEntity<List<DEPOT>> getBudgetByDepotID(@PathVariable String depotID);

    @GetMapping(path = "/by/month")
    ResponseEntity<List<Budget>> viewAllBudgetByMonth();

    @GetMapping(path = "/all")
    ResponseEntity<List<Budget>> getAllBudget();

    @GetMapping(path = "/summary")
    ResponseEntity<List<BudgetSummary>> getSummary();

    @GetMapping(path = "/categoryWiseSummary")
    ResponseEntity<List<CategoryWiseSummary>> getCategoryWiseSummary();

    @GetMapping(path = "/categoryWiseSummaryDepot")
    ResponseEntity<List<CategoryWiseSummary>> getCategoryWiseSummaryDepot();

    @GetMapping("/dashboard/getSSUSummary")
    ResponseEntity<List<BudgetSSUSummaryProjection>> getSSUSummary();

    @GetMapping(path = "/previous/ssu/{ssu_id}/{month}/{year}")
    ResponseEntity<List<SSU>> getPreviousSSUBudgetByMonthAndYear(@PathVariable String ssu_id,
                                                                 @PathVariable String month,
                                                                 @PathVariable int year);

    @GetMapping(path = "/previous/depot/{depotID}/{month}/{year}")
    ResponseEntity<List<DEPOT>> getPreviousDepotBudgetByMonthAndYear(@PathVariable String depotID,
                                                                     @PathVariable String month,
                                                                     @PathVariable int year);

}
