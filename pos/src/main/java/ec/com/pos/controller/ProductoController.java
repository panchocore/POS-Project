package ec.com.pos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import ec.com.pos.excepciones.ResourceNotFoundException;
import ec.com.pos.model.Producto;
import ec.com.pos.repository.IProductoRepo;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "http://localhost:4200/")
public class ProductoController {

	@Autowired
	private IProductoRepo repo;
	
	@GetMapping("/listar")
	public List<Producto> listar(){
		return repo.findAll();
	}
	
	@PostMapping("/crear")
	public void guardar(@RequestBody Producto obj) throws JsonMappingException, JsonProcessingException {
		repo.save(obj);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Producto obj){
		repo.save(obj);
	}
	
	@DeleteMapping(value = "/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		repo.deleteById(id);
	}
	
	@GetMapping("/producto/{id}")
	public ResponseEntity<Producto> getProductoPorId(@PathVariable("id") Integer id){
		Producto producto = repo.findById(id)
							.orElseThrow(() -> new ResourceNotFoundException("No existe producto con ID: " + id));
		return ResponseEntity.ok(producto);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Producto> updateProducto(@PathVariable("id") Integer id, @RequestBody Producto detallesProducto){
		Producto producto = repo.findById(id)
							.orElseThrow(() -> new ResourceNotFoundException("No existe producto con ID: " + id));
		
		producto.setPrd_name(detallesProducto.getPrd_name());
		producto.setPrd_price(detallesProducto.getPrd_price());
		
		Producto productoActualizado = repo.save(producto);
		
		return ResponseEntity.ok(productoActualizado);
	}
}
