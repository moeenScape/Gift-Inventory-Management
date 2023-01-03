package com.square.Inventory.Management.System.Service;

import com.square.Inventory.Management.System.DTO.UserDTO;
import com.square.Inventory.Management.System.Entity.User;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;

public interface UserService {
    ResponseEntity<String> createUser(Map<String, String> requestMap);

    ResponseEntity<String> login(Map<String, String> requestMap);

    ByteArrayInputStream load();

    ResponseEntity<String> deleteUser(Integer userId);

    List<UserDTO> getAllUserByPagination(int page, int size);

    List<UserDTO> getAllUserByPaginationBySort(int page, int size, String sortBy);

    ResponseEntity<User> update(User user, Integer userId);
}
