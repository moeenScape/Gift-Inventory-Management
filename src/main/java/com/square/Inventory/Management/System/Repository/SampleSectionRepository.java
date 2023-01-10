package com.square.Inventory.Management.System.Repository;

import com.square.Inventory.Management.System.DTO.SsuDto;
import com.square.Inventory.Management.System.Entity.SampleSectionUnit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleSectionRepository extends JpaRepository<SampleSectionUnit, Long> {

    @Query("select new com.square.Inventory.Management.System.DTO.SsuDto(s.ssuID,s.ssuName," +
            "s.location) from SampleSectionUnit s")
    Page<SsuDto> getAllUser(Pageable paging);

    @Query(value = "select user_id from sample_section_unit where user_id=:user_id ",nativeQuery = true)
    Long getUserIDbySsuID(@Param("user_id")Long user_id);

    @Query(value = "select ssu_name from sample_section_unit where user_id=:id",nativeQuery = true)
    String getSSUNameByUID(@Param("id") Long id);
}
