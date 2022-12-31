package com.square.Inventory.Management.System.Service;


import com.square.Inventory.Management.System.DTO.BudgetSummary;
import com.square.Inventory.Management.System.DTO.CategoryWiseSummary;
import com.square.Inventory.Management.System.DTO.DEPOT;
import com.square.Inventory.Management.System.DTO.SSU;
import com.square.Inventory.Management.System.Entity.Budget;
import com.square.Inventory.Management.System.ExcelHepler.BudgetDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BudgetService {

    List<BudgetDTO> getAllBudgetFromExcel();

    List<Budget> addBudgetFromExcel(MultipartFile file);

    ResponseEntity<List<SSU>> getBudgetForSSUByName(String ssuName);

    ResponseEntity<List<DEPOT>> getBudgetForDepotByID(String depotID);

    ResponseEntity<Budget> viewAllBudgetByMonth(String month);

    ResponseEntity<List<Budget>> getAllBudget();

    ResponseEntity<List<BudgetSummary>> getSummary();

    void saveFromUpload(MultipartFile file);

    ResponseEntity<List<CategoryWiseSummary>> getCategoryWiseSummary();

    ResponseEntity<List<CategoryWiseSummary>> getCategoryWiseSummaryDepot();
}
