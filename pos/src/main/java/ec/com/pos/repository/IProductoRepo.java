package ec.com.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.com.pos.model.Producto;

public interface IProductoRepo extends JpaRepository<Producto, Integer> {

}
