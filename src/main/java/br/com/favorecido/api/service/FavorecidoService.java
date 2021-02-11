package br.com.favorecido.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.favorecido.api.dto.FavorecidoDto;
import br.com.favorecido.api.model.Favorecido;
import br.com.favorecido.api.repository.FavorecidoRepository;

@Service
public class FavorecidoService {

	@Autowired
	private FavorecidoRepository favorecidoRepository;
	
	public List<Favorecido> pesquisar() {
		return favorecidoRepository.findAll();
	}
	
	public Favorecido buscarPorCodigo(Long codigo) {
		return favorecidoRepository.findById(codigo).get();
	}
	
	public FavorecidoDto incluir(FavorecidoDto dto) {
		Favorecido f = new Favorecido();
		BeanUtils.copyProperties(dto, f);
		Favorecido favorecidoSalvo = favorecidoRepository.save(f);
		BeanUtils.copyProperties(favorecidoSalvo, dto);
		return dto;
	}
	
	public List<FavorecidoDto> buscarPorCpfCnpfCliente(String cpfCnpfCliente) {
		
		List<FavorecidoDto> dtoLst = new ArrayList<>();
		List<Favorecido> favorecidoLst = favorecidoRepository.findByCliente(cpfCnpfCliente);
		
		favorecidoLst.stream()
			.forEach(f -> {
				FavorecidoDto dto = new FavorecidoDto();
				BeanUtils.copyProperties(f, dto);
				dtoLst.add(dto);
		});
		return dtoLst;
	}

}
