package com.td1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.td1.entites.Departement;

@RepositoryRestResource
public interface DepartementRepository extends JpaRepository<Departement, Long>{

}
