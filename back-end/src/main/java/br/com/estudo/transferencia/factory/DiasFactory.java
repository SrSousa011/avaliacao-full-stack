package br.com.estudo.transferencia.factory;

import java.math.BigDecimal;

import br.com.estudo.transferencia.business.CompareDate;
import br.com.estudo.transferencia.business.Dias;
import br.com.estudo.transferencia.business.SemRegra;
import br.com.estudo.transferencia.business.imp.Acima10Dias;
import br.com.estudo.transferencia.business.imp.Acima20Dias;
import br.com.estudo.transferencia.business.imp.Acima30Dias;
import br.com.estudo.transferencia.business.imp.Acima40Dias;
import br.com.estudo.transferencia.model.Transferencia;

public class DiasFactory extends CompareDate {
	
	public Dias calculaTaxaDias(Transferencia transferencia) {
		
		if(validaData(transferencia, 10))
			return new Acima10Dias();
		else if (validaData(transferencia, 20))
			return new Acima20Dias();
		else if (validaData(transferencia, 30))
			return new Acima30Dias();
		else if (comparaDataMaior(transferencia, 40))
			return new Acima40Dias();
		else 
			return new SemRegra();
		
	}
	
	public Boolean validaData(Transferencia transferencia, Integer data) {
		return comparaDataMaior(transferencia, data) && comparaDataMenorIgual(transferencia, data+10);
	}

}
