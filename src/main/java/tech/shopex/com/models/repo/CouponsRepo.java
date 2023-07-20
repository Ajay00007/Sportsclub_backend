package tech.shopex.com.models.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.shopex.com.models.Coupons;

public interface CouponsRepo  extends JpaRepository<Coupons,Long > {

	
	Optional<Coupons> findByName(String name);
}
