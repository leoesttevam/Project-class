package br.com.estudo.java.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estudo.java.spring.model.Aluno;
import br.com.estudo.java.spring.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;
	
	public List<Aluno> obterTodos() {
		
		return repository.findAll();
	}
	
	public Optional<Aluno> obterPorId(Long id) {
		
		return repository.findById(id);
	}
	
	public Optional<Aluno> cadastrar(Aluno aluno) {
		
		return Optional.of(repository.save(aluno));
	}
	
	public void deletar(Long id) {
		
		repository.deleteById(id);
	}
}
