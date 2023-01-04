package com.square.Inventory.Management.System.Repository;

import com.square.Inventory.Management.System.DTO.UserDTO;
import com.square.Inventory.Management.System.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.email=:username")
    User findByEmail(@Param("username") String username);

    @Query("select new com.square.Inventory.Management.System.DTO.UserDTO(u.id,u.firstName,u.lastName," +
            "u.contactNumber,u.email,u.role,u.status) from User u")
    Page<UserDTO> getAllUser(Pageable paging);
}
