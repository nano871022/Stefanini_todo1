package co.com.todo1.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.com.todo1.jpa.jpa.UserJPA;

@Repository
public interface UserRepository extends JpaRepository<UserJPA, String>{

	@Query("select u from UserJPA u where u.name = ?1 and u.password = ?2")
	public UserJPA finLoggin(String user,String password);
}
