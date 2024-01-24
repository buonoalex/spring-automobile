package org.learning.springautomobile.controller;

import org.learning.springautomobile.repository.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class AutoController {

    @Autowired
    private AutoRepository autoRepository;

    @GetMapping
    public String index() {
        return "automobili/index";
    }
}
