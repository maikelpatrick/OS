package com.maikel.os.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maikel.os.domain.Tecnico;
import com.maikel.os.dtos.TecnicoDTO;
import com.maikel.os.repositories.TecnicoRepository;
import com.maikel.os.services.exceptions.DataIntegratyViolationException;
import com.maikel.os.services.exceptions.ObjectNotFoundException;

@Service
public class TecnicoService {
	
	@Autowired
	private TecnicoRepository repository;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id +", Tipo: "+ Tecnico.class.getName()));
	}

	public List<Tecnico> findAll() {
		return repository.findAll();
	}
	
	public Tecnico create(TecnicoDTO objDTO) {
		if(findByCPF(objDTO)!= null) {
			throw new DataIntegratyViolationException("CPF já Cadastrado!");			
		}
		
		return repository.save(new Tecnico(null,objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone()));
	}
	
	private Tecnico findByCPF(TecnicoDTO objDTO){
		Tecnico obj = repository.findByCFP(objDTO.getCpf());
		if(obj != null) {
			return obj;
		}
		return null;
	}

}
