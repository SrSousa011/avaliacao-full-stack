package br.com.estudo.transferencia.model;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import br.com.estudo.transferencia.business.OperacaoEnum;
import br.com.estudo.transferencia.rest.dto.ContaDTO;

@Entity
public class Conta {
	
	public Conta() {
		// TODO Auto-generated constructor stub
	}
	
	public Conta(UUID id, String numero, BigDecimal saldo) {
		super();
		this.id = id;
		this.numero = numero;
		this.saldo = saldo;
	}

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
	        name = "UUID",
	        strategy = "org.hibernate.id.UUIDGenerator"
	)
	@ColumnDefault("random_uuid()")
	@Type(type = "uuid-char")
	private UUID id;
	
	@Column(name = "NUMERO", length = 10)
	private String numero;
	
	@Column(name = "SALDO")
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
	
	public void operacao(BigDecimal valorOperacao, BigDecimal taxa, OperacaoEnum operacao) {
		if(operacao.equals(OperacaoEnum.SAQUE))
			this.saldo = saldo.subtract(valorOperacao.add(taxa));
		else if(operacao.equals(OperacaoEnum.DEPOSITA))
			this.saldo = saldo.add(valorOperacao);
	}

	public ContaDTO getConverte() {
		return new ContaDTO(this.id, this.numero, this.saldo);
	}

}
