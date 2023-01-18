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
    private Long userId;

    private String adminName;

    private String contactNumber;

    private String email;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Depot convertDepot(DepotDto depotDto, User user) {
        Depot depot = new Depot();

        depot.setId(depotDto.getId());
        depot.setDepotName(depotDto.getDepotName());
        depot.setLocation(depotDto.getLocation());
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

        depotDto.setUserId(user.getId());
        depotDto.setAdminName(user.getFirstName() + ' ' + user.getLastName());
        depotDto.setEmail(user.getEmail());
        depotDto.setContactNumber(user.getContactNumber());

        return depotDto;
    }

}

