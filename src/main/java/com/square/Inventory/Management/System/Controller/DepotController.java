package com.square.Inventory.Management.System.Controller;

import com.square.Inventory.Management.System.DTO.DepotDto;
import com.square.Inventory.Management.System.Entity.Depot;
import com.square.Inventory.Management.System.Projection.DepotProjectionInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/depot")
public interface DepotController {

    @PostMapping("/add")
    ResponseEntity<DepotDto> addDepot(@RequestBody DepotDto depotDto);

    @PutMapping("/edit")
    ResponseEntity<DepotDto> editDepot(@RequestBody DepotDto depotDto);

    @GetMapping("/view/{id}")
    ResponseEntity<?> getDepot(@PathVariable("id") Long id);

    @GetMapping("/viewAll")
    ResponseEntity<List<DepotDto>> viewAllDepots();

    @GetMapping("/viewAllName")
    ResponseEntity<List<DepotProjectionInterface>> showAllDepotName();

    @GetMapping("/viewAllPaginated")
    ResponseEntity<?> viewAllDepotsPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue="10") int size);

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteDepot(@PathVariable("id") Long id);
}
