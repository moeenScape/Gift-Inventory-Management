package com.square.Inventory.Management.System.ControllerImpl;

import com.square.Inventory.Management.System.Controller.DepotController;
import com.square.Inventory.Management.System.Entity.Depot;
import com.square.Inventory.Management.System.Repository.DepotRepository;
import com.square.Inventory.Management.System.Service.DepotService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepotControllerImpl implements DepotController {
    private final DepotService depotService;
    private final DepotRepository depotRepository;

    public DepotControllerImpl(DepotService depotService, DepotRepository depotRepository){
        this.depotService = depotService;
        this.depotRepository = depotRepository;
    }

    /**
     * add depots
     * @param depot something
     * @return something
     */
    @Override
    public ResponseEntity<Depot> addDepot(@RequestBody Depot depot){
        return new ResponseEntity<Depot>(depotService.addDepot(depot), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Depot> addDepotMain(@RequestBody Depot depot){
        return new ResponseEntity<Depot>(depotService. addDepotMain(depot), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Depot> editDepot(@PathVariable("id") Long id, @RequestBody Depot depot){
        return new ResponseEntity<Depot>(depotService.editDepot(id,depot), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getDepotWithoutUser(@PathVariable("id") Long id) {
        Optional<Depot> depot = depotRepository.findById(id);
        if (depot.isPresent()) {
            Depot _depot = depot.get();
            return new ResponseEntity<Depot>(_depot, HttpStatus.OK);
        }
        return new ResponseEntity<String>("No Depot Found", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<Depot>> viewAllDepots(){
        return new ResponseEntity<List<Depot>>(depotRepository.findAll(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> viewAllDepotsPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue="10") int size) {
        return new ResponseEntity<>(depotService.viewDepotsPaginated(page,size),HttpStatus.OK);
    }

    @Override
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
