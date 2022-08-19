package com.luv2code.springboot.cruddemo.dao;

import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Producto;

@Repository
public class ProductoDAOJdbcImpl implements ProductoDAO {

	@Autowired
	DataSource dataSource;

	@Override
	public List<Producto> findAll() {
		System.out.println("Implementación DAO con JDBC: " + dataSource);

		List<Producto> listaEmpleados = new ArrayList<>();
		// create sql statement
		String sql = "select * from productos";

		try (Connection myConn = dataSource.getConnection();
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery(sql);) {

			// process result set
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String nombre = myRs.getString("nombre");
				String descripcion = myRs.getString("descripcion");
				int stock = myRs.getInt("stock");

				// create new student object
				Producto tempProducto = new Producto(id, nombre, descripcion, stock);

				// add it to the list of students
				listaEmpleados.add(tempProducto);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaEmpleados;
	}

	@Override
	public Producto findById(int theId) {
		Producto producto = null;

		String sql = "SELECT * FROM productos WHERE id=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setInt(1, theId);
			try (ResultSet rest = stmt.executeQuery();) {

				if (rest.next()) {
					String nombre = rest.getString("nombre");
					String descipr = rest.getString("descripcion");
					int stock = rest.getInt("stock");
					producto = new Producto(theId, nombre, descipr, stock);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return producto;
	}

	@Override
	public void save(Producto theProdcuto) {

		if (theProdcuto.getId() != 0) {
			String sql = "update productos set nombre=?, descripcion=?, stock=? where id=?";
			try (Connection con = dataSource.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

		
				pstmt.setString(1, theProdcuto.getNameProduct());
				pstmt.setString(2, theProdcuto.getDescripcion());
				pstmt.setInt(3, theProdcuto.getStock());
				pstmt.setInt(4, theProdcuto.getId());

				pstmt.execute();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

			System.out.println("INSERTAR un producto nuevo");
			String sql = "INSERT INTO productos VALUES(?,?, ?, ?)";
			try (Connection con = dataSource.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

				pstmt.setInt(1, theProdcuto.getId());
				pstmt.setString(2, theProdcuto.getDescripcion());
				pstmt.setString(3, theProdcuto.getDescripcion());
				pstmt.setInt(4, theProdcuto.getStock());

				pstmt.execute();
				System.out.println("Producto insertado: " + theProdcuto);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void deleteById(int theId) {
		String sql = "DELETE FROM productos WHERE id=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {

			pstmt.setInt(1, theId);
			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
