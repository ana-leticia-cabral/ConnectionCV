package com.analeticia.apicurriculos.entity;

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
	
	// CANDIDATO - possui - PERFIL PESSOAL (1:N)
	@OneToMany(mappedBy = "candidato")
	@JsonIgnoreProperties("candidato")
	private List<PerfilPessoal> dadosPessoais = new ArrayList<>();

	/*
	 * CANDIDATO - possui - ENDEREÇO (N:N) Em um mesmo endereço pode haver um ou
	 * mais candidatos; Um candidato pode ter mais de um endereço.
	 * 
	 */
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "endereco_compartilhado", joinColumns = @JoinColumn(name = "candidato_id"), inverseJoinColumns = @JoinColumn(name = "endereco_id"))
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
