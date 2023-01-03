package com.square.Inventory.Management.System.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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
