package com.maikel.os.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maikel.os.domain.Pessoa;
import com.maikel.os.domain.Tecnico;
import com.maikel.os.dtos.TecnicoDTO;
import com.maikel.os.repositories.PessoaRepository;
import com.maikel.os.repositories.TecnicoRepository;
import com.maikel.os.services.exceptions.DataIntegratyViolationException;
import com.maikel.os.services.exceptions.ObjectNotFoundException;

@Service
public class TecnicoService {
	
	@Autowired
	private TecnicoRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
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
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");			
		}
		
		return repository.save(new Tecnico(null,objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone()));
	}

	public Tecnico update(Integer id, @Valid TecnicoDTO objDTO) {
		Tecnico oldOBJ = findById(id);
		
		if(findByCPF(objDTO) != null && findByCPF(objDTO).getId() != id) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");		
		}
		oldOBJ.setNome(objDTO.getNome());
		oldOBJ.setCpf(objDTO.getCpf());
		oldOBJ.setTelefone(objDTO.getTelefone());
		
		return repository.save(oldOBJ);
	}
	
	public void delete(Integer id) {
		Tecnico obj = findById(id);
		
		if(obj.getList().size() >0) {
			throw new DataIntegratyViolationException("Técnico possui Ordens de Srerviço, não pode ser deletado!");
		}
		
		repository.deleteById(id);
	}

	private Pessoa findByCPF(TecnicoDTO objDTO){
		Pessoa obj = pessoaRepository.findByCFP(objDTO.getCpf());
		if(obj != null) {
			return obj;
		}
		return null;
	}



}
