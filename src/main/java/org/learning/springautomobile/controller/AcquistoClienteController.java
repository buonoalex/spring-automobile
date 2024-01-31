package org.learning.springautomobile.controller;

import jakarta.validation.Valid;
import org.learning.springautomobile.model.AcquistoCliente;
import org.learning.springautomobile.model.Auto;
import org.learning.springautomobile.model.AutoType;
import org.learning.springautomobile.repository.AcquistoClienteRepository;
import org.learning.springautomobile.repository.AutoRepository;
import org.learning.springautomobile.repository.AutoTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/acquistoCliente")
public class AcquistoClienteController {

    @Autowired
    private AcquistoClienteRepository acquistoClienteRepository;

    @Autowired
    private AutoRepository autoRepository;

    @Autowired
    private AutoTypeRepository autoTypeRepository;

    @GetMapping("/create/{id}")
    public String index(@PathVariable int id, Model model) {
        //autoType list
        List<AutoType> autoTypeList = autoTypeRepository.findAll();
        model.addAttribute("autoTypeList",autoTypeList);
        //auto da inserire
        Optional<Auto> autoRecovery = autoRepository.findById(id);
        if (autoRecovery.isPresent()){
            model.addAttribute("auto",autoRecovery.get());
            //creare una nuova instanza dim AcquistoCliente
            AcquistoCliente acquistoCliente = new AcquistoCliente();
            acquistoCliente.setData(LocalDate.now());
            acquistoCliente.setAuto(autoRecovery.get());
            model.addAttribute("acquistoCliente",acquistoCliente);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"l'auto con id "+id+" non esiste");
        }
        return "acquisto/formAcquisto";
    }

    @PostMapping("/create/{id}")
    public String saveAcquisto(@Valid @ModelAttribute("acquistoCliente") AcquistoCliente fornAcquistoCliente,Model model, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "acquisto/formAcquisto";
        }else{
            acquistoClienteRepository.save(fornAcquistoCliente);
            return "redirect:/";
        }
    }



}
