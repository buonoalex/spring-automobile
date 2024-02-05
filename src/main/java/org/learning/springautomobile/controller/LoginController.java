package org.learning.springautomobile.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.learning.springautomobile.model.AutoUser;
import org.learning.springautomobile.model.Role;
import org.learning.springautomobile.repository.AutoUserRepository;
import org.learning.springautomobile.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

@Controller
public class LoginController {

    @Autowired
    private AutoUserRepository autoUserRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserDetailsService userDetailsService;


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
    public String saveUser(@Valid @ModelAttribute("formUser")AutoUser formUser, BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest){
        if (bindingResult.hasErrors()){
            return "user/registrati";
        }
        formUser.setPassword("{noop}"+formUser.getPassword());
        Optional<Role> roleUser = roleRepository.findById("USER");
        if (roleUser.isPresent()){
            Set<Role> s = Collections.singleton((roleUser.get()));
            formUser.setRoleSet(s);
        }
        autoUserRepository.save(formUser);
        redirectAttributes.addFlashAttribute("redirectMessage",
                "Ciao " + formUser.getUsername() + " la tua registrazione è andata a buon fine!");
        return "redirect:/";
    }

}
