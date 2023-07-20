package tech.shopex.com.models.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.shopex.com.models.Booked;

public interface BookedRepo  extends JpaRepository<Booked,Long >{
	Optional<Booked> findByName(String name);

	List<Booked>  findByEmail(String email);
}