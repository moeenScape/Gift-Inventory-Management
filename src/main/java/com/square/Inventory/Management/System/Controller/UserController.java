package com.square.Inventory.Management.System.Controller;

import com.square.Inventory.Management.System.Entity.User;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping(path = "/inventory/user")
public interface UserController {
    @PostMapping(path = "/signup")
    public ResponseEntity<String> signUp(@RequestBody(required = true) Map<String, String> requestMap);

    @PostMapping(path = "/login")
    public ResponseEntity<String> login(@RequestBody(required = true) Map<String, String> requestMap);

    @GetMapping(path = "/download/userAsExcel/")
    ResponseEntity<Resource> getFile();

    @PutMapping(path = "/update/{userId}")
    ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("userId") Integer userId);

    @DeleteMapping(path = "/delete/{userId}")
    ResponseEntity<String> deleteUser(@PathVariable("userId") Integer userId);

    @GetMapping(path = "/get/all")
    ResponseEntity<List<User>> getAllUser();

    @GetMapping(path = "/get/all/page")
    ResponseEntity<?> getAllByPagination(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "3") int size);

    @GetMapping(path = "/get/all/pageSort")
    ResponseEntity<?> getAllByPaginationBySorting(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "3") int size,
                                                  @RequestParam(defaultValue = "id") String sortBy);
}



