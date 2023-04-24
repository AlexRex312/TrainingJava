package training.spring.restful.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import training.spring.restful.domain.Producto;

@RestController
@RequestMapping("/producto")
public class ProductoResource {

	private List<Producto> productos = new ArrayList<Producto>();
	
	@GetMapping
	public List<Producto> obtenerProductos(){
		return productos;
	}
	
	@GetMapping("/{id}")
	public Producto obtenerProductoPorId(@PathVariable Long id) {
		for( Producto p : productos) {
			if (p.getId().equals(id)) {
				return p;
			}
		}
		return null;
	}
	
	@PostMapping
	public Producto crearProducto(@RequestBody Producto producto) {
		producto.setId(System.currentTimeMillis());
		productos.add(producto);
		return producto;
	}
	
	@PutMapping("/{id}")
	public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto productoActualizado) {
		for (Producto p : productos) {
			if(p.getId().equals(id)) {
				p.setNombre(productoActualizado.getNombre());
				p.setPrecio(productoActualizado.getPrecio());
				return p;
			}
		}
		return null;
	}
	
	
}
