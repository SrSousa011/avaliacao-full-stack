package br.com.estudo.transferencia.business;

import java.math.BigDecimal;

import br.com.estudo.transferencia.model.Transferencia;

public class SemRegra implements Dias {

	@Override
	public BigDecimal calculaTaxa(Transferencia transferencia) {
		return BigDecimal.ZERO;
	}

}
