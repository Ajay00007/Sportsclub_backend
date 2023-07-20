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

import tech.shopex.com.models.Cart;
import tech.shopex.com.models.Category;
import tech.shopex.com.models.Products;
import tech.shopex.com.models.Users;
import tech.shopex.com.Service.CategoryService;
import tech.shopex.com.Service.ProductsService;

@RestController
public class ProductsResource {
	
private final ProductsService productsService;
private final CategoryService categoryService;

	
	public ProductsResource(ProductsService productsService,CategoryService categoryService) {
		this.productsService=productsService;
		this.categoryService=categoryService;
		
	}
	@GetMapping("/products")
	public ResponseEntity<List<Products>>getAllTrips(){
		List<Products> products=productsService.findAll();
		return new ResponseEntity<>(products,HttpStatus.OK);
	}
	
	@GetMapping("/products/{Id}")
	public ResponseEntity<Products>getByID(@PathVariable("Id") Long Id){
		Products products=productsService.findById(Id);
		return new ResponseEntity<>(products,HttpStatus.OK);
	}

	@PostMapping("/products/{id}")
	public ResponseEntity<Products> add(@RequestBody Products e,@PathVariable("id")Long id){
		Category cat=categoryService.findById(id);
		Collection<Products> pro=cat.getProducts();
		pro.add(e);
		cat.setProducts(pro);
		Category ca=categoryService.update(cat);
		return new ResponseEntity<>(e,HttpStatus.OK);
	}

	@PutMapping("/products")
	public ResponseEntity<Products> update(@RequestBody Products products){
		Products up=productsService.update(products);
		return new ResponseEntity<>(up,HttpStatus.CREATED);
	}
	@DeleteMapping("/products/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id){
		productsService.delete(id);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}
