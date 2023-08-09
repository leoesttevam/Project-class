package br.com.estudo.java.spring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudo.java.spring.model.Professor;
import br.com.estudo.java.spring.service.ProfessorService;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

	private ProfessorService service;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Professor>> buscaTodos() {
		
		return ResponseEntity.ok(service.obterTodos());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Professor> cadastrarAluno(@Validated Professor professor) {
		
		return service.cadastrar(professor)
				.map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}
	
	@PostMapping("/atualizar")
	public ResponseEntity<Professor> atualizarAluno(@Validated Professor professor) {
		
		return service.cadastrar(professor)
				.map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}
	
	@DeleteMapping("/id")
	public void deletar(Long id) {
		 
		service.deletar(id);
	}
}
