package br.com.favorecido.api.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.favorecido.api.dto.FavorecidoDto;
import br.com.favorecido.api.model.Favorecido;

public class FavorecidoDtoMock {
	
	public static FavorecidoDto getMock() {
		FavorecidoDto favorecido = new FavorecidoDto();
		favorecido.setCodigo(1L);
		favorecido.setNome("Fernando Teste");
		favorecido.setCpfCnpj("29933861824");
		return favorecido;
	}
	
	public static List<FavorecidoDto> getMockList() {
		List<FavorecidoDto> lst = new ArrayList<>();
		FavorecidoDto favorecido = new FavorecidoDto();
		favorecido.setCodigo(2L);
		favorecido.setNome("Paulo Teste");
		favorecido.setCpfCnpj("29933861824");
		lst.add(favorecido);
		lst.add(getMock());
		return lst;
	}
}
