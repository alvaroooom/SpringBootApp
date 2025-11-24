package com.optativa.thymeleaf.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.optativa.thymeleaf.ThymeleafApplication;
import com.optativa.thymeleaf.entidad.Producto;

@Controller
public class Controlador {
	
	private final ThymeleafApplication thymeleafApplication;

    Controlador(ThymeleafApplication thymeleafApplication) {
        this.thymeleafApplication = thymeleafApplication;
    }
    
    @GetMapping("/saluda")
	public String saludo(@RequestParam(required = false, defaultValue = "Test") String name, Model modelo) {
		System.out.println("#####  Entra en /saluda");
		//String name = "Manuel";
		modelo.addAttribute("nombre", name);
		
		return "saludo";
	}
    
    @GetMapping("/productos")
    public String listado(Model model) {
    	
    	List<Producto> ListaProductos = new ArrayList<Producto>();
    	Producto p1 = new Producto("Pan", 1, "Alimentación");
    	Producto p2 = new Producto("PC", 3000, "Componentes");
    	ListaProductos.add(p1); 	
    	ListaProductos.add(p2);
    	
    	model.addAttribute("ListaProductos", ListaProductos);
    	
		return "lista";
    }
}
