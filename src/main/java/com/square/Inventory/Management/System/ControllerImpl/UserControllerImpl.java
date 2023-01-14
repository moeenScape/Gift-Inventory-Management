package com.square.Inventory.Management.System.ControllerImpl;

import com.square.Inventory.Management.System.Constant.InventoryConstant;
import com.square.Inventory.Management.System.Controller.UserController;
import com.square.Inventory.Management.System.DTO.UserDTO;
import com.square.Inventory.Management.System.IMSUtils.InventoryUtils;
import com.square.Inventory.Management.System.JWT.JWTFilter;
import com.square.Inventory.Management.System.Repository.UserRepository;
import com.square.Inventory.Management.System.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class UserControllerImpl implements UserController {

    private final UserService userService;
    @Autowired
    UserRepository userRepository;

    private final JWTFilter jwtFilter;

    public UserControllerImpl(UserService userService,
                              JWTFilter jwtFilter) {
        this.userService = userService;
        this.jwtFilter = jwtFilter;
    }

    @Override
    public ResponseEntity<String> createUser(@Valid UserDTO user, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return ResponseEntity.badRequest()
                        .body(bindingResult
                                .getAllErrors()
                                .stream()
                                .map(ObjectError::getDefaultMessage)
                                .collect(Collectors.joining()));
            } else {
                if (jwtFilter.isAdmin()) {
                    return userService.createUser(user);
                } else {
                    return InventoryUtils.getResponse(InventoryConstant.UNAUTHORIZED_ACCESS, HttpStatus.UNAUTHORIZED);
                }
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
    public ResponseEntity<String> updateUser(UserDTO userDTO, Long userId) {
        return userService.update(userDTO, userId);
    }

    @Override
    public ResponseEntity<String> disableUser(Long userId) {
        if (jwtFilter.isAdmin()) {
            return userService.disableUser(userId);
        } else {
            return InventoryUtils.getResponse(InventoryConstant.UNAUTHORIZED_ACCESS, HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    public ResponseEntity<List<UserDTO>> getAllUsers(int page, int size) {
        if (jwtFilter.isAdmin()) {
            List<UserDTO> userList = userService.getAllUserByPagination(page, size);
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    public ResponseEntity<List<UserDTO>> getAllByPaginationBySorting(int page, int size, String sortBy) {
        if (jwtFilter.isAdmin()) {
            List<UserDTO> userList = userService.getAllUserByPaginationBySort(page, size, sortBy);
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    public ResponseEntity<?> updateUserRole(String role, Long userID) {
        if (jwtFilter.isAdmin()) {
            return userService.updateUserRole(role, userID);
        } else {
            return new ResponseEntity<>("You do not have access", HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    public ResponseEntity<?> updateUserStatus(String status, Long userID) {
        if (jwtFilter.isAdmin()) {
            return userService.updateUserStatus(status, userID);
        } else {
            return new ResponseEntity<>("You do not have access to update User Status", HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    public List<String> getClaimDetails() {
        return userService.getClaimDetails();
    }

    @Override
    public Object getClaimFromLogin() {
        return userService.getClaimFromLogin();
    }

    @Override
    public ResponseEntity<?> forgetPassword(@RequestBody UserDTO userDTO) {
        String email = userDTO.getEmail();
        return Optional
                .ofNullable(userRepository.findByEmail(email))
                .map(user -> ResponseEntity.ok(userService.forgetPassword(user)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<?> checkOtpStatus(@RequestBody UserDTO userDTO) {
        String otp = userDTO.getOtp();
        String email = userDTO.getEmail();

        return Optional
                .ofNullable(userRepository.findByEmail(email))
                .map(user -> ResponseEntity.ok(userService.checkOtpStatus(user, otp)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<?> resetPassword(@RequestBody UserDTO userDTO) {
        String email = userDTO.getEmail();
        String newPassword = userDTO.getPassword();

        return Optional
                .ofNullable(userRepository.findByEmail(email))
                .map(user -> ResponseEntity.ok(userService.resetPassword(user, newPassword)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
