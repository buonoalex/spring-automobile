package org.learning.springautomobile.controller;

import jakarta.validation.Valid;
import org.learning.springautomobile.model.Acquisto;
import org.learning.springautomobile.model.AutoType;
import org.learning.springautomobile.repository.AutoRepository;
import org.learning.springautomobile.repository.AutoTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Controller
@RequestMapping("home/auto/autoType")
public class AutoTypeController {
    @Autowired
    private AutoRepository autoRepository;

    @Autowired
    private AutoTypeRepository autoTypeRepository;

    // METODO INDEX CHE MOSTRA LA LISTA DELLE TIPOLOGIE DI AUTO
    @GetMapping
    public String index(Model model) {
        model.addAttribute("autoTypeList", autoTypeRepository.findAll());
        return "";
    }

    // METODO CHE CREA UNA TIPOLOGIA
    @GetMapping
    public String create(Model model) {
        model.addAttribute("formAutoType", new AutoType());
        return "";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("autoType") AutoType formAutoType, BindingResult bindingResult){
        return "";
    }

    // METODO CHE MODIFICA UNA TIPOLOGIA
    @GetMapping("/edit/{id}")
    public String update(@PathVariable Integer id, Model model) {
        Optional<AutoType> result = autoTypeRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("autoType", result.get());
            return "";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Le tipologie per id " + id + " non sono state trovate!");
        }
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable Integer id, @Valid @ModelAttribute("autoType") AutoType formAutoType, BindingResult bindingResult) {
        Optional<AutoType> result = autoTypeRepository.findById(id);
        if (result.isPresent()) {
            AutoType autoTypeToEdit = result.get();
            if(bindingResult.hasErrors()) {
                return "";
            }
            AutoType savedAutoType = autoTypeRepository.save(formAutoType);
            return  "redirect:/ingredienti";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Le tipologie per id \" + id + \" non sono state trovate!");
        }
    }

    // METODO CHE ELIMINA UNA TIPOLOGIA
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Optional<AutoType> result = autoTypeRepository.findById(id);
        if (result.isPresent()) {
            autoTypeRepository.deleteById(id);
            return "redirect:/autoType";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Le tipologie per id " + id + " non sono state trovate!");
        }
    }
}
