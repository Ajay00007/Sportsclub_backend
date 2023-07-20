package tech.shopex.com;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tech.shopex.com.Service.CategoryService;
import tech.shopex.com.Service.ProductsService;

import tech.shopex.com.models.Category;
import tech.shopex.com.models.Products;


@RestController


public class CategoryResource {

private final CategoryService categoryService;
private final ProductsService productsService;
	
	public CategoryResource(CategoryService categoryService, ProductsService productsService) {
		this.categoryService=categoryService;
		this.productsService = productsService;
	}
	@GetMapping("category")
	public ResponseEntity<List<Category>>getAll(){
		List<Category> category=categoryService.findAll();
		return new ResponseEntity<>(category,HttpStatus.OK);
	}
	@PostMapping("/category")
	public ResponseEntity<Category> add(@RequestBody Category category){
		Category ca=categoryService.add(category);
		return new ResponseEntity<>(ca,HttpStatus.CREATED);
	}
	@PutMapping("/category/{name}")
  public ResponseEntity<Category> update(@RequestBody Category category,@PathVariable("name") String name){
		Category bb=categoryService.update(category);
//		String namechanger=updater.getName();
//		List<Products> productss=productsService.findAll();
//		for(Products t:productss) {
//			if(t.getCategory().equals(name)) {
//				t.setCategory(namechanger);
//			}
//			productsService.update(t);
//		}
		
		return new ResponseEntity<>(bb,HttpStatus.CREATED);
  }

	@DeleteMapping("/category/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id){
		String name=categoryService.findById(id).getName();
		List<Products> products=productsService.findAll();
//		for(Products t:products) {
//			if(t.getCategory().equals(name)) {
//				productsService.delete(t.getId());
//			}
//
//		}
		categoryService.delete(id);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
