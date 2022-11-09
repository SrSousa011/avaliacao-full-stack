package br.com.estudo.transferencia.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.estudo.transferencia.model.Transferencia;
import br.com.estudo.transferencia.rest.dto.TransferenciaDTO;

public interface TransferenciaRepository extends JpaRepository<Transferencia, UUID>{

	@Query("select entity from Transferencia entity where entity.contaDestino.numero = :numero")
	List<Transferencia> findByContaOrigem(@Param(value = "numero") String numero);

}
