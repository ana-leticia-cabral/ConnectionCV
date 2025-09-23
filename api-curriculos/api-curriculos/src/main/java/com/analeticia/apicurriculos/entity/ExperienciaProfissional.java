package com.analeticia.apicurriculos.entity;

import java.time.Year;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Experiencia_profissional")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExperienciaProfissional {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "O campo CARGO é obrigatório")
	private String cargo;
	
	@NotNull(message = "O campo EMPRESA é obrigatório")
	private String empresa;
	
	@NotNull(message = "O campo ATIVIDADES é obrigatório")
	private String atividades;
	
	@NotNull(message = "O campo COMPETENCIAS é obrigatório")
	private String competencias;
	
	@NotNull(message = "O campo INICIO é obrigatório")
	private Year inicio;
	
	@NotNull(message = "O campo TERMINO é obrigatório")
	private Year termino;
	
	@NotNull(message = "O campo ATUAL TRABALHO é obrigatório")
	private boolean atualTrabalho;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("experiencias")
	@JoinColumn(name = "candidato_id")
	private Candidato candidato;
	
}
