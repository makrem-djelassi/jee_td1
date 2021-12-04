package com.td1.entites;

import java.util.*;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Etudiants {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numE;
	
	@Column(nullable = false)
	private String nomE;
	private int niveau;
	@ManyToOne
	@JoinColumn(name = "id_specialite")
	private Specialite id_specialite;
	@ManyToOne
	@JoinColumn(name = "id_departement")
	private Departement id_departement;
	private Date dateEntree;
	private float moyenne;
	
}
