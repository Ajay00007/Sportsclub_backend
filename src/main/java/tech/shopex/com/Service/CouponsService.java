package tech.shopex.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.shopex.com.models.Coupons;
import tech.shopex.com.models.repo.CouponsRepo;

import Exception.UserNotFoundException;

@Service
public class CouponsService {
	private final CouponsRepo couponsRepo;
	@Autowired
	public CouponsService(CouponsRepo couponsRepo) {
		this.couponsRepo=couponsRepo;
	}
	public Coupons add(Coupons coupons) {
		return couponsRepo.save(coupons);
	}
	public List<Coupons> findAll(){
		return couponsRepo.findAll();
	}
	public Coupons update(Coupons coupons){
		return couponsRepo.save(coupons);
	}
	public void delete(Long id){
		couponsRepo.deleteById(id);
	}
	public Coupons findByName(String name) {
		return couponsRepo.findByName(name).orElseThrow(()->new UserNotFoundException("User by id not found"));
	}
	
	public Coupons findById(Long id) {
		// TODO Auto-generated method stub
		return couponsRepo.findById(id).orElseThrow(()->new UserNotFoundException("User by id not found"));
	}
	
}
