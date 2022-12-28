package com.square.Inventory.Management.System.ControllerImpl;

import com.square.Inventory.Management.System.Controller.BudgetController;
import com.square.Inventory.Management.System.DTO.BudgetSummary;
import com.square.Inventory.Management.System.DTO.DEPOT;
import com.square.Inventory.Management.System.DTO.SSU;
import com.square.Inventory.Management.System.Entity.Budget;
import com.square.Inventory.Management.System.ExcelHepler.BudgetDTO;
import com.square.Inventory.Management.System.JWT.JWTFilter;
import com.square.Inventory.Management.System.Service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BudgetControllerImpl implements BudgetController {

    @Autowired
    JWTFilter jwtFilter;
    private final BudgetService budgetService;

    public BudgetControllerImpl(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @Override
    public ResponseEntity<List<BudgetDTO>> getAllEmployeesFromExcel() {
        return new ResponseEntity<List<BudgetDTO>>(budgetService.getAllBudgetFromExcel(), HttpStatus.OK);
    }

    /**
     * writing comments
     *
     * @return a list which contains all the rows of the excel
     */
    @Override
    public ResponseEntity<List<Budget>> addBudgetDTOFromExcel() {
        return new ResponseEntity<>(budgetService.addBudgetFromExcel(), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<SSU>> getBudgetBySSU(String ssuName) {

        if (jwtFilter.isAdmin() || jwtFilter.isSSU()) {
            return budgetService.getBudgetForSSUByName(ssuName);
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.UNAUTHORIZED);
    }

    @Override
    public ResponseEntity<List<DEPOT>> getBudgetByDepotID(String id) {

        if (jwtFilter.isAdmin() | jwtFilter.isDepot()) {
            return budgetService.getBudgetForDepotByID(id);
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.UNAUTHORIZED);
    }

    @Override
    public ResponseEntity<Budget> viewAllBudgetByMonth(String month) {

        return budgetService.viewAllBudgetByMonth(month);
    }

    @Override
    public ResponseEntity<List<Budget>> getAllBudget() {

        return budgetService.getAllBudget();
    }

    @Override
    public ResponseEntity<List<BudgetSummary>> getSummary() {
        return budgetService.getSummary();
    }


}
