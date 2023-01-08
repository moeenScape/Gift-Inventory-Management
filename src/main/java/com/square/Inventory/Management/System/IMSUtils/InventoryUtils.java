package com.square.Inventory.Management.System.IMSUtils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class InventoryUtils {
    public InventoryUtils()
    {

    }
    public static ResponseEntity<String> getResponse(String responseMessage, HttpStatus httpStatus)
    {
        return new ResponseEntity<>("{\"message\":\"" + responseMessage + "\"}", httpStatus);
    }
}
