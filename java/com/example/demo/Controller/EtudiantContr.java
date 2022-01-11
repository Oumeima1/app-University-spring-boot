package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.DAO.EtudiantR;
import com.example.demo.entities.Etudiants;
import java.util.List;
@Controller
@RequestMapping(value="/etudiants")
public class EtudiantContr {
    
	//Injection de l'etudiant repository
	@Autowired 
	private EtudiantR ET;

    @GetMapping("/Q1")
    public List<Etudiants> Q1(){
	return ET.findAll();
	 
}
  /* @RequestMapping("/AllE")
    public String AfficherE(Model model) {
	List<Etudiants> etds=ET.findAll();
	model.addAttribute("etudiants",etds);
	
	return "Page_etudiants";
}*/
   

 /*  @RequestMapping("/AllEP")
   public String AfficherEP( Model model,@RequestParam(name="page", defaultValue = "0") int p)
    {
	  Page<Etudiants> etds= ET.findAll(PageRequest.of(p, 1));
	  int Nbpages= etds.getTotalPages();
	  int [] pages =new int[Nbpages];
	  for (int i=0; i<Nbpages; i++)
	  {pages[i]=i;}
	  model.addAttribute("pagesNB", pages);
	  model.addAttribute("pc", p);
	  model.addAttribute("etudiants", etds);
	   return "Page_etudiants";
	   
}*/
   @RequestMapping("/AllEP")
   public String AfficherEP( Model model,@RequestParam(name="page", defaultValue = "0") int p,
		   @RequestParam(name="motcle", defaultValue="") String mc)
    {
	   	   
	   
	  Page<Etudiants> etds= ET.findByNomeContaining(mc, PageRequest.of(p, 1));
	  int Nbpages= etds.getTotalPages();
	  int [] pages =new int[Nbpages];
	  for (int i=0; i<Nbpages; i++)
	  {pages[i]=i;}
	  model.addAttribute("pagesNB", pages);
	  model.addAttribute("pc", p);
	  model.addAttribute("etudiants", etds);
	   return "Page_etudiants";
	   
}
  
 /*  @RequestMapping(value="/AjoutE", method=RequestMethod.GET)
   public String formEtudiant(Model model) {
	   
	   model.addAttribute("etudiants", new Etudiants());
	   return "AjouterEtudiant";
	      
   }
   
   @RequestMapping(value="saveEtudiant", method=RequestMethod.POST)
   public String EnregistrerE(Etudiants E) {
	   ET.save(E);
	   return "redirect:AllEP";
   }
   */
   
   
   

}
/*@GetMapping("Q1")
	public List<Etudiants> Q1() {

		return ET.findByDateEDESC();*/
   /* @GetMapping("Q2")
	public List<Etudiants> Q2(){
    	return ET.findByNomeContainingAndNomeContaining();
    }*/
	
/*	@GetMapping("Q3")
	public List<Departement> Q3(){
		return ET.dateemin();	
	}
	
	@GetMapping("Q4")
	public double Q4(){
		return ET.getAVG1();
		
	}
	@GetMapping("Q5")
	public double Q5() {
		return ET.getAVG();
	}
	@GetMapping ("Q7")
	public Collection<Object> Q7(){
		
		return ET.NBDpt();
	}
	
	  @GetMapping("/Q8")
	  public  Collection<Departement> Q8() {
	  return ET.MoinsDept(ET.MoinsDept1());
	  }

	*/
	


