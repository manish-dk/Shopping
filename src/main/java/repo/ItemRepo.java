package repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item,Long> {
	public List<Item> findByName(String name); 
	
}
