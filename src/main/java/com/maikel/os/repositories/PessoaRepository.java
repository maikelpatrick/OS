package com.maikel.os.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.maikel.os.domain.Pessoa;
import com.maikel.os.domain.Tecnico;

@Repository
public interface PessoaRepository extends JpaRepository<Tecnico, Integer>{

	@Query("Select obj FROM Pessoa obj where obj.cpf =:cpf")
	Pessoa findByCFP(@Param("cpf") String cpf);

}
