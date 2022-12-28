package com.square.Inventory.Management.System.Controller;

import com.square.Inventory.Management.System.Entity.Depot;
import com.square.Inventory.Management.System.Repository.DepotRepository;
import com.square.Inventory.Management.System.Service.DepotService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/depot")
public class DepotController {
    private final DepotService depotService;
    private final DepotRepository depotRepository;

    public DepotController(DepotService depotService, DepotRepository depotRepository){
        this.depotService = depotService;
        this.depotRepository = depotRepository;
    }

    /**
     * add depots
     * @param depot something
     * @return something
     */
    @PostMapping("/addDepot")
    public ResponseEntity<Depot> addDepot(@RequestBody Depot depot){
        return new ResponseEntity<Depot>(depotService.addDepot(depot), HttpStatus.CREATED);
    }

    @PostMapping("/addDepotMain")
    public ResponseEntity<Depot> addDepotMain(@RequestBody Depot depot){
        return new ResponseEntity<Depot>(depotService. addDepotMain(depot), HttpStatus.CREATED);
    }

    @PutMapping("/editDepot/{id}")
    public ResponseEntity<Depot> editDepot(@PathVariable("id") Long id, @RequestBody Depot depot){
        return new ResponseEntity<Depot>(depotService.editDepot(id,depot), HttpStatus.OK);
    }

    @GetMapping("/viewDepot/{id}")
    public ResponseEntity<?> getDepotWithoutUser(@PathVariable("id") Long id) {
        Optional<Depot> depot = depotRepository.findById(id);
        if (depot.isPresent()) {
            Depot _depot = depot.get();
            return new ResponseEntity<Depot>(_depot, HttpStatus.OK);
        }
        return new ResponseEntity<String>("No Depot Found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/viewAllDepots")
    public ResponseEntity<List<Depot>> viewAllDepots(){
        return new ResponseEntity<List<Depot>>(depotRepository.findAll(),HttpStatus.OK);
    }

    @GetMapping("/viewAllDepotsPaginated")
    public ResponseEntity<?> viewAllDepotsPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue="10") int size) {
        return new ResponseEntity<>(depotService.viewDepotsPaginated(page,size),HttpStatus.OK);
    }

    @DeleteMapping("/deleteDepot/{id}")
    public ResponseEntity<?> deleteDepot(@PathVariable("id") Long id) {
        Optional<Depot> depot = depotRepository.findById(id);
        if (depot.isPresent()) {
            Depot _depot = depot.get();
            depotService.deleteDepot(_depot);
            return ResponseEntity.ok("Deleted");
        }
        return new ResponseEntity<String>("No Depot Found", HttpStatus.NOT_FOUND);
    }
}
