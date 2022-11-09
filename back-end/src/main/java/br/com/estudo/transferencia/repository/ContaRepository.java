package br.com.estudo.transferencia.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estudo.transferencia.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, UUID>{

	Conta findByNumero(String numero);

}
