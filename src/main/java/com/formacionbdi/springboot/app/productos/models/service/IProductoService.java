package com.formacionbdi.springboot.app.productos.models.service;

import java.util.List;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;

/**
 * The Interface IProductoService.
 *
 */
public interface IProductoService {
	
	/**
	 * Method findAll().
	 * 
	 * @return List of Producto
	 */
	public List<Producto> findAll();
	
	/**
	 * Method findById.
	 * @param id
	 * @return Object Producto
	 */
	public Producto findById(Long id);

}
