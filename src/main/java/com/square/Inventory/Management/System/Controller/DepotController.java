package com.square.Inventory.Management.System.Controller;

import com.square.Inventory.Management.System.DTO.DepotDTO;
import com.square.Inventory.Management.System.Entity.Depot;
import com.square.Inventory.Management.System.Projection.DepotProjectionInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/depot")
public interface DepotController {

    @PostMapping("/add")
    ResponseEntity<Depot> addDepot(@RequestBody DepotDTO depotDTO);

    @PutMapping("/edit")
    ResponseEntity<Depot> editDepot(@PathVariable("id") Long id, @RequestBody Depot depot);

    @GetMapping("/view/{id}")
    ResponseEntity<?> getDepotWithoutUser(@PathVariable("id") Long id);

    @GetMapping("/viewAll")
    ResponseEntity<List<Depot>> viewAllDepots();

    @GetMapping("/viewAllDepotsName")
    ResponseEntity<List<DepotProjectionInterface>> showAllDepotName();

    @GetMapping("/viewAllPaginated")
    ResponseEntity<?> viewAllDepotsPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue="10") int size);

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteDepot(@PathVariable("id") Long id);
}
