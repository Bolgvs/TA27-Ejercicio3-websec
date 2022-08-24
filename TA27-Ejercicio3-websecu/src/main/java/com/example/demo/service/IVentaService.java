package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Venta;

public interface IVentaService {

	public List<Venta> listarVenta();
			
	public Venta guardarVenta(Venta venta);
			
	public Venta venta(int id); 
			
	public Venta actualizarVenta(Venta venta); 
			
	public void eliminarVenta(int id);
}