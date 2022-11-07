package com.app.login_registration.web;

import com.app.login_registration.dto.UserRegistrationDto;
import com.app.login_registration.model.User;
import com.app.login_registration.service.UserService;
import com.app.login_registration.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserServiceImpl userService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(){
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto userRegistrationDto , HttpSession session){
        List<User> userList = userService.findAll();

        for (User user :userList) {
            System.out.println(user.getEmail());
            if (userRegistrationDto.getEmail().equals(user.getEmail())){
                session.setAttribute("msg", "Email Already Registered!");
                return "redirect:/registration";
            }
        }
        userService.save(userRegistrationDto);
        return "redirect:/registration?success";

    }


}
