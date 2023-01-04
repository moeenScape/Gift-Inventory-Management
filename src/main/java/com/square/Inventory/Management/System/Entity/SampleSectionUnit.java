package com.square.Inventory.Management.System.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SampleSectionUnit {
    @Id
    @Column(name = "ssuID")
    private Integer ssuID;

    @Column(name = "ssuName")
    private String ssuName;

    @Column(name = "location")
    private String location;

    @Column(name = "numberOfEmployee")
    private Integer numberOfEmployee;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
