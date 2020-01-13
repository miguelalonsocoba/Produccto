package com.formacionbdi.springboot.app.productos.models.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionbdi.springboot.app.productos.models.dao.IProductoDao;
import com.formacionbdi.springboot.app.productos.models.entity.Producto;
import com.formacionbdi.springboot.app.productos.models.service.IProductoService;

/**
 * The class Service. ProductoServiceImpl.
 *
 */
@Service("productoServiceImpl")
public class ProductoServiceImpl implements IProductoService {

	/**
	 * Param procuctoDao.
	 */
	@Autowired
	private IProductoDao productoDao;

	/**
	 * Find All Productos.
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>) productoDao.findAll();
	}

	/**
	 * Find one Producto.
	 */
	@Override
	public Producto findById(Long id) {
		return productoDao.findById(id).orElse(null);
	}

}
