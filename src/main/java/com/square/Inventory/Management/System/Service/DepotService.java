package com.square.Inventory.Management.System.Service;

import com.square.Inventory.Management.System.DTO.DepotDto;
import com.square.Inventory.Management.System.Entity.Depot;
import com.square.Inventory.Management.System.Entity.User;
import com.square.Inventory.Management.System.Projection.DepotProjectionInterface;
import com.square.Inventory.Management.System.Repository.DepotRepository;
import com.square.Inventory.Management.System.Repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@Service
public class DepotService {
    private final DepotRepository depotRepository;
    private final UserRepository userRepository;

    public DepotService(DepotRepository depotRepository, UserRepository userRepository) {
        this.depotRepository = depotRepository;
        this.userRepository = userRepository;
    }

    public Depot addDepot(DepotDto depotDto) {
        Long userId = depotDto.getUser_id();

        Depot depot = new Depot();

        if (userId == null) {
            depot.setDepotName(depotDto.getDepotName());
            depot.setLocation(depotDto.getLocation());

            return depotRepository.save(depot);
        } else {
            Optional<User> user = userRepository.findById(userId);

            if (user.isPresent()) {
                depot = depotDto.convertDepot(depotDto, user.get());

                return depotRepository.save(depot);
            } else {
                return null; // todo need improvement
            }
        }
    }

    public DepotDto editDepot(DepotDto depotDto) {
        Depot depot = depotRepository.findById(depotDto.getId()).orElseThrow(NoSuchElementException::new); // todo custom exception

        depot.setDepotName(depotDto.getDepotName());
        depot.setLocation(depotDto.getLocation());
        User user = null;
        if (depotDto.getUser_id() != null) {
            user = userRepository.findById(depotDto.getUser_id()).orElseThrow(NoSuchElementException::new);
            depot = depotDto.convertDepot(depotDto, user);
        }

        depot = depotRepository.save(depot); // todo response should be a dto ... not entity
        depotDto = depotDto.convertDepotDTO(depot, user);
        return depotDto;
    }

    public void deleteDepot(Depot depot) {
        depotRepository.delete(depot);
    }

    public List<Depot> viewDepotsPaginated(int page, int size) {
        List<Depot> depots = new ArrayList<Depot>();
        Pageable paging = PageRequest.of(page, size);
        Page<Depot> pageDepots = depotRepository.findAll(paging);
        depots = pageDepots.getContent();

        //to show all the values in dictionary format
//        Map<String, Object> response = new HashMap<>();
//        response.put("depots", depots);
//        return new ResponseEntity<>(response,HttpStatus.OK);

        // to show all the values in list format
        return depots;
    }

    public List<DepotDto> viewAllDepots() {
        List<Depot> allDepots = new ArrayList<>();
        DepotDto _depotDto = new DepotDto();
        User _user;

        allDepots = depotRepository.findAll();
        int len = allDepots.size();
        List<DepotDto> allDepotsDto = new ArrayList<>(len);

        for (Depot allDepot : allDepots) {
            _user = allDepot.getUser();
            allDepotsDto.add(_depotDto.convertDepotDTO(allDepot, _user));
        }
        return allDepotsDto;
    }

    public List<DepotProjectionInterface> showAllDepotName() {
        return depotRepository.getAllDepotName();
    }

}
