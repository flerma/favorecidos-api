package br.com.favorecido.api.resource;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.favorecido.api.dto.FavorecidoDto;
import br.com.favorecido.api.mocks.FavorecidoDtoMock;
import br.com.favorecido.api.mocks.FavorecidoMock;
import br.com.favorecido.api.service.FavorecidoService;

public class FavorecidoResourceTest {
	
	private MockMvc mockMvc;
	
	@Mock	
	private FavorecidoService service;
	
	@InjectMocks
	private FavorecidoResource resource;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(resource).alwaysDo(print()).build();
	}
	
	@Test
	public void DEVE_BUSCAR_FAVORECIDO_POR_CPF_CNPJ() throws Exception {
		String cpfCnpjCliente = FavorecidoMock.getMock().getCliente().getCpfCnpj();
		List<FavorecidoDto> favorecidoLst = FavorecidoDtoMock.getMockList();
		
		when(service.buscarPorCpfCnpfCliente(anyString())).thenReturn(favorecidoLst);
		
		mockMvc.perform(get("/favorecidos/por-cliente/" + cpfCnpjCliente))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", hasSize(2)))
			.andExpect(jsonPath("$[0].codigo", is(2)))
			.andDo(print());
		
		verify(service, times(1)).buscarPorCpfCnpfCliente(cpfCnpjCliente);
	}
}
