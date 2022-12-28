package com.square.Inventory.Management.System.Service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserService {
    ResponseEntity<String> signup(Map<String, String> requestMap);

    ResponseEntity<String> login(Map<String, String> requestMap);
}
