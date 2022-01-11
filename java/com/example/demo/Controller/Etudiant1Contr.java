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
import com.example.demo.DAO.Etudiant1R;
import com.example.demo.entities.Etudiants;
import com.example.demo.entities.Salle;
@Controller
@RequestMapping("/Etudiant1/")
public class Etudiant1Contr {
	private final Etudiant1R etudiantRepository;
    @Autowired
    public Etudiant1Contr(Etudiant1R etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }
    
    @GetMapping("list")
    public String listEtudiant(Model model) {
        model.addAttribute("etudiant", etudiantRepository.findAll());
        return "Etudiant/listEtudiant";
    }
    
    @GetMapping("add")
    public String showAddEtudiantForm(Salle salle) {
        return "Etudiant/addEtudiant";
    }
    
    @PostMapping("add")
    public String addEtudiant(@Valid Etudiants etudiant, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/addEtudiant";
        }
        etudiantRepository.save(etudiant);
        return "redirect:list";
    }
    
    @GetMapping("delete/{id}")
public String deleteCours(@PathVariable("id") long id, Model model) {
        Etudiants etudiant = etudiantRepository.findById(id)
            .orElseThrow(()-> new IllegalArgumentException("Invalid etudiant Id:" + id));
        etudiantRepository.delete(etudiant);
        model.addAttribute("etudiant",etudiantRepository.findAll());
        return "etudiant/listEtudiant";
    }
    
    
    @GetMapping("edit/{id}")
    public String showCoursFormToUpdate(@PathVariable("id") long id, Model model) {
        Etudiants etudiant = etudiantRepository.findById(id)
            .orElseThrow(()->new IllegalArgumentException("Invalid etudiant Id:" + id));
        model.addAttribute("etudiant", etudiant);
        return "salle/updateEtudiant";
    }
    @PostMapping("update/{id}")
    public String updateCours(@PathVariable("id") long id, @Valid Etudiants etudiant, BindingResult result,
        Model model) {
        if (result.hasErrors()) {
            etudiant.setIdE(id);
            return "cours/updateCours";
        }
        etudiantRepository.save(etudiant);
        model.addAttribute("etudiant", etudiantRepository.findAll());
        return "etudiant/listEtudiant";
    } 
}