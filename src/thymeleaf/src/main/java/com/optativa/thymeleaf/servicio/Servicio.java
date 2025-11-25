package com.optativa.thymeleaf.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.optativa.thymeleaf.entidad.Producto;

@Service
public class Servicio {
	private List<Producto> listaProductos = new ArrayList<Producto>();
	
	public Servicio() {
		Producto p1 = new Producto(1, "Pan", 1, "Alimentación");
		Producto p2 = new Producto(2, "PC", 3000, "Componentes");
		Producto p3 = new Producto(3, "TEST", 334, "Prueba");
		listaProductos.add(p1);
		listaProductos.add(p2);
		listaProductos.add(p3);
	}
	
	
	public List<Producto> obtenerProductos(){
	
			return listaProductos;
	}
	
	public Producto obtenerProductoPorId(int id) {
		for(Producto p : listaProductos) {
			if(p.getId() == id) {
				return p;
			}
		}
		return null;
	}

}
