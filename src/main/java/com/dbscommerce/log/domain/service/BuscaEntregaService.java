package com.dbscommerce.log.domain.service;

import org.springframework.stereotype.Service;

import com.dbscommerce.log.domain.exception.EntidadeNaoEncontradaException;
import com.dbscommerce.log.domain.model.Entrega;
import com.dbscommerce.log.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BuscaEntregaService {
	
	private EntregaRepository entregaRepository;
	
	public Entrega buscar(Long entregaId) {
		return entregaRepository.findById(entregaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
	}
	

}
