package org.learning.springautomobile.controller;

import jakarta.validation.Valid;
import org.learning.springautomobile.model.AutoUser;
import org.learning.springautomobile.model.Role;
import org.learning.springautomobile.repository.AutoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    private AutoUserRepository autoUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }


    @GetMapping("/register")
    public String registroUser(Model model){
        AutoUser user = new AutoUser();
        model.addAttribute("formUser",user);
        return "user/registrati";
    }

    @PostMapping("/register")
    public String saveUser(@Valid @ModelAttribute("formUser")AutoUser formUser, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "user/registrati";
        }
        formUser.setPassword("{noop}"+formUser.getPassword());
        autoUserRepository.save(formUser);
        return "redirect:/";
    }

}
