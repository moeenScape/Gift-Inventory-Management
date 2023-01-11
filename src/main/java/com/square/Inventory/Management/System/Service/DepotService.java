package com.square.Inventory.Management.System.Service;

import com.square.Inventory.Management.System.DTO.DepotDto;
import com.square.Inventory.Management.System.Entity.Depot;
import com.square.Inventory.Management.System.Projection.DepotProjectionInterface;
import java.util.List;

public interface DepotService {
    Depot addDepot(DepotDto depotDto);

    DepotDto editDepot(DepotDto depotDto);

    List<Depot> viewDepotsPaginated(int page, int size);

    List<DepotDto> viewAllDepots();

    List<DepotProjectionInterface> showAllDepotName();

    void deleteDepot(Depot depot);
}
