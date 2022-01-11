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

import com.example.demo.DAO.EnseignantR;
import com.example.demo.entities.Enseignant;
@Controller
@RequestMapping("/enseignant/")
public class EnseignantContr {
	private final EnseignantR enseignantRepository;
    @Autowired
    public EnseignantContr(EnseignantR enseignantRepository) {
        this.enseignantRepository = enseignantRepository;
    }
    
    @GetMapping("list")
    public String listProviders(Model model) {
        model.addAttribute("enseignant", enseignantRepository.findAll());
        return "enseignant/listenseignant";
    }
    
    @GetMapping("add")
    public String showAddProviderForm(Enseignant enseignant) {
        return "enseignant/addenseignant";
    }
    
    @PostMapping("add")
    public String addenseignant(@Valid Enseignant enseignant, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/addenseignant";
        }
        enseignantRepository.save(enseignant);
        return "redirect:list";
    }
    
    @GetMapping("delete/{id}")
public String deleteenseignant(@PathVariable("id") long id, Model model) {
        Enseignant enseignant = enseignantRepository.findById(id)
            .orElseThrow(()-> new IllegalArgumentException("Invalid enseignant Id:" + id));
        enseignantRepository.delete(enseignant);
        model.addAttribute("enseignant", enseignantRepository.findAll());
        return "enseignant/listenseignant";
    }
    
    
    @GetMapping("edit/{id}")
    public String showenseignantFormToUpdate(@PathVariable("id") long id, Model model) {
        Enseignant enseignant = enseignantRepository.findById(id)
            .orElseThrow(()->new IllegalArgumentException("Invalid enseignant Id:" + id));
        model.addAttribute("enseignant", enseignant);
        return "enseignant/updateenseignant";
    }
    @PostMapping("update/{id}")
    public String updateenseignant(@PathVariable("id") long id, @Valid Enseignant enseignant, BindingResult result,
        Model model) {
        if (result.hasErrors()) {
            enseignant.setMatricule(id);
            return "enseignant/updateEnseignant";
        }
        enseignantRepository.save(enseignant);
        model.addAttribute("courrs", enseignantRepository.findAll());
        return "enseignant/listenseignant";
    }


}
