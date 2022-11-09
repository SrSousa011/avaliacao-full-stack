package br.com.estudo.transferencia.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import br.com.estudo.transferencia.rest.dto.TransferenciaDTO;

@Entity
public class Transferencia {
	
	public Transferencia() {
		// TODO Auto-generated constructor stub
	}
	
	public Transferencia(Conta contaOrigem, Conta contaDestino, BigDecimal valorOperacao,
			LocalDate dataTransferencia) {
		super();
		this.contaOrigem = contaOrigem;
		this.contaDestino = contaDestino;
		this.valorOperacao = valorOperacao;
		this.dataTransferencia = dataTransferencia;
		this.dataAgendamento = LocalDate.now();
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
	
	@ManyToOne	
	private Conta contaOrigem;
	
	@ManyToOne
	private Conta contaDestino;
	
	@Column(name = "TAXA")
	private BigDecimal taxa;
	
	@Column(name = "VALOROPERACAO")
	private BigDecimal valorOperacao;
	
	@Column(name = "DATATRANSFERENCIA")
	private LocalDate dataTransferencia;
	
	@Column(name = "DATAAGENDAMENTO")
	private LocalDate dataAgendamento;
	
	public BigDecimal getTaxa() {
		return taxa;
	}
	
	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}

	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}

	public Conta getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(Conta contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public Conta getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(Conta contaDestino) {
		this.contaDestino = contaDestino;
	}

	public BigDecimal getValorOperacao() {
		return valorOperacao;
	}

	public void setValorOperacao(BigDecimal valorOperacao) {
		this.valorOperacao = valorOperacao;
	}

	public LocalDate getDataTransferencia() {
		return dataTransferencia;
	}
	
	public void setDataTransferencia(LocalDate dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}

	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}
	
	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	
}
