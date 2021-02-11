package br.com.favorecido.api.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.favorecido.api.RegisterMetricsConfiguration;
import br.com.favorecido.api.dto.FavorecidoDto;
import br.com.favorecido.api.model.Favorecido;
import br.com.favorecido.api.service.FavorecidoService;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Timer;
import io.swagger.annotations.Api;

@RestController
@Api(tags = "Cadastro e consulta de favorecidos")
@RequestMapping("/favorecidos")
public class FavorecidoResource {
	
	@Autowired
	private FavorecidoService favorecidoService;
	
	Timer findTimer;
	
	@Timed("consulta.por.cnpj.cpf.cliente")
	@GetMapping("por-cliente/{cpfCnpj}")
	public List<FavorecidoDto> buscarPorCpfCnpfCliente(@PathVariable String cpfCnpj) {
		RegisterMetricsConfiguration.counter.increment();
		return favorecidoService.buscarPorCpfCnpfCliente(cpfCnpj);
	}
	
	@Timed("consulta.por.codigo")
	@GetMapping("/{codigo}")
	public ResponseEntity<Favorecido> buscarPeloCodigo(@PathVariable Long codigo) {
		RegisterMetricsConfiguration.counter.increment();
		return ResponseEntity.ok().body(favorecidoService.buscarPorCodigo(codigo));
	}
	
	@Timed("incluir.favorecido")
	@PostMapping
	public ResponseEntity<FavorecidoDto> incluir(@Valid @RequestBody FavorecidoDto favorecidoDto, HttpServletResponse response) {
		RegisterMetricsConfiguration.counter.increment();
		FavorecidoDto favorecidoSalvo = favorecidoService.incluir(favorecidoDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(favorecidoSalvo.getCodigo()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(favorecidoSalvo);
	}
	
}
