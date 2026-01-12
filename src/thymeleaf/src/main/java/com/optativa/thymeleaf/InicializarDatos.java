package com.optativa.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.optativa.thymeleaf.entidad.Producto;
import com.optativa.thymeleaf.servicio.ProductoServicio;

import jakarta.annotation.PostConstruct;

@Component
public class InicializarDatos {
	
	final int TOTAL_PRUEBAS = 10;
	
	@Autowired
	private ProductoServicio productoServicio;
	

	private final Faker faker = new Faker();
	
	@PostConstruct
	public void init() {
		for(int i=0; i<TOTAL_PRUEBAS; i++) {
		
		Producto p = new Producto();
		p.setNombre(faker.name().name());
		p.setPrecio(faker.number().randomDouble(2, 10, 20));
		p.setCategoria(faker.beer().style());
		
		
		productoServicio.agregarProducto(p);
		}
		
	}
}
