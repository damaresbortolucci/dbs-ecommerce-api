package com.dbscommerce.log.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbscommerce.log.domain.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	
	//query method
	List<Cliente> findByNome(String nome);
	List<Cliente> findByNomeContaining(String nome); //busca por nome parcial (like do sql)
	Optional<Cliente> findByEmail(String email);
}
