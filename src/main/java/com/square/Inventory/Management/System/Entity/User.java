package com.square.Inventory.Management.System.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;

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

    @Pattern(regexp = "^(?:\\+?88)?01[15-9]\\d{8}$")
    @Column(name = "contractNumber")
    private String contactNumber;

    @Email
    @Column(name = "email")
    private String email;

    @NotBlank(message = "mandatory")
    @Column(name = "password")
    private String password;

    @NotBlank(message = "role mandatory")
    @Column(name = "role")
    private String role;

    @Column(name = "status")
    private String  status;

}
