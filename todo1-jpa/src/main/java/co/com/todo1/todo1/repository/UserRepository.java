package co.com.todo1.todo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.todo1.todo1.jpa.UserJPA;

@Repository
public interface UserRepository extends JpaRepository<UserJPA, String>{

	public UserJPA findLoggin(UserJPA user);
}
