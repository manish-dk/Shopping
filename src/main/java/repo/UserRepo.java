package repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
	public User findByName(String name); 

}
