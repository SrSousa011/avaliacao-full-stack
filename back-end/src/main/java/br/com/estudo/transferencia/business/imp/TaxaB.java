package br.com.estudo.transferencia.business.imp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import br.com.estudo.transferencia.business.Taxa;
import br.com.estudo.transferencia.model.Conta;
import br.com.estudo.transferencia.model.Transferencia;

public class TaxaB extends Taxa {

	public TaxaB(Taxa outro) {
		super(outro);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected BigDecimal verifica(Transferencia transferencia) {
		BigDecimal valorTaxa = BigDecimal.ZERO;
		if(!dataIguais(transferencia) && comparaDataMenorIgual(transferencia, 10))
			valorTaxa = calculaTaxa(transferencia);
			
		return valorTaxa;
	}
	
	public BigDecimal calculaTaxa(Transferencia transferencia) {
		return new BigDecimal("12");
	}

}
