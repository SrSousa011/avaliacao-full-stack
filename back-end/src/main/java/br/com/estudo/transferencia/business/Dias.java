package br.com.estudo.transferencia.business;

import java.math.BigDecimal;

import br.com.estudo.transferencia.model.Transferencia;

public interface Dias {

	BigDecimal calculaTaxa(Transferencia transferencia);
}
