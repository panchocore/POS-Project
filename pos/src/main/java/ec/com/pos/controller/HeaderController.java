package ec.com.pos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import ec.com.pos.model.Header;
import ec.com.pos.repository.IHeaderRepo;

@RestController
@RequestMapping("/header")
@CrossOrigin(origins = "http://localhost:4200/")
public class HeaderController {

	@Autowired
	private IHeaderRepo repo;
	
	@GetMapping("/listar")
	public List<Header> listar(){
		return repo.findAll();
	}
	
	@PostMapping("/crear")
	public void guardar(@RequestBody Header obj) throws JsonMappingException, JsonProcessingException {
		repo.save(obj);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Header obj){
		repo.save(obj);
	}
	
	@DeleteMapping(value = "/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		repo.deleteById(id);
	}
}
