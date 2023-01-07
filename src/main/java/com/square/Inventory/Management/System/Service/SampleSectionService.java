package com.square.Inventory.Management.System.Service;

import com.square.Inventory.Management.System.DTO.SsuDto;
import com.square.Inventory.Management.System.Entity.SampleSectionUnit;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SampleSectionService {
    ResponseEntity<String> createSSU(SsuDto sampleSectionUnit);

    List<SsuDto> getAllSSU(int page, int size);

    ResponseEntity<String> updateSSU(SampleSectionUnit sampleSectionUnit, Long ssuID);

    ResponseEntity<String> deleteSSU(Long ssuID);
}
