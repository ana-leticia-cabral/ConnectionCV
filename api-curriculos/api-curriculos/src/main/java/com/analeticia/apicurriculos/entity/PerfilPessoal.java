package com.analeticia.apicurriculos.entity;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import com.analeticia.apicurriculos.entity.constants.GeneroCandidato;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Tabela dados_pessoais
@Entity
@Table(name = "dados_pessoais")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PerfilPessoal {

	// Coluna id_dp - chave primária
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_dados_pessoais")
	private Long idDadosPessoais;
    
	// Coluna nome 
	@NotBlank(message = "O campo 'nome' é obrigatório.")
	@Size(min = 2, message = "O campo 'nome' deve ter no mínimo 2 caracteres.")
	@Pattern(regexp = "^[A-Za-zÀ-ÿ ]+$", message = "O campo 'nome' deve conter apenas letras e espaços.")
	private String nome;

	@NotBlank(message = "O campo 'sobrenome' é obrigatório.")
	@Size(min = 2, message = "O campo 'sobrenome' deve ter no mínimo 2 caracteres.")
	@Pattern(regexp = "^[A-Za-zÀ-ÿ ]+$", message = "O campo 'nome' deve conter apenas letras e espaços.")
	private String sobrenome;

	// Coluna genero
	private GeneroCandidato genero;

	// Coluna data_de_nascimento
	@NotNull(message = "O campo 'data_de_nascimento' é obrigatório.")
	@Past(message = "A data de nascimento deve estar no passado.")
	@Column(name = "data_de_nascimento")
	private LocalDate nascimento;
	
	
	// Coluna cpf - chave única
	@NotBlank(message = "O campo 'cpf' é obrigatório.")
	@CPF
	@Column(unique = true)
	private String cpf;

	// Coluna email - chave única
	@NotBlank(message = "O campo 'email' é obrigatório.")
	@Email(message = "Formato de e-mail inválido.")
	@Column(unique = true)
	private String email;

	// Coluna telefone_fixo
	@Column(name = "telefone_fixo")
	@Pattern(regexp = "^\\(?\\d{2}\\)?\\s?\\d{4}-?\\d{4}$", message = "Telefone fixo deve estar no formato (DD) XXXX-XXXX")
	private String telefoneFixo;

	// Coluna numero_celular - chave única
	@NotBlank(message = "O campo 'numero_celular' é obrigatório.")
	@Column(name = "numero_celular", unique = true)
	@Pattern(regexp = "^\\(?\\d{2}\\)?\\s?9\\d{4}-?\\d{4}$", message = "Celular deve estar no formato (DD) 9XXXX-XXXX")
	private String celular;

	// Coluna resumo_profissional
	@NotBlank(message = "O campo 'resumo_profissional' é obrigatório.")
	@Column(name = "resumo_profissional")
	@Size(min = 200, max = 3000, message = "O campo 'resumo_profissional' deve conter entre 200 e 3000 caracteres.")
	private String resumoProfissional;
	
	@OneToOne(mappedBy = "dadosPessoais")
	@JsonIgnoreProperties("dadosPessoais")
	private Candidato candidato;
	
}
