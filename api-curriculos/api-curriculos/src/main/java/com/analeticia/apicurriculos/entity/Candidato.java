package com.analeticia.apicurriculos.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Candidato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "O campo NOME é obrigatório")
	private String nome;
	
	@NotNull(message = "O campo SOBRENOME é obrigatório")
	private String sobrenome;
	
	private GeneroCandidato genero;
	private LocalDate nascimento;
	
	@NotNull(message = "O campo CPF é obrigatório")
	private String cpf;
	
	@NotNull(message = "O campo EMAIL é obrigatório")
	private String email;
	
	private String telefone;
	
	@NotNull(message = "O campo CELULAR é obrigatório")
	private String celular;
	
	private String sobre;
}
