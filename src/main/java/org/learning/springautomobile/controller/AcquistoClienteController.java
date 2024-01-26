package org.learning.springautomobile.controller;

import org.learning.springautomobile.model.AutoType;
import org.learning.springautomobile.repository.AcquistoClienteRepository;
import org.learning.springautomobile.repository.AutoTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/acquistoCliente")
public class AcquistoClienteController {

    @Autowired
    private AcquistoClienteRepository acquistoClienteRepository;

    @Autowired
    private AutoTypeRepository autoTypeRepository;

    @GetMapping
    public String index(Model model) {
        List<AutoType> autoTypeList = autoTypeRepository.findAll();
        model.addAttribute("autoTypeList",autoTypeList);
        return "";
    }

}
