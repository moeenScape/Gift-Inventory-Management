package com.square.Inventory.Management.System.Controller;

import com.square.Inventory.Management.System.DTO.BudgetSummary;
import com.square.Inventory.Management.System.DTO.CategoryWiseSummary;
import com.square.Inventory.Management.System.DTO.depotDtoForBudget;
import com.square.Inventory.Management.System.DTO.SSUDtoForBudget;
import com.square.Inventory.Management.System.ExcelHepler.BudgetExcelDto;
import com.square.Inventory.Management.System.Entity.Budget;
import com.square.Inventory.Management.System.Projection.BudgetSSUSummaryProjection;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("/budget")
public interface BudgetController {

    @PostMapping("/showExcel")
    ResponseEntity<List<BudgetExcelDto>> getAllEmployeesFromExcel(@RequestParam("file") MultipartFile file) throws IOException;

    ResponseEntity<List<Budget>> addBudgetDTOFromExcel(MultipartFile file);

    @PostMapping("/addBudgetFromExcel")
    ResponseEntity<List<Budget>> addBudgetExcelDTOFromExcel(@RequestParam("file") MultipartFile file) throws IOException;

    @GetMapping(path = "/for/ssu/{ssuName}")
    ResponseEntity<List<SSUDtoForBudget>> getBudgetBySSU(@PathVariable String ssuName);

    @GetMapping(path = "/for/depot/{depotID}")
    ResponseEntity<List<depotDtoForBudget>> getBudgetByDepotID(@PathVariable String depotID);

    @GetMapping(path = "/all")
    ResponseEntity<List<Budget>> getAllBudget();

    @GetMapping(path = "/summary")
    ResponseEntity<List<BudgetSummary>> getSummary();


    @GetMapping(path = "/categoryWiseSummaryDepot")
    ResponseEntity<List<CategoryWiseSummary>> getCategoryWiseSummaryDepot();

    @GetMapping("/dashboard/getSSUSummary")
    ResponseEntity<List<BudgetSSUSummaryProjection>> getSSUSummary();

    @GetMapping(path = "/previous/ssu/{ssu_id}/{month}/{year}")
    ResponseEntity<List<SSUDtoForBudget>> getPreviousSSUBudgetByMonthAndYear(@PathVariable String ssu_id,
                                                                             @PathVariable String month,
                                                                             @PathVariable int year);

    @GetMapping(path = "/previous/depot/{depotID}/{month}/{year}")
    ResponseEntity<List<depotDtoForBudget>> getPreviousDepotBudgetByMonthAndYear(@PathVariable String depotID,
                                                                                 @PathVariable String month,
                                                                                 @PathVariable int year);

    @GetMapping(path = "/depot")
    ResponseEntity<List<depotDtoForBudget>> getDepotUserWiseBudget();

    @GetMapping(path = "/ssu")
    ResponseEntity<List<SSUDtoForBudget>> getSSUUserWiseBudget();

}
