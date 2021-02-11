package br.com.favorecido.api.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.favorecido.api.model.Cliente;
import br.com.favorecido.api.model.Favorecido;

public class FavorecidoMock {
	
	public static Favorecido getMock() {
		Favorecido favorecido = new Favorecido();
		favorecido.setCodigo(1L);
		favorecido.setNome("Fernando Teste");
		favorecido.setCliente(getCliente());
		return favorecido;
	}
	
	public static List<Favorecido> getMockList() {
		List<Favorecido> lst = new ArrayList<>();
		
		Favorecido favorecido = new Favorecido();
		favorecido.setCodigo(2L);
		favorecido.setNome("Paulo Teste");
		favorecido.setCliente(getCliente());
		lst.add(favorecido);
		lst.add(getMock());
		
		return lst;
	}
	
	private static Cliente getCliente() {
		Cliente cliente = new Cliente();
		cliente.setCodigo(1L);
		cliente.setNome("João Silva");
		cliente.setCpfCnpj("29933861824");
		return cliente;
	}

}
