package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Producto;

public interface ProductoService {

	public List<Producto> findAll();
	
	public Producto findById(int theId);
	
	public void save(Producto theProducto);
	
	public void deleteById(int theId);
	
}
