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

import com.example.demo.DAO.GroupeR;

import com.example.demo.entities.Groupe;
@Controller
@RequestMapping("/Groupe/")
public class GroupeContr {
	private final GroupeR groupeRepository;
    @Autowired
    public GroupeContr(GroupeR groupeRepository) {
        this.groupeRepository = groupeRepository;
    }
    
    @GetMapping("list")
    public String listGroupe(Model model) {
        model.addAttribute("groupe", groupeRepository.findAll());
        return "groupe/listGroupe";
    }
    
    @GetMapping("add")
    public String showAddGroupeForm(Groupe groupe) {
        return "groupe/addGroupe";
    }
    
    @PostMapping("add")
    public String addGroupe(@Valid Groupe groupe, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/addGroupe";
        }
        groupeRepository.save(groupe);
        return "redirect:list";
    }
    
    @GetMapping("delete/{id}")
public String deleteGroupe(@PathVariable("id") long id, Model model) {
        Groupe   groupe = groupeRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid groupe Id:" + id));
        groupeRepository.delete(groupe);
        model.addAttribute("groupe", groupeRepository.findAll());
        return "groupe/listGroupe";
    }
    
    
    @GetMapping("edit/{id}")
    public String showCoursFormToUpdate(@PathVariable("id") long id, Model model) {
        Groupe groupe = groupeRepository.findById(id)
            .orElseThrow(()->new IllegalArgumentException("Invalid groupe Id:" + id));
        model.addAttribute("groupe", groupe);
        return "groupe/updateGroupe";
    }
    @PostMapping("update/{id}")
    public String updateCours(@PathVariable("id") long id, @Valid Groupe groupe, BindingResult result,
        Model model) {
        if (result.hasErrors()) {
            groupe.setId(id);
            return "groupe/updateGroupe";
        }
        groupeRepository.save(groupe);
        model.addAttribute("groupe", groupeRepository.findAll());
        return "groupe/listGroupe";
    }


}
