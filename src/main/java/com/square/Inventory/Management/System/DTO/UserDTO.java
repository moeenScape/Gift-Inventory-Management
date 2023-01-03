package com.square.Inventory.Management.System.DTO;

import com.square.Inventory.Management.System.Entity.User;
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

//    public User userConverter(User user)
//    {
//        User user1=new User();
//        user1.setFirstName(user.getFirstName());
//        user1.setLastName(user.getLastName());
//        user1.setContactNumber(user.getContactNumber());
//        return user1;
//    };
}
