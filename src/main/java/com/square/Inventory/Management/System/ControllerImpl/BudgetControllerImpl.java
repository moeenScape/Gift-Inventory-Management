package com.square.Inventory.Management.System.ControllerImpl;

import com.square.Inventory.Management.System.Controller.BudgetController;
import com.square.Inventory.Management.System.DTO.BudgetSummary;
import com.square.Inventory.Management.System.DTO.CategoryWiseSummary;
import com.square.Inventory.Management.System.DTO.DEPOT;
import com.square.Inventory.Management.System.DTO.SSU;
import com.square.Inventory.Management.System.Entity.Budget;
<<<<<<< HEAD
import com.square.Inventory.Management.System.ExcelHepler.BudgetDTO;
=======
import com.square.Inventory.Management.System.ExcelHepler.BudgetExcelDTO;
import com.square.Inventory.Management.System.ExcelHepler.ExcelHelper;
import com.square.Inventory.Management.System.IMSUtils.InventoryUtils;
>>>>>>> f2f852e109e8cf739f638c78dabe5235b20fbb1d
import com.square.Inventory.Management.System.JWT.JWTFilter;
import com.square.Inventory.Management.System.Projection.BudgetSSUSummaryProjection;
import com.square.Inventory.Management.System.Service.BudgetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class BudgetControllerImpl implements BudgetController {

    @Autowired
    JWTFilter jwtFilter;

    private final BudgetService budgetService;

    public BudgetControllerImpl(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @Override
    public ResponseEntity<List<BudgetExcelDTO>> getAllEmployeesFromExcel() {
        return new ResponseEntity<List<BudgetExcelDTO>>(budgetService.getAllBudgetFromExcel(), HttpStatus.OK);
    }

    /**
     * writing comments
     *
     * @return a list which contains all the rows of the excel
     */
    @Override
<<<<<<< HEAD
    public ResponseEntity<List<Budget>> addBudgetDTOFromExcel(MultipartFile file) {
        try{
            if(jwtFilter.isAdmin())
            {
                return new ResponseEntity<>(budgetService.addBudgetFromExcel(file), HttpStatus.CREATED);
            }else {
                return new ResponseEntity<>(new ArrayList<>(),HttpStatus.UNAUTHORIZED);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
=======
    public ResponseEntity<List<Budget>> addBudgetExcelDTOFromExcel(MultipartFile file) {
        return new ResponseEntity<>(budgetService.addBudgetFromExcel(file), HttpStatus.CREATED);
>>>>>>> f2f852e109e8cf739f638c78dabe5235b20fbb1d
    }

    @Override
    public ResponseEntity<List<SSU>> getBudgetBySSU(String ssuName) {

//        if (jwtFilter.isAdmin() || jwtFilter.isSSU()) {
//            return budgetService.getBudgetForSSUByName(ssuName);
//        }
//        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.UNAUTHORIZED);
        return budgetService.getBudgetForSSUByName(ssuName);
    }

    @Override
    public ResponseEntity<List<DEPOT>> getBudgetByDepotID(String depotID) {

//        if (jwtFilter.isAdmin() || (jwtFilter.isDepot() && jwtFilter.getRole() == id)) {
//            return budgetService.getBudgetForDepotByID(id);
//        }
//        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.UNAUTHORIZED);
        return budgetService.getBudgetForDepotByID(depotID);
    }

    @Override
    public ResponseEntity<List<Budget>> viewAllBudgetByMonth() {

        return budgetService.viewAllBudgetByMonth();
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
    public ResponseEntity<List<CategoryWiseSummary>> getCategoryWiseSummary() {
        return budgetService.getCategoryWiseSummary();
    }

    @Override
    public ResponseEntity<List<CategoryWiseSummary>> getCategoryWiseSummaryDepot() {
        return budgetService.getCategoryWiseSummaryDepot();
    }

    @Override
    public ResponseEntity<List<BudgetSSUSummaryProjection>> getSSUSummary(){
        return budgetService.getSSUSummary();
    }


}
