package br.com.estudo.java.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estudo.java.spring.model.Professor;
import br.com.estudo.java.spring.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository repository;
	
	public List<Professor> obterTodos() {
		
		return repository.findAll();
	}
	
	public Optional<Professor> obterPorId(Long id) {
		
		return repository.findById(id);
	}
	
	@SuppressWarnings("unchecked")
	public Optional<Professor> cadastrar(Professor professor) {
		
		String msg = "Preencha os campos em branco";
		
		if(professor.getNome().isEmpty() || professor.getIdade() <= 0 || professor.getDisciplina().isEmpty()) {
			
			return (Optional<Professor>) Optional.empty().orElse(msg);
		}
		
		return Optional.of(repository.save(professor));
	}
	
	public void deletar(Long id) {
		
		repository.deleteById(id);
	}
}
