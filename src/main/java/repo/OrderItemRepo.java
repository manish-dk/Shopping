package repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.OrdersItems;

public interface OrderItemRepo extends JpaRepository<OrdersItems,Long> {


	public List<OrdersItems> findByQuantity(int quantity);
}
