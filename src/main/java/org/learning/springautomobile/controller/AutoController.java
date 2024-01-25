package org.learning.springautomobile.controller;

import org.learning.springautomobile.model.Auto;
import org.learning.springautomobile.repository.AcquistoClienteRepository;
import org.learning.springautomobile.repository.AcquistoRifornitoreRepository;
import org.learning.springautomobile.repository.AutoRepository;
import org.learning.springautomobile.repository.AutoTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
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
    public String index(Model model) {
        List<Auto> listaAuto = autoRepository.findAll();
        model.addAttribute("listaAuto", listaAuto);
        //Creare una search con una parola chiave
        //Se la parola chiave è presente faccio la ricerca
        //altrimenti recupero la lista delle auto
        //aggiungo la lista di auto agli attributi del model
        //precarico il value dell'input di ricerca con la stringa della search
        return "automobili/list";
    }

    //Metodo che mostra i dettagli dell'auto
    @GetMapping("/show/{id}")
    public String show () {
        // nel corpo del metodo ho l'id dell'auto da cercare
        // verifico se l'auto è stata trovata
        // estraggo l'auto dall'Optional
        // aggiungo al Model l'attributo con l'auto
        // restituisco il template
        // gestisco il caso in cui nel database un'auto con quell'id non c'è
        return "";
    }

    // metodo create che mostra la pagina col form di aggiunta di una nuova auto
    @GetMapping("/create")
    public String create() {
        return "";
    }

    // metodo che riceve il submit del form di creazione e salva su db il Book
    @PostMapping("/create")
    public String store() {
        // valido i dati dell'auto, cioè verifico se la mappa BindingResult ha errori
        // qui gestisco che ho campi non validi
        // ricaricando il template del form
        // passo tramite Model la lista di tutte le AutoType disponibili
        // se esiste già ritorno un errore
        // se sono validi lo salvo su db
        // faccio una redirect alla pagina di dettaglio dell'auto appena creato
        return "";
    }

    // metodo che restituisce la pagina di modifica del Book
    @GetMapping("/edit/{id}")
    public String edit() {
        // recupero L'auto da database
        // verifico se L'auto è presente
        // lo passo come attributo del Model
        // passo la lista di tutte le AutoType
        // ritorno il template
        return "";
    }

    // metodo che riceve il submit del form di edit
    @PostMapping("/edit/{id}")
    public String update() {
        // valido i dati dell'auto
        // se ci sono errori di validazione
        // se sono validi salvo l'auto su db
        // recupero gli acquisti
        // faccio la redirect alla pagina di dettaglio dell'auto
        return "";
    }

    // metodo che cancella un'auto presa per id
    @PostMapping("/delete/{id}")
    public String delete() {
        // verifico se l'auto è presente su db
        // se c'è lo cancello
        // mando un messaggio di successo con la redirect
        // se non c'è sollevo un'eccezione
        return "";
    }

}
