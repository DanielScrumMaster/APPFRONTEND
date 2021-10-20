package com.dmaktech.ventas;

import java.util.List;

public class Venta {

	private Long id;
	private Long cedulaCliente;
	private Long cedulaUsuario;
	private Double valorInicial;
	private Double iva;
	private Double valorTotal;
	private List<DetalleVenta> detallesVenta;

	public Venta() {}
	
	public Venta(Long id, Long cedulaCliente, Long cedulaUsuario, Double valorInicial, Double iva, Double valorTotal,
			List<DetalleVenta> detallesVenta) {
		super();
		this.id = id;
		this.cedulaCliente = cedulaCliente;
		this.cedulaUsuario = cedulaUsuario;
		this.valorInicial = valorInicial;
		this.iva = iva;
		this.valorTotal = valorTotal;
		this.detallesVenta = detallesVenta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(Long cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public Long getCedulaUsuario() {
		return cedulaUsuario;
	}

	public void setCedulaUsuario(Long cedulaUsuario) {
		this.cedulaUsuario = cedulaUsuario;
	}

	public Double getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(Double valorInicial) {
		this.valorInicial = valorInicial;
	}

	public Double getIva() {
		return iva;
	}

	public void setIva(Double iva) {
		this.iva = iva;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<DetalleVenta> getDetallesVenta() {
		return detallesVenta;
	}

	public void setDetallesVenta(List<DetalleVenta> detallesVenta) {
		this.detallesVenta = detallesVenta;
	}
}
