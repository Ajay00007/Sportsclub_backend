package tech.shopex.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.shopex.com.models.Cart;
import tech.shopex.com.models.repo.CartRepo;

import Exception.UserNotFoundException;

@Service
public class CartService {

	private final CartRepo cartRepo;
	@Autowired
	public CartService(CartRepo cartRepo) {
		this.cartRepo=cartRepo;
	}
	public Cart add(Cart cart) {
		return cartRepo.save(cart);
	}
	public List<Cart> findAll(){
		return cartRepo.findAll();
	}
	public Cart update(Cart cart){
		return cartRepo.save(cart);
	}
	public void delete(Long id){
		cartRepo.deleteById(id);
	}
	public Cart findById(Long id) {
		// TODO Auto-generated method stub
		return cartRepo.findById(id).orElseThrow(()->new UserNotFoundException("User by id not found"));
	}
	public List<Cart>  findByEmail(String Email) {
		return cartRepo.findByEmail(Email);
	}
	
	

}
