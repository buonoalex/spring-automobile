package org.learning.springautomobile.controller;

import jakarta.validation.Valid;
import org.learning.springautomobile.model.AcquistoRifornitore;
import org.learning.springautomobile.repository.AcquistoRifornitoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/acquistoRifornitore")
public class AcquistoRifornitoreController {

    @Autowired
    private AcquistoRifornitoreRepository acquistoRifornitoreRepository;

    @GetMapping
    public String index(Model model){
        List<AcquistoRifornitore> acquistoRifornitoreList = acquistoRifornitoreRepository.findAll();
        model.addAttribute("rifornimentoList",acquistoRifornitoreList);
        return "rifornimento/index";
    }

    @GetMapping("/create")
    public String createRifornimento(Model model){
        model.addAttribute("rifornimento",new AcquistoRifornitore());
        return "rifornimento/create";
    }

    @PostMapping("/create")
    public String saveRifornimento(AcquistoRifornitore formAcquistoRifornitore, Model model){
        acquistoRifornitoreRepository.save(formAcquistoRifornitore);
        return "redirect:/acquistoRifornitore";

    }
}
