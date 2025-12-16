package com.optativa.thymeleaf.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.optativa.thymeleaf.entidad.Producto;

@Repository
public interface ProductoRepositorio extends CrudRepository<Producto, Integer>{

}
