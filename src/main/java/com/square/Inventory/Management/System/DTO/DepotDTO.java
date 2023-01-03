package com.square.Inventory.Management.System.DTO;

import com.square.Inventory.Management.System.Entity.Depot;
import com.square.Inventory.Management.System.Entity.User;

import javax.validation.constraints.NotNull;

public class DepotDTO {
    @NotNull
    private String depotName;
    @NotNull
    private String location;
    private Integer user_id;

    public String getDepotName() {
        return depotName;
    }

    public void setDepotName(String depotName) {
        this.depotName = depotName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Depot convertDepot(DepotDTO depotDTO, User user) {
        Depot depot = new Depot();
        depot.setDepotName(depotDTO.getDepotName());
        depot.setLocation(depotDTO.getLocation());
        depot.setUser(user);
        return depot;
    }

    public DepotDTO convertDepotDTO(Depot depot, User user) {
        DepotDTO depotDTO = new DepotDTO();
        depotDTO.setDepotName(depot.getDepotName());
        depotDTO.setLocation(depot.getLocation());
        depotDTO.setUser_id(user.getId());
        return depotDTO;
    }

}

