package com.optativa.thymeleaf.controlador;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.optativa.thymeleaf.entidad.Producto;
import com.optativa.thymeleaf.servicio.Servicio;

@WebMvcTest(Controlador.class)
class ControladorTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private Servicio servicio;   // 🔴 CLAVE: mock del servicio para que el contexto arranque

    @Test
    @DisplayName("GET /formulario devuelve la vista 'formulario' con un Producto en el modelo")
    void mostrarForm_devuelveFormularioConProducto() throws Exception {
        mockMvc.perform(get("/formulario"))
               .andExpect(status().isOk())
               .andExpect(view().name("formulario"))
               .andExpect(model().attributeExists("producto"));
    }

    @Test
    @DisplayName("GET /productos rellena el modelo con listaProductos y muestra 'lista'")
    void listadoProductos() throws Exception {
        when(servicio.obtenerProductos()).thenReturn(
                List.of(new Producto(1, "P1", 10.0, "Cat1"))
        );

        mockMvc.perform(get("/productos"))
               .andExpect(status().isOk())
               .andExpect(view().name("lista"))
               .andExpect(model().attributeExists("listaProductos"))
               .andExpect(model().attribute("listaProductos", hasSize(1)));

        verify(servicio, times(1)).obtenerProductos();
    }
}
