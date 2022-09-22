package ec.com.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import ec.com.pos.model.Detail;
import ec.com.pos.repository.IDetailRepo;

@RestController
@RequestMapping("/detail")
public class DetailController {

	@Autowired
	private IDetailRepo repo;
	
	@PostMapping("/crear")
	public void guardar(@RequestBody Detail obj) throws JsonMappingException, JsonProcessingException {
		repo.save(obj);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Detail obj){
		repo.save(obj);
	}
	
	@DeleteMapping(value = "/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		repo.deleteById(id);
	}
}
