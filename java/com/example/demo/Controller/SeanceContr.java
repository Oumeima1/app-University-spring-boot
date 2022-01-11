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


import com.example.demo.DAO.SeanceR;

import com.example.demo.entities.Seance;
@Controller
@RequestMapping("/Sceance/")
public class SeanceContr {
	private final SeanceR sceanceRepository;
    @Autowired
    public SeanceContr(SeanceR sceanceRepository) {
        this.sceanceRepository = sceanceRepository;
    }
    
    @GetMapping("list")
    public String listSalles(Model model) {
        model.addAttribute("sceance", sceanceRepository.findAll());
        return "Sceance/listSceance";
    }
    
    @GetMapping("add")
    public String showAddSalleForm(Seance sceance) {
        return "Sceancee/addSceance";
    }
    
    @PostMapping("add")
    public String addSceance(@Valid Seance sceance, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/addSceance";
        }
        sceanceRepository.save(sceance);
        return "redirect:list";
    }
    
    @GetMapping("delete/{id}")
public String deleteSceance(@PathVariable("id") long id, Model model) {
        Seance sceance = sceanceRepository.findById(id)
            .orElseThrow(()-> new IllegalArgumentException("Invalid sceance Id:" + id));
        sceanceRepository.delete(sceance);
        model.addAttribute("sceance",sceanceRepository.findAll());
        return "sceance/listSceance";
    }
    
    
    @GetMapping("edit/{id}")
    public String showSceanceFormToUpdate(@PathVariable("id") long id, Model model) {
        Seance sceance = sceanceRepository.findById(id)
            .orElseThrow(()->new IllegalArgumentException("Invalid sceance Id:" + id));
        model.addAttribute("sceance", sceance);
        return "sceance/updateSceance";
    }
    @PostMapping("update/{id}")
    public String updateSceance(@PathVariable("id") long id, @Valid Seance seance, BindingResult result,
        Model model) {
        if (result.hasErrors()) {
            seance.setId(id);
            return "sceance/updateSceance";
        }
        sceanceRepository.save(seance);
        model.addAttribute("sceance", sceanceRepository.findAll());
        return "sceance/listSceance";
    }
}
