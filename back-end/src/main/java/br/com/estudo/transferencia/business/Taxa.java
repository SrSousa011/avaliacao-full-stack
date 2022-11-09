package br.com.estudo.transferencia.business;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import br.com.estudo.transferencia.model.Conta;
import br.com.estudo.transferencia.model.Transferencia;

public abstract class Taxa extends CompareDate {
	
	private Taxa outro;

	public Taxa(Taxa outro) {
		this.outro = outro;
	}
	
	protected abstract BigDecimal verifica(Transferencia transferencia);
	protected abstract BigDecimal calculaTaxa(Transferencia transferencia);
	
	public BigDecimal executa(Transferencia transferencia) {
		BigDecimal valorTaxa = verifica(transferencia);
		BigDecimal valorOutraTaxa = BigDecimal.ZERO;

		if(existeTaxa(valorTaxa) && Objects.nonNull(outro))
			valorOutraTaxa = outro.executa(transferencia);
		
		return valorTaxa.add(valorOutraTaxa);
	}
	
	private Boolean existeTaxa(BigDecimal valorTaxa) {
		return valorTaxa.compareTo(BigDecimal.ZERO) == 0;
	}

}
