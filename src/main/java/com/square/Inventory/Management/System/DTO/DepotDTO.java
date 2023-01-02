package com.square.Inventory.Management.System.DTO;

import com.square.Inventory.Management.System.Entity.Depot;

public class DepotDTO {
    private String depotName;
    private String location;
    private String user_id;

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

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Depot convertDepot(DepotDTO depotDTO) {
        Depot depot = new Depot();
        depot.setDepotName(depotDTO.getDepotName());
//        depot.setUser(depotDTO.getUser_id());
        depot.setLocation(depotDTO.getLocation());
        return depot;
    }

    public DepotDTO convertDepotDTO(Depot depot) {
        DepotDTO depotDTO = new DepotDTO();
        depotDTO.setDepotName(depot.getDepotName());
        depotDTO.setLocation(depot.getLocation());
//        depotDTO.setUser_id(depot.get);
        return depotDTO;
    }

}

