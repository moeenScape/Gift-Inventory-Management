package com.square.Inventory.Management.System.DTO;

import com.square.Inventory.Management.System.Entity.Depot;
import com.square.Inventory.Management.System.Entity.User;

import javax.validation.constraints.NotNull;

public class DepotDto {
    private Long id;

    @NotNull
    private String depotName;
    @NotNull
    private String location;
    private Long user_id;

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

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Depot convertDepot(DepotDto depotDTO, User user) {
        Depot depot = new Depot();

        depot.setId(depotDTO.getId());
        depot.setDepotName(depotDTO.getDepotName());
        depot.setLocation(depotDTO.getLocation());
        depot.setUser(user);

        return depot;
    }

    public DepotDto convertDepotDTO(Depot depot, User user) {
        DepotDto depotDto = new DepotDto();

        depotDto.setId(depot.getId());
        depotDto.setDepotName(depot.getDepotName());
        depotDto.setLocation(depot.getLocation());

        if (user == null) {
            return depotDto;
        }

        depotDto.setUser_id(user.getId());
        return depotDto;
    }

}

