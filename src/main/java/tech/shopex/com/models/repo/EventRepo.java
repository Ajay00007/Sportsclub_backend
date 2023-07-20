package tech.shopex.com.models.repo;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.shopex.com.models.Event;

public interface EventRepo extends JpaRepository<Event,Long > {

	
	Optional<Event> findByName(String name);
}
