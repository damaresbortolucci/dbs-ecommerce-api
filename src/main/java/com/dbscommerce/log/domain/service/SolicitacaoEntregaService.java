package com.dbscommerce.log.domain.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;

import com.dbscommerce.log.domain.model.Cliente;
import com.dbscommerce.log.domain.model.Entrega;
import com.dbscommerce.log.domain.model.StatusEntrega;
import com.dbscommerce.log.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {
	
	private EntregaRepository entregaRepository;
	private CatalogoClienteService catalogoClienteService;
	
	
	public Entrega solicitar(Entrega entrega) {
		
		Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());

		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());
		
		return entregaRepository.save(entrega);
	}
	
	

}
