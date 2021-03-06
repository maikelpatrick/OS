package com.maikel.os.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.maikel.os.domain.Cliente;



@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
	@Query("Select obj FROM Cliente obj where obj.cpf =:cpf")
	Cliente findByCFP(@Param("cpf") String cpf);

}
