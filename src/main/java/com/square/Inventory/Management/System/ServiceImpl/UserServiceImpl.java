package com.square.Inventory.Management.System.ServiceImpl;

import com.square.Inventory.Management.System.Constant.InventoryConstant;
import com.square.Inventory.Management.System.DTO.UserDTO;
import com.square.Inventory.Management.System.Entity.LogInDetails;
import com.square.Inventory.Management.System.Entity.User;
import com.square.Inventory.Management.System.IMSUtils.EmailUtils;
import com.square.Inventory.Management.System.IMSUtils.InventoryUtils;
import com.square.Inventory.Management.System.IMSUtils.OtpUtils;
import com.square.Inventory.Management.System.JWT.CustomUserServiceDetails;
import com.square.Inventory.Management.System.JWT.JWTFilter;
import com.square.Inventory.Management.System.JWT.JWTUtils;
import com.square.Inventory.Management.System.Projection.ActivatedDeactivatedUser;
import com.square.Inventory.Management.System.Repository.LogInHistoryRepository;
import com.square.Inventory.Management.System.Repository.UserRepository;
import com.square.Inventory.Management.System.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    private final CustomUserServiceDetails customUserServiceDetails;

    private final JWTUtils jwtUtils;

    private final JWTFilter jwtFilter;

    private final EmailUtils emailUtils;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final OtpUtils otpUtils;

    private final LogInHistoryRepository logInHistoryRepository;
    public UserServiceImpl(UserRepository userRepository,
                           AuthenticationManager authenticationManager,
                           CustomUserServiceDetails customUserServiceDetails,
                           JWTUtils jwtUtils,
                           JWTFilter jwtFilter,
                           EmailUtils emailUtils,
                           BCryptPasswordEncoder bCryptPasswordEncoder, OtpUtils otpUtils, LogInHistoryRepository logInHistoryRepository) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.customUserServiceDetails = customUserServiceDetails;
        this.jwtUtils = jwtUtils;
        this.jwtFilter = jwtFilter;
        this.emailUtils = emailUtils;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.otpUtils = otpUtils;
        this.logInHistoryRepository = logInHistoryRepository;
    }

    @Override
    public ResponseEntity<String> createUser(UserDTO user) {
        try {
            User newUser = userRepository.findByEmail(user.getEmail());
            log.info("Inside log in {}", newUser);
            if (Objects.isNull(newUser)) {

                userRepository.save(getUserFromDTO(user));
                emailUtils.sendMail(user.getEmail(), "Account Approved By" + " " + getCurrentUserName(),
                        "Email: " + user.getEmail() + "\n" + "Password " + user.getPassword() + "\n"
                                + "Please Change Your Password As Soon As possible http//:localhost:8080/inventory/user/changePassword"
                                + "\n" + "Thank You!!!" + "\n" + "\n" + "This mail Send from IMS by Square");
                return InventoryUtils.getResponse("User Register Successful", HttpStatus.CREATED);

            } else {
                return InventoryUtils.getResponse("Email or UserID Already Exist", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return InventoryUtils.getResponse(InventoryConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private String getCurrentUserName() {

        User user = userRepository.findByEmail(jwtFilter.getCurrentUser());
        return user.getFirstName() + "  " + user.getLastName();
    }

    @Override
    public ResponseEntity<String> login(UserDTO userDTO) {
        try {
            User user = userRepository.findByEmail(userDTO.getEmail());
            if (Objects.nonNull(user)) {
                Authentication auth = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(userDTO.getEmail(), userDTO.getPassword()));
                if (auth.isAuthenticated()) {
                    if (customUserServiceDetails.getUserDetails().getStatus().equalsIgnoreCase("true")) {
                        logInHistoryRepository.save(getLogInDetails(customUserServiceDetails.getUserDetails().getEmail()));
                        return new ResponseEntity<>("{\"token\":\"" + jwtUtils.generateToken(customUserServiceDetails.getUserDetails().getEmail(),
                                customUserServiceDetails.getUserDetails().getRole()) + "\"}", HttpStatus.OK);
                    } else {
                        return InventoryUtils.getResponse("Wait for Approve", HttpStatus.NOT_ACCEPTABLE);
                    }
                }
            } else {
                return InventoryUtils.getResponse("No user found by this Email", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return InventoryUtils.getResponse(InventoryConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private LogInDetails getLogInDetails(@Email String email) throws UnknownHostException {
        LogInDetails logInDetails=new LogInDetails();
        InetAddress inetAddress=InetAddress.getLocalHost();
        User user=userRepository.findByEmail(email);
        logInDetails.setUserId(user.getId());
        logInDetails.setLogInTime(new Date());
        logInDetails.setLogInStatus("success");
        logInDetails.setIP(inetAddress.getHostAddress());
        return logInDetails;
    }


    @Override
    public ResponseEntity<String> update(UserDTO user, Long userId) {
        try {
            Optional<User> user1 = userRepository.findById(userId);
            if (user1.isPresent()) {
                User user2 = user1.get();
                user2.setFirstName(user.getFirstName());
                user2.setLastName(user.getLastName());
                user2.setContactNumber(user.getContactNumber());
                userRepository.save(user2);
                return new ResponseEntity<>("User Updated", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("User is not present", HttpStatus.OK);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>("Fail to update", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> updateUserRole(String role, Long userID) {
        try {
            Optional<User> user1 = userRepository.findById(userID);
            if (user1.isPresent()) {
                User user2 = user1.get();
                user2.setRole(role);
                userRepository.save(user2);
                return new ResponseEntity<>(user2.getFirstName() + " " + user2.getLastName() + "New Role : " + role, HttpStatus.OK);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>("Fail to upload", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> updateUserStatus(String status, Long userID) {
        try {
            Optional<User> user = userRepository.findById(userID);
            if (user.isPresent()) {
                User newUser = user.get();
                newUser.setStatus(status);
                userRepository.save(newUser);
                return new ResponseEntity<>(newUser.getFirstName() + " " + newUser.getLastName() + "New Role : " + status, HttpStatus.OK);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>("Fail to upDate Status", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public List<String> getClaimDetails() {
        List<String> stringList = new ArrayList<>();
        stringList.add(jwtFilter.getCurrentUser());
        stringList.add(jwtFilter.getRole());
        return stringList;
    }

    @Override
    public Object getClaimFromLogin() {
        User user = userRepository.findByEmail(jwtFilter.getCurrentUser());

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setContactNumber(user.getContactNumber());
        userDTO.setRole(user.getRole());
        return userDTO;
    }

    @Override
    public ResponseEntity<String> disableUser(Long userId) {

        Optional<User> optional = userRepository.findById(userId);
        if (optional.isPresent() && !"admin".equals(optional.get().getRole())) {

            userRepository.disableUser(userId);
            return new ResponseEntity<>("User Disable Successfully ", HttpStatus.OK);

        } else if (optional.isPresent() && optional.get().getRole().equals("admin")) {
            return new ResponseEntity<>("Can not  Disable Admin ", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("User Not Find ", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<UserDTO> getAllUserByPagination(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        Page<UserDTO> pageResult = userRepository.getAllUser(paging);
        if (pageResult.hasContent()) {
            return pageResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<UserDTO> getAllUserByPaginationBySort(int page, int size, String sortBy) {
        Pageable paging = PageRequest.of(page, size, Sort.by(sortBy));
        Page<UserDTO> pageResult = userRepository.getAllUser(paging);
        if (pageResult.hasContent()) {
            return pageResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    private User getUserFromDTO(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setContactNumber(userDTO.getContactNumber());
        user.setEmail(userDTO.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        user.setRole(userDTO.getRole());
        user.setStatus(userDTO.getStatus());
        return user;
    }

    @Override
    public ResponseEntity<?> forgetPassword(User user) {
        String otp = otpUtils.generateOTP(user);
        String email = user.getEmail();

        user.setOtp(otp);
        user.setSetOtpGenerationTime(new Date());
        userRepository.save(user);

        emailUtils.sendMail(email, "Forget Password Request",
                "Hello User,\n" +
                        "Your OTP is: " + otp + "\n" + "\n" +
                        "This mail Send from IMS by Square\n" +
                        "Note: this OTP is set to expire in 5 minutes."
        );
        return ResponseEntity.ok("OTP generated!! check mail");
    }

    @Override
    public Boolean checkOtpStatus(User user, String givenOtp) {
        if (!user.getOtp().equals(givenOtp)) {
            return false;
        }
        return otpUtils.isOtpExpired(user);
    }

    @Override
    public ResponseEntity<?> resetPassword(User user, String newPassword) {
        newPassword = bCryptPasswordEncoder.encode(newPassword);
        String oldPassword = user.getPassword();
        if (Objects.equals(newPassword, oldPassword)) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        } else {
            user.setPassword(newPassword);
            otpUtils.clearOTP(user);
            return ResponseEntity.ok("Password Updated!");
        }
    }

    @Override
    public ResponseEntity<ActivatedDeactivatedUser> getActiveDeactivateUser() {
        ActivatedDeactivatedUser activatedDeactivatedUsers = userRepository.getActiveDeactivateUser();
        return new ResponseEntity<>(activatedDeactivatedUsers, HttpStatus.OK);

    }

}