package com.dbscommerce.log.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dbscommerce.log.domain.model.Cliente;
import com.dbscommerce.log.domain.repository.ClienteRepository;
import com.dbscommerce.log.domain.service.CatalogoClienteService;

import lombok.AllArgsConstructor;

@AllArgsConstructor //gera construtor com tds as propriedades da classe
@RestController //especifica que é uma classe de controller rest
@RequestMapping("/clientes")
public class ClienteController {

	
	private ClienteRepository clienteRepository;
	private CatalogoClienteService catalogoClienteService;

	
    @GetMapping
    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }
    
    
    
    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long clienteId) {
    	Optional<Cliente> cliente = clienteRepository.findById(clienteId);
    	
    	if(cliente.isPresent()) {
    		return ResponseEntity.ok(cliente.get()); //cod 200
    	}
    	
    	return ResponseEntity.notFound().build(); //cod 404
    }
    
    
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //cod 201 created
    public Cliente salvar(@Valid @RequestBody Cliente cliente) {
    	return catalogoClienteService.salvar(cliente);
    }
    
    
    
    //ResponseEntity p/ poder ter duas resp possíveis na request = 200 ou 404 se o ID nao existir
    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> atualizar (@PathVariable Long clienteId,@Valid @RequestBody Cliente cliente){
    	
    	if(!clienteRepository.existsById(clienteId)) {
    		return ResponseEntity.notFound().build();
    	}
    	
    	cliente.setId(clienteId);
    	cliente = catalogoClienteService.salvar(cliente);
    	
    	return ResponseEntity.ok(cliente);
    }
    
    
    
    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> deletar (@PathVariable Long clienteId){
    	
    	if(!clienteRepository.existsById(clienteId)) {
    		return ResponseEntity.notFound().build();
    	}
    	
    	catalogoClienteService.deletar(clienteId);
    	
    	return ResponseEntity.noContent().build(); //cod 204 success (não tem corpo na resposta)
    }	
    
    
    
    
    
    
    
    
    
    
    
    

}
