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

import model.Order;
import repo.OrderRepo;

@RestController
@RequestMapping("/api")
public class OrderController {
	
	@Autowired
	OrderRepo orderRepo;
	
	@PostMapping("/order")
	public Order createOrder(@RequestBody Order order) {
		orderRepo.save(order);
		return order;
	}
	
	@GetMapping("/order")
	public List<Order> getOrders() {
		return orderRepo.findAll();
	}
	
	@PutMapping("/order/{id}")
	public Order updateOrder(@PathVariable long id,@RequestBody Order order) {
		for(Order o:orderRepo.findAll()) {
			if(o.getOrderId()==order.getOrderId()) {
				orderRepo.save(order);
			}
		}
		return order;
	}
	
	@DeleteMapping("/order/{id}")
	public Order deleteOrder(@PathVariable long id, Order order) {
		orderRepo.delete(order);
		return order;
	}

}
