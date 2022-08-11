package com.isakayabasi.maintermproject.service.Service;


import com.isakayabasi.maintermproject.dto.UserRegistrationDto;
import com.isakayabasi.maintermproject.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

    User save(UserRegistrationDto registrationDto);

    List<User> getAllUsers();

    User updateUser(User user);
    User getUserById(Long id);
}
