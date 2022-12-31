package com.square.Inventory.Management.System.JWT;

import com.square.Inventory.Management.System.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Slf4j
@Service
public class CustomUserServiceDetails implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    public com.square.Inventory.Management.System.Entity.User userDetails;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        userDetails = userRepository.findByEmail(username);
        if (!Objects.isNull(userDetails)) {
            return new User(userDetails.getEmail(), userDetails.getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("user Not Found");
        }
    }

    public com.square.Inventory.Management.System.Entity.User getUserDetails() {
        return userDetails;
    }

    public String getRole()
    {
        String role =getUserDetails().getRole();
        return role;
    }
}
