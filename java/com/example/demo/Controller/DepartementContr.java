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
import com.example.demo.DAO.DepartementR;
import com.example.demo.entities.Departement;

/*@RestController
public class DepartementContr {
	@Autowired
	private DepartementR dept;

	@PostMapping("departement")
	public void ajouter(@RequestBody Departement d) {
		dept.save(d);
	}

	@GetMapping(value = "departement")
	public List<Departement> getAllDepartement() {
		return (List<Departement>) dept.findAll();
	}
}*/
@Controller
@RequestMapping("/Departement/")
public class DepartementContr {
	private final DepartementR departementRepository;
    @Autowired
    public DepartementContr(DepartementR departementRepository) {
        this.departementRepository = departementRepository;
    }
    
    @GetMapping("list")
    public String listDepartement(Model model) {
        model.addAttribute("departement", departementRepository.findAll());
        return "cours/listDepartement";
    }
    
    @GetMapping("add")
    public String showAddDepartementForm(Departement departement) {
        return "cours/addDepartement";
    }
    
    @PostMapping("add")
    public String addCours(@Valid Departement departement, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/addDepartement";
        }
        departementRepository.save(departement);
        return "redirect:list";
    }
    
    @GetMapping("delete/{id}")
    public String deleteDepartement(@PathVariable("id") long id, Model model) {
        Departement  departement = departementRepository.findById(id)
            .orElseThrow(()-> new IllegalArgumentException("Invalid departement Id:" + id));
        departementRepository.delete(departement);
        model.addAttribute("cours", departementRepository.findAll());
        return "cours/listCours";
    }
    
    
    @GetMapping("edit/{id}")
    public String showCoursFormToUpdate(@PathVariable("id") long id, Model model) {
        Departement departement = departementRepository.findById(id)
            .orElseThrow(()->new IllegalArgumentException("Invalid departement Id:" + id));
        model.addAttribute("departement", departement);
        return "departement/updateDepartement";
    }
    @PostMapping("update/{id}")
    public String updateCours(@PathVariable("id") long id, @Valid Departement departement, BindingResult result,
        Model model) {
        if (result.hasErrors()) {
            departement.setId(id);
            return "departement/updateDepartement";
        }
        departementRepository.save(departement);
        model.addAttribute("departement", departementRepository.findAll());
        return "departement/listDepartement";
    }


}
