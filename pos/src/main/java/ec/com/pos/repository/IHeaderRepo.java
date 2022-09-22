package ec.com.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.com.pos.model.Header;

@Repository("IHeaderRepo")
public interface IHeaderRepo extends JpaRepository<Header, Integer> {

}
