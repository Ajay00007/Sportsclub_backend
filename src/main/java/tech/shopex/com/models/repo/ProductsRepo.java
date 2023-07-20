package tech.shopex.com.models.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.shopex.com.models.Products;


public interface ProductsRepo extends JpaRepository<Products,Long > {

	
	}
