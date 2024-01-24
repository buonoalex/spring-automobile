package org.learning.springautomobile.controller;

import org.learning.springautomobile.repository.AutoRepository;
import org.learning.springautomobile.repository.AutoTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("autoType")
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
}
