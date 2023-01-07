package com.square.Inventory.Management.System.DTO;

import com.square.Inventory.Management.System.Entity.SampleSectionUnit;
import com.square.Inventory.Management.System.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SsuDto {
    private Long ssuID;

    private String ssuName;

    private String location;

    private Integer numberOfEmployee;

    private Long user_id;

    public SsuDto(Long ssuID, String ssuName, String location) {
        this.ssuID = ssuID;
        this.ssuName = ssuName;
        this.location = location;
    }

    public SampleSectionUnit convertSSU(SsuDto ssuDto, User user) {
        SampleSectionUnit sampleSectionUnit=new SampleSectionUnit();
        sampleSectionUnit.setSsuID(ssuDto.getSsuID());
        sampleSectionUnit.setSsuName(ssuDto.getSsuName());
        sampleSectionUnit.setLocation(ssuDto.getLocation());
        sampleSectionUnit.setNumberOfEmployee(ssuDto.getNumberOfEmployee());
        sampleSectionUnit.setUser(user);
        return sampleSectionUnit;
    }

    public SsuDto convertSSuDto(SampleSectionUnit sampleSectionUnit,User user)
    {
        SsuDto ssuDto=new SsuDto();
        ssuDto.setSsuID(sampleSectionUnit.getSsuID());
        ssuDto.setSsuName(sampleSectionUnit.getSsuName());
        ssuDto.setNumberOfEmployee(sampleSectionUnit.getNumberOfEmployee());
        ssuDto.setUser_id(user.getId());
        return ssuDto;
    }

}
