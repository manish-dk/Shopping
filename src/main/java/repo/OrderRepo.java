package repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Orders;

@Repository
public interface OrderRepo extends JpaRepository<Orders,Long> {
	public List<Orders> findByDate(String date);

}
