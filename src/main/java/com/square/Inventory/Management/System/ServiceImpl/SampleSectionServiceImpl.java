package com.square.Inventory.Management.System.ServiceImpl;

import com.square.Inventory.Management.System.DTO.SsuDto;
import com.square.Inventory.Management.System.Entity.SampleSectionUnit;
import com.square.Inventory.Management.System.Entity.User;
import com.square.Inventory.Management.System.Repository.SampleSectionRepository;
import com.square.Inventory.Management.System.Repository.UserRepository;
import com.square.Inventory.Management.System.Service.SampleSectionService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SampleSectionServiceImpl implements SampleSectionService {

    private final SampleSectionRepository sampleSectionRepository;

    private final UserRepository userRepository;

    public SampleSectionServiceImpl(SampleSectionRepository sampleSectionRepository, UserRepository userRepository) {
        this.sampleSectionRepository = sampleSectionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<String> createSSU(SsuDto sampleSectionUnit) {
        try {

            Optional<SampleSectionUnit> sectionUnit = sampleSectionRepository.findById(sampleSectionUnit.getSsuID());

            if (sectionUnit.isPresent()) {
                return new ResponseEntity<>("This Sample Section ID Already Exist", HttpStatus.BAD_REQUEST);
            } else if (findUserID(sampleSectionUnit.getUser_id())) {
                return new ResponseEntity<>("This User Already Assign in a SSU", HttpStatus.BAD_REQUEST);
            } else {

                Long user_id = sampleSectionUnit.getUser_id();
                SampleSectionUnit newSampleSectionUnit = new SampleSectionUnit();
                if (user_id == null) {
                    newSampleSectionUnit.setSsuID(sampleSectionUnit.getSsuID());
                    newSampleSectionUnit.setSsuName(sampleSectionUnit.getLocation());
                    newSampleSectionUnit.setLocation(sampleSectionUnit.getLocation());
                    newSampleSectionUnit.setNumberOfEmployee(sampleSectionUnit.getNumberOfEmployee());
                    sampleSectionRepository.save(newSampleSectionUnit);
                    return new ResponseEntity<>("Add SSU without User", HttpStatus.OK);

                } else {

                    Optional<User> user = userRepository.findById(user_id);
                    if (user.isPresent()) {
                        newSampleSectionUnit = sampleSectionUnit.convertSSU(sampleSectionUnit, user.get());
                        sampleSectionRepository.save(newSampleSectionUnit);
                        return new ResponseEntity<>("Add SSu with User", HttpStatus.OK);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>("Failed to Add", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private boolean findUserID(Long user_id) {
        return !Objects.isNull(sampleSectionRepository.getUserIDbySsuID(user_id));
    }

    @Override
    public List<SsuDto> getAllSSU(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        Page<SsuDto> pageResult = sampleSectionRepository.getAllUser(paging);
        if (pageResult.hasContent()) {
            return pageResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public ResponseEntity<String> updateSSU(SampleSectionUnit sampleSectionUnit, Long ssuID) {
        try {
            Optional<SampleSectionUnit> sectionUnit = sampleSectionRepository.findById(ssuID);

            if (sectionUnit.isPresent()) {
                SampleSectionUnit newSampleSectionUnit = sectionUnit.get();
                newSampleSectionUnit.setSsuID(ssuID);
                newSampleSectionUnit.setSsuName(sampleSectionUnit.getSsuName());
                newSampleSectionUnit.setLocation(sampleSectionUnit.getLocation());
                newSampleSectionUnit.setUser(sectionUnit.get().getUser());
                newSampleSectionUnit.setNumberOfEmployee(sectionUnit.get().getNumberOfEmployee());
                sampleSectionRepository.save(newSampleSectionUnit);
                return new ResponseEntity<>("Sample Section Unit Update", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("This SSU does not Exist", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>("Failed to Update", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> deleteSSU(Long ssuID) {
        try {
            Optional<SampleSectionUnit> sampleSectionUnit = sampleSectionRepository.findById(ssuID);

            if (sampleSectionUnit.isPresent()) {
                sampleSectionRepository.deleteById(ssuID);
                return new ResponseEntity<>("Delete SSU  " + sampleSectionUnit.get().getSsuName(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("There are no SSU With " + ssuID + "ID", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return new ResponseEntity<>("Failed to Delete", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
