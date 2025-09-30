package com.analeticia.apicurriculos.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
import jakarta.validation.constraints.*;
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
	
	@NotBlank(message = "O campo NOME é obrigatório.")
	@Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres.")
	private String nome;
	
	@NotBlank(message = "O campo SOBRENOME é obrigatório")
	private String sobrenome;
	
	private GeneroCandidato genero;
	
	private LocalDate nascimento;
	
	@NotBlank(message = "O campo CPF é obrigatório")
	@Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF inválido")
	@Column(unique = true)
	private String cpf;
	
	@NotBlank(message = "O campo EMAIL é obrigatório")
	@Email(message = "Email deve ser válido")
	@Column(unique = true)
	private String email;
	
	private String telefone;
	
	@NotBlank(message = "O campo CELULAR é obrigatório")
	@Column(unique = true)
	private String celular;
	
	@NotBlank
	private String sobre;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	// PERSIST -> Salva endereço quando salva candidato
	// MERGE -> Atualiza endereço quando atualiza candidato
	// Não deleta endereços compartilhados
    @JoinTable(name = "endereco_compartilhado", 
               joinColumns = @JoinColumn(name = "candidato_id"), 
               inverseJoinColumns = @JoinColumn(name = "endereco_id"))
	private List<Endereco> enderecos = new ArrayList<>();
	
	@OneToMany(mappedBy = "candidato")
	@JsonIgnoreProperties("candidato")
	private List<ExperienciaProfissional> experiencias = new ArrayList<>();
	
	@OneToMany(mappedBy = "candidato")
	@JsonIgnoreProperties("candidato")
	private List<Habilidade> habilidades = new ArrayList<>();
	
}
