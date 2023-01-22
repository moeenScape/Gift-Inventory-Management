package com.square.Inventory.Management.System.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@Entity
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String budgetId;

    @Column
    private String sapCode;

    @Column
    private String productName;
    @Column
    private String productionUnit;

    @Column
    private String packageSize;

    @Enumerated(EnumType.STRING)
    @Column
    private SBU sbu;

    @Column
    private String fieldColleagueId;

    @Column
    private String fieldColleagueName;

    @Column
    private int quantity;

    @Column
    private String depotName;

    @Column
    private String depotId;

    @Pattern(regexp = "^(ppm|sample|gift|PPM|SAMPLE|GIFT|Ppm|Sample|Gift)$", message = "unknown category inserted")
    @Column
    private String category;

    @Column
    private String month;

    @Column
    private int year;

    @Column
    private String ssuId;

    @Column(columnDefinition = "boolean default false")
    private boolean isDepotReceived = false;

    @Column(columnDefinition = "boolean default true")
    private boolean isInSSU = true;

}
