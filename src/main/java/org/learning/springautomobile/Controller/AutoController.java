package org.learning.springautomobile.Controller;

import org.learning.springautomobile.Repository.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
