package com.maikel.os.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maikel.os.domain.Cliente;
import com.maikel.os.domain.OS;
import com.maikel.os.domain.Tecnico;
import com.maikel.os.domain.enuns.Prioridade;
import com.maikel.os.domain.enuns.Status;
import com.maikel.os.repositories.ClienteRepository;
import com.maikel.os.repositories.OSRepository;
import com.maikel.os.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private OSRepository osRepository;	
	
	
	public void instaciaDB() {
		Tecnico t1 = new Tecnico(null, "Maikel Patrick", "54298254097", "(88) 88888-8888");
		Tecnico t2 = new Tecnico(null, "Almeida", "54298254097", "(88) 88788-8888");
		Cliente c1 = new Cliente(null, "Tatiana", "23844797092", "(88) 99888-8888");
		OS os1 = new OS(null, Prioridade.ALTA, "Teste Criação OS", Status.ANDAMENTO, t1, c1);

		t1.getList().add(os1);
		c1.getList().add(os1);

		tecnicoRepository.saveAll(Arrays.asList(t1,t2));

		clienteRepository.saveAll(Arrays.asList(c1));

		osRepository.saveAll(Arrays.asList(os1));
	}

}
