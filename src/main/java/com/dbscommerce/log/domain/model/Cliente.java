package com.dbscommerce.log.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
//@Table(name = "tb_cliente") ex1 para criar com outro nome
public class Cliente {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank //do javax-validation - impede valor nulo ou vazio
	@Size(max = 60) //max de caracteres de acordo com o banco de dados
    private String nome;
	
	@NotBlank
	@Email //valida a sintaxe do e-mail
	@Size(max = 255)
    private String email;
	
	
	@NotBlank
	@Size(max = 20)
    private String telefone;
	
	
    
}
