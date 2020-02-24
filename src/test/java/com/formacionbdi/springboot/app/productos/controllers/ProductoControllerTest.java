package com.formacionbdi.springboot.app.productos.controllers;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;
import com.formacionbdi.springboot.app.productos.models.service.IProductoService;

/**
 * PU de la clase ProductoController.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductoControllerTest {

	@InjectMocks
	private ProductoController controller;

	@Mock
	private IProductoService productoService;

	/**
	 * Test get All OK.
	 */
	@Test
	public void okTest() {
		when(productoService.findAll()).thenReturn(getObject());
		List<Producto> productos = controller.listar();

		assertNotNull("La lista producto es null. ",productos);		
//		assertEquals("Mon Feb 17 20:31:46 CST 2020", productos.get(0).getCreateAt());
		assertEquals(5, productos.get(0).getId());
		assertEquals("Monica", productos.get(0).getNombre());
		assertEquals(null, productos.get(0).getPort());
		assertEquals(30.00, productos.get(0).getPrecio());
	}
	
	/**
	 * Test ver Ok.
	 * @throws Exception 
	 */
	@Test
	public void okTestVer() throws Exception {
		when(productoService.findById(ArgumentMatchers.anyLong())).thenReturn(new Producto());
		
		Producto producto = controller.detalle(1L);
		assertNotNull("El objeto producto es null", producto);
	}

	/**
	 * Input object.
	 */
	private List<Producto> getObject() {
		List<Producto> listProducto = new ArrayList<>();
		Producto product = new Producto();
		product.setCreateAt(new Date());
		product.setId(5L);
		product.setNombre("Monica");
		product.setPort(9000);
		product.setPrecio(30.00);
		listProducto.add(product);
		return listProducto;
	}

}
