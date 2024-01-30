package org.learning.springautomobile.controller;

import jakarta.validation.Valid;
import org.learning.springautomobile.model.Auto;
import org.learning.springautomobile.model.AutoType;
import org.learning.springautomobile.repository.AcquistoClienteRepository;
import org.learning.springautomobile.repository.AcquistoRifornitoreRepository;
import org.learning.springautomobile.repository.AutoRepository;
import org.learning.springautomobile.repository.AutoTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/auto")
public class AutoController {

    @Autowired
    private AutoRepository autoRepository;

    @Autowired
    private AutoTypeRepository autoTypeRepository;

    @Autowired
    private AcquistoClienteRepository acquistoClienteRepository;

    @Autowired
    private AcquistoRifornitoreRepository acquistoRifornitoreRepository;


    // metodo index che mostra la lista di tutti i libri
    @GetMapping
    public String index(@RequestParam(name = "Keyword", required = false)String searchKeyword, Model model) {
        List<AutoType> autoTypeList = autoTypeRepository.findAll();
        model.addAttribute("autoTypeList",autoTypeList);
        List<Auto> listaAuto;
        //Creare una search con una parola chiave
        if (searchKeyword != null) {
            //Se la parola chiave è presente faccio la ricerca
            listaAuto = autoRepository.findByNameContaining(searchKeyword);

        } else {
            //altrimenti recupero la lista delle auto
            listaAuto = autoRepository.findAll();
        }
        //aggiungo la lista di auto agli attributi del model
        model.addAttribute("listaAuto", listaAuto);
        //precarico il value dell'input di ricerca con la stringa della search
        model.addAttribute("preloadSearch", searchKeyword);
        return "automobili/list";
    }

    @GetMapping("/{id}")
    public String autoTypeShow(@PathVariable int id,Model model){
        //Prendo oggetto autotype selezionato nel filtro
        Optional<AutoType> autoTypeRecovery = autoTypeRepository.findById(id);
        AutoType autoType = autoTypeRecovery.get();
        //Autotype per vedere le categorie sulla Nav-Bar
        List<AutoType> autoTypeList = autoTypeRepository.findAll();
        model.addAttribute("autoTypeList",autoTypeList);
        //Logica Filtro per Autotype
        List<Auto> listaAuto = autoType.getAutoList();
        model.addAttribute("listaAuto",listaAuto);
        return "automobili/list";
    }

    //Metodo che mostra i dettagli dell'auto
    @GetMapping("/show/{id}")
    public String show (@PathVariable Integer id, Model model) {
        // nel corpo del metodo ho l'id dell'auto da cercare
        Optional<Auto> result = autoRepository.findById(id);
        // verifico se l'auto è stata trovata
        if (result.isPresent()) {
            // estraggo l'auto dall'Optional
            Auto auto = result.get();
            // aggiungo al Model l'attributo con l'auto
            model.addAttribute("auto", auto);
            // restituisco il template
            return "automobili/show";
        } else {
            // gestisco il caso in cui nel database un'auto con quell'id non c'è
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'auto con l'id " + id + " non è stata trovata");
        }
    }

    // metodo create che mostra la pagina col form di aggiunta di una nuova auto
    @GetMapping("/create")
    public String create(Model model) {
        Auto auto = new Auto();
        // passo tramite Model un attributo di tipo Auto vuoto
        model.addAttribute("auto", auto);
        // passo tramite Model la lista di tutti i modelli di Auto disponibili
        model.addAttribute("autoTypeList", autoTypeRepository.findAll());
        return "automobili/create";
    }

    // metodo che riceve il submit del form di creazione e salva su db il Book
    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("auto") Auto formAuto, BindingResult bindingResult, Model model) {
        // valido i dati dell'auto, cioè verifico se la mappa BindingResult ha errori
        if (bindingResult.hasErrors()) {
            // qui gestisco che ho campi non validi
            // ricaricando il template del form
            // passo tramite Model la lista di tutte le AutoType disponibili
            model.addAttribute("autoTypeList", autoTypeRepository.findAll());
            return "automobili/create";
        } else {
            // se sono validi lo salvo su db
            Auto savedAuto = autoRepository.save(formAuto);
            // faccio una redirect alla pagina di dettaglio dell'auto appena creato
            return "redirect:/admin/acquistoRifornitore/catalogoAuto";
        }
    }

    // metodo che restituisce la pagina di modifica del Book
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        // recupero L'auto da database
        Optional<Auto> result = autoRepository.findById(id);
        // verifico se L'auto è presente
        if (result.isPresent()) {
            // lo passo come attributo del Model
            model.addAttribute("auto", result.get());
            // passo la lista di tutte le AutoType
            model.addAttribute("autoTypeList", autoTypeRepository.findAll());
            // ritorno il template
            return "automobili/edit";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'auto con l'id " + id + " non è stata trovata");
        }
    }

    // metodo che riceve il submit del form di edit
    @PostMapping("/edit/{id}")
    public String update(@PathVariable Integer id, @Valid @ModelAttribute("auto") Auto formAuto, BindingResult bindingResult) {
        Optional<Auto> result = autoRepository.findById(id);
        if (result.isPresent()) {
           // Auto autoToEdit = result.get();
            // valido i dati dell'auto
            if (bindingResult.hasErrors()) {
                return "automobili/edit";
            }
            // se sono validi salvo l'auto su db
            Auto savedAuto = autoRepository.save(formAuto);
            // faccio la redirect alla pagina di dettaglio del libro
            return "redirect:/auto/show/" + id;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'auto con l'id " + id + " non è stata trovata");
        }
    }

    // metodo che cancella un'auto presa per id
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        // verifico se l'auto è presente su db
        Optional<Auto> result =autoRepository.findById(id);
        if (result.isPresent()) {
            // se c'è lo cancello
            autoRepository.deleteById(id);
            // mando un messaggio di successo con la redirect
            redirectAttributes.addFlashAttribute("redirectMessage", "L'auto " + result.get().getName() + " è stata cancellata con successo");
            return "redirect:/admin/acquistoRifornitore/catalogoAuto";
        } else {
            // se non c'è sollevo un'eccezione
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'auto con l'id " + id + " non è stata trovata");
        }
    }

}
