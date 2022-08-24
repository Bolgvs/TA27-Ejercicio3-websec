package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IMaquinasRegistradorasDAO;
import com.example.demo.dto.MaquinasRegistradoras;

@Service
public class MaquinasRegistradorasServiceImpl implements IMaquinasRegistradorasService{

	@Autowired
	IMaquinasRegistradorasDAO iMaquinasRegistradorasDAO;

	@Override
	public List<MaquinasRegistradoras> listarMaquinasRegistradoras() {
		return iMaquinasRegistradorasDAO.findAll();
	}

	@Override
	public MaquinasRegistradoras guardarMaquinasRegistradoras(MaquinasRegistradoras maquinas_registradoras) {
		return iMaquinasRegistradorasDAO.save(maquinas_registradoras);
	}

	@Override
	public MaquinasRegistradoras maquinas_registradoras(int id) {
		return iMaquinasRegistradorasDAO.findById(id).get();
	}

	@Override
	public MaquinasRegistradoras actualizarMaquinasRegistradoras(MaquinasRegistradoras maquinas_registradoras) {
		return iMaquinasRegistradorasDAO.save(maquinas_registradoras);
	}

	@Override
	public void eliminarMaquinasRegistradoras(int id) {
		iMaquinasRegistradorasDAO.deleteById(id);
	}
}
