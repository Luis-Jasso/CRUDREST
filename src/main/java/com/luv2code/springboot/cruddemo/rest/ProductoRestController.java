package com.luv2code.springboot.cruddemo.rest;

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

import com.luv2code.springboot.cruddemo.entity.Producto;
import com.luv2code.springboot.cruddemo.service.ProductoService;

@RestController
@RequestMapping("/api")
public class ProductoRestController {

	private ProductoService productoService;
	
	@Autowired
	public ProductoRestController(ProductoService theProductoService) {
		productoService = theProductoService;
	}
	
	// expose "/productoss" and return list of productos
	@GetMapping("/productoss")
	public List<Producto> findAll() {
		return productoService.findAll();
	}

	// add mapping for GET /productoss/{productoId}
	
	@GetMapping("/productoss/{productoId}")
	public Producto getEmployee(@PathVariable int productoId) {
		
		Producto theProducto = productoService.findById(productoId);
		
		if (theProducto == null) {
			throw new RuntimeException("Producto id no encontrado - " + productoId);
		}
		
		return theProducto;
	}
	
	// add mapping for POST /productos - add new producto
	
	@PostMapping("/productoss")
	public Producto addProducto(@RequestBody Producto theProducto) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theProducto.setId(0);
		
		productoService.save(theProducto);
		
		return theProducto;
	}
	
	// add mapping for PUT /productos - update existing producto
	
	@PutMapping("/productoss")
	public Producto updateProducto(@RequestBody Producto theProducto) {
		
		productoService.save(theProducto);
		
		return theProducto;
	}
	
	// add mapping for DELETE /productoss/{productoId} - delete producto
	
	@DeleteMapping("/productoss/{productoId}")
	public String deleteProducto(@PathVariable int productoId) {
		
		Producto tempProducto = productoService.findById(productoId);
		
		// throw exception if null
		
		if (tempProducto == null) {
			throw new RuntimeException("Producto id no encontrado - " + productoId);
		}
		
		productoService.deleteById(productoId);
		
		return "Eliminar producto id - " + productoId;
	}
	
}










