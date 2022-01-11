/*package com.example.demo.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import com.departement.DAO.EtudiantRepo;
//import com.departement.entities.Etudiant;


  @Controller
  @RequestMapping(value="/Etudiant")
  public class EtudiantContrWeb {
    //   @Autowired
	//  private EtudiantRepo ET;
       
       /*@RequestMapping("/index")
       public String Index( Model model)
       {
    	  List<Etudiant> etds= ET.findAll();
    	   model.addAttribute("etudiants", etds);
    	   return "etudiants";
    	   
       }*/
       
       
       
       
      /* @RequestMapping("/index1")
       public String Index1( Model model,@RequestParam(name="page", defaultValue = "0") int p)
       {
    	  Page<Etudiant> etds= ET.findAll(PageRequest.of(p, 3));
    	  int Nbpages= etds.getTotalPages();
    	  int [] pages =new int[Nbpages];
    	  for (int i=0; i<Nbpages; i++)
    	  {pages[i]=i;}
    	  model.addAttribute("pagesNB", pages);
    	  model.addAttribute("pagecourante", p);
    	  model.addAttribute("etudiantpages", etds);
    	   return "etudiants2";
    	   
       }*/
  //}
 