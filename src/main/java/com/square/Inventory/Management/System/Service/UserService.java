package com.square.Inventory.Management.System.Service;

import com.square.Inventory.Management.System.DTO.UserDTO;
import com.square.Inventory.Management.System.Projection.ActivatedDeactivatedUser;
import com.square.Inventory.Management.System.Entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    ResponseEntity<?> createUser(UserDTO user);

    ResponseEntity<?> login(UserDTO userDTO);

    ResponseEntity<String> disableUser(Long userId);

    //List<UserDTO> getAllUserByPagination(int page, int size);
    List<UserDTO> getAllUsers();

    List<UserDTO> getAllUserByPaginationBySort(int page, int size, String sortBy);

    ResponseEntity<?> update(UserDTO userDTO, Long userId);

    ResponseEntity<?> updateUserRole(String role,Long userID);

    ResponseEntity<?> updateUserStatus(String status, Long userID);

    List<String> getClaimDetails();

    Object getClaimFromLogin();

    ResponseEntity<?> forgetPassword(User user);

    Boolean checkOtpStatus(User user, String givenOtp);

    ResponseEntity<?> resetPassword(User user, String newPassword, String givenOtp);
    ResponseEntity<ActivatedDeactivatedUser> getActiveDeactivateUser();

}
