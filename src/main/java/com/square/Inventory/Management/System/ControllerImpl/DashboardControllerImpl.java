package com.square.Inventory.Management.System.ControllerImpl;

import com.square.Inventory.Management.System.Controller.DashboardController;
import com.square.Inventory.Management.System.DTO.CategoryWiseSummary;
import com.square.Inventory.Management.System.JWT.JWTFilter;
import com.square.Inventory.Management.System.Projection.ActivatedDeactivatedUser;
import com.square.Inventory.Management.System.Projection.BudgetMonthWiseSumProjection;
import com.square.Inventory.Management.System.Projection.FieldColleagueProjection;
import com.square.Inventory.Management.System.Service.BudgetService;
import com.square.Inventory.Management.System.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class DashboardControllerImpl implements DashboardController {

    private final UserService userService;

    private final BudgetService budgetService;

    private final JWTFilter jwtFilter;

    public DashboardControllerImpl(UserService userService, BudgetService budgetService, JWTFilter jwtFilter) {
        this.userService = userService;
        this.budgetService = budgetService;
        this.jwtFilter = jwtFilter;
    }

    @Override
    public ResponseEntity<ActivatedDeactivatedUser> getActiveDeactivateUser() {
        return userService.getActiveDeactivateUser();
    }

    @Override
    public ResponseEntity<List<BudgetMonthWiseSumProjection>> getMonthWiseSum() {
        return budgetService.getMonthWiseSum();
    }

    @Override
    public ResponseEntity<FieldColleagueProjection> getCurrentMonthFieldColleague() {
        return budgetService.getCurrentMonthFieldColleague();
    }
    @Override
    public ResponseEntity<CategoryWiseSummary> getCategoryWiseSummary() {
        if(jwtFilter.isAdmin()) {
            return budgetService.getCategoryWiseSummary();
        } return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }
}
