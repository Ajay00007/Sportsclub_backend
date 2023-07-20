package tech.shopex.com.models.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import tech.shopex.com.models.Cart;


public interface CartRepo  extends JpaRepository<Cart,Long > {


	List<Cart>  findByEmail(String email);
}
