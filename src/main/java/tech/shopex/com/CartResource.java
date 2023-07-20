package tech.shopex.com;

import java.util.Collection;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tech.shopex.com.Service.CartService;
import tech.shopex.com.Service.UserService;
import tech.shopex.com.models.Cart;
import tech.shopex.com.models.Users;

@RestController
public class CartResource {
private final CartService cartService;
private final UserService userService;
	
	public CartResource(CartService cartService,UserService userService) {
		this.cartService=cartService;
		this.userService=userService;
	}
	@GetMapping("/cart")
	public ResponseEntity<List<Cart>>getAll(){
		List<Cart> cart=cartService.findAll();
		return new ResponseEntity<>(cart,HttpStatus.OK);
	}
	
	@GetMapping("/cart/{Id}")
	public ResponseEntity<Cart>getByID(@PathVariable("Id") Long Id){
		Cart cart=cartService.findById(Id);
		return new ResponseEntity<>(cart,HttpStatus.OK);
	}

	@PostMapping("/cart/{name}")
	public ResponseEntity<Users> getByEmail(@PathVariable("name")String name,@RequestBody Cart e){
		Users user=userService.findByEmail(name);
		Collection<Cart> cart=user.getCarts();
		cart.add(e);
		user.setCarts(cart);
		System.out.println(user);
		Users a=userService.update(user);
		return new ResponseEntity<>(a,HttpStatus.OK);
	}


	@PutMapping("/cart")
	public ResponseEntity<Cart> update(@RequestBody Cart products){
		Cart ca=cartService.update(products);
		return new ResponseEntity<>(ca,HttpStatus.CREATED);
	}
	@DeleteMapping("/cart/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id){
		cartService.delete(id);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
