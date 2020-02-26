package co.com.todo1.todo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.todo1.todo1.jpa.ParameterJPA;

@Repository
public interface ParameterRepository extends JpaRepository<ParameterJPA, String>{

}
