package com.formacionbdi.springboot.app.productos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.commons.models.entity.Producto;
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
//	@Autowired
//	private Environment env;

	@Value("${server.port}")
	private Integer port;

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

	/**
	 * Obtiene una lista de Productos.
	 * @return List Productos
	 */
	@GetMapping("/listar")
	public List<Producto> listar() {
		LOG.info("Method listar().");
		
		return productoService.findAll().stream().map(producto -> {
//			producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			producto.setPort(port);
			return producto;
		}).collect(Collectors.toList());
	}

	/**
	 * Obtienen un producto dependiendo del id.
	 * @param id
	 * @return Producto
	 * @throws Exception
	 */
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id) throws Exception {
		LOG.info("Method detalle(). Parameter-Value: " + id);
		
		Producto producto = productoService.findById(id);
//		producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		producto.setPort(port);
		
//		try {
//			Thread.sleep(2000L);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		return producto;
	}
	
	/**
	 * Crea un Producto.
	 * @ResponseStatus: devuele un codigo 201 de que la transacción fue exitosa.
	 * @param producto
	 * @return Producto
	 */
	@PostMapping(value = "/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto crear(@RequestBody Producto producto) {
		LOG.info("Method: crear(). Parameter-Value: " + producto);
		
		return productoService.save(producto);
	}
	
	/**
	 * Modifica un Producto existente.
	 * @param producto
	 * @param id
	 * @return Producto modificado
	 */
	@PutMapping(value = "/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto editar(@RequestBody Producto producto, @PathVariable Long id) {
		LOG.info("Method: editar(). Parameter-Value: " + producto);
		
		Producto productoDB = productoService.findById(id);
		productoDB.setNombre(producto.getNombre());
		productoDB.setPrecio(producto.getPrecio());
		
		return productoService.save(productoDB);
	}
	
	/**
	 * Elimina un producto en base a su id.
	 * @ResponseStatus: Devuelve un codigo de 204 de que se realizo la eliminacion correctamente
	 * @param id
	 */
	@DeleteMapping(value = "/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		LOG.info("Method: eliminar(). Parameter-Value: " + id);
		
		productoService.deleteById(id);
	}

}
