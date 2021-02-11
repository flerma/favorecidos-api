package br.com.favorecido.api.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class FavorecidoDto {
	
	@NotNull
	private long codigo;

	@NotNull
	private String nome;
	
	@NotNull
	private String cpfCnpj;
	
}
