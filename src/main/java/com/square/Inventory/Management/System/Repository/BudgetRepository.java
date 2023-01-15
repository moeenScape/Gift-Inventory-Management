package com.square.Inventory.Management.System.Repository;

import com.square.Inventory.Management.System.DTO.BudgetSummary;
import com.square.Inventory.Management.System.DTO.CategoryWiseSummary;
import com.square.Inventory.Management.System.DTO.depotDtoForBudget;
import com.square.Inventory.Management.System.DTO.SSUDtoForBudget;
import com.square.Inventory.Management.System.Entity.Budget;
import com.square.Inventory.Management.System.Projection.BudgetMonthWiseSumProjection;
import com.square.Inventory.Management.System.Projection.BudgetSSUSummaryProjection;
import com.square.Inventory.Management.System.Projection.FieldColleagueProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {
    @Query("select new com.square.Inventory.Management.System.DTO.SSUDtoForBudget(b.budgetID,b.sapCode," +
            "b.productName,b.productionUnit,b.packageSize,b.category,b.sbu,b.fieldColleagueID,b.fieldColleagueName," +
            "b.quantity,b.depotID,b.depotName,b.month,b.year) from Budget " +
            "b where b.ssu_id=:ssuName AND b.month=:month AND b.year=:year")
    List<SSUDtoForBudget> getBudgetForSSUByName(@Param("ssuName") String ssuName,
                                                @Param("month") String month,
                                                @Param("year") Integer year);

    @Query("select new com.square.Inventory.Management.System.DTO.depotDtoForBudget(b.budgetID,b.sapCode," +
            "b.productName,b.productionUnit,b.packageSize,b.category,b.sbu,b.fieldColleagueID,b.fieldColleagueName," +
            "b.quantity,b.month,b.year) from Budget b where b.depotID =:depotID AND b.month=:month AND b.year=:year")
    List<depotDtoForBudget> getBudgetForDepotByID(@Param("depotID") String depotID,
                                                  @Param("month") String month,
                                                  @Param("year") Integer year);
    @Query("select new com.square.Inventory.Management.System.DTO.depotDtoForBudget(b.budgetID,b.sapCode," +
            "b.productName,b.productionUnit,b.packageSize,b.category,b.sbu,b.fieldColleagueID,b.fieldColleagueName," +
            "b.quantity,b.month,b.year) from Budget b where b.depotName =:depotName AND b.month=:month AND b.year=:year")
    List<depotDtoForBudget> getBudgetForDepotUser(@Param("depotName") String depotName,
                                                  @Param("month") String month,
                                                  @Param("year") Integer year);
    @Query(value = "SELECT budgetid,sap_code,product_name,deport_name,deportid,category," +
            "warehouse_name,month,year,sum(quantity) as sum FROM budget group by deportid", nativeQuery = true)
    List<BudgetSummary> getSummary();

    @Query(value = "select sum(case when category='PPU' then quantity else 0 end) as PPM," +
            "sum(case when category='Hiking' then quantity else 0 end) as Sample," +
            "sum(case when category='gift' then quantity else 0 end) as Gift from budget;", nativeQuery = true)
    CategoryWiseSummary getCategoryWiseSummary();

    @Query(value = "select depot_name as Category, sum(quantity) as Sum from budget group by depot_name", nativeQuery = true)
    List<CategoryWiseSummary> getCategoryWiseDepotSummary();

    @Query(value = "select distinct(ssu_id), sum(quantity) as Total, sum(is_inssu) as TotalInSSU, sum(is_depot_received) as TotalInDepot from budget group by ssu_id", nativeQuery = true)
    List<BudgetSSUSummaryProjection> getSSUSummary();

    @Query(value = "select month, sum(quantity) as sum from budget group by month", nativeQuery = true)
    List<BudgetMonthWiseSumProjection> getMonthWiseSum();

    @Query(value = "select count(distinct(field_colleagueid)) as total from budget where month=:month",nativeQuery = true)
    FieldColleagueProjection getCurrentMonthFieldColleague(@Param("month") String month);
}
