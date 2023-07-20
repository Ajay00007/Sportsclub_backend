package tech.shopex.com;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tech.shopex.com.Service.UserService;
import tech.shopex.com.models.Singin;
import tech.shopex.com.models.Users;
@RestController
public class UserResource {
	private final UserService usersservice;
	
	public UserResource(UserService usersservice) {
		this.usersservice=usersservice;
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<Users>>getAll(){
		List<Users> users=usersservice.findAll();
		return new ResponseEntity<>(users,HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<Users> getByEmail(@RequestBody Singin singin){
	
	Users users=usersservice.findByEmail(singin.getEmail());
	
	if(users.getPassword().equals(singin.getPassword())) {
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	}
	@PutMapping("/update")
	public ResponseEntity<Users> update(@RequestBody Users user){
		Users use=usersservice.update(user);
		return new ResponseEntity<>(use,HttpStatus.CREATED);
	}
	@PostMapping("/users")
	public ResponseEntity<Users> addUser(@RequestBody Users user){
		Users ad=usersservice.add(user);
		return new ResponseEntity<>(ad,HttpStatus.CREATED);
	}
	
}
