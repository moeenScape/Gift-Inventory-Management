package com.square.Inventory.Management.System.Controller;

import com.square.Inventory.Management.System.DTO.CategoryWiseSummary;
import com.square.Inventory.Management.System.Projection.ActivatedDeactivatedUser;
import com.square.Inventory.Management.System.Projection.BudgetMonthWiseSumProjection;
import com.square.Inventory.Management.System.Projection.FieldColleagueProjection;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequestMapping(path = "/dashboard")
public interface DashboardController {
    @GetMapping(path = "/user")
    ResponseEntity<ActivatedDeactivatedUser> getActiveDeactivateUser();

    @GetMapping("/monthWiseSum")
    ResponseEntity<List<BudgetMonthWiseSumProjection>> getMonthWiseSum();

    @GetMapping("/totalFieldColleague")
    ResponseEntity<FieldColleagueProjection> getCurrentMonthFieldColleague();

    @GetMapping(path = "/categoryWiseSummary")
    ResponseEntity<CategoryWiseSummary> getCategoryWiseSummary();
}
