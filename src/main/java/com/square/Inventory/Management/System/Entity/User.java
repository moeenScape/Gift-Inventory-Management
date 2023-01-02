package com.square.Inventory.Management.System.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "userID")
    private Integer userID;

    @Column(name = "firstName")
    @NotNull
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "contractNumber")
    private String contactNumber;

    @Email
    @Column(name = "email")
    private String email;

    @NotBlank(message = "password is mandatory")
    @Column(name = "password")
    private String password;

    @NotBlank(message = "role mandatory")
    @Column(name = "role")
    private String role;

    @Column(name = "status")
    private String status;

}
