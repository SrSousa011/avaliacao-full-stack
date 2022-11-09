package br.com.estudo.transferencia.business.imp;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.estudo.transferencia.business.Dias;
import br.com.estudo.transferencia.model.Transferencia;

public class Acima40Dias implements Dias {

	@Override
	public BigDecimal calculaTaxa(Transferencia transferencia) {
		return transferencia.getValorOperacao().multiply(new BigDecimal(0.017)).setScale(2, RoundingMode.HALF_UP);
	}
	
}
