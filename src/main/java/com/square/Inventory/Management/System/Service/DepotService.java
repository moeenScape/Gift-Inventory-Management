package com.square.Inventory.Management.System.Service;

import com.square.Inventory.Management.System.DTO.DepotDTO;
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
import java.util.Optional;

@Service
public class DepotService {
    private final DepotRepository depotRepository;
    private final UserRepository userRepository;

    public DepotService(DepotRepository depotRepository, UserRepository userRepository){
        this.depotRepository = depotRepository;
        this.userRepository = userRepository;
    }

    public Depot addDepot(DepotDTO depotDTO) {
        Integer user_id = depotDTO.getUser_id();

        Depot depot = new Depot();

        if (user_id == null) {
            depot.setDepotName(depotDTO.getDepotName());
            depot.setLocation(depotDTO.getLocation());

            return depotRepository.save(depot);
        } else {
            Optional<User> user = userRepository.findById(user_id);

            if (user.isPresent()) {
                depot = depotDTO.convertDepot(depotDTO, user.get());

                return depotRepository.save(depot);
            } else {
                return null; // todo need improvement
            }
        }
    }

    public Depot addDepotMain(Depot getFullDepot) {
        Depot depot = new Depot();
        depot.setLocation(getFullDepot.getLocation());
        depot.setDepotName(getFullDepot.getDepotName());
        depot.setUser(getFullDepot.getUser());

        return depotRepository.save(depot);
    }

    public Depot editDepot(Long id, Depot givenDepot) {
        Optional<Depot> depot = depotRepository.findById(id);
        if (depot.isPresent()) {
            Depot changeDepot = depot.get();
            changeDepot.setDepotName(givenDepot.getDepotName());
            changeDepot.setLocation(givenDepot.getLocation());
            depotRepository.save(changeDepot);
            return changeDepot;
        } else {
            System.out.println("Invalid Id given");
            return null;
        }
    }

    public void deleteDepot(Depot _depot){
        depotRepository.delete(_depot);
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

    public List<DepotProjectionInterface> showAllDepotName(){
        return depotRepository.getAllDepotName();
    }

}
