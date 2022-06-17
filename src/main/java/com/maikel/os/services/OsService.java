package com.maikel.os.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maikel.os.domain.Cliente;
import com.maikel.os.domain.OS;
import com.maikel.os.domain.Tecnico;
import com.maikel.os.domain.enuns.Prioridade;
import com.maikel.os.domain.enuns.Status;
import com.maikel.os.dtos.OSDTO;
import com.maikel.os.repositories.OSRepository;
import com.maikel.os.services.exceptions.ObjectNotFoundException;

@Service
public class OsService {
	
	@Autowired
	private OSRepository repository;
	
	
	@Autowired
	private TecnicoService tecnicoService;
	
	@Autowired
	private ClienteService clienteService;
	
	public OS findById(Integer id) {
		Optional<OS> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrato! ID: "+id+", Tipo: "+OS.class.getName()));
	}
	

	public List<OS> findAll(){
		return repository.findAll();
	}


	public OS create(@Valid OSDTO obj) {
		return fromDTO(obj);				
	}
	
	public OS update(@Valid OSDTO obj) {
		findById(obj.getId());
		return fromDTO(obj);
	}
	
	private OS fromDTO(OSDTO obj) {
		OS newObj = new OS();
		newObj.setId(obj.getId());
		newObj.setObservações(obj.getObservações());
		newObj.setPrioridades(obj.getPrioridades());
		newObj.setStatus(obj.getStatus());
		
		Tecnico tec = tecnicoService.findById(obj.getTecnico());
		Cliente cli = clienteService.findById(obj.getCliente());
		
		newObj.setTecnico(tec);
		newObj.setCliente(cli);
		
		if(newObj.getStatus().getCod().equals(2)) {
			newObj.setDataFechamento(LocalDateTime.now());
		}
		
		return repository.save(newObj);
	}



}
