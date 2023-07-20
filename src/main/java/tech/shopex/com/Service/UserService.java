package tech.shopex.com.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.shopex.com.models.Users;
import tech.shopex.com.models.repo.UsersRepo;

import Exception.UserNotFoundException;
@Service
public class UserService {
	private final UsersRepo usersrepo;
	@Autowired
	public UserService(UsersRepo usersrepo) {
		this.usersrepo=usersrepo;
		
	}
	public Users add(Users user) {
		return usersrepo.save(user);
	}
	public List<Users> findAll(){
		return usersrepo.findAll();
	}
	public Users update(Users user){

		return usersrepo.save(user);
	}
	public Users findByEmail(String Email) {
		return usersrepo.findUserByEmail(Email).orElseThrow(()->new UserNotFoundException("User by id not found"));
	}
	
}
