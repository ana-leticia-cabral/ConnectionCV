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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Tabela Candidato
@Entity
@Table(name = "candidato")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Candidato {

	// Coluna id_candidato - chave primária
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_candidato")
	private Long idCandidato;
	
	
	/*
	 * CANDIDATO - possui - PERFIL_PESSOAL (1:1) 
	 * PERFIL_PESSOAL - pertence - CANDIDATO (1:1)
	 */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dados_pessoais_id", unique = true)
    @JsonIgnoreProperties("candidato")
    private PerfilPessoal dadosPessoais;

	/*
	 * CANDIDATO - possui - ENDEREÇO (N:N) Em um mesmo endereço pode haver um ou
	 * mais candidatos; Um candidato pode ter mais de um endereço.
	 * 
	 */
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "candidato_endereco", joinColumns = @JoinColumn(name = "candidato_id"), inverseJoinColumns = @JoinColumn(name = "endereco_id"))
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
