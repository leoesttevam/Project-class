package br.com.estudo.java.spring.model;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "alunos")
public class Aluno {
	
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private int idade;
	private String matricula;
	
	@ManyToAny
	private List<Professor> prof;
	
	//Construtor
	public Aluno() {
		super();
	}
	
	public Aluno(Long id, String nome, int idade, String matricula) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.matricula = matricula;
	}



	//Métodos de acesso (getters e setters)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public List<Professor> getProf() {
		return prof;
	}

	public void setProf(List<Professor> prof) {
		this.prof = prof;
	}

	// Método para exibir informações do aluno
	public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Matrícula: " + matricula);
    }
}
