package com.formacionbdi.springboot.app.productos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;
import com.formacionbdi.springboot.app.productos.models.service.IProductoService;

/**
 * The class Controller. ProductoController.
 *
 */
@RestController
public class ProductoController {

	/**
	 * Atributo del las enviroments e indica el numero de puerto en el que se
	 * despliega la aplicación.
	 */
	@Autowired
	private Environment env;

	/**
	 * Variable Log.
	 */
	private static final Log LOG = LogFactory.getLog(ProductoController.class);

	/**
	 * Parameter. Inyeccion de dependencia. productoService.
	 */
	@Autowired
	@Qualifier(value = "productoServiceImpl")
	private IProductoService productoService;

	@GetMapping("/listar")
	public List<Producto> listar() {
		LOG.info("Method listar().");
		return productoService.findAll().stream().map(producto -> {
			producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			return producto;
		}).collect(Collectors.toList());
	}

	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id) {
		LOG.info("Method detalle(). Parameter-Value: " + id);
		Producto producto = productoService.findById(id);
		producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return producto;
	}

}
