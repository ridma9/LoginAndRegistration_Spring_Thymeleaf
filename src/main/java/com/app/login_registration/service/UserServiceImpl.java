package com.app.login_registration.service;

import com.app.login_registration.dto.UserRegistrationDto;
import com.app.login_registration.model.User;
import com.app.login_registration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(UserRegistrationDto userRegistrationDto) {
        User user = new User(userRegistrationDto.getFirstName(),
                userRegistrationDto.getLastName(),userRegistrationDto.getEmail(),
                userRegistrationDto.getPassword());
        return userRepository.save(user);

    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

}
