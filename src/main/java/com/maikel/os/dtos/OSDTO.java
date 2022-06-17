package com.maikel.os.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maikel.os.domain.Cliente;
import com.maikel.os.domain.OS;
import com.maikel.os.domain.Tecnico;
import com.maikel.os.domain.enuns.Prioridade;
import com.maikel.os.domain.enuns.Status;

public class OSDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataAbertuda;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataFechamento;

	private Integer prioridades;
	
	@NotEmpty(message = "O campo OBSERVAÇÕES é requerido")
	private String observações;
	private Integer status;
	
	private Integer tecnico;
	private Integer cliente;

	public OSDTO() {
		super();
	}

	public OSDTO(OS obj) {
		super();
		this.id = obj.getId();
		this.dataAbertuda = obj.getDataAbertuda();
		this.dataFechamento = obj.getDataFechamento();
		this.prioridades = obj.getPrioridades().getCod();
		this.observações = obj.getObservações();
		this.status = obj.getStatus().getCod();
		this.tecnico = obj.getTecnico().getId();
		this.cliente = obj.getCliente().getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDataAbertuda() {
		return dataAbertuda;
	}

	public void setDataAbertuda(LocalDateTime dataAbertuda) {
		this.dataAbertuda = dataAbertuda;
	}

	public LocalDateTime getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(LocalDateTime dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public Prioridade getPrioridades() {
		return Prioridade.toEnum(this.prioridades);
	}

	public void setPrioridades(Integer prioridades) {
		this.prioridades = prioridades;
	}

	public String getObservações() {
		return observações;
	}

	public void setObservações(String observações) {
		this.observações = observações;
	}

	public Status getStatus() {
		return Status.toEnum(this.status);
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getTecnico() {
		return tecnico;
	}

	public void setTecnico(Integer tecnico) {
		this.tecnico = tecnico;
	}

	public Integer getCliente() {
		return cliente;
	}

	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}
	
	
	
	

}
