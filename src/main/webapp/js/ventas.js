const listadoProductos = document.querySelector("#listaProductos");
const carrito = {
	productos: []	
};

listadoProductos.addEventListener('click', e => {
	if(e.target.matches('.btn-consultar')) {
		const fila = e.target.closest('tr');
		const codigo = parseInt(fila.querySelector('td:first-child input').value);
		
		if(isNaN(codigo))
			return;
		
		traerDatosProducto(codigo)
		.then(producto => {
			
			producto.cantidad = 1;
			
			if (carrito.productos.findIndex(p => p.codigo === producto.codigo) === -1) {
				carrito.productos.push(producto);	
			} 
			else {
				Swal.fire({
			  		title: 'El producto ya se encuentra agregado',
			  		icon: 'info',
			  		timer: 2500
				});
				return;
			}
			
			fila.children[2].textContent = producto.nombre;
			
			const inputCantidad =  fila.children[3].querySelector('input')
			inputCantidad.value = producto.cantidad;
			inputCantidad.disabled = false;
			const totalProducto = fila.children[4];
			totalProducto.textContent = producto.precioVenta;
			producto.subtotal = producto.precioVenta;
			producto.valorIva = producto.iva * producto.precioVenta / 100;	
			calcularTotalVenta();
			
			['change', 'blur'].forEach(evt => {
				inputCantidad.addEventListener(evt, event => calcularSubtotalProducto(event, totalProducto, codigo));							
			});
		})
		.catch(e => {		
			Swal.fire({
		  		title: e.message,
		  		icon: 'error',
		  		timer: 2500
			});
		});					
	}
});

async function traerDatosProducto(codigoProducto) {
	
	const response = await fetch(`http://localhost:5000/productos/${codigoProducto}`);
	
	if(response.status === 404) {
		throw new Error('Producto no encontrado');
	}
	
	return await response.json();		
}

function calcularSubtotalProducto(event, totalProducto, codigo) {
	
	const producto = carrito.productos.filter(p => p.codigo === codigo)[0];
	producto.cantidad = parseInt(event.target.value);
	const subtotalProducto = producto.cantidad * producto.precioVenta
	totalProducto.textContent = subtotalProducto;
	
	producto.subtotal = subtotalProducto;
	producto.valorIva = producto.iva * subtotalProducto / 100;	
	
	calcularTotalVenta();
}

function calcularTotalVenta() {
	const inputSubtotal = document.querySelector('#subtotal');
	const inputIva = document.querySelector('#totalIva');
	const inputTotal = document.querySelector('#total');
	
	carrito.subtotal = carrito.productos.reduce((sub, p) => sub + p.subtotal, 0);
	carrito.totalIva = carrito.productos.reduce((iva, p) => iva + p.valorIva, 0);
	
	inputSubtotal.value = carrito.subtotal;
	inputIva.value = carrito.totalIva;
	inputTotal.value = carrito.subtotal + carrito.totalIva;	
}
