package com.square.Inventory.Management.System.Repository;

import com.square.Inventory.Management.System.Entity.LogInDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogInHistoryRepository extends JpaRepository<LogInDetails,Long>{
}
