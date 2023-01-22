package com.square.Inventory.Management.System.ControllerImpl;

import com.square.Inventory.Management.System.Controller.BudgetController;
import com.square.Inventory.Management.System.DTO.BudgetSummaryProjection;
import com.square.Inventory.Management.System.DTO.CategoryWiseSummary;
import com.square.Inventory.Management.System.DTO.SSUDtoForBudget;
import com.square.Inventory.Management.System.DTO.depotDtoForBudget;
import com.square.Inventory.Management.System.Entity.Budget;
import com.square.Inventory.Management.System.ExcelHepler.BudgetExcelDto;
import com.square.Inventory.Management.System.JWT.JWTFilter;
import com.square.Inventory.Management.System.Projection.BudgetSSUSummaryProjection;
import com.square.Inventory.Management.System.Service.BudgetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class BudgetControllerImpl implements BudgetController {

    private final JWTFilter jwtFilter;

    private final BudgetService budgetService;

    public BudgetControllerImpl(JWTFilter jwtFilter, BudgetService budgetService) {
        this.jwtFilter = jwtFilter;
        this.budgetService = budgetService;
    }

    @Override
    public ResponseEntity<List<BudgetExcelDto>> getAllEmployeesFromExcel(@RequestParam("file") MultipartFile file) throws IOException {
        return new ResponseEntity<List<BudgetExcelDto>>(budgetService.getAllBudgetFromExcel(file), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> addBudgetExcelDTOFromExcel(MultipartFile file) throws IOException {
        if (jwtFilter.isAdmin()) {
            return budgetService.addBudgetFromExcel(file);
        } else {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    public ResponseEntity<List<SSUDtoForBudget>> getBudgetBySSU(String ssuName) {
        if (jwtFilter.isAdmin()) {
            return budgetService.getBudgetForSSUByName(ssuName);
        }

        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @Override
    public ResponseEntity<List<depotDtoForBudget>> getBudgetByDepotID(String depotID) {
        if (jwtFilter.isAdmin()) {
            return budgetService.getBudgetForDepotByID(depotID);
        }

        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @Override
    public ResponseEntity<List<Budget>> getAllBudget() {
        return budgetService.getAllBudget();
    }

    @Override
    public ResponseEntity<List<BudgetSummaryProjection>> getSummary() {
        return budgetService.getSummary();
    }

    @Override
    public ResponseEntity<List<CategoryWiseSummary>> getCategoryWiseSummaryDepot() {
        return budgetService.getCategoryWiseSummaryDepot();
    }

    @Override
    public ResponseEntity<List<BudgetSSUSummaryProjection>> getSSUSummary() {
        return budgetService.getSSUSummary();
    }

    @Override
    public ResponseEntity<List<SSUDtoForBudget>> getPreviousSSUBudgetByMonthAndYear(String ssu_id, String month, int year) {
        return budgetService.getPreviousMonthBudgetByMonthAndYear(ssu_id, month, year);
    }

    @Override
    public ResponseEntity<List<depotDtoForBudget>> getPreviousDepotBudgetByMonthAndYear(String depotID, String month, int year) {
        return budgetService.getPreviousDepotBudgetByMonthAndYear(depotID, month, year);
    }

    @Override
    public ResponseEntity<List<depotDtoForBudget>> getDepotUserWiseBudget() {
        if (jwtFilter.isDepot()) {
            return budgetService.getDepotUserWiseBudget();
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @Override
    public ResponseEntity<List<SSUDtoForBudget>> getSSUUserWiseBudget() {
        if (jwtFilter.isSSU()) {
            return budgetService.getSSUUSerWiseBudget();
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

}
