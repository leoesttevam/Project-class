package br.com.estudo.java.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudo.java.spring.model.Aluno;
import br.com.estudo.java.spring.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoService service;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Aluno>> buscaTodos() {
		
		return ResponseEntity.ok(service.obterTodos());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Aluno> cadastrarAluno(@Validated Aluno aluno) {
		
		return service.cadastrar(aluno)
				.map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Aluno> atualizarAluno(@Validated Aluno aluno) {
		
		return service.cadastrar(aluno)
				.map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}
	
	@DeleteMapping("/id")
	public void deletar(Long id) {
		 
		service.deletar(id);
	}
}
