package com.app.login_registration.web;

import com.app.login_registration.dto.UserRegistrationDto;
import com.app.login_registration.model.User;
import com.app.login_registration.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @PostMapping("/login")
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto userRegistrationDto, HttpSession session){
        List<User> userList = userService.findAll();

        for (User user :userList) {
            System.out.println(user.getEmail());
            if (userRegistrationDto.getEmail().equals(user.getEmail())){
                return "index";
            }
        }
        session.setAttribute("msg", "Invalid Credentials.!");
        return "redirect:/login";

    }
}
