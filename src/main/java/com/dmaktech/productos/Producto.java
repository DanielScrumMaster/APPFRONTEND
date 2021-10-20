package com.dmaktech.productos;

import com.dmaktech.proveedores.Proveedor;

public class Producto {
	
	private Long codigo;
	private String nombre;
	private Double iva;
	private Long nitProveedor;
	private Double precioCompra;
	private Double precioVenta;
	private Proveedor proveedor;
	
	public Producto() { }

	public Producto(Long codigo, String nombre, Double iva, Long nitProveedor, Double precioCompra,
			Double precioVenta) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.iva = iva;
		this.nitProveedor = nitProveedor;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
	}

	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Double getIva() {
		return iva;
	}
	
	public void setIva(Double iva) {
		this.iva = iva;
	}
	
	public Long getNitProveedor() {
		return nitProveedor;
	}
	
	public void setNitProveedor(Long nitProveedor) {
		this.nitProveedor = nitProveedor;
	}
	
	public Double getPrecioCompra() {
		return precioCompra;
	}
	
	public void setPrecioCompra(Double precioCompra) {
		this.precioCompra = precioCompra;
	}
	
	public Double getPrecioVenta() {
		return precioVenta;
	}
	
	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
}
