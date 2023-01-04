package com.square.Inventory.Management.System.Controller;

import com.square.Inventory.Management.System.Entity.SampleSectionUnit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/ssu")
public interface SampleSectionController {
    @PostMapping(path = "/create")
    ResponseEntity<String> createSSu(SampleSectionUnit sampleSectionUnit);
}
