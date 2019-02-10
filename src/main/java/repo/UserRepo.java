package repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
	public List<User> findByEmail(String email); 

}
