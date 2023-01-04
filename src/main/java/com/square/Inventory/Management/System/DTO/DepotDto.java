package com.square.Inventory.Management.System.DTO;

import com.square.Inventory.Management.System.Entity.Depot;
import com.square.Inventory.Management.System.Entity.User;

import javax.validation.constraints.NotNull;

public class DepotDto {
    private long id;

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

    public long getId() {
        return id;
    }

    public Depot convertDepot(DepotDto depotDTO, User user) {
        Depot depot = new Depot();

        depot.setDepotName(depotDTO.getDepotName());
        depot.setLocation(depotDTO.getLocation());
        depot.setUser(user);

        return depot;
    }

    public DepotDto convertDepotDTO(Depot depot, User user) {
        DepotDto depotDTO = new DepotDto();

        depotDTO.setDepotName(depot.getDepotName());
        depotDTO.setLocation(depot.getLocation());
        depotDTO.setUser_id(user.getId());

        return depotDTO;
    }

}

