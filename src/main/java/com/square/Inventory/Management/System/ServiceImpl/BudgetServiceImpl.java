package com.square.Inventory.Management.System.ServiceImpl;

import com.poiji.bind.Poiji;
import com.square.Inventory.Management.System.DTO.BudgetSummary;
import com.square.Inventory.Management.System.DTO.CategoryWiseSummary;
import com.square.Inventory.Management.System.DTO.DEPOT;
import com.square.Inventory.Management.System.DTO.SSU;
import com.square.Inventory.Management.System.Entity.Budget;
import com.square.Inventory.Management.System.ExcelHepler.BudgetDTO;
import com.square.Inventory.Management.System.ExcelHepler.ExcelHelper;
import com.square.Inventory.Management.System.Repository.BudgetRepository;
import com.square.Inventory.Management.System.Service.BudgetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BudgetServiceImpl implements BudgetService {
    private final BudgetRepository budgetRepository;

    public BudgetServiceImpl(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    @Override
    public List<BudgetDTO> getAllBudgetFromExcel() {
        List<BudgetDTO> budgets = Poiji.fromExcel(new File("sample_budget.xlsx"), BudgetDTO.class);
        return new ArrayList<BudgetDTO>(budgets);
    }

    @Override
    public List<Budget> addBudgetFromExcel(MultipartFile file) {
        String filename = file.getOriginalFilename();
//        log.info(filename);
        assert filename != null;
        List<BudgetDTO> budgetDTO = Poiji.fromExcel(new File(filename), BudgetDTO.class);
        List<Budget> allBudget = new ArrayList<>();
        int len = budgetDTO.size();
        for (int i = 0; i < len; i++) {
            BudgetDTO _budgetDTO = budgetDTO.get(i);
            Budget _budget = new Budget();
            _budget.setSapCode(_budgetDTO.getSapCode());
            _budget.setBudgetID(_budgetDTO.getBudgetID());
            _budget.setProductName(_budgetDTO.getProductName());
            _budget.setProductionUnit(_budgetDTO.getProductionUnit());
            _budget.setPackageSize(_budgetDTO.getPackageSize());
            _budget.setSbu(_budgetDTO.getSbu());
            _budget.setFieldColleagueID(_budgetDTO.getFieldColleagueID());
            _budget.setFieldColleagueName(_budgetDTO.getFieldColleagueName());
            _budget.setQuantity(_budgetDTO.getQuantity());
            _budget.setDepotName(_budgetDTO.getDepotName());
            _budget.setDepotID(_budgetDTO.getDepotID());
            _budget.setCategory(_budgetDTO.getCategory());
            _budget.setMonth(_budgetDTO.getMonth());
            _budget.setYear(_budgetDTO.getYear());
            _budget.setSsu_id(_budgetDTO.getSsu_id());
            budgetRepository.save(_budget);
            allBudget.add(_budget);
        }
        return allBudget;
    }

    private String getCurrentMonth() {
        LocalDate currentDate = LocalDate.now();
        String currentMonth = currentDate.getMonth().name();
        return currentMonth;
    }

    @Override
    public ResponseEntity<List<SSU>> getBudgetForSSUByName(String ssuName) {

        List<SSU> ssuList = budgetRepository.getBudgetForSSUByName(ssuName);

        return new ResponseEntity<>(ssuList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<DEPOT>> getBudgetForDepotByID(String depotID) {

        List<DEPOT> depotList = budgetRepository.getBudgetForDepotByID(depotID);

        return new ResponseEntity<>(depotList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Budget> viewAllBudgetByMonth(String month) {
        month = getCurrentMonth();

        return null;
    }

    @Override
    public ResponseEntity<List<Budget>> getAllBudget() {
        List<Budget> budgetList = budgetRepository.findAll();
        return new ResponseEntity<>(budgetList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<BudgetSummary>> getSummary() {
        List<BudgetSummary> budgetSummaryList = budgetRepository.getSummary();
        return new ResponseEntity<>(budgetSummaryList, HttpStatus.OK);
    }

    @Override
    public void saveFromUpload(MultipartFile file) {
        try {
            List<Budget> budgetList = ExcelHelper.excelToBudget(file.getInputStream());
            budgetList.removeIf(budget -> (budget.getBudgetID() == null
                    || budget.getDepotID() == null));
            budgetRepository.saveAll(budgetList);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<List<CategoryWiseSummary>> getCategoryWiseSummary() {
        List<CategoryWiseSummary> categoryWiseSummaryList = budgetRepository.getCategoryWiseSummary();
        return new ResponseEntity<>(categoryWiseSummaryList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CategoryWiseSummary>> getCategoryWiseSummaryDepot() {
        List<CategoryWiseSummary> categoryWiseSummaryList = budgetRepository.getCategoryWiseDepotSummary();
        return new ResponseEntity<>(categoryWiseSummaryList, HttpStatus.OK);
    }
}
