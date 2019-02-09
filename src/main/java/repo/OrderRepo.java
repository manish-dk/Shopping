package repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order,Long> {
	public List<Order> findbyId(Long id);

}
