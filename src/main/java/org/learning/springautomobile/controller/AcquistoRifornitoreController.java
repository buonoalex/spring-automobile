package org.learning.springautomobile.controller;

import org.learning.springautomobile.model.AcquistoRifornitore;
import org.learning.springautomobile.repository.AcquistoRifornitoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/acquistoRifornitore")
public class AcquistoRifornitoreController {

    @Autowired
    private AcquistoRifornitoreRepository acquistoRifornitoreRepository;

    @GetMapping
    public String index(Model model){
        model.addAttribute("rifornimentoList",acquistoRifornitoreRepository.findAll());
        return "rifornimento/index";
    }

    @GetMapping("/create")
    public String createRifornimento(Model model){
        model.addAttribute("riforimento",new AcquistoRifornitore());
        return "rifornimento/create";
    }
}
