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
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SampleSectionControllerImpl implements SampleSectionController {

    private final JWTFilter jwtFilter;
    private final SampleSectionService sampleSectionService;

    public SampleSectionControllerImpl(JWTFilter jwtFilter, SampleSectionService sampleSectionService) {
        this.jwtFilter = jwtFilter;
        this.sampleSectionService = sampleSectionService;
    }

    @Override
    public ResponseEntity<String> createSSu(SsuDto sampleSectionUnit, BindingResult bindingResult) {
        if (jwtFilter.isAdmin()) {
            if (bindingResult.hasErrors()) {
                return ResponseEntity.badRequest().body(
                        bindingResult
                                .getAllErrors()
                                .stream()
                                .map(ObjectError::getDefaultMessage)
                                .collect(Collectors.joining()));
            }
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
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
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
