package com.td1.entites;

import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@Data
public class Specialite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_specialite;
	@Column(nullable = false)
	private String libelle_specialite;
	@OneToMany(mappedBy = "id_specialite")
    @Getter(onMethod = @__( @JsonIgnore ))
	private Collection<Etudiants> etudiants;
	
}
