package com.square.Inventory.Management.System.ControllerImpl;

import com.square.Inventory.Management.System.Constant.InventoryConstant;
import com.square.Inventory.Management.System.Controller.SampleSectionController;
import com.square.Inventory.Management.System.Entity.SampleSectionUnit;
import com.square.Inventory.Management.System.IMSUtils.InventoryUtils;
import com.square.Inventory.Management.System.JWT.JWTFilter;
import com.square.Inventory.Management.System.Service.SampleSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class SampleSectionControllerImpl implements SampleSectionController {

    @Autowired
    JWTFilter jwtFilter;

    @Autowired
    SampleSectionService sampleSectionService;
    @Override
    public ResponseEntity<String> createSSu(SampleSectionUnit sampleSectionUnit) {
        if(jwtFilter.isAdmin()) {
            return sampleSectionService.createSSU(sampleSectionUnit);
        }
        return InventoryUtils.getResponse(InventoryConstant.UNAUTHORIZED_ACCESS, HttpStatus.UNAUTHORIZED);
    }
}
