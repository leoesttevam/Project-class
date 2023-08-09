package br.com.estudo.java.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estudo.java.spring.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{

}
