package br.com.estudo.transferencia.business;

import java.time.temporal.ChronoUnit;

import br.com.estudo.transferencia.model.Transferencia;

public class CompareDate {

	public Boolean comparaDataMaior(Transferencia transferencia, Integer data) {
		return ChronoUnit.DAYS.between(transferencia.getDataAgendamento(), transferencia.getDataTransferencia()) > data;
	}
	
	public Boolean comparaDataMenorIgual(Transferencia transferencia, Integer data) {
		return ChronoUnit.DAYS.between(transferencia.getDataAgendamento(), transferencia.getDataTransferencia()) <= data;
	}
	
	public Boolean dataIguais(Transferencia transferencia) {
		return transferencia.getDataTransferencia().equals(transferencia.getDataAgendamento());
	}
	
}
