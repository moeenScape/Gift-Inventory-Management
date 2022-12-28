package com.square.Inventory.Management.System.ControllerImpl;

import com.square.Inventory.Management.System.Constant.InventoryConstant;
import com.square.Inventory.Management.System.Controller.UserController;
import com.square.Inventory.Management.System.IMSUtils.InventoryUtils;
import com.square.Inventory.Management.System.JWT.JWTFilter;
import com.square.Inventory.Management.System.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    UserService userService;

    @Autowired
    JWTFilter jwtFilter;
    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        try{
//            if(jwtFilter.isAdmin())
//            {
                return userService.signup(requestMap);
//            }else {
//               return InventoryUtils.getResponse(InventoryConstant.UNAUTHORIZED_ACCESS, HttpStatus.UNAUTHORIZED);
//            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return InventoryUtils.getResponse(InventoryConstant.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> login(Map<String, String> requestMap) {
        return userService.login(requestMap);
    }
}
