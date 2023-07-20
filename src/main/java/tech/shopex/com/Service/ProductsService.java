package tech.shopex.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.shopex.com.models.repo.ProductsRepo;
import tech.shopex.com.models.Products;
import Exception.UserNotFoundException;

@Service
public class ProductsService {
	private final ProductsRepo productsrepo;
	@Autowired
	public ProductsService(ProductsRepo productsrepo) {
		this.productsrepo=productsrepo;
	}
	public Products add(Products products) {
		return productsrepo.save(products);
	}
	public List<Products> findAll(){
		return productsrepo.findAll();
	}
	public Products update(Products products){
		return productsrepo.save(products);
	}
	public void delete(Long id){
		productsrepo.deleteById(id);
	}

	public Products findById(Long id) {
		// TODO Auto-generated method stub
		return productsrepo.findById(id).orElseThrow(()->new UserNotFoundException("User by id not found"));
	}
	
	
}
