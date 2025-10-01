package com.analeticia.apicurriculos.entity;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import com.analeticia.apicurriculos.entity.constants.GeneroCandidato;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "candidato")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Candidato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_candidato")
	private Long idCandidato;
	
	@NotBlank(message = "O campo 'nome' é obrigatório.")
	@Size(min = 2, max = 50, message = "O campo 'nome' deve ter entre 2 e 50 caracteres.")
	private String nome;
	
	@NotBlank(message = "O campo 'sobrenome' é obrigatório")
	@Size(min = 2, max = 50, message = "O campo 'sobrenome' deve ter entre 2 e 50 caracteres.")
	private String sobrenome;
	
	private GeneroCandidato genero;
	
	@Column(name = "data_de_nascimento")
	@Past // A data de nascimento deve estar no passado
	private LocalDate nascimento;
	
	@NotBlank(message = "O campo 'cpf' é obrigatório")
	@Column(unique = true)
	private String cpf;
	
	@NotBlank(message = "O campo 'email' é obrigatório")
	@Column(unique = true)
	@Email(message = "Email inválido")
	private String email;
	
	@Column(name = "telefone_fixo")
	private String telefone;
	
	@NotBlank(message = "O campo 'celular' é obrigatório")
	@Column(unique = true,
			name = "numero_de_celular")
	private String celular;
	
	@NotBlank
	@Column(name = "resumo_profissional")
	@Size(min = 200, max = 3000, message = "O campo 'resumo_profissional' deve ter entre 200 e 3000 caracteres.")
	private String resumo;
	
	
	/*
	 * CANDIDATO - possui - ENDEREÇO (N:N)
	 * Em um mesmo endereço pode haver um ou mais candidatos;
	 * Um candidato pode ter mais de um endereço.
	 * 
	 */
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	/* 
	 * PERSIST -> Salva endereço quando salva candidato
	 * MERGE -> Atualiza endereço quando atualiza candidato
	 * Não deleta endereços compartilhados
	 * 
	 */
    @JoinTable(name = "endereco_compartilhado", 
               joinColumns = @JoinColumn(name = "candidato_id"), 
               inverseJoinColumns = @JoinColumn(name = "endereco_id"))
	private List<Endereco> enderecos = new ArrayList<>();
	
	
	// CANDIDATO - possui - EXPERIÊNCIA PROFISSIONAL (1:N)
	@OneToMany(mappedBy = "candidato")
	@JsonIgnoreProperties("candidato")
	private List<ExperienciaProfissional> experiencias = new ArrayList<>();
	
	
	// CANDIDATO - possui - HABILIDADE (1:N)
	@OneToMany(mappedBy = "candidato")
	@JsonIgnoreProperties("candidato")
	private List<Habilidade> habilidades = new ArrayList<>();
	
	
	// CANDIDATO - possui - FORMAÇÃO ACADÊMICA (1:N)
	@OneToMany(mappedBy = "candidato")
	@JsonIgnoreProperties("candidato")
	private List<FormacaoAcademica> formacoes = new ArrayList<>();
	
	
}
