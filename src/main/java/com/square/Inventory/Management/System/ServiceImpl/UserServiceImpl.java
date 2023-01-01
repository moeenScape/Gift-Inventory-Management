package com.square.Inventory.Management.System.ServiceImpl;

import com.square.Inventory.Management.System.Constant.InventoryConstant;
import com.square.Inventory.Management.System.Entity.User;
import com.square.Inventory.Management.System.ExcelHepler.ExcelHelper;
import com.square.Inventory.Management.System.IMSUtils.EmailUtils;
import com.square.Inventory.Management.System.IMSUtils.InventoryUtils;
import com.square.Inventory.Management.System.JWT.CustomUserServiceDetails;
import com.square.Inventory.Management.System.JWT.JWTFilter;
import com.square.Inventory.Management.System.JWT.JWTUtils;
import com.square.Inventory.Management.System.Repository.UserRepository;
import com.square.Inventory.Management.System.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.*;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired(required = true)
    AuthenticationManager authenticationManager;

    @Autowired
    CustomUserServiceDetails customUserServiceDetails;

    @Autowired
    JWTUtils jwtUtils;

    @Autowired
    JWTFilter jwtFilter;

    @Autowired
    EmailUtils emailUtils;

    @Override
    public ResponseEntity<String> signup(Map<String, String> requestMap) {
        if (validateSignUpMap(requestMap)) {
            User user = userRepository.findByEmail(requestMap.get("email"));
            Optional<User> optional = userRepository.findById(Integer.parseInt(requestMap.get("userID")));
            if (Objects.isNull(user) && optional.isEmpty()) {
                userRepository.save(getUserFromMap(requestMap));
                String subject="Account Approved By"+" "+jwtFilter.getCurrentUser();
                String text="Email: "+requestMap.get("email")+"\n"+"Password "+requestMap.get("password")+"\n"
                        +"Please Change Your Password"+"\n"+"Thank You";
                emailUtils.sendMail(requestMap.get("email"),subject,text);
                return InventoryUtils.getResponse("User Register Successful", HttpStatus.CREATED);

            } else {
                return InventoryUtils.getResponse("Email or UserID Already Exist", HttpStatus.BAD_REQUEST);
            }
        }
        return InventoryUtils.getResponse(InventoryConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @Override
    public ResponseEntity<String> login(Map<String, String> requestMap) {
        log.info("Inside Login{}", requestMap);
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(requestMap.get("email"), requestMap.get("password"))
            );

            if (auth.isAuthenticated()) {
                if (customUserServiceDetails.getUserDetails().getStatus().equalsIgnoreCase("true")) {
                    return new ResponseEntity<String>("{\"token\":\"" + jwtUtils.generateToken(customUserServiceDetails.getUserDetails().getEmail(),
                            customUserServiceDetails.getUserDetails().getRole()) + "\"}", HttpStatus.OK);
                } else {
                    return InventoryUtils.getResponse("Wait for Approve", HttpStatus.NOT_ACCEPTABLE);
                }
            }

        } catch (Exception ex) {
            log.error("{}", ex);
        }
        return InventoryUtils.getResponse(InventoryConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ByteArrayInputStream load() {
        List<User> users = userRepository.findAll();

        ByteArrayInputStream in = ExcelHelper.UserToExcel(users);
        return in;
    }

    @Override
    public ResponseEntity<User> update(User user, Integer userId) {
        Optional<User> user1 = userRepository.findById(userId);
        if (user1.isPresent()) {
            User user2 = user1.get();
            user2.setEmail(user.getEmail());
            user2.setPassword(user.getPassword());
            user2.setFirstName(user.getFirstName());
            user2.setLastName(user.getLastName());
            user2.setContactNumber(user.getContactNumber());
            user2.setWorkPlace(user.getWorkPlace());
            user2.setRole(user.getRole());
            user2.setStatus(user.getStatus());
            userRepository.save(user2);

        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteUser(Integer userId) {
        Optional<User> optional = userRepository.findById(userId);

        if (optional.isPresent()) {
            userRepository.deleteById(userId);
            return new ResponseEntity<>("User Deleted ", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User Not Find ", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getAllUserByPagination(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        Page<User> pageResult = userRepository.findAll(paging);
        if (pageResult.hasContent()) {
            return pageResult.getContent();
        } else {
            return new ArrayList<User>();
        }
    }

    @Override
    public List<User> getAllUserByPaginationBySort(int page, int size, String sortBy) {
        Pageable paging = PageRequest.of(page, size, Sort.by(sortBy));
        Page<User> pageResult = userRepository.findAll(paging);
        if (pageResult.hasContent()) {
            return pageResult.getContent();
        } else {
            return new ArrayList<User>();
        }
    }

    private User getUserFromMap(Map<String, String> requestMap) {
        User user = new User();
        user.setUserID(Integer.parseInt(requestMap.get("userID")));
        user.setFirstName(requestMap.get("firstName"));
        user.setLastName(requestMap.get("lastName"));
        user.setContactNumber(requestMap.get("contactNumber"));
        user.setEmail(requestMap.get("email"));
        user.setPassword(requestMap.get("password"));
        user.setRole(requestMap.get("role"));
        user.setStatus(requestMap.get("status"));
        user.setWorkPlace(requestMap.get("workPlace"));
        return user;
    }

    private boolean validateSignUpMap(Map<String, String> requestMap) {
        if (requestMap.containsKey("firstName") && requestMap.containsKey("lastName") && requestMap.containsKey("contactNumber")
                && requestMap.containsKey("email") && requestMap.containsKey("password") && requestMap.containsKey("workPlace")) {
            return true;
        }
        return false;
    }
}
