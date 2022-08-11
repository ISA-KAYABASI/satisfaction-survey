package com.isakayabasi.maintermproject.service.Impl;

import com.isakayabasi.maintermproject.dto.UserRegistrationDto;
import com.isakayabasi.maintermproject.model.Role;
import com.isakayabasi.maintermproject.model.User;
import com.isakayabasi.maintermproject.repository.IUserRepository;
import com.isakayabasi.maintermproject.service.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl  implements IUserService {

    @Autowired
    @Lazy
    private BCryptPasswordEncoder passwordEncoder;


    private IUserRepository iUserRepository;

    public UserServiceImpl(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }



    @Override
    public User save(UserRegistrationDto registrationDto){
        User user=new User(
                registrationDto.getFirstName(),
                registrationDto.getLastName(),
                registrationDto.getEmail(),
                passwordEncoder.encode(registrationDto.getPassword()),
                registrationDto.getEnterValue(),
                registrationDto.isActiveOrPassive(),
                Arrays.asList(new Role("ROLE_USER")));

             return  iUserRepository.save(user);

    }

    @Override
    public List<User> getAllUsers() {
        return iUserRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user=iUserRepository.findByEmail(username);


        if(user == null ){
            throw new UsernameNotFoundException("Invalid username or password. ");
        }else{


            if (user.isActiveOrPassive()){
                return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRolessToAuthorities(user.getRoles()));
            }else {
                throw new UsernameNotFoundException("user blocked");
            }


        }
        // email = username
//        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRolessToAuthorities(user.getRoles()));
 //  }

}


    private Collection<? extends GrantedAuthority> mapRolessToAuthorities(Collection<Role>roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

    }

    ////////////////////////////////////

    @Override
    public User getUserById(Long id) {
        return iUserRepository.findById(id).get();
    }

    @Override
    public User updateUser(User user) {
        return iUserRepository.save(user);
    }









}