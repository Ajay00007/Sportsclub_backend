package tech.shopex.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.shopex.com.models.Event;
import tech.shopex.com.models.repo.EventRepo;

import Exception.UserNotFoundException;

@Service
public class EventService {
	private final EventRepo eventRepo;
	@Autowired
	public EventService(EventRepo eventRepo) {
		this.eventRepo=eventRepo;
	}
	public Event add(Event event) {
		return eventRepo.save(event);
	}
	public List<Event> findAll(){
		return eventRepo.findAll();
	}
	public Event update(Event event){
		return eventRepo.save(event);
	}
	public void delete(Long id){
		eventRepo.deleteById(id);
	}
	public Event findById(Long id) {
		// TODO Auto-generated method stub
		return eventRepo.findById(id).orElseThrow(()->new UserNotFoundException("User by id not found"));
	}
	
	
}
