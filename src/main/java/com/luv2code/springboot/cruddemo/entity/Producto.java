package com.luv2code.springboot.cruddemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Producto {

	// define fields

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nombre")
	private String nameProduct;

	@Column(name = "descripcion")
	private String description;

	@Column(name = "stock")
	private int stockProduct;

	// define constructors

	public Producto() {
	}

	public Producto(String nombreProducto, String description, int stock) {
		this.nameProduct = nombreProducto;
		this.description = description;
		this.stockProduct = stock;
	}

	public Producto(int id, String nombreProducto, String descripcion, int stock) {
		this.id = id;
		this.nameProduct = nombreProducto;
		this.description = descripcion;
		this.stockProduct = stock;
	}
	// define getter/setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombrePorducto() {
		return nameProduct;
	}

	public void setNombreProducto(String firstName) {
		this.nameProduct = firstName;
	}

	public String getDescripcion() {
		return description;
	}

	public void setDescripcion(String lastName) {
		this.description = lastName;
	}

	public int getStock() {
		return stockProduct;
	}

	public void setStock(int stock) {
		this.stockProduct = stock;
	}

	// define tostring

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nameProduct + ", descripcion=" + description + ", stock=" + stockProduct + "]";
	}

}
