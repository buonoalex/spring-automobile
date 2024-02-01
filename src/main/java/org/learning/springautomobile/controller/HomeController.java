package org.learning.springautomobile.controller;

import org.learning.springautomobile.compare.AutoVenditeComparator;
import org.learning.springautomobile.model.Auto;
import org.learning.springautomobile.model.AutoType;
import org.learning.springautomobile.repository.AutoRepository;
import org.learning.springautomobile.repository.AutoTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private AutoTypeRepository autoTypeRepository;

    @Autowired
    private AutoRepository autoRepository;

    @GetMapping
    public String home(Model model) {
        List<AutoType> autoTypeList = autoTypeRepository.findAll();
        model.addAttribute("autoTypeList",autoTypeList);
        //Bonus Auto
        List<Auto> autoList = autoRepository.findAll();
        if (autoList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "non ci sono auto");
        }else{
            Collections.sort(autoList, new AutoVenditeComparator());
            Collections.reverse(autoList);
            List<Auto> b = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                b.add(i,autoList.get(i));
            }
            model.addAttribute("autoList",b);
            //Fine Logica Bonus
        }

        //Logica logo
        List<Auto> autoListLogo = autoRepository.findAll();
        Set<Auto> logoList = new HashSet<>();
        for (Auto auto1: autoListLogo){
            Boolean check = false;
            for (Auto auto2: autoListLogo){
                if (auto1.equals(auto2) || !check){
                    logoList.add(auto1);
                    check = true;
                }else {
                    logoList.add(auto2);
                }
            }
        }
        model.addAttribute("logoList",logoList);
        //Fine logica logo

        return "home/landing-page";
    }

}
