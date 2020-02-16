package com.formacionbdi.springboot.app.productos.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The Entity Producto.
 *
 */
@Entity
@Table(name = "productos")
@Getter
@Setter
@ToString
public class Producto implements Serializable {

	/**
	 * Parameter id. Identity Autoincremental. Llave autoincremental.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Parameter nombre.
	 */
	private String nombre;

	/**
	 * Parameter precio.
	 */
	private Double precio;

	/**
	 * Parameter creatAt.
	 */
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	/**
	 * Parameter port.
	 * Transient: Indica que este campo no es persistente, y no esta mapeado a ningun campo.
	 */
	@Transient
	private Integer port;

	/**
	 * Atributo 'serialVersionUID'.
	 */
	private static final long serialVersionUID = 3317290695180406185L;

}
