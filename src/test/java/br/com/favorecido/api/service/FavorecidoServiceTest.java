package br.com.favorecido.api.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.favorecido.api.dto.FavorecidoDto;
import br.com.favorecido.api.mocks.FavorecidoMock;
import br.com.favorecido.api.model.Favorecido;
import br.com.favorecido.api.repository.FavorecidoRepository;

public class FavorecidoServiceTest {
	

	private MockMvc mockMvc;
	
	@Mock	
	private FavorecidoRepository repository;
	
	@InjectMocks
	private FavorecidoService service;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(service).alwaysDo(print()).build();
	}
	
	@Test
	public void DEVE_BUSCAR_FAVORECIDO_POR_CPF() {
		String cpfCnpjCliente = FavorecidoMock.getMock().getCliente().getCpfCnpj();
		List<Favorecido> favorecidoLst = FavorecidoMock.getMockList();
		
		when(repository.findByCliente(anyString())).thenReturn(favorecidoLst);
		List<FavorecidoDto> result = service.buscarPorCpfCnpfCliente(cpfCnpjCliente);
		
		
		assertEquals("verifica a quantidade de registros", result.size(), 2);
		
		verify(repository, times(1)).findByCliente(cpfCnpjCliente);
	}

}
