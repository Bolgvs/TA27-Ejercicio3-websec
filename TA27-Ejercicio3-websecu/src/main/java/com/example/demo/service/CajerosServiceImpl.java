package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICajerosDAO;
import com.example.demo.dto.Cajeros;

@Service
public class CajerosServiceImpl implements ICajerosService {

	@Autowired
	ICajerosDAO iCajerosDAO;

	@Override
	public List<Cajeros> listarCajeros() {
		return iCajerosDAO.findAll();
	}

	@Override
	public Cajeros guardarCajeros(Cajeros cajeros) {
		return iCajerosDAO.save(cajeros);
	}

	@Override
	public Cajeros cajeros(int id) {
		return iCajerosDAO.findById(id).get();
	}

	@Override
	public Cajeros actualizarCajeros(Cajeros cajeros) {
		return iCajerosDAO.save(cajeros);
	}

	@Override
	public void eliminarCajeros(int id) {
		iCajerosDAO.deleteById(id);
	}
}
