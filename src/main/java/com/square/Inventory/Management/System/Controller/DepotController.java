package com.square.Inventory.Management.System.Controller;

import com.square.Inventory.Management.System.DTO.DepotDTO;
import com.square.Inventory.Management.System.Entity.Depot;
import com.square.Inventory.Management.System.Projection.DepotProjectionInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/depot")
public interface DepotController {

    @PostMapping("/addDepot")
    ResponseEntity<Depot> addDepot(@RequestBody DepotDTO depotDTO);

    @PostMapping("/addDepotMain")
    ResponseEntity<Depot> addDepotMain(@RequestBody Depot depot);

    @PutMapping("/editDepot/{id}")
    ResponseEntity<Depot> editDepot(@PathVariable("id") Long id, @RequestBody Depot depot);

    @GetMapping("/viewDepot/{id}")
    ResponseEntity<?> getDepotWithoutUser(@PathVariable("id") Long id);

    @GetMapping("/viewAllDepots")
    ResponseEntity<List<Depot>> viewAllDepots();

    @GetMapping("/viewAllDepotsName")
    ResponseEntity<List<DepotProjectionInterface>> showAllDepotName();

    @GetMapping("/viewAllDepotsPaginated")
    ResponseEntity<?> viewAllDepotsPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue="10") int size);

    @DeleteMapping("/deleteDepot/{id}")
    ResponseEntity<?> deleteDepot(@PathVariable("id") Long id);
}
