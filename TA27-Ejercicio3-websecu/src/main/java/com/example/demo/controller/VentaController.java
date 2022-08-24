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

import com.example.demo.dto.Venta;
import com.example.demo.service.VentaServiceImpl;

@RestController
@RequestMapping("/api")
public class VentaController {

	@Autowired
	VentaServiceImpl ventaServiceImpl;
	
	@GetMapping("/venta")
	public List<Venta> listarVenta(){
		return ventaServiceImpl.listarVenta();
	}
	
	
	@PostMapping("/venta")
	public Venta salvarVenta(@RequestBody Venta venta) {
		
		return ventaServiceImpl.guardarVenta(venta);
	}
	
	
	@GetMapping("/venta/{id}")
	public Venta VentaXID(@PathVariable(name="id") int id) {
		
		Venta Venta = new Venta();
		
		Venta = ventaServiceImpl.venta(id);
		
		return Venta;
	}
	
	@PutMapping("/venta/{id}")
	public Venta actualizarVenta(@PathVariable(name="id")int id,@RequestBody Venta venta) {
		
		Venta Ventaseleccionado = new Venta();
		Venta Ventaactualizado = new Venta();
		
		Ventaseleccionado= ventaServiceImpl.venta(id);
		
		
		Ventaseleccionado.setCajero(venta.getCajero());
		Ventaseleccionado.setMaquina(venta.getMaquina());
		Ventaseleccionado.setProducto(venta.getProducto());
		
		Ventaactualizado = ventaServiceImpl.actualizarVenta(Ventaseleccionado);
		
		return Ventaactualizado;
	}
	
	@DeleteMapping("/venta/{id}")
	public void eleiminarVenta(@PathVariable(name="id")int id) {
		ventaServiceImpl.eliminarVenta(id);
	}
}
