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
import tech.shopex.com.Service.EventService;
import tech.shopex.com.Service.CouponsService;
import tech.shopex.com.models.Cart;
import tech.shopex.com.models.Coupons;
import tech.shopex.com.models.Event;
import tech.shopex.com.models.Users;

@RestController
public class CouponsResource {
private final CouponsService couponsService;
private final EventService eventService;
	
	public CouponsResource(CouponsService couponsService,EventService eventService) {
		this.couponsService=couponsService;
		this.eventService=eventService;
	}
	@GetMapping("/coupons")
	public ResponseEntity<List<Coupons>>getAll(){
		List<Coupons> coupons=couponsService.findAll();
		return new ResponseEntity<>(coupons,HttpStatus.OK);
	}
	
	@GetMapping("/coupons/{Id}")
	public ResponseEntity<Coupons>getByID(@PathVariable("Id") Long Id){
		Coupons coupons=couponsService.findById(Id);
		return new ResponseEntity<>(coupons,HttpStatus.OK);
	}

	@PostMapping("/coupons/{id}")
	public ResponseEntity<Event> add(@RequestBody Coupons e,@PathVariable("Id") Long Id){
		Event event=eventService.findById(Id);
		Collection<Coupons> coupon=event.getCoupon();
		coupon.add(e);
		event.setCoupon(coupon);
		Event aa=eventService.update(event);
		return new ResponseEntity<>(aa,HttpStatus.OK);
	}
	@PutMapping("/coupons")
	public ResponseEntity<Coupons> update(@RequestBody Coupons coupons){
		Coupons bb=couponsService.update(coupons);
		return new ResponseEntity<>(bb,HttpStatus.CREATED);
	}
	@DeleteMapping("/coupons/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id){
		couponsService.delete(id);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}