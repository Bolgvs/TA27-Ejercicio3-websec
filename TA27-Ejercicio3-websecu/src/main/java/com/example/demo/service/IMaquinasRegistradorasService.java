package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.MaquinasRegistradoras;

public interface IMaquinasRegistradorasService {

	public List<MaquinasRegistradoras> listarMaquinasRegistradoras(); //Listar All 
			
	public MaquinasRegistradoras guardarMaquinasRegistradoras(MaquinasRegistradoras maquinas_registradoras);
			
	public MaquinasRegistradoras maquinas_registradoras(int id);
			
	public MaquinasRegistradoras actualizarMaquinasRegistradoras(MaquinasRegistradoras maquinas_registradoras); 
			
	public void eliminarMaquinasRegistradoras(int id);
}
