package br.com.estudo.java.spring.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "professores")
public class Professor {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String nome;
    private int idade;
    private String disciplina;
    
    @OneToMany(mappedBy = "prof", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("alunos")
    private List<Aluno> aluno;

    // Construtor
    public Professor() {
        
    }
    
    public Professor(Long id, String nome, int idade, String disciplina) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.disciplina = disciplina;
	}

	// Métodos de acesso (getters e setters)
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

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    
    public List<Aluno> getAluno() {
		return aluno;
	}

	public void setAluno(List<Aluno> aluno) {
		this.aluno = aluno;
	}

	// Método para exibir informações do professor
    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Disciplina: " + disciplina);
    }
}
