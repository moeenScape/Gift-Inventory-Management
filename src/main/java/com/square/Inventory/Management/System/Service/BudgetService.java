package com.square.Inventory.Management.System.Service;


import com.square.Inventory.Management.System.DTO.BudgetSummary;
import com.square.Inventory.Management.System.DTO.CategoryWiseSummary;
import com.square.Inventory.Management.System.DTO.DEPOT;
import com.square.Inventory.Management.System.DTO.SSU;
import com.square.Inventory.Management.System.Entity.Budget;
import com.square.Inventory.Management.System.ExcelHepler.BudgetExcelDto;
import com.square.Inventory.Management.System.Projection.BudgetMonthWiseSumProjection;
import com.square.Inventory.Management.System.Projection.BudgetSSUSummaryProjection;
import com.square.Inventory.Management.System.Projection.FieldColleagueProjection;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BudgetService {

    List<BudgetExcelDto> getAllBudgetFromExcel(MultipartFile file) throws IOException;

    List<Budget> addBudgetFromExcel(MultipartFile file) throws IOException;

    ResponseEntity<List<SSU>> getBudgetForSSUByName(String ssuName);

    ResponseEntity<List<DEPOT>> getBudgetForDepotByID(String depotID);

    ResponseEntity<List<Budget>> getAllBudget();

    ResponseEntity<List<BudgetSummary>> getSummary();

    ResponseEntity<CategoryWiseSummary> getCategoryWiseSummary();

    ResponseEntity<List<CategoryWiseSummary>> getCategoryWiseSummaryDepot();

    ResponseEntity<List<BudgetSSUSummaryProjection>> getSSUSummary();

    ResponseEntity<List<SSU>> getPreviousMonthBudgetByMonthAndYear(String ssu_id, String month, int year);

    ResponseEntity<List<DEPOT>> getPreviousDepotBudgetByMonthAndYear(String depotID, String month, int year);

    ResponseEntity<List<DEPOT>> getDepotUserWiseBudget();

    ResponseEntity<List<SSU>> getSSUUSerWiseBudget();
    ResponseEntity<List<BudgetMonthWiseSumProjection>> getMonthWiseSum();

    ResponseEntity<FieldColleagueProjection> getCurrentMonthFieldColleague();

}
