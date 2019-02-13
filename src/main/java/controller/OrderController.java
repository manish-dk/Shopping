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

import model.Item;
import model.Orders;
import model.OrdersItems;
import repo.ItemRepo;
import repo.OrderItemRepo;
import repo.OrderRepo;

@RestController
@RequestMapping("/api")
public class OrderController {
	
	@Autowired
	OrderRepo orderRepo;
	
	@Autowired
	ItemRepo itemRepo;
	
	@Autowired
	OrderItemRepo orderItemRepo;
	
	@PostMapping("/order")
	public Orders createOrder(@RequestBody Orders order) {
		
		orderRepo.save(order);
		return order;
	}
	
	@GetMapping("/order")
	public List<Orders> getOrders() {
		return orderRepo.findAll();
	}
	
//	@PutMapping("/order/{id}/{itemId}")
//	public Orders updateOrder(@PathVariable long id,@PathVariable long itemId,@RequestBody Orders order) {
//		for(Orders o:orderRepo.findAll()) {
//			if(o.getOrderId()==id) {
//				for(Item i:itemRepo.findAll()) {
//					if(i.getItemId()==itemId) {
//						o.addItem(i);
//					}
//				}
//				orderRepo.save(o);
//			}
//		}
//		return order;
//	}
	
	@PostMapping("/order/{id}/{itemId}/{qty}")
	public String updateOrder(@PathVariable long id,@PathVariable long itemId,@PathVariable int qty) {
		for(Orders o:orderRepo.findAll()) {
			if(o.getOrderId()==id) {
				for(Item i:itemRepo.findAll()) {
					if(i.getItemId()==itemId) {
						for(OrdersItems io:orderItemRepo.findAll()) {
							if(io.getItem()==i && io.getOrder()==o) {
								io.setQuantity(io.getQuantity()+qty);
								orderItemRepo.save(io);
								return "Order Updated";
							}
						}
						OrdersItems io = new OrdersItems(o,i,qty);
						orderItemRepo.save(io);
						return "Success";
					}
				}
			}
		}
		return "Fail";
	}
	
	@DeleteMapping("/order/{id}")
	public Orders deleteOrder(@PathVariable long id, Orders order) {
		orderRepo.delete(order);
		return order;
	}

}
