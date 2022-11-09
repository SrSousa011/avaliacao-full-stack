package br.com.estudo.transferencia.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudo.transferencia.business.TransferenciaBusiness;
import br.com.estudo.transferencia.rest.dto.TransferenciaDTO;

@RestController
@RequestMapping("/agendamento")
public class TransferenciaREST {
	
	@Autowired
	TransferenciaBusiness _business;
	
	@PostMapping
	public void transferencia(@RequestBody TransferenciaDTO transferencia) {
		_business.salvaTransferencia(transferencia);
	}
	
	@GetMapping
	public List<TransferenciaDTO> findByConta() {
		return _business.findAll();
	}

}
