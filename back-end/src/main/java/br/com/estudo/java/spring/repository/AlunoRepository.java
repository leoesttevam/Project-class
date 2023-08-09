package br.com.estudo.java.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estudo.java.spring.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{

	
}
