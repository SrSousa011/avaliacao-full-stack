package br.com.estudo.transferencia.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudo.transferencia.business.ContaBusiness;
import br.com.estudo.transferencia.rest.dto.ContaDTO;


@RestController
@RequestMapping("/conta")
public class ContaREST {
	
	@Autowired
	ContaBusiness _business;
	
	@PostMapping
	public void saveConta(@RequestBody ContaDTO conta) {
		_business.save(conta.getConverte(conta));
	}
	
	@GetMapping(value = "/{numero}")
	public ContaDTO conta(@PathVariable String numero) {
		return _business.findByNumero(numero).getConverte();
	}

}
