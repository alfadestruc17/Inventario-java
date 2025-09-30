package com.prueba.prueba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.prueba.producto.Producto;
import com.prueba.prueba.repository.ProductoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public void createProducto(Producto producto){
        productoRepository.save(producto);
    }

    public List<Producto> verProductos() {
        return productoRepository.findAll();
    }

    @Transactional
    public Producto buscarProductoId(Long id){
        return productoRepository.findById(id).orElse(null);
    }

    @Transactional
    public void eliminarProducto(Producto producto){
        productoRepository.delete(producto);
    }

    @Transactional
    public Producto actualizarProducto(Long id, Producto producto) {
        producto.setId(id);                 // asegura que se actualiza el recurso {id}
        return productoRepository.save(producto);
    }

}
