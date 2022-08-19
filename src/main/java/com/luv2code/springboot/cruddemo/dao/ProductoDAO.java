package com.luv2code.springboot.cruddemo.dao;

import java.util.List;
import com.luv2code.springboot.cruddemo.entity.Producto;

public interface ProductoDAO {

	List<Producto> findAll();
	
	Producto findById(int theId);
	
	void save(Producto theProducto);
	
	void deleteById(int theId);
	
}
