package com.td1.entites;

import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.*;

@Entity
@Data
public class Departement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_departement;
	@Column(nullable = false)
	private String libelle_departement;
	@OneToMany(mappedBy = "id_departement")
    @Getter(onMethod = @__( @JsonIgnore ))
	private Collection<Etudiants> edtudiants;
}
