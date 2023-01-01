package com.square.Inventory.Management.System.Service;


import com.square.Inventory.Management.System.DTO.BudgetSummary;
import com.square.Inventory.Management.System.DTO.CategoryWiseSummary;
import com.square.Inventory.Management.System.DTO.DEPOT;
import com.square.Inventory.Management.System.DTO.SSU;
import com.square.Inventory.Management.System.Entity.Budget;
import com.square.Inventory.Management.System.ExcelHepler.BudgetExcelDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BudgetService {

    List<BudgetExcelDTO> getAllBudgetFromExcel();

    List<Budget> addBudgetFromExcel(MultipartFile file);

    ResponseEntity<List<SSU>> getBudgetForSSUByName(String ssuName);

    ResponseEntity<List<DEPOT>> getBudgetForDepotByID(String depotID);

    ResponseEntity<Budget> viewAllBudgetByMonth(String month);

    ResponseEntity<List<Budget>> getAllBudget();

    ResponseEntity<List<BudgetSummary>> getSummary();

    ResponseEntity<List<CategoryWiseSummary>> getCategoryWiseSummary();

    ResponseEntity<List<CategoryWiseSummary>> getCategoryWiseSummaryDepot();
}
