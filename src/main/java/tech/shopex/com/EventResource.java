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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.shopex.com.Service.CouponsService;
import tech.shopex.com.Service.EventService;

import tech.shopex.com.models.Coupons;
import tech.shopex.com.models.Event;

@RestController
public class EventResource {
private final EventService eventService;

	private final CouponsService couponService;
	public EventResource(EventService eventService,CouponsService couponService) {
		this.eventService=eventService;
		this.couponService=couponService;
		
	}
	@GetMapping("/events")
	public ResponseEntity<List<Event>>getAll(){
		List<Event> events=eventService.findAll();
		return new ResponseEntity<>(events,HttpStatus.OK);
	}
	
	@GetMapping("/events/{Id}")
	public ResponseEntity<Event>getByID(@PathVariable("Id") Long Id){
		Event events=eventService.findById(Id);
		return new ResponseEntity<>(events,HttpStatus.OK);
	}
	@PostMapping("/events")
	public ResponseEntity<Event> add(@RequestBody Event event){
		Event kk=eventService.add(event);
		return new ResponseEntity<>(kk,HttpStatus.CREATED);
	}
	@PutMapping("/events")
	public ResponseEntity<Event> update(@RequestBody Event event){
		Event events=eventService.findById(event.getId());
		Collection<Coupons> coupon = events.getCoupon();
		for(Coupons c: coupon){
			c.setS_date(event.getS_date());
			c.setE_date(event.getE_date());
			couponService.update(c);

		}

		event.setCoupon(coupon);
		Event updater=eventService.update(event);
		return new ResponseEntity<>(updater,HttpStatus.CREATED);
	}
	@DeleteMapping("/events/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id){
		eventService.delete(id);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}