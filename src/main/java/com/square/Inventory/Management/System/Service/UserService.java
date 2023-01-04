package com.square.Inventory.Management.System.Service;

import com.square.Inventory.Management.System.DTO.UserDTO;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface UserService {
    ResponseEntity<String> createUser(UserDTO user);

    ResponseEntity<String> login(UserDTO userDTO);

    ByteArrayInputStream load();

    ResponseEntity<String> deleteUser(Integer userId);

    List<UserDTO> getAllUserByPagination(int page, int size);

    List<UserDTO> getAllUserByPaginationBySort(int page, int size, String sortBy);

    ResponseEntity<String> update(UserDTO userDTO, Integer userId);

    ResponseEntity<?> updateUserRole(String role,Integer userID);

    ResponseEntity<?> updateUserStatus(String status, Integer userID);
}
