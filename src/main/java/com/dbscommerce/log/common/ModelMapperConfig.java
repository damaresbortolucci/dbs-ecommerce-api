package com.dbscommerce.log.common;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//declara que essa classe é um componente spring com objetivo de definir/conf beans
//add metodos que definem beans spring
public class ModelMapperConfig {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
