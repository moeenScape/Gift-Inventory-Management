package com.square.Inventory.Management.System.Controller;

import com.square.Inventory.Management.System.DTO.UserDTO;
import com.square.Inventory.Management.System.DTO.UserUpdateDTO;
import com.square.Inventory.Management.System.Entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping(path = "/user")
public interface UserController {

    @PostMapping(path = "/login")
    public ResponseEntity<String> login(@RequestBody(required = true) Map<String, String> requestMap);

    @PostMapping(path = "/create")
    public ResponseEntity<String> createUser(@RequestBody UserDTO user);

    @PutMapping(path = "/update/{userId}")
    ResponseEntity<String> updateUser(@RequestBody UserUpdateDTO userUpdateDTO,
                                    @PathVariable Integer userId);

    @DeleteMapping(path = "/delete/{userId}")
    ResponseEntity<String> deleteUser(@PathVariable Integer userId);

    @GetMapping(path = "/all")
    ResponseEntity<?> getAllUsers(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size);

    @GetMapping(path = "/page")
    ResponseEntity<?> getAllByPaginationBySorting(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "10") int size,
                                                  @RequestParam(defaultValue = "id") String sortBy);

    @PutMapping(path = "/update/role/{userID}")
    ResponseEntity<?> updateUserRole(@RequestBody String role,
                                     @PathVariable Integer userID);

    @PutMapping(path = "/update/status/{userID}")
    ResponseEntity<?> updateUserStatus(@RequestBody String status,
                                       @PathVariable Integer userID);


    @GetMapping(path = "/dump")
    Object getFile();

}



