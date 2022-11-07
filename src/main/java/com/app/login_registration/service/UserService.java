package com.app.login_registration.service;

import com.app.login_registration.dto.UserRegistrationDto;
import com.app.login_registration.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User save(UserRegistrationDto userRegistrationDto);
}
