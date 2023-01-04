package com.square.Inventory.Management.System.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class UserDTO {

    private Integer id;
    private String firstName;

    private String lastName;

    private String contactNumber;
    @Email
    private String email;

    @NotBlank(message = "Password is mandatory")
    private String password;

    @NotBlank(message = "role is mandatory")
    private String role;

    private String status;

    public UserDTO(Integer id, String firstName, String lastName,
                   String contactNumber, String email, String role, String status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.email = email;
        this.role = role;
        this.status = status;
    }

    public UserDTO() {

    }
}
