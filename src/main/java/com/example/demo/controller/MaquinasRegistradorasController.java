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

import com.example.demo.dto.MaquinasRegistradoras;
import com.example.demo.service.MaquinasRegistradorasServiceImpl;

@RestController
@RequestMapping("/api")
public class MaquinasRegistradorasController {

	@Autowired
	MaquinasRegistradorasServiceImpl maquinasRegistradorasServiceImpl;
	
	@GetMapping("/maquinasRegistradoras")
	public List<MaquinasRegistradoras> listarMaquinasRegistradoras(){
		return maquinasRegistradorasServiceImpl.listarMaquinasRegistradoras();
	}
	
	
	@PostMapping("/maquinasRegistradoras")
	public MaquinasRegistradoras salvarMaquinasRegistradoras(@RequestBody MaquinasRegistradoras maquinasRegistradoras) {
		
		return maquinasRegistradorasServiceImpl.guardarMaquinasRegistradoras(maquinasRegistradoras);
	}
	
	
	@GetMapping("/maquinasRegistradoras/{id}")
	public MaquinasRegistradoras MaquinasRegistradorasXID(@PathVariable(name="id") int id) {
		
		MaquinasRegistradoras MaquinasRegistradoras = new MaquinasRegistradoras();
		
		MaquinasRegistradoras = maquinasRegistradorasServiceImpl.maquinas_registradoras(id);
		
		return MaquinasRegistradoras;
	}
	
	@PutMapping("/maquinasRegistradoras/{id}")
	public MaquinasRegistradoras actualizarMaquinasRegistradoras(@PathVariable(name="id")int id,@RequestBody 
			MaquinasRegistradoras MaquinasRegistradoras) {
		
		MaquinasRegistradoras MaquinasRegistradorasseleccionado= new MaquinasRegistradoras();
		MaquinasRegistradoras MaquinasRegistradorasactualizado= new MaquinasRegistradoras();
		
		MaquinasRegistradorasseleccionado= maquinasRegistradorasServiceImpl.maquinas_registradoras(id);
		
		MaquinasRegistradorasseleccionado.setPiso(MaquinasRegistradoras.getPiso());
		MaquinasRegistradorasseleccionado.setVenta(MaquinasRegistradoras.getVenta());
		
		MaquinasRegistradorasactualizado = maquinasRegistradorasServiceImpl
				.actualizarMaquinasRegistradoras(MaquinasRegistradorasseleccionado);
		
		return MaquinasRegistradorasactualizado;
	}
	
	@DeleteMapping("/maquinasRegistradoras/{id}")
	public void eleiminarMaquinasRegistradoras(@PathVariable(name="id")int id) {
		maquinasRegistradorasServiceImpl.eliminarMaquinasRegistradoras(id);
	}
}