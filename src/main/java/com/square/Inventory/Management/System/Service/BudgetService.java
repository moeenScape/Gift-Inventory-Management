package com.square.Inventory.Management.System.Service;


import com.square.Inventory.Management.System.DTO.BudgetSummaryProjection;
import com.square.Inventory.Management.System.DTO.CategoryWiseSummary;
import com.square.Inventory.Management.System.DTO.depotDtoForBudget;
import com.square.Inventory.Management.System.DTO.SSUDtoForBudget;
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

    ResponseEntity<?> addBudgetFromExcel(MultipartFile file) throws IOException;

    ResponseEntity<List<SSUDtoForBudget>> getBudgetForSSUByName(String ssuName);

    ResponseEntity<List<depotDtoForBudget>> getBudgetForDepotByID(String depotID);

    ResponseEntity<List<Budget>> getAllBudget();

    ResponseEntity<List<BudgetSummaryProjection>> getSummary();

    ResponseEntity<CategoryWiseSummary> getCategoryWiseSummary();

    ResponseEntity<List<CategoryWiseSummary>> getCategoryWiseSummaryDepot();

    ResponseEntity<List<BudgetSSUSummaryProjection>> getSSUSummary();

    ResponseEntity<List<SSUDtoForBudget>> getPreviousMonthBudgetByMonthAndYear(String ssu_id, String month, int year);

    ResponseEntity<List<depotDtoForBudget>> getPreviousDepotBudgetByMonthAndYear(String depotID, String month, int year);

    ResponseEntity<List<depotDtoForBudget>> getDepotUserWiseBudget();

    ResponseEntity<List<SSUDtoForBudget>> getSSUUSerWiseBudget();
    ResponseEntity<List<BudgetMonthWiseSumProjection>> getMonthWiseSum();

    ResponseEntity<FieldColleagueProjection> getCurrentMonthFieldColleague();

}
