package br.com.favorecido.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.favorecido.api.model.Favorecido;

public interface FavorecidoRepository extends JpaRepository<Favorecido, Long> {

	@Query("from Favorecido f where f.cliente.cpfCnpj = :cpfCnpj ")
	public List<Favorecido> findByCliente(@Param("cpfCnpj") String cpfCnpj);
	
}
