package com.square.Inventory.Management.System.Repository;

import com.example.inventory_project.entity.Budget;
import com.example.inventory_project.projection.BudgetProjectionInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {
    @Query(value = "select depotName,sum(quantity) as sum from Budget group by depotName", nativeQuery = true)
    List<BudgetProjectionInterface> getDepotWiseProductSum();
}
