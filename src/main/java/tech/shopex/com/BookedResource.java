package tech.shopex.com;

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

import tech.shopex.com.Service.BookedService;
import tech.shopex.com.models.Booked;

@RestController
public class BookedResource {
private final BookedService bookedService;
	
	public BookedResource(BookedService bookedService) {
		this.bookedService=bookedService;
	}
	@GetMapping("/orders")
	public ResponseEntity<List< Booked>>getAll(){
		List<Booked> booked=bookedService.findAll();
		return new ResponseEntity<>(booked,HttpStatus.OK);
	}
	
	@GetMapping("/orders/{Id}")
	public ResponseEntity<Booked>getByID(@PathVariable("Id") Long Id){
		Booked booked=bookedService.findById(Id);
		return new ResponseEntity<>(booked,HttpStatus.OK);
	}

	@GetMapping("/orders/{name}")
	public ResponseEntity<List<Booked>>getByEmail(@PathVariable("name")String name){
		List<Booked> booked=bookedService.findByEmail(name);
		return new ResponseEntity<>(booked,HttpStatus.OK);
	}
	@PostMapping("/orders")
	public ResponseEntity<Booked> add(@RequestBody Booked booked){
		Booked boo=bookedService.add(booked);
		return new ResponseEntity<>(boo,HttpStatus.CREATED);
	}
	@PutMapping("/orders")
	public ResponseEntity<Booked> update(@RequestBody Booked booked){
		Booked bo=bookedService.update(booked);
		return new ResponseEntity<>(bo,HttpStatus.CREATED);
	}
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id){
		bookedService.delete(id);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
