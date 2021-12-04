package com.td1.dao;

import java.util.*;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.rest.core.annotation.*;

import com.td1.entites.Etudiants;
import com.td1.entites.Departement;

@RepositoryRestResource
public interface EtudiantsRepository extends JpaRepository<Etudiants, Long>{

	
	//  1. Donnez la liste des étudiants de la departement informatique classée par une date_entrée décroissante.
	  @RestResource(path="/Q1")
	  @Query("select e from Etudiants e where e.id_departement.libelle_departement = 'Informatique' order by e.dateEntree DESC" ) 
	  List<Etudiants> findBydateEntreeDESC();

	//  2. Donner les noms des étudiants qui contiennent les Lettres L et M
	  @RestResource(path = "/Q2")
	  //@Query("select e from Etudiants e where e.nomE like '%x%' and e.nomE like '%y%'")
	  List<Etudiants> findByNomEContainingAndNomEContaining(String x, String y);

	//  3. Donner le département qui a l’étudiant le plus ancien
	  @RestResource(path="/Q3")
	  @Query("select distinct e.id_departement from Etudiants e where e.dateEntree = (select min(dateEntree) from Etudiants)")
	  List<Departement> findOldDepartement();

	//  4. Donner la moyenne des Moyennes des étudiants
	  @RestResource(path="/Q4")
	  @Query("select avg(e.moyenne) from Etudiants e")
	  float moyenneEtudiant();
	  
	//  5. Donner les étudiants ayant les meilleurs moyens dans chaque département
	  @RestResource(path="/Q5")
	  @Query("select e from Etudiants e where e.moyenne = (select max(t.moyenne) from Etudiants t where e.id_departement = t.id_departement)") 
	  List<Etudiants> bestEtudiantByDepartement();
	
	 
	  
	  //  6. Donner le ou les étudiant(s) ayant la meilleure moyenne
	  @RestResource(path="/Q6")
	  @Query("select e from Etudiants e where e.moyenne = (select max(t.moyenne) from Etudiants t)")
	  List<Etudiants> EtudiantBestMoyenne();
	//  7. Donner le nombre des étudiants de chaque département
	  @RestResource(path="/Q7")
	  @Query("select d, count(e) from Departement d left join d.edtudiants e group by d ")
	  Object[] NbEtudiantByDept();
	//  8. Donner le département qui possède le moins des étudiants
	  @RestResource(path="/Q8")
	  @Query("select d from Departement d left join d.edtudiants e group by d "
	  		+ "having count(e) <= all (select count(e) from Departement d left join d.edtudiants e group by d)")
	  Object[] MinEtudiantDept();
	  
	//  9. Donner les niveaux de chaque spécialité
	  @RestResource(path="/Q9")
	  @Query("select s, e.niveau from Specialite s left join s.etudiants e")
	  Object[] SpecialiteNiv();
	//  10. Donner le niveau ayant le plus d’étudiants
	  @RestResource(path="/Q10")
	  @Query("select e.niveau from Etudiants e group by e.niveau "
	  		+ "having count(e.numE) >= all(select count(e.numE) from Etudiants e group by e.niveau)")
	  Object[] NiveauMaxEtudiant();
  
	//  11. Donner le département qui possède le plus grand nombre d’étudiants
	  @RestResource(path="/Q11")
	  @Query("select d from Departement d left join d.edtudiants e group by d "
	  		+ "having count(e) >= all (select count(e) from Departement d left join d.edtudiants e group by d)")
	  Object[] MaxEtudiantDept();
	//  12. Donner le département qui ne contient aucun étudiant
	  @RestResource(path="/Q12")
	  @Query("select d from Departement d left join d.edtudiants e where e.numE is null")
	  Object[] EmtpyDept();
	  
	//  13. Donner le département qui possède le meilleur étudiant
	  @RestResource(path="/Q13")
	  @Query("select e.id_departement from Etudiants e where e.moyenne = (select max(e.moyenne) from Etudiants e)")
	  Object[] BestEtudiantDept();
	  
	//  14. Donner le département qui a la meilleure moyenne des Moyennes des étudiants
	  @RestResource(path="/Q14")
	  @Query("select e.id_departement from Etudiants e group by e.id_departement having avg(e.moyenne) > (select avg(e.moyenne) from Etudiants e)")
	  Object[] BestMoyDept();
	  
	//  15. Donner les départements dont la moyenne de tous les étudiants est supérieur a 10	
	  @RestResource(path="/Q15")
	  @Query("select e.id_departement from Etudiants e group by e.id_departement having avg(e.moyenne) > 10")
	  Object[] MoyDeptSupTen();
	  
}
