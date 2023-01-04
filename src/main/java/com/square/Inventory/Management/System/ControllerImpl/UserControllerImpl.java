package com.square.Inventory.Management.System.ControllerImpl;

import com.square.Inventory.Management.System.Constant.InventoryConstant;
import com.square.Inventory.Management.System.Controller.UserController;
import com.square.Inventory.Management.System.DTO.UserDTO;
import com.square.Inventory.Management.System.IMSUtils.InventoryUtils;
import com.square.Inventory.Management.System.JWT.JWTFilter;
import com.square.Inventory.Management.System.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    UserService userService;

    @Autowired
    JWTFilter jwtFilter;

    @Override
    public ResponseEntity<String> createUser(UserDTO user) {
        try {
            if (jwtFilter.isAdmin()) {
                return userService.createUser(user);
            } else {
                return InventoryUtils.getResponse(InventoryConstant.UNAUTHORIZED_ACCESS, HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return InventoryUtils.getResponse(InventoryConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> login(UserDTO userDTO) {
        return userService.login(userDTO);
    }

    @Override
    public ResponseEntity<Resource> getFile() {
        if (jwtFilter.isAdmin()) {
            String filename = "user.xlsx";
            InputStreamResource file = new InputStreamResource(userService.load());

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                    .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                    .body(file);
        }
        return null;
    }

    @Override
    public ResponseEntity<String> updateUser(UserDTO userDTO, Integer userId) {
        return userService.update(userDTO, userId);
    }

    @Override
    public ResponseEntity<String> deleteUser(Integer userId) {
        if (jwtFilter.isAdmin()) {
            return userService.deleteUser(userId);
        } else {
            return InventoryUtils.getResponse(InventoryConstant.UNAUTHORIZED_ACCESS, HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    public ResponseEntity<List<UserDTO>> getAllUsers(int page, int size) {
        if (jwtFilter.isAdmin()) {
            List<UserDTO> userList = userService.getAllUserByPagination(page, size);
            return new ResponseEntity<List<UserDTO>>(userList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    public ResponseEntity<List<UserDTO>> getAllByPaginationBySorting(int page, int size, String sortBy) {
        if (jwtFilter.isAdmin()) {
            List<UserDTO> userList = userService.getAllUserByPaginationBySort(page, size, sortBy);
            return new ResponseEntity<List<UserDTO>>(userList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

    }

    @Override
    public ResponseEntity<?> updateUserRole(String role, Integer userID) {
        if (jwtFilter.isAdmin()) {
            return userService.updateUserRole(role, userID);
        } else {
            return new ResponseEntity<>("You do not have access", HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    public ResponseEntity<?> updateUserStatus(String status, Integer userID) {
        if (jwtFilter.isAdmin()) {
            return userService.updateUserStatus(status, userID);
        } else {
            return new ResponseEntity<>("You do not have access to update User Status", HttpStatus.UNAUTHORIZED);
        }

    }

}
