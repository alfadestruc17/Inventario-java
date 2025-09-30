package com.prueba.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.prueba.producto.Producto;
import com.prueba.prueba.service.ProductoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/v1/productos")
@CrossOrigin(origins = "https://front-adso-main.vercel.app")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @PostMapping()
    public void createProducto(@RequestBody Producto producto) {
        productoService.createProducto(producto);
    }

    @GetMapping()
    public List<Producto> verProductos() {
        return productoService.verProductos();
    }

    @GetMapping("/{id}")
    public Producto buscarProductoId(@PathVariable Long id){
        return productoService.buscarProductoId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id){
        Producto producto = productoService.buscarProductoId(id);
        if (producto != null) productoService.eliminarProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable Long id, @RequestBody Producto producto) {
        return productoService.actualizarProducto(id, producto);
    }
}
