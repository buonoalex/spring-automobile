package org.learning.springautomobile.controller;

import jakarta.validation.Valid;
import org.learning.springautomobile.model.Acquisto;
import org.learning.springautomobile.repository.AcquistoRecovery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home/auto/acquisto")
public class AcquistoController {

    @Autowired
    private AcquistoRecovery acquistoRecovery;

    @GetMapping
    public String index(){
        return "";
    }

    @GetMapping("/create")
    public String createAcquisto(Model model){
        Acquisto acquisto = new Acquisto();
        model.addAttribute("acquisto",acquisto);
        return "";
    }

    @PostMapping("/create")
    public String saveAcquisto(@Valid @ModelAttribute("acquisto") Acquisto formAcquisto, BindingResult bindingResult){
        return "";
    }

}
