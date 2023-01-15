package com.square.Inventory.Management.System.ControllerImpl;

import com.square.Inventory.Management.System.Controller.DepotController;
import com.square.Inventory.Management.System.DTO.DepotDto;
import com.square.Inventory.Management.System.Entity.Depot;
import com.square.Inventory.Management.System.JWT.JWTFilter;
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

    private final JWTFilter jwtFilter;

    public DepotControllerImpl(DepotService depotService, DepotRepository depotRepository, JWTFilter jwtFilter) {
        this.depotService = depotService;
        this.depotRepository = depotRepository;
        this.jwtFilter = jwtFilter;
    }

    /**
     * add depots with or without user!!
     *
     * @param depotDto object
     * @return an depot Object
     */
    @Override
    public ResponseEntity<DepotDto> addDepot(@RequestBody DepotDto depotDto) {
        if (jwtFilter.isAdmin()) {
            Depot depot = depotService.addDepot(depotDto);

            return ResponseEntity.ok(depotDto.convertDepotDTO(depot, depot.getUser()));
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    public ResponseEntity<DepotDto> editDepot(@RequestBody DepotDto depotDTO) {
        if (jwtFilter.isAdmin()) {
            return ResponseEntity.ok(depotService.editDepot(depotDTO));
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    public ResponseEntity<?> getDepot(@PathVariable("id") Long id) {
        if (jwtFilter.isAdmin()) {
            Optional<Depot> depot = depotRepository.findById(id);

            if (depot.isPresent()) {
                return ResponseEntity.ok(depot.get());
            }

            return new ResponseEntity<>("No Depot Found", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    public ResponseEntity<List<DepotDto>> viewAllDepots() {
        if (jwtFilter.isAdmin()) {
            return ResponseEntity.ok(depotService.viewAllDepots());
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * this api don't have any usage on this version. As the name suggests
     * it handles the pagination mechanism properly.
     *
     * @param page int
     * @param size int
     * @return a list of Depots object
     */
    @Override
    public ResponseEntity<?> viewAllDepotsPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        if (jwtFilter.isAdmin()) {
            return ResponseEntity.ok(depotService.viewDepotsPaginated(page, size));
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * this api don't have any usage now. But this api was done if admin wants all depots' name and locations only.
     *
     * @return a list of DepotProjection objects
     */
    @Override
    public ResponseEntity<List<DepotProjectionInterface>> showAllDepotName() {
        if (jwtFilter.isAdmin()) {
            return ResponseEntity.ok(depotService.showAllDepotName());
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    public ResponseEntity<?> deleteDepot(@PathVariable("id") Long id) {
        if (jwtFilter.isAdmin()) {
            Optional<Depot> depot = depotRepository.findById(id);

            if (depot.isPresent()) {
                Depot _depot = depot.get();

                depotService.deleteDepot(_depot);
                return ResponseEntity.ok("Deleted");
            }

            return new ResponseEntity<>("No Depot Found", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

}
