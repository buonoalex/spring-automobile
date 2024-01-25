package org.learning.springautomobile.controller;

import org.learning.springautomobile.repository.AcquistoClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/acquistoCliente")
public class AcquistoClienteController {

    @Autowired
    private AcquistoClienteRepository acquistoClienteRepository;

    @GetMapping
    public String index(){
        return "";
    }

}
