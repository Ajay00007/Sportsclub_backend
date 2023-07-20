package tech.shopex.com.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.shopex.com.models.Category;
import tech.shopex.com.models.repo.CategoryRepo;

import Exception.UserNotFoundException;

@Service
public class CategoryService {
	private final CategoryRepo categoryRepo;
	@Autowired
	public CategoryService(CategoryRepo categoryRepo) {
		this.categoryRepo=categoryRepo;
	}
	public Category add(Category category) {
		return categoryRepo.save(category);
	}
	public List<Category> findAll(){
		return categoryRepo.findAll();
	}
	public Category update(Category category){
		return categoryRepo.save(category);
	}
	public Category findById(Long id) {
		// TODO Auto-generated method stub
		return categoryRepo.findById(id).orElseThrow(()->new UserNotFoundException("User by id not found"));
	}

	public void delete(Long id){
		categoryRepo.deleteById(id);
	}

}
