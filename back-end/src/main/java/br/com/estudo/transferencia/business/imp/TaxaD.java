package br.com.estudo.transferencia.business.imp;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.estudo.transferencia.business.Taxa;
import br.com.estudo.transferencia.model.Conta;
import br.com.estudo.transferencia.model.Transferencia;

public class TaxaD extends Taxa {

	public TaxaD(Taxa outro) {
		super(outro);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected BigDecimal verifica(Transferencia transferencia) {
		if(transferencia.getValorOperacao().compareTo(new BigDecimal("1000")) >= 0)
			return new TaxaA(null).calculaTaxa(transferencia);
		else if (transferencia.getValorOperacao().compareTo(new BigDecimal("2000")) >= 0)
			return new TaxaB(null).calculaTaxa(transferencia);
		else if (transferencia.getValorOperacao().compareTo(new BigDecimal("2000")) >= 0)
			return new TaxaC(null).calculaTaxa(transferencia);
		else 
			return this.calculaTaxa(transferencia);
	}

	@Override
	protected BigDecimal calculaTaxa(Transferencia transferencia) {
		return BigDecimal.ZERO;
	}

}
