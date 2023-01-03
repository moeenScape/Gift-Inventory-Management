package com.square.Inventory.Management.System.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Integer userID;

    private String firstName;

    private String lastName;

    private String contactNumber;

    private String email;

    private String  role;

    private String status;
}
