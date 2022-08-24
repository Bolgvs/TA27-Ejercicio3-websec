package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Cajeros;

public interface ICajerosService {

	public List<Cajeros> listarCajeros();
	
	public Cajeros guardarCajeros(Cajeros cajeros);	
	
	public Cajeros cajeros(int id); 
	
	public Cajeros actualizarCajeros(Cajeros cajeros); 
	
	public void eliminarCajeros(int id);
	
}
