package com.formacionbdi.springboot.app.productos.models.service;

import java.util.List;

import com.formacionbdi.springboot.app.commons.models.entity.Producto;

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
	
	/**
	 * Method save one Producto.
	 * @param producto
	 * @return Producto
	 */
	public Producto save(Producto producto);
	
	/**
	 * Method delete by id
	 * @param id
	 */
	public void deleteById(Long id);

}
