package org.learning.springautomobile.controller;

import jakarta.validation.Valid;
import org.learning.springautomobile.model.AutoType;
import org.learning.springautomobile.repository.AutoRepository;
import org.learning.springautomobile.repository.AutoTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Controller
@RequestMapping("/admin/autoType")
public class AutoTypeController {
    @Autowired
    private AutoRepository autoRepository;

    @Autowired
    private AutoTypeRepository autoTypeRepository;

    // METODO INDEX CHE MOSTRA LA LISTA DELLE AUTOTYPE DI AUTO
    @GetMapping
    public String index(Model model) {
        // AL TEMPLATE DEVO FARE ARRIVARE LA LISTA DI TUTTE LE AUTOTYPE
        model.addAttribute("autoTypeList", autoTypeRepository.findAll());
        return "";
    }

    // METODO CHE CREA UNA TIPOLOGIA
    @GetMapping("/create")
    public String create(Model model,Authentication authentication) {
        //Passo l'utente
        if (authentication != null && authentication.isAuthenticated()){
            model.addAttribute("username", true);
        }else {
            model.addAttribute("username",false);
        }
        // PREPARO IL TEMPLATE COL FORM DI CREAZIONE AUTOTYPE
        model.addAttribute("autoType", new AutoType());
        return "catalogo/create";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("autoType") AutoType formAutoType, BindingResult bindingResult,Authentication authentication,Model model){
        // VALIDO LE TIPOLOGIE
        if (bindingResult.hasErrors()) {
            //Passo l'utente
            if (authentication != null && authentication.isAuthenticated()){
                model.addAttribute("username", true);
            }else {
                model.addAttribute("username",false);
            }
        // SE CI SONO ERRORI RICARICO LA PAGINA COL FORM
           return "catalogo/create";
        }
        // SE NON CI SONO ERRORI SALVO LE TIPOLOGIE SUL DATABASE
       autoTypeRepository.save(formAutoType);
        // FACCIO LA REDIRECT ALLA LISTA DI ""
       return "redirect:/admin/acquistoRifornitore/catalogoCategorie";
    }

    // METODO CHE MODIFICA UNA TIPOLOGIA
    @GetMapping("/edit/{id}")
    public String update(@PathVariable Integer id, Model model, Authentication authentication) {
        //Passo l'utente
        if (authentication != null && authentication.isAuthenticated()){
            model.addAttribute("username", true);
        }else {
            model.addAttribute("username",false);
        }
        // RECUPERO L'AUTOTYPE CON QUELL'ID DA DATABASE
        Optional<AutoType> result = autoTypeRepository.findById(id);
        // SE E' PRESENTE PRECARICO IL FORM CON L'AUTOTYPE
        if (result.isPresent()) {
            // LO PASSO COME ATTRIBUTO AL MODEL
            model.addAttribute("autoType", result.get());
            // RESTITUISCO IL TEMPLATE
            return "catalogo/edit";
        } else {
            // ALTRIMENTI SOLLEVO UN'ECCEZIONE HTTP 404
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Le tipologie per id " + id + " non sono state trovate!");
        }
    }

    // METODO PER RICEVERE IL SUBMIT DEL FORM EDIT
    @PostMapping("/edit/{id}")
    public String update(@PathVariable Integer id, @Valid @ModelAttribute("autoType") AutoType formAutoType, BindingResult bindingResult,Authentication authentication,Model model) {
        Optional<AutoType> result = autoTypeRepository.findById(id);
        if (result.isPresent()) {
            AutoType autoTypeToEdit = result.get();
            // VALIDO L'AUTOTYPE
            if(bindingResult.hasErrors()) {
                //Passo l'utente
                if (authentication != null && authentication.isAuthenticated()){
                    model.addAttribute("username", true);
                }else {
                    model.addAttribute("username",false);
                }
            // SE CI SONO ERRORI RICARICO LA PAGINA COL FORM DI EDIT
                return "catalogo/edit";
            }
            // SE NON CI SONO ERRORI LO SALVO SUL DATABASE
            AutoType savedAutoType = autoTypeRepository.save(formAutoType);
            return "redirect:/admin/acquistoRifornitore/catalogoCategorie";
        } else {
            // ALTRIMENTI SOLLEVO UN'ECCEZIONE HTTP 404
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Le tipologie per id \" + id + \" non sono state trovate!");
        }
    }

    // METODO CHE ELIMINA UNA TIPOLOGIA
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id,Authentication authentication,Model model) {
        // VERIFICO SE L'AUTOTYPE CON L'ID PASSATO ESISTE
        Optional<AutoType> result = autoTypeRepository.findById(id);
        // SE ESISTE LO ELIMINO DAL DATABASE
        if (result.isPresent()) {
            autoTypeRepository.deleteById(id);
            //Passo l'utente
            if (authentication != null && authentication.isAuthenticated()){
                model.addAttribute("username", true);
            }else {
                model.addAttribute("username",false);
            }
            return "redirect:/admin/acquistoRifornitore/catalogoCategorie";
        } else {
            // ALTRIMENTI SOLLEVO UN'ECCEZIONE HTTP 404
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Le tipologie per id " + id + " non sono state trovate!");
        }
    }
}
