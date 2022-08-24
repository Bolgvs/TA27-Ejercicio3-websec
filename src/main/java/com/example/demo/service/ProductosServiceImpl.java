package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProductosDAO;
import com.example.demo.dto.Productos;

@Service
public class ProductosServiceImpl implements IProductosService{

	@Autowired
	IProductosDAO iProductosDAO;

	@Override
	public List<Productos> listarProductos() {
		return iProductosDAO.findAll();
	}

	@Override
	public Productos guardarProductos(Productos productos) {
		return iProductosDAO.save(productos);
	}

	@Override
	public Productos productos(int id) {
		return iProductosDAO.findById(id).get();
	}

	@Override
	public Productos actualizarProductos(Productos productos) {
		return iProductosDAO.save(productos);
	}

	@Override
	public void eliminarProductos(int id) {
		iProductosDAO.deleteById(id);
	}
}
