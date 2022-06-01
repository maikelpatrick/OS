package com.maikel.os.domain;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maikel.os.domain.enuns.Prioridade;
import com.maikel.os.domain.enuns.Status;

@Entity
public class OS {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataAbertuda;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataFechamento;
	
	private Integer prioridades;
	private String observações;
	private Integer status;
	
	@ManyToOne
	@JoinColumn(name = "tecnico_id")
	private Tecnico tecnico;
	
	@ManyToOne
	@JoinColumn(name = "cliente	_id")
	private Cliente cliente;

	public OS() {
		super();
		this.setDataAbertuda(LocalDateTime.now());
		this.setPrioridades(Prioridade.BAIXA);
		this.setStatus(Status.ABERTO);
	}

	public OS(Integer id, Prioridade prioridades, String observações, Status status,
			Tecnico tecnico, Cliente cliente) {
		super();
		this.id = id;
		this.setDataAbertuda(LocalDateTime.now());
		this.prioridades = (prioridades == null) ? 0 : prioridades.getCodigo();
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
		this.prioridades = prioridades.getCodigo();
	}

	public void setObservações(String observações) {
		this.observações = observações;
	}

	public void setStatus(Status status) {
		this.status = status.getCodigo();
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
