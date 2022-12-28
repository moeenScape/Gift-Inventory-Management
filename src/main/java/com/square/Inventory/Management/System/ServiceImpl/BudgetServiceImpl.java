package com.square.Inventory.Management.System.ServiceImpl;

import com.poiji.bind.Poiji;
import com.square.Inventory.Management.System.Entity.Budget;
import com.square.Inventory.Management.System.ExcelHepler.BudgetDTO;
import com.square.Inventory.Management.System.Repository.BudgetRepository;
import com.square.Inventory.Management.System.Service.BudgetService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class BudgetServiceImpl implements BudgetService {
    private final BudgetRepository budgetRepository;

    public BudgetServiceImpl(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    @Override
    public List<BudgetDTO> getAllBudgetFromExcel() {
        List<BudgetDTO> budgets = Poiji.fromExcel(new File("sample_budget.xlsx"), BudgetDTO.class);
//        int length = budgets.size();
        return new ArrayList<BudgetDTO>(budgets);
    }

    @Override
    public List<Budget> addBudgetFromExcel() {
        List<BudgetDTO> budgetDTO = Poiji.fromExcel(new File("sample_budget.xlsx"), BudgetDTO.class);
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
}
