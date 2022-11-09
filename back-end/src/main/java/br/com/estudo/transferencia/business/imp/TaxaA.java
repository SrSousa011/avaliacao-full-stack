package br.com.estudo.transferencia.business.imp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.estudo.transferencia.business.Taxa;
import br.com.estudo.transferencia.model.Conta;
import br.com.estudo.transferencia.model.Transferencia;

public class TaxaA extends Taxa {

	public TaxaA(Taxa outro) {
		super(outro);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected BigDecimal verifica(Transferencia transferencia) {
		BigDecimal valorTaxa = BigDecimal.ZERO;
		if(dataIguais(transferencia)) {
			valorTaxa = calculaTaxa(transferencia);
		}
	
		return valorTaxa;
	}
	
	public BigDecimal calculaTaxa(Transferencia transferencia) {
		BigDecimal valorTaxaFixa = new BigDecimal(3);
		BigDecimal valorTaxaPercentual = transferencia.getValorOperacao().multiply(new BigDecimal(0.03));
		return valorTaxaFixa.add(valorTaxaPercentual).setScale(2, RoundingMode.HALF_UP);
	}

	
}
