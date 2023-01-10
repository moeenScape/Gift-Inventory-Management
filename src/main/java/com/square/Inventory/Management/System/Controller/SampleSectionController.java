package com.square.Inventory.Management.System.Controller;

import com.square.Inventory.Management.System.DTO.SsuDto;
import com.square.Inventory.Management.System.Entity.SampleSectionUnit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(path = "/ssu")
public interface SampleSectionController {
    @PostMapping(path = "/create")
    ResponseEntity<String> createSSu(@RequestBody SsuDto sampleSectionUnit);

    @GetMapping(path = "/all")
    ResponseEntity<?> getAllSSU(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size);

    @PutMapping(path = "/edit/{ssuID}")
    ResponseEntity<String> updateSSU(@RequestBody SampleSectionUnit sampleSectionUnit, @PathVariable Long ssuID);

    @DeleteMapping(path = "/delete/{ssuID}")
    ResponseEntity<String> deleteSSU(@PathVariable Long ssuID);
}
