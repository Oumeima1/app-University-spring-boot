package com.example.demo.Controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.demo.DAO.SalleR;

import com.example.demo.entities.Salle;
@Controller
@RequestMapping("/Salle/")
public class SalleContr {
	private final SalleR salleRepository;
    @Autowired
    public SalleContr(SalleR salleRepository) {
        this.salleRepository = salleRepository;
    }
    
    @GetMapping("list")
    public String listSalles(Model model) {
        model.addAttribute("salle", salleRepository.findAll());
        return "Salle/listSalle";
    }
    
    @GetMapping("add")
    public String showAddSalleForm(Salle salle) {
        return "Salle/addSalle";
    }
    
    @PostMapping("add")
    public String addSalle(@Valid Salle salle, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/addSalle";
        }
        salleRepository.save(salle);
        return "redirect:list";
    }
    
    @GetMapping("delete/{id}")
public String deleteCours(@PathVariable("id") long id, Model model) {
        Salle salle = salleRepository.findById(id)
            .orElseThrow(()-> new IllegalArgumentException("Invalid salle Id:" + id));
        salleRepository.delete(salle);
        model.addAttribute("salle",salleRepository.findAll());
        return "salle/listSalle";
    }
    
    
    @GetMapping("edit/{id}")
    public String showCoursFormToUpdate(@PathVariable("id") long id, Model model) {
        Salle salle = salleRepository.findById(id)
            .orElseThrow(()->new IllegalArgumentException("Invalid cours Id:" + id));
        model.addAttribute("salle", salle);
        return "salle/updateSalle";
    }
    @PostMapping("update/{id}")
    public String updateCours(@PathVariable("id") long id, @Valid Salle salle, BindingResult result,
        Model model) {
        if (result.hasErrors()) {
            salle.setId(id);
            return "cours/updateCours";
        }
        salleRepository.save(salle);
        model.addAttribute("salle", salleRepository.findAll());
        return "salle/listSalle";
    }
}

