package com.maikel.os;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.maikel.os.domain.Cliente;
import com.maikel.os.domain.OS;
import com.maikel.os.domain.Tecnico;
import com.maikel.os.domain.enuns.Prioridade;
import com.maikel.os.domain.enuns.Status;
import com.maikel.os.repositories.ClienteRepository;
import com.maikel.os.repositories.OSRepository;
import com.maikel.os.repositories.TecnicoRepository;


@SpringBootApplication
public class OsApplication  implements CommandLineRunner{
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private OSRepository osRepository;

	public static void main(String[] args) {
		SpringApplication.run(OsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Tecnico t1 = new Tecnico(null, "Maikel Patrick", "54298254097","(88) 88888-8888");
		Cliente c1 = new Cliente(null, "Tatiana", "23844797092", "(88) 99888-8888");
		OS os1  = new OS(null, Prioridade.ALTA, "Teste Criação OS", Status.ANDAMENTO, t1,c1);	
		
		t1.getList().add(os1);
		c1.getList().add(os1);
		
//		tecnicoRepository.saveAll(Arrays.asList(t1));
		
	//	clienteRepository.saveAll(Arrays.asList(c1));
		
	//	osRepository.saveAll(Arrays.asList(os1));
		
	}

}
