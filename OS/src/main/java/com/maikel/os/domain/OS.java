package com.maikel.os.domain;

import java.time.LocalDateTime;
import java.util.Objects;

import com.maikel.os.domain.enuns.Prioridade;

import ch.qos.logback.core.status.Status;

public class OS {

	private Integer id;
	private LocalDateTime dataAbertuda;
	private LocalDateTime dataFechamento;
	private Integer prioridades;
	private String observações;
	private Integer status;
	private Tecnico tecnico;
	private Cliente cliente;

	public OS() {
		super();
	}

	public OS(Integer id, LocalDateTime dataAbertuda, LocalDateTime dataFechamento, Prioridade prioridades,
			String observações, Status status, Tecnico tecnico, Cliente cliente) {
		super();
		this.id = id;
		this.dataAbertuda = dataAbertuda;
		this.dataFechamento = dataFechamento;
		this.prioridades = (prioridade == null)?0 : prioridades.getCodigo();
		this.observações = observações;
		this.status = (status == null) ? 0 : status.getCodigo();
				
		this.tecnico = tecnico;
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public LocalDateTime getDataAbertuda() {
		return dataAbertuda;
	}

	public LocalDateTime getDataFechamento() {
		return dataFechamento;
	}

	public Prioridade getPrioridades() {
		return Prioridade.toEnum(this.prioridades);
	}

	public String getObservações() {
		return observações;
	}

	public Status getStatus() {
		return Status.toEnum(this.status);
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDataAbertuda(LocalDateTime dataAbertuda) {
		this.dataAbertuda = dataAbertuda;
	}

	public void setDataFechamento(LocalDateTime dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public void setPrioridades(Prioridade prioridades) {
		this.prioridades = prioridades;
	}

	public void setObservações(String observações) {
		this.observações = observações;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OS other = (OS) obj;
		return Objects.equals(id, other.id);
	}

}
