package com.square.Inventory.Management.System.Repository;

import com.square.Inventory.Management.System.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
