package com.square.Inventory.Management.System.Repository;

import com.square.Inventory.Management.System.DTO.BudgetSummary;
import com.square.Inventory.Management.System.DTO.CategoryWiseSummary;
import com.square.Inventory.Management.System.DTO.DEPOT;
import com.square.Inventory.Management.System.DTO.SSU;
import com.square.Inventory.Management.System.Entity.Budget;
import com.square.Inventory.Management.System.Projection.BudgetProjectionInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {
    @Query("select new com.square.Inventory.Management.System.DTO.SSU(b.budgetID,b.sapCode," +
            "b.productName,b.productionUnit,b.packageSize,b.category,b.fieldColleagueID,b.fieldColleagueName," +
            "b.quantity,b.DepotID,b.depotName,b.month,b.year) from Budget " +
            "b where b.ssu_id=:ssuName")
    List<SSU> getBudgetForSSUByName(@Param("ssuName") String ssuName);

    @Query("select new com.square.Inventory.Management.System.DTO.DEPOT(b.budgetID,b.sapCode," +
            "b.productName,b.productionUnit,b.packageSize,b.category,b.fieldColleagueID,b.fieldColleagueName," +
            "b.quantity,b.month,b.year) from Budget b where b.DepotID =:depotID")
    List<DEPOT> getBudgetForDepotByID(@Param("depotID") String depotID);

    @Query(value = "SELECT budgetid,sap_code,product_name,deport_name,deportid,category," +
            "warehouse_name,month,year,sum(quantity) as sum FROM budget group by deportid",nativeQuery = true)
    List<BudgetSummary> getSummary();

    @Query(value = "select category as Category,sum(quantity) as SUM from budget group by category;",nativeQuery = true)
    List<CategoryWiseSummary> getCategoryWiseSummary();

    @Query(value = "select depot_name as Category, sum(quantity) as Sum from budget group by depot_name", nativeQuery = true)
    List<CategoryWiseSummary> getCategoryWiseDepotSummary();
}
