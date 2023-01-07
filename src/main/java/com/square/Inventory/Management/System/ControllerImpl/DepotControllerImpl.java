package com.square.Inventory.Management.System.ControllerImpl;

import com.square.Inventory.Management.System.Controller.DepotController;
import com.square.Inventory.Management.System.DTO.DepotDto;
import com.square.Inventory.Management.System.Entity.Depot;
import com.square.Inventory.Management.System.Projection.DepotProjectionInterface;
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

    public DepotControllerImpl(DepotService depotService, DepotRepository depotRepository) {
        this.depotService = depotService;
        this.depotRepository = depotRepository;
    }

    /**
     * add depots with or without user!!
     *
     * @param depotDto object
     * @return an depot Object
     */
    @Override
    public ResponseEntity<DepotDto> addDepot(@RequestBody DepotDto depotDto) {
        Depot depot = depotService.addDepot(depotDto);
        return ResponseEntity.ok(depotDto.convertDepotDTO(depot, depot.getUser()));
    }

    @Override
    public ResponseEntity<DepotDto> editDepot(@RequestBody DepotDto depotDTO) {
        return ResponseEntity.ok(depotService.editDepot(depotDTO));
    }

    @Override
    public ResponseEntity<?> getDepot(@PathVariable("id") Long id) {
        Optional<Depot> depot = depotRepository.findById(id);
        if (depot.isPresent()) {
            return ResponseEntity.ok(depot.get());
        }
        return new ResponseEntity<String>("No Depot Found", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<Depot>> viewAllDepots() {
        return new ResponseEntity<List<Depot>>(depotRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> viewAllDepotsPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return new ResponseEntity<>(depotService.viewDepotsPaginated(page, size), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<DepotProjectionInterface>> showAllDepotName() {
        return new ResponseEntity<>(depotService.showAllDepotName(), HttpStatus.OK);
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
