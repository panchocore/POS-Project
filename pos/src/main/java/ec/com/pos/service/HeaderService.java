package ec.com.pos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.com.pos.model.Detail;
import ec.com.pos.model.Header;
import ec.com.pos.repository.IDetailRepo;
import ec.com.pos.repository.IHeaderRepo;

@RestController
@RequestMapping("/factura")
@CrossOrigin
public class HeaderService {
	@Autowired
	IHeaderRepo repoH;
	
	@Autowired
	IDetailRepo repoD;

	@GetMapping("/buscar")
	public List<Header> buscar(){
		return repoH.findAll();
	}
	
	@PostMapping("/guardar")
	public Header guardar(@RequestBody Header header) {
		List<Detail> details = header.getDetailList();
		header.setDetailList(null);
		repoH.save(header);
		for(Detail det: details) {
			det.setHdr_id(header.getHdr_id());
		}
		
		repoD.saveAll(details);
		return header;
		
	}
	
	@DeleteMapping(path="/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		Optional<Header> header = repoH.findById(id);
		if(header.isPresent()) {
			repoD.deleteAll(header.get().getDetailList());
			repoH.delete(header.get());
		}
	}
}
