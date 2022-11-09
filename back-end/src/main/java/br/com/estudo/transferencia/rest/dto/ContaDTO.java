package br.com.estudo.transferencia.rest.dto;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import br.com.estudo.transferencia.model.Conta;

public class ContaDTO {
	
	public ContaDTO() {
		// TODO Auto-generated constructor stub
	}

	public ContaDTO(UUID id, String numero, BigDecimal saldo) {
		super();
		this.id = id;
		this.numero = numero;
		this.saldo = saldo;
	}

	private UUID id;

	private String numero;

	private BigDecimal saldo;
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public Conta getConverte(ContaDTO conta) {
		return new Conta(this.id, this.numero, this.getSaldo());
	}

}
