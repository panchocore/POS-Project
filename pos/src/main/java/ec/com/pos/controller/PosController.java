
package ec.com.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import ec.com.pos.model.Producto;
import ec.com.pos.repository.IProductoRepo;

@Controller
public class PosController {

	@Autowired
	private IProductoRepo repo;
	
	@GetMapping("/inicio")
    public String inicio(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        //logica 
		
		Producto p = new Producto();
		p.setPrd_id(1);
		p.setPrd_name("mesa");
		p.setPrd_price(45.00);
		repo.save(p);
		
		model.addAttribute("name", name);
        return "inicio";
    }
	
	@GetMapping("/listar")
    public String inicio(Model model) {
        //logica 							
		model.addAttribute("productos", repo.findAll());
        return "inicio";
    }
	
}
