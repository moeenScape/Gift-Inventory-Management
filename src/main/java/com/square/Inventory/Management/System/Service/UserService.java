package com.square.Inventory.Management.System.Service;

import com.square.Inventory.Management.System.DTO.UserDTO;
import com.square.Inventory.Management.System.Entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<String> createUser(UserDTO user);

    ResponseEntity<String> login(UserDTO userDTO);

    ResponseEntity<String> disableUser(Long userId);

    List<UserDTO> getAllUserByPagination(int page, int size);

    List<UserDTO> getAllUserByPaginationBySort(int page, int size, String sortBy);

    ResponseEntity<String> update(UserDTO userDTO, Long userId);

    ResponseEntity<?> updateUserRole(String role,Long userID);

    ResponseEntity<?> updateUserStatus(String status, Long userID);

    List<String> getClaimDetails();

    Object getClaimFromLogin();

    ResponseEntity<?> forgetPassword(User user);
}
