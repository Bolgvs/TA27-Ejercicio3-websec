package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Productos;
import com.example.demo.service.ProductosServiceImpl;

@RestController
@RequestMapping("/api")
public class ProductosController {

	@Autowired
	ProductosServiceImpl productosServiceImpl;
	
	@GetMapping("/productos")
	public List<Productos> listarProductos(){
		return productosServiceImpl.listarProductos();
	}
	
	
	@PostMapping("/productos")
	public Productos salvarProductos(@RequestBody Productos productos) {
		
		return productosServiceImpl.guardarProductos(productos);
	}
	
	
	@GetMapping("/productos/{id}")
	public Productos Productos(@PathVariable(name="id") int id) {
		
		Productos Productos= new Productos();
		
		Productos=productosServiceImpl.productos(id);
		
		return Productos;
	}
	
	@PutMapping("/productos/{id}")
	public Productos actualizarProductos(@PathVariable(name="id")int id,@RequestBody Productos Productos) {
		
		Productos Productosseleccionado= new Productos();
		Productos Productosactualizado= new Productos();
		
		Productosseleccionado= productosServiceImpl.productos(id);
		
		Productosseleccionado.setNombre(Productos.getNombre());
		Productosseleccionado.setPrecio(Productos.getPrecio());
		Productosseleccionado.setVenta(Productos.getVenta());
		
		Productosactualizado = productosServiceImpl.actualizarProductos(Productosseleccionado);
		
		return Productosactualizado;
	}
	
	@DeleteMapping("/productos/{id}")
	public void eleiminarProductos(@PathVariable(name="id")int id) {
		productosServiceImpl.eliminarProductos(id);
	}
	
}
