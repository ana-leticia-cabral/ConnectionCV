package com.analeticia.apicurriculos.entity;

import java.time.LocalDate;

import com.analeticia.apicurriculos.entity.constants.EscolaridadeFormacaoAcademica;
import com.analeticia.apicurriculos.entity.constants.ModalidadeFormacaoAcademica;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "formacao_academica")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FormacaoAcademica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_formacao")
	private Long idFormacao;
	
	@NotBlank(message = "O campo 'escolaridade' é obrigatório")
	private EscolaridadeFormacaoAcademica escolaridade;
	
	@NotBlank(message = "O campo 'curso' é obrigatório")
	private String curso;
	
	private String instituicao;
	
	private ModalidadeFormacaoAcademica modalidade;
	
	@NotBlank(message = "O campo 'data_de_inicio' é obrigatório")
	@Column(name = "data_de_inicio")
	private LocalDate inicio;
	
	@NotBlank(message = "O campo 'data_de_termino' é obrigatório")
	@Column(name = "data_de_termino")
	private LocalDate termino;
	
	@NotBlank(message = "O campo 'atual_formacao' é obrigatório")
	@Column(name = "atual_formacao")
	private boolean atualFormacao;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "candidato_id")
	@JsonIgnoreProperties("formacoes")
	private Candidato candidato;
	
	
	
}
