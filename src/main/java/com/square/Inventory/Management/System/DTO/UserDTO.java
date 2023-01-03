package com.square.Inventory.Management.System.DTO;

import com.square.Inventory.Management.System.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String firstName;

    private String lastName;

    private String contactNumber;

    @Email(message = "Valid Email")
    private String email;

    @NotBlank(message = "Password Mandatory")
    private String password;

    @NotBlank(message = "Role Mandatory")
    private String role;

    private String status;


}
