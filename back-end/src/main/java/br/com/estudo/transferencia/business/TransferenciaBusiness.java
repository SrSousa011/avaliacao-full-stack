package br.com.estudo.transferencia.business;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estudo.transferencia.business.imp.TaxaA;
import br.com.estudo.transferencia.business.imp.TaxaB;
import br.com.estudo.transferencia.business.imp.TaxaC;
import br.com.estudo.transferencia.business.imp.TaxaD;
import br.com.estudo.transferencia.model.Conta;
import br.com.estudo.transferencia.model.Transferencia;
import br.com.estudo.transferencia.repository.TransferenciaRepository;
import br.com.estudo.transferencia.rest.dto.TransferenciaDTO;

@Service
public class TransferenciaBusiness {
	
	@Autowired
	TransferenciaRepository _repository;
	
	@Autowired
	ContaBusiness _contaBusiness;

	public void salvaTransferencia(TransferenciaDTO transferenciaDTO) {
		
		Conta contaDestino = _contaBusiness.findByNumero(transferenciaDTO.getContaDestino());
		Conta contaOrigem = _contaBusiness.findByNumero(transferenciaDTO.getContaOrigem());
		Transferencia transferencia = new Transferencia(contaOrigem, contaDestino, transferenciaDTO.getValorOperacao(), transferenciaDTO.getDataTransferencia());
		transferencia.setTaxa(calcular(transferencia, new TaxaA(new TaxaB(new TaxaC(new TaxaD(null))))));
		
		_repository.save(transferencia);
	}
	
	public BigDecimal calcular(Transferencia transferencia, Taxa taxa) {
		return taxa.executa(transferencia);
	}

	public List<TransferenciaDTO> findByConta(String numero) {
		return TransferenciaDTO.converter(_repository.findByContaOrigem(numero));
	}

	public List<TransferenciaDTO> findAll() {
		return TransferenciaDTO.converter(_repository.findAll());
	}
}
