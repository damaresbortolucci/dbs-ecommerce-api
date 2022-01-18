package com.dbscommerce.log.domain.exception;


//tratando erro de e-mail de cliente já cadastrado
public class NegocioException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NegocioException(String message) {
		super(message);
	}
}
