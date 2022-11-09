package br.com.estudo.transferencia.business.imp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.estudo.transferencia.business.Taxa;
import br.com.estudo.transferencia.factory.DiasFactory;
import br.com.estudo.transferencia.model.Conta;
import br.com.estudo.transferencia.model.Transferencia;

public class TaxaC extends Taxa {

	public TaxaC(Taxa outro) {
		super(outro);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected BigDecimal verifica(Transferencia transferencia) {		
		return calculaTaxa(transferencia);
	}
	
	public BigDecimal calculaTaxa(Transferencia transferencia) {
		DiasFactory dias = new DiasFactory();
		return dias.calculaTaxaDias(transferencia).calculaTaxa(transferencia);
	}
}
