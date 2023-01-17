package com.square.Inventory.Management.System.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SampleSectionUnit {
    @Id
    @NotNull(message = "Sample Section Unit ID is mandatory")
    private Long ssuID;

    @NotNull(message = "SAmple Section Unit is mandatory")
    private String ssuName;

    @NotNull(message = "Location is mandatory")
    private String location;

    private Integer numberOfEmployee;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getSsuID() {
        return ssuID;
    }

    public void setSsuID(Long ssuID) {
        this.ssuID = ssuID;
    }

    public String getSsuName() {
        return ssuName;
    }

    public void setSsuName(String ssuName) {
        this.ssuName = ssuName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getNumberOfEmployee() {
        return numberOfEmployee;
    }

    public void setNumberOfEmployee(Integer numberOfEmployee) {
        this.numberOfEmployee = numberOfEmployee;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
