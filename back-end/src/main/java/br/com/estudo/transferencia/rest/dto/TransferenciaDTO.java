package br.com.estudo.transferencia.rest.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.estudo.transferencia.model.Transferencia;

public class TransferenciaDTO {
	
	public TransferenciaDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public TransferenciaDTO(Transferencia transferencia) {
		this.contaOrigem = transferencia.getContaOrigem().getNumero();
		this.contaDestino = transferencia.getContaDestino().getNumero();
		this.taxa = transferencia.getTaxa();
		this.valorOperacao = transferencia.getValorOperacao();
		this.dataTransferencia = transferencia.getDataTransferencia();
		this.dataAgendamento = LocalDate.now();
		
	}
	
	private String contaOrigem;
	
	private String contaDestino;
	
	private BigDecimal taxa;
	
	private BigDecimal valorOperacao;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dataTransferencia;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dataAgendamento;
	
	public BigDecimal getTaxa() {
		return taxa;
	}
	
	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}

	public String getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(String contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public String getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(String contaDestino) {
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
	
	public static List<TransferenciaDTO> converter(List<Transferencia> listTransferencias){
		return listTransferencias.stream().map(TransferenciaDTO::new).collect(Collectors.toList());
	}
}
