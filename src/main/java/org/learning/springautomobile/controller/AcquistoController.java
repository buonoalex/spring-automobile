package org.learning.springautomobile.controller;

import jakarta.validation.Valid;
import org.learning.springautomobile.model.Acquisto;
import org.learning.springautomobile.model.Auto;
import org.learning.springautomobile.repository.AcquistoRecovery;
import org.learning.springautomobile.repository.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/acquisto")
public class AcquistoController {

    @Autowired
    private AcquistoRecovery acquistoRecovery;

    @Autowired
    private AutoRepository autoRepository;

    @GetMapping
    public String index(){
        return "";
    }

    @GetMapping("/create/{id}")
    public String createAcquisto(@PathVariable int id , Model model){

        /* Commento giusto
        Optional<Auto> auto = autoRepository.findById(id);*/

        //Commento da Cancellare
        Auto auto = new Auto();

        Acquisto acquisto = new Acquisto();
        acquisto.setData(LocalDate.now());

        /* Commento giusto
        acquisto.setAuto(auto.get());*/

        //Commento da Cancelllare
        acquisto.setAuto(auto);
        model.addAttribute("acquisto",acquisto);
        return "acquisto/formAcquisto";
    }

    @PostMapping("/create/{id}")
    public String saveAcquisto(@Valid @ModelAttribute("acquisto") Acquisto formAcquisto, BindingResult bindingResult){
        return "";
    }

}
