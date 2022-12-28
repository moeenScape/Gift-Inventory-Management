package com.square.Inventory.Management.System.Repository;

import com.square.Inventory.Management.System.Entity.Depot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepotRepository extends JpaRepository<Depot,Long> {
}
