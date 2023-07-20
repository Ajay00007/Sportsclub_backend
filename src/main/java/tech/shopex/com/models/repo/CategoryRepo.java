package tech.shopex.com.models.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.shopex.com.models.Category;

public interface CategoryRepo extends JpaRepository<Category,Long > {


}
