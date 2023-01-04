package com.square.Inventory.Management.System.ServiceImpl;

import com.square.Inventory.Management.System.Entity.SampleSectionUnit;
import com.square.Inventory.Management.System.Repository.SampleSectionRepository;
import com.square.Inventory.Management.System.Service.SampleSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class SampleSectionServiceImpl implements SampleSectionService {
    @Autowired
    SampleSectionRepository sampleSectionRepository;
    @Override
    public ResponseEntity<String >createSSU(SampleSectionUnit sampleSectionUnit) {
        try{

        }catch (Exception ex) {
            ex.printStackTrace();
        }
        sampleSectionRepository.save(sampleSectionUnit);
        return new ResponseEntity<>("Add SSU Done", HttpStatus.OK);

    }
}
