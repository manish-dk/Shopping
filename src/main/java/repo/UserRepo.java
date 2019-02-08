package repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.User;

public interface UserRepo extends JpaRepository<User,Long> {
	public List<User> findByEmail(String email); 

}
