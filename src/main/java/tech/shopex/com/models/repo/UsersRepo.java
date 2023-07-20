package tech.shopex.com.models.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.shopex.com.models.Users;

public interface UsersRepo extends JpaRepository<Users,Long >{
	Optional<Users> findUserByEmail(String email);
}