package com.dbscommerce.log.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dbscommerce.log.domain.model.Cliente;
import com.dbscommerce.log.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor //gera um construtor com tds as propriedades da classe
@RestController //especifica que é uma classe de controller rest
public class ClienteController {

	
	@Autowired
	private ClienteRepository clienteRepository;
	

    @GetMapping("/clientes")
    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }
    
    
    @GetMapping("/clientes/{clienteId}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long clienteId) {
    	Optional<Cliente> cliente = clienteRepository.findById(clienteId);
    	
    	if(cliente.isPresent()) {
    		return ResponseEntity.ok(cliente.get()); //cod 200
    	}
    	
    	return ResponseEntity.notFound().build(); //cod 404
    }
    
    
    
    

}
