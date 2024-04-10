package repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	
	//CRUD Operations
	Optional<User> findByUserNameAndUserPassword(String user, String password);
	User findByUserMail(String userName);
	User findByUserName(String userName);
	
}
