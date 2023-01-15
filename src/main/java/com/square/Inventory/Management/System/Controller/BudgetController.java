package com.square.Inventory.Management.System.Controller;

import com.square.Inventory.Management.System.DTO.BudgetSummary;
import com.square.Inventory.Management.System.DTO.CategoryWiseSummary;
import com.square.Inventory.Management.System.DTO.DEPOT;
import com.square.Inventory.Management.System.DTO.SSU;
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

    @PostMapping("/showExcel") // "/showExcel" is not understandable, use a proper name
    // method name getAllEmployeesFromExcel -> getAllEmployeeFromExcel or getEmployeesFromExcel
    // discuss with me about parameter name
    // can we use @ExceptionHandler(IOException.class) on behalf throws IOException
    ResponseEntity<List<BudgetExcelDto>> getAllEmployeesFromExcel(@RequestParam("file") MultipartFile file) throws IOException;

    // why List<Budget>, use dto, use Dto in return
    // change name addBudgetFromExcel
    ResponseEntity<List<Budget>> addBudgetDTOFromExcel(MultipartFile file);

    // why List<Budget>, use dto, use Dto in return
    // change name addBudgetExcelFromExcel
    // @PostMapping("/addBudgetFromExcel") change to @PostMapping("/addBudget")
    @PostMapping("/addBudgetFromExcel")
    ResponseEntity<List<Budget>> addBudgetExcelDTOFromExcel(@RequestParam("file") MultipartFile file) throws IOException;

    // @GetMapping(path = "/for/ssu/{ssuName}") change to @GetMapping(path = "/ssu/{ssuName}")
    // return dto
    @GetMapping(path = "/for/ssu/{ssuName}")
    ResponseEntity<List<SSU>> getBudgetBySSU(@PathVariable String ssuName);

    // @GetMapping(path = "/for/depot/{depotID}") change to @GetMapping(path = "/depot/{depotID}")
    // return dto
    @GetMapping(path = "/for/depot/{depotID}")
    ResponseEntity<List<DEPOT>> getBudgetByDepotID(@PathVariable String depotID);

    // @GetMapping(path = "/all") change to @GetMapping(path = "/get/all")
    // return dto
    @GetMapping(path = "/all")
    ResponseEntity<List<Budget>> getAllBudget();

    // return dto
    @GetMapping(path = "/summary")
    ResponseEntity<List<BudgetSummary>> getSummary();

    // remove line spacing
    // @GetMapping(path = "/categoryWiseSummaryDepot") change to @GetMapping(path = "/categoryWiseDepotSummary")
    // change method name getCategoryWiseSummaryDepot to getCategoryWiseDepotSummary
    // return dto
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

    @GetMapping(path = "/depot")
    ResponseEntity<List<DEPOT>> getDepotUserWiseBudget();

    @GetMapping(path = "/ssu")
    ResponseEntity<List<SSU>> getSSUUserWiseBudget();

}
