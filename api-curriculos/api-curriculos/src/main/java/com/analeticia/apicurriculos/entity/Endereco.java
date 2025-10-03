package com.analeticia.apicurriculos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Tabela endereco
@Entity
@Table(name = "endereco")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

	// Coluna id_endereco - chave primária
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private Long idEndereco;
	
	// Coluna cep
	@NotBlank(message = "O campo 'cep' é obrigatório.")
	@Pattern(regexp = "\\d{5}-?\\d{3}", message = "CEP deve estar no formato XXXXX-XXX")
	private String cep;
	
	// Coluna logradouro
	@NotBlank(message = "O campo 'logradouro' é obrigatório.")
	@Size(max = 200, message = "Logradouro deve ter no máximo 200 caracteres.")
	private String logradouro;
	
	// Coluna numero
	@NotBlank(message = "O campo 'numero' é obrigatório.")
	private String numero;
	
	// Coluna complemento
	private String complemento;
	
	// Coluna bairro
	@NotBlank(message = "O campo 'bairro' é obrigatório.")
	private String bairro;
	
	// Coluna cidade
	@NotBlank(message = "O campo 'cidade' é obrigatório.")
	@Size(max = 100, message = "Cidade deve ter no máximo 100 caracteres.")
	private String cidade;
	
	// Coluna estado
	@NotBlank(message = "O campo 'estado' é obrigatório.")
	@Size(min = 2, max = 2, message = "Estado deve ser a sigla com 2 caracteres.")
	@Pattern(regexp = "[A-Z]{2}", message = "Estado deve conter apenas letras maiúsculas.")
	private String estado;
	
	// Coluna pais
	@NotBlank(message = "O campo 'pais' é obrigatório")
	private String pais;
	
		
}
