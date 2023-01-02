package com.square.Inventory.Management.System.Projection;

public interface BudgetSSUSummaryProjection {
    String getSsu_id();
    Integer getTotal();
    Integer getTotalInSSU();
    Integer getTotalInDepot();
}