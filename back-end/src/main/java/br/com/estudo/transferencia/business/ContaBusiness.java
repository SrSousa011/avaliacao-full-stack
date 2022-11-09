package br.com.estudo.transferencia.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estudo.transferencia.model.Conta;
import br.com.estudo.transferencia.repository.ContaRepository;
import br.com.estudo.transferencia.rest.dto.ContaDTO;

@Service
public class ContaBusiness {

	@Autowired
	ContaRepository _repository;
	
	public void save(Conta conta) {
		_repository.save(conta);
	}

	public Conta findByNumero(String numero) {
		return _repository.findByNumero(numero);
	}
	
}
