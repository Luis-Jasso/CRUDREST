 package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.ProductoDAO;
import com.luv2code.springboot.cruddemo.entity.Producto;

@Service
public class ProductoServiceImpl implements ProductoService {

	
	private ProductoDAO productoDAO;
	
	@Autowired
	public ProductoServiceImpl(@Qualifier("productoDAOJdbcImpl") ProductoDAO theProducntoDAO) {
		productoDAO = theProducntoDAO;
	}
	
	@Override
	@Transactional
	public List<Producto> findAll() {
		return productoDAO.findAll();
	}

	@Override
	@Transactional
	public Producto findById(int theId) {
		return productoDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Producto theProducto) {
		productoDAO.save(theProducto);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		productoDAO.deleteById(theId);
	}

}






