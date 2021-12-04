package com.td1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.td1.dao.EtudiantsRepository;
import com.td1.entites.Etudiants;

@RestController
@RequestMapping(value = "/etudiants")
public class EtudiantsController {

	@Autowired
	EtudiantsRepository etudiantsRepository;
	
	@GetMapping("/list")
	public List<Etudiants> etudiantList(){
		return etudiantsRepository.findAll();
	}
	@GetMapping("/")
	public Optional<Etudiants> etudiant(@RequestParam Long etudiantId) {
		return etudiantsRepository.findById(etudiantId);
	}
	
}
