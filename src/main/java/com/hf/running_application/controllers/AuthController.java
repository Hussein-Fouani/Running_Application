package com.hf.running_application.controllers;

import com.hf.running_application.entities.UserEntity;
import com.hf.running_application.model.RegistrationUserDTO;
import com.hf.running_application.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
@NoArgsConstructor
public class AuthController {
    private UserService userService;


    @GetMapping("/register")
    public String getRegisterForm(Model model){
        RegistrationUserDTO registrationUserDTO = new RegistrationUserDTO();
        model.addAttribute("user",registrationUserDTO);
        return "register";
    }


    @GetMapping("/login")
    public String loginPage(){
        return "login"
    }
    @PostMapping("/register/save")
    public String register(@Valid @ModelAttribute("user")RegistrationUserDTO users, BindingResult result,Model model){
        UserEntity ExisituserEmail = userService.findUserByEmailAndUserName(users.getEmail());
        if(ExisituserEmail !=null && ExisituserEmail .getEmail()!= null && !ExisituserEmail .getEmail().isEmpty()){
            result.rejectValue("Email","Email AlReady Exist");
        }
        UserEntity ExistuserName = userService.findByUserName(ExisituserEmail .getUserName());
        if (result.hasErrors()){
            model.addAttribute("user",ExisituserEmail );
            return "register";
        }
        if(ExistuserName !=null && ExistuserName.getUserName()!= null && !ExistuserName .getUserName().isEmpty()){
            result.rejectValue("UserName","UserName AlReady Exist");
        }
        userService.SaveUser(users);
        return "redirect:/clubs";
    }
}
