package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Orders;
import repo.OrderRepo;

@RestController
@RequestMapping("/api")
public class OrderController {
	
	@Autowired
	OrderRepo orderRepo;
	
	@PostMapping("/order")
	public Orders createOrder(@RequestBody Orders order) {
		orderRepo.save(order);
		return order;
	}
	
	@GetMapping("/order")
	public List<Orders> getOrders() {
		return orderRepo.findAll();
	}
	
	@PutMapping("/order/{id}")
	public Orders updateOrder(@PathVariable long id,@RequestBody Orders order) {
		for(Orders o:orderRepo.findAll()) {
			if(o.getOrderId()==order.getOrderId()) {
				orderRepo.save(order);
			}
		}
		return order;
	}
	
	@DeleteMapping("/order/{id}")
	public Orders deleteOrder(@PathVariable long id, Orders order) {
		orderRepo.delete(order);
		return order;
	}

}
