package com.td1.webcontroller;

import java.util.List;
import java.util.Optional;

import javax.persistence.PostRemove;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.td1.dao.DepartementRepository;
import com.td1.dao.EtudiantsRepository;
import com.td1.entites.Departement;
import com.td1.entites.Etudiants;

@Controller
@RequestMapping(value="/td")
public class EtudiantsWebController {
	@Autowired
	private EtudiantsRepository ER;
	@Autowired
	private DepartementRepository DR;
	
	@GetMapping("/index")
	public String index (Model model) {
		model.addAttribute("message", "Bonjour à tous");
		return "etudiants";
	}

	@GetMapping("/list")
	public String etudiantList(Model model){
		List<Etudiants> etds = ER.findAll();
		model.addAttribute("etudiantslist", etds);
		return "etudiantslist";
	}
	
	@PostMapping("/add")
	public String add(Etudiants etds){
		ER.save(etds);
		return "redirect:/td/list";
	}

	@GetMapping("/add")
	public String add(Model model){
		Etudiants etds = new Etudiants();
		model.addAttribute("etudiants", etds);
		return "etudiantsadd";
	}

	@PutMapping("/edit/{id}")
	public String editput(Etudiants etds){
		ER.save(etds);
		return "redirect:/td/list";
	}

	@GetMapping("/edit/{id}")
	public String editget(Model model, @PathVariable Long id){
		Optional<Etudiants> etds = ER.findById(id);
		model.addAttribute("etds", etds.get());
		List<Departement> dep = DR.findAll();
		model.addAttribute("deps", dep);
		return "etudiantsedit";
	}

	@RequestMapping("/delete/{id}")
	public String delete(Model model, @PathVariable Long id) {
		ER.deleteById(id);

		return "redirect:../list";
	}

	@RequestMapping(path = "/new")
	public String addEtudiant() {
		return "addDepartement";
	}}
