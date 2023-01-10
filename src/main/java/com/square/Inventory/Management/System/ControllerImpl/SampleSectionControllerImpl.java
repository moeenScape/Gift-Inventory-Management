package com.square.Inventory.Management.System.ControllerImpl;

import com.square.Inventory.Management.System.Constant.InventoryConstant;
import com.square.Inventory.Management.System.Controller.SampleSectionController;
import com.square.Inventory.Management.System.DTO.SsuDto;
import com.square.Inventory.Management.System.Entity.SampleSectionUnit;
import com.square.Inventory.Management.System.IMSUtils.InventoryUtils;
import com.square.Inventory.Management.System.JWT.JWTFilter;
import com.square.Inventory.Management.System.Service.SampleSectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SampleSectionControllerImpl implements SampleSectionController {

    private final JWTFilter jwtFilter;
    private final SampleSectionService sampleSectionService;

    public SampleSectionControllerImpl(JWTFilter jwtFilter, SampleSectionService sampleSectionService) {
        this.jwtFilter = jwtFilter;
        this.sampleSectionService = sampleSectionService;
    }

    @Override
    public ResponseEntity<String> createSSu(SsuDto sampleSectionUnit) {
        if (jwtFilter.isAdmin()) {
            return sampleSectionService.createSSU(sampleSectionUnit);
        }
        return InventoryUtils.getResponse(InventoryConstant.UNAUTHORIZED_ACCESS, HttpStatus.UNAUTHORIZED);
    }

    @Override
    public ResponseEntity<List<SsuDto>> getAllSSU(int page, int size) {
        if (jwtFilter.isAdmin()) {
            List<SsuDto> getAll = sampleSectionService.getAllSSU(page, size);
            return new ResponseEntity<>(getAll, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.UNAUTHORIZED);
        }

    }

    @Override
    public ResponseEntity<String> updateSSU(SampleSectionUnit sampleSectionUnit, Long ssuID) {
        if (jwtFilter.isAdmin()) {
            return sampleSectionService.updateSSU(sampleSectionUnit, ssuID);
        } else {
            return new ResponseEntity<>("You do not have access for update", HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    public ResponseEntity<String> deleteSSU(Long ssuID) {
        if (jwtFilter.isAdmin()) {
            return sampleSectionService.deleteSSU(ssuID);
        } else {
            return new ResponseEntity<>("You do not have access for Delete", HttpStatus.UNAUTHORIZED);
        }
    }
}
