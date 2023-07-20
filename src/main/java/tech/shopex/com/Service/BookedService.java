package tech.shopex.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Exception.UserNotFoundException;
import tech.shopex.com.models.Booked;
import tech.shopex.com.models.repo.BookedRepo;

@Service
public class BookedService {
	
private final BookedRepo bookedRepo;
	
	@Autowired
	public BookedService(BookedRepo bookedRepo) {
		this.bookedRepo=bookedRepo;
	}
	public Booked add(Booked booked) {
		return bookedRepo.save(booked);
	}
	public List<Booked> findAll(){
		return bookedRepo.findAll();
	}
	public Booked update(Booked booked){
		return bookedRepo.save(booked);
	}
	public void delete(Long id){
		bookedRepo.deleteById(id);
	}
	public Booked findByName(String name) {
		return bookedRepo.findByName(name).orElseThrow(()->new UserNotFoundException("User by id not found"));
	}

	public Booked findById(Long id) {
		// TODO Auto-generated method stub
		return bookedRepo.findById(id).orElseThrow(()->new UserNotFoundException("User by id not found"));
	}
	public List<Booked>  findByEmail(String Email) {
		return bookedRepo.findByEmail(Email);
}

}
