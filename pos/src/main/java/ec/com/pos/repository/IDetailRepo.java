package ec.com.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.com.pos.model.Detail;

@Repository("IDetailRepo")
public interface IDetailRepo extends JpaRepository<Detail, Integer> {

}
