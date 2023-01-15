package com.square.Inventory.Management.System.Controller;

import com.square.Inventory.Management.System.DTO.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// cross origin could be globally configured
@CrossOrigin(origins = {"http://localhost:4200"},methods ={RequestMethod.POST,RequestMethod.DELETE,RequestMethod.GET,RequestMethod.PUT})
@RequestMapping(path = "/user")
public interface UserController {

    // why returning string, use httpstatus
    @PostMapping(path = "/login")
    ResponseEntity<String> login(@RequestBody UserDTO userDTO);

    // why returning string, use httpstatus
    @PostMapping(path = "/create")
    ResponseEntity<String> createUser(@RequestBody UserDTO user,BindingResult bindingResult);

    // why returning string, use httpstatus
    @PutMapping(path = "/update/{userId}")
    ResponseEntity<String> updateUser(@RequestBody UserDTO userDTO,
                                      @PathVariable Long userId);

    // why returning string, use httpstatus
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
    // why Object
    Object getClaimFromLogin();

    @PostMapping("/forgetPassword")
    ResponseEntity<?> forgetPassword(@RequestBody UserDTO userDTO);

    @PostMapping("/checkOtpStatus")
    ResponseEntity<?> checkOtpStatus(@RequestBody UserDTO userDTO);

    @PostMapping("/resetPassword")
    ResponseEntity<?> resetPassword(@RequestBody UserDTO userDTO);


}