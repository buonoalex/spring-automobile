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
@RequestMapping("/autoType")
public class AutoTypeController {
    @Autowired
    private AutoRepository autoRepository;

    @Autowired
    private AutoTypeRepository autoTypeRepository;

    // METODO INDEX CHE MOSTRA LA LISTA DELLE TIPOLOGIE DI AUTO
    @GetMapping
    public String index(Model model) {
        // AL TEMPLATE DEVO FARE ARRIVARE LA LISTA DI TUTTE LE TIPOLOGIE
        model.addAttribute("autoTypeList", autoTypeRepository.findAll());
        return "";
    }

    // METODO CHE CREA UNA TIPOLOGIA
    @GetMapping("/create")
    public String create(Model model) {
        // PREPARO IL TEMPLATE COL FORM DI CREAZIONE TIPOLOGIE
        model.addAttribute("formAutoType", new AutoType());
        return "";
    }

    @PostMapping("/create")
    public String store(@PathVariable Integer id, @Valid @ModelAttribute("autoType") AutoType formAutoType, BindingResult bindingResult){
        // VALIDO LE TIPOLOGIE
        if (bindingResult.hasErrors()) {
        // SE CI SONO ERRORI RICARICO LA PAGINA COL FORM
           return "";
        }
        // SE NON CI SONO ERRORI SALVO LE TIPOLOGIE SUL DATABASE
       autoTypeRepository.save(formAutoType);
        // FACCIO LA REDIRECT ALLA LISTA DI ""
       return "redirect:/";
    }

    // METODO CHE MODIFICA UNA TIPOLOGIA
    @GetMapping("/edit/{id}")
    public String update(@PathVariable Integer id, Model model) {
        // RECUPERO L'AUTOTYPE CON QUELL'ID DA DATABASE
        Optional<AutoType> result = autoTypeRepository.findById(id);
        // SE E' PRESENTE PRECARICO IL FORM CON L'AUTOTYPE
        if (result.isPresent()) {
            // LO PASSO COME ATTRIBUTO AL MODEL
            model.addAttribute("autoType", result.get());
            // RESTITUISCO IL TEMPLATE
            return "";
        } else {
            // ALTRIMENTI SOLLEVO UN'ECCEZIONE HTTP 404
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Le tipologie per id " + id + " non sono state trovate!");
        }
    }

    // METODO PER RICEVERE IL SUBMIT DEL FORM EDIT
    @PostMapping("/edit/{id}")
    public String update(@PathVariable Integer id, @Valid @ModelAttribute("autoType") AutoType formAutoType, BindingResult bindingResult) {
        Optional<AutoType> result = autoTypeRepository.findById(id);
        if (result.isPresent()) {
            AutoType autoTypeToEdit = result.get();
            // VALIDO L'AUTOTYPE
            if(bindingResult.hasErrors()) {
            // SE CI SONO ERRORI RICARICO LA PAGINA COL FORM DI EDIT
                return "";
            }
            // SE NON CI SONO ERRORI LO SALVO SUL DATABASE
            AutoType savedAutoType = autoTypeRepository.save(formAutoType);
            return "redirect:";
        } else {
            // ALTRIMENTI SOLLEVO UN'ECCEZIONE HTTP 404
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Le tipologie per id \" + id + \" non sono state trovate!");
        }
    }

    // METODO CHE ELIMINA UNA TIPOLOGIA
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        // VERIFICO SE L'AUTOTYPE CON L'ID PASSATO ESISTE
        Optional<AutoType> result = autoTypeRepository.findById(id);
        // SE ESISTE LO ELIMINO DAL DATABASE
        if (result.isPresent()) {
            autoTypeRepository.deleteById(id);
            /*return "redirect:/autoType";*/
            return "";
        } else {
            // ALTRIMENTI SOLLEVO UN'ECCEZIONE HTTP 404
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Le tipologie per id " + id + " non sono state trovate!");
        }
    }
}
