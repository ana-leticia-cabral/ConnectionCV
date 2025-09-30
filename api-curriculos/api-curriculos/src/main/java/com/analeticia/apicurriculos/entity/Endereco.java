package com.analeticia.apicurriculos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "endereco")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private long idEndereco;
	
	@NotBlank(message = "O campo 'cep' é obrigatório")
	private String cep;
	
	@NotBlank(message = "O campo 'logradouro' é obrigatório")
	private String logradouro;
	
	@NotBlank(message = "O campo 'numero' é obrigatório")
	private String numero;
	
	private String complemento;
	
	@NotBlank(message = "O campo 'bairro' é obrigatório")
	private String bairro;
	
	@NotBlank(message = "O campo 'cidade' é obrigatório")
	private String cidade;
	
	@NotBlank(message = "O campo 'estado' é obrigatório")
	private String estado;
	
	@NotBlank(message = "O campo 'pais' é obrigatório")
	private String pais;
	
	
	
}
