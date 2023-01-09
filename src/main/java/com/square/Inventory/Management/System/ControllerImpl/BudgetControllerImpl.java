package com.square.Inventory.Management.System.ControllerImpl;

import com.square.Inventory.Management.System.Controller.BudgetController;
import com.square.Inventory.Management.System.DTO.BudgetSummary;
import com.square.Inventory.Management.System.DTO.CategoryWiseSummary;
import com.square.Inventory.Management.System.DTO.DEPOT;
import com.square.Inventory.Management.System.DTO.SSU;
import com.square.Inventory.Management.System.Entity.Budget;
import com.square.Inventory.Management.System.ExcelHepler.BudgetExcelDto;
import com.square.Inventory.Management.System.JWT.JWTFilter;
import com.square.Inventory.Management.System.Projection.BudgetMonthWiseSumProjection;
import com.square.Inventory.Management.System.Projection.BudgetSSUSummaryProjection;
import com.square.Inventory.Management.System.Repository.BudgetRepository;
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

    public BudgetControllerImpl(BudgetRepository budgetRepository, JWTFilter jwtFilter, BudgetService budgetService) {
        this.jwtFilter = jwtFilter;
        this.budgetService = budgetService;
    }

    @Override
    public ResponseEntity<List<BudgetExcelDto>> getAllEmployeesFromExcel(@RequestParam("file") MultipartFile file) throws IOException {
        return new ResponseEntity<List<BudgetExcelDto>>(budgetService.getAllBudgetFromExcel(file), HttpStatus.OK);
    }

    /**
     * writing comments
     *
     * @return a list which contains all the rows of the excel
     */
    @Override
    public ResponseEntity<List<Budget>> addBudgetDTOFromExcel(MultipartFile file) {
        try {
            if (jwtFilter.isAdmin()) {
                return new ResponseEntity<>(budgetService.addBudgetFromExcel(file), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(new ArrayList<>(), HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<Budget>> addBudgetExcelDTOFromExcel(MultipartFile file) throws IOException {
        return new ResponseEntity<>(budgetService.addBudgetFromExcel(file), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<SSU>> getBudgetBySSU(String ssuName) {

        if (jwtFilter.isAdmin()) {
            return budgetService.getBudgetForSSUByName(ssuName);
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.UNAUTHORIZED);

    }

    @Override
    public ResponseEntity<List<DEPOT>> getBudgetByDepotID(String depotID) {

        if (jwtFilter.isAdmin()) {
            return budgetService.getBudgetForDepotByID(depotID);
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.UNAUTHORIZED);

    }

    @Override
    public ResponseEntity<List<Budget>> getAllBudget() {

        return budgetService.getAllBudget();
    }

    @Override
    public ResponseEntity<List<BudgetSummary>> getSummary() {
        return budgetService.getSummary();
    }

    @Override
    public ResponseEntity<CategoryWiseSummary> getCategoryWiseSummary() {
        if(jwtFilter.isAdmin()) {
            return budgetService.getCategoryWiseSummary();
        } return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
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
    public ResponseEntity<List<SSU>> getPreviousSSUBudgetByMonthAndYear(String ssu_id, String month, int year) {
        return budgetService.getPreviousMonthBudgetByMonthAndYear(ssu_id, month, year);
    }

    @Override
    public ResponseEntity<List<DEPOT>> getPreviousDepotBudgetByMonthAndYear(String depotID, String month, int year) {
        return budgetService.getPreviousDepotBudgetByMonthAndYear(depotID, month, year);
    }

    @Override
    public ResponseEntity<List<DEPOT>> getDepotUserWiseBudget() {
        if (jwtFilter.isDepot()) {
            return budgetService.getDepotBudgetWithUser();
        }
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);

    }

    @Override
    public ResponseEntity<List<SSU>> getSSUUserWiseBudget() {
        if (jwtFilter.isSSU()) {
            return budgetService.getSSUWiseBudget();
        }
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);

    }

    @Override
    public ResponseEntity<List<BudgetMonthWiseSumProjection>> getMonthWiseSum() {
        return budgetService.getMonthWiseSum();
    }


}
