package com.formacionbdi.springboot.app.productos.models.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
	 * Variable LOG.
	 */
	private static final Log LOG = LogFactory.getLog(ProductoServiceImpl.class);

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
		LOG.info("Method: findAll().");
		return (List<Producto>) productoDao.findAll();
	}

	/**
	 * Find one Producto.
	 */
	@Override
	public Producto findById(Long id) {
		LOG.info("Method: findById. Parameter-Value: " + id);
		return productoDao.findById(id).orElse(null);
	}

}
