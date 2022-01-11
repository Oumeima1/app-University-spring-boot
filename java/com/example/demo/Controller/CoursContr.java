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

import com.example.demo.DAO.CoursR;
import com.example.demo.entities.Cours;
@Controller
@RequestMapping("/Cours/")
public class CoursContr {
	private final CoursR coursRepository;
    @Autowired
    public CoursContr(CoursR coursRepository) {
        this.coursRepository = coursRepository;
    }
    
    @GetMapping("list")
    public String listProviders(Model model) {
        model.addAttribute("cours", coursRepository.findAll());
        return "cours/listCours";
    }
    
    @GetMapping("add")
    public String showAddProviderForm(Cours cours) {
        return "cours/addCours";
    }
    
    @PostMapping("add")
    public String addCours(@Valid Cours cours, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/addCours";
        }
        coursRepository.save(cours);
        return "redirect:list";
    }
    
    @GetMapping("delete/{id}")
public String deleteCours(@PathVariable("id") long id, Model model) {
        Cours cours = coursRepository.findById(id)
            .orElseThrow(()-> new IllegalArgumentException("Invalid cours Id:" + id));
        coursRepository.delete(cours);
        model.addAttribute("cours", coursRepository.findAll());
        return "cours/listCours";
    }
    
    
    @GetMapping("edit/{id}")
    public String showCoursFormToUpdate(@PathVariable("id") long id, Model model) {
        Cours cours = coursRepository.findById(id)
            .orElseThrow(()->new IllegalArgumentException("Invalid cours Id:" + id));
        model.addAttribute("cours", cours);
        return "cours/updateCours";
    }
    @PostMapping("update/{id}")
    public String updateCours(@PathVariable("id") long id, @Valid Cours cours, BindingResult result,
        Model model) {
        if (result.hasErrors()) {
            cours.setId(id);
            return "cours/updateCours";
        }
        coursRepository.save(cours);
        model.addAttribute("courrs", coursRepository.findAll());
        return "cours/listCours";
    }


}
