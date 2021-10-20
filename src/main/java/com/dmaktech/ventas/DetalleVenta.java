package com.dmaktech.ventas;

public class DetalleVenta {

	private Long codigoDetalle;
	private Long codigoProducto;
	private Long cantidadProducto;
	private Double valorUnitario;
	private Double valorTotal;
	private Double valorIva;

	public DetalleVenta() {}

	public DetalleVenta(Long codigoDetalle, Long codigoProducto, Long cantidadProducto, Double valorUnitario,
			Double valorTotal, Double valorIva) {

		this.codigoDetalle = codigoDetalle;
		this.codigoProducto = codigoProducto;
		this.cantidadProducto = cantidadProducto;
		this.valorUnitario = valorUnitario;
		this.valorTotal = valorTotal;
		this.valorIva = valorIva;
	}

	public Long getCodigoDetalle() {
		return codigoDetalle;
	}

	public void setCodigoDetalle(Long codigoDetalle) {
		this.codigoDetalle = codigoDetalle;
	}

	public Long getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(Long codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public Long getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(Long cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Double getValorIva() {
		return valorIva;
	}

	public void setValorIva(Double valorIva) {
		this.valorIva = valorIva;
	}
}
