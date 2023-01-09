package com.square.Inventory.Management.System.Controller;

import com.square.Inventory.Management.System.DTO.UserDTO;
import com.square.Inventory.Management.System.Projection.ActivatedDeactivatedUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(path = "/user")
public interface UserController {

    @PostMapping(path = "/login")
    ResponseEntity<String> login(@RequestBody UserDTO userDTO);

    @PostMapping(path = "/create")
    ResponseEntity<String> createUser(@RequestBody UserDTO user);

    @PutMapping(path = "/update/{userId}")
    ResponseEntity<String> updateUser(@RequestBody UserDTO userDTO,
                                      @PathVariable Long userId);

    @PutMapping(path = "/disable/{userId}")
    ResponseEntity<String> disableUser(@PathVariable Long userId);

    @GetMapping(path = "/all")
    ResponseEntity<?> getAllUsers(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size);

    @GetMapping(path = "/page")
    ResponseEntity<?> getAllByPaginationBySorting(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "10") int size,
                                                  @RequestParam(defaultValue = "id") String sortBy);

    @PutMapping(path = "/update/role/{userID}")
    ResponseEntity<?> updateUserRole(@RequestBody String role,
                                     @PathVariable Long userID);

    @PutMapping(path = "/update/status/{userID}")
    ResponseEntity<?> updateUserStatus(@RequestBody String status,
                                       @PathVariable Long userID);

    @GetMapping(path = "/claim_details")
    List<String> getClaimDetails();

    @GetMapping(path = "/claim_object")
    Object getClaimFromLogin();

    @PostMapping("/forgetPassword")
    ResponseEntity<?> forgetPassword(@RequestBody UserDTO userDTO);

    @PostMapping("/checkOtpStatus")
    ResponseEntity<?> checkOtpStatus(@RequestBody UserDTO userDTO);

    @PostMapping("/resetPassword")
    ResponseEntity<?> resetPassword(@RequestBody UserDTO userDTO);

}