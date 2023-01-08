package com.square.Inventory.Management.System.Repository;

import com.square.Inventory.Management.System.Entity.Depot;
import com.square.Inventory.Management.System.Projection.DepotProjectionInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepotRepository extends JpaRepository<Depot,Long> {

    @Query(value = "select depot_name,location from depot", nativeQuery = true)
    List<DepotProjectionInterface> getAllDepotName();

    @Query(value = "select depot_name from depot where user_id=:id",nativeQuery = true)
    String getDepotID(@Param("id") Long id);
}
