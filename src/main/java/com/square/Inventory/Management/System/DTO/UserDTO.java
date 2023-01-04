package com.square.Inventory.Management.System.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {

    private String firstName;

    private String lastName;

    private String contactNumber;

    private String email;

    private String password;

    private String role;

    private String status;

    public UserDTO(String firstName, String lastName,
                   String contactNumber, String email, String role, String status) {
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
