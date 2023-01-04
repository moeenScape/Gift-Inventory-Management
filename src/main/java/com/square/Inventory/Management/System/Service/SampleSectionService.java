package com.square.Inventory.Management.System.Service;

import com.square.Inventory.Management.System.Entity.SampleSectionUnit;
import org.springframework.http.ResponseEntity;

public interface SampleSectionService {
    ResponseEntity<String> createSSU(SampleSectionUnit sampleSectionUnit);
}
