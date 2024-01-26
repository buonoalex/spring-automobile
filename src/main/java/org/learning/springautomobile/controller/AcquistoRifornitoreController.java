package org.learning.springautomobile.controller;

import jakarta.validation.Valid;
import org.learning.springautomobile.model.AcquistoRifornitore;
import org.learning.springautomobile.model.Auto;
import org.learning.springautomobile.model.AutoType;
import org.learning.springautomobile.repository.AcquistoRifornitoreRepository;
import org.learning.springautomobile.repository.AutoRepository;
import org.learning.springautomobile.repository.AutoTypeRepository;
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

    @Autowired
    private AutoRepository autoRepository;

    @Autowired
    private AutoTypeRepository autoTypeRepository;


    @GetMapping
    public String index(Model model){
        List<AcquistoRifornitore> acquistoRifornitoreList = acquistoRifornitoreRepository.findAll();
        model.addAttribute("rifornimentoList",acquistoRifornitoreList);
        List<AutoType> autoTypeList = autoTypeRepository.findAll();
        model.addAttribute("autoTypeList",autoTypeList);
        return "rifornimento/index";
    }

    @GetMapping("/create")
    public String createRifornimento(Model model){
        model.addAttribute("rifornimento",new AcquistoRifornitore());
        List<Auto> autoList = autoRepository.findAll();
        model.addAttribute("autoList",autoList);
        return "rifornimento/create";
    }

    @PostMapping("/create")
    public String saveRifornimento(@Valid @ModelAttribute("acquistoRifornitore") AcquistoRifornitore formAcquistoRifornitore, Model model, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "rifornimento/create";
        }else {
            acquistoRifornitoreRepository.save(formAcquistoRifornitore);
            return "redirect:/acquistoRifornitore";
        }
    }
}
