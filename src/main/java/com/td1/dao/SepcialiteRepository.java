package com.td1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.td1.entites.Specialite;

@RepositoryRestResource
public interface SepcialiteRepository extends JpaRepository<Specialite, Long> {

}
