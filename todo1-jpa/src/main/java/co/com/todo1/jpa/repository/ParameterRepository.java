package co.com.todo1.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.com.todo1.jpa.jpa.ParameterJPA;

@Repository
public interface ParameterRepository extends JpaRepository<ParameterJPA, String>{

	@Query("select u from ParameterJPA u where u.state = 1 and u.group = 'typemovement' ")
	public ParameterJPA findTypeMovementActive();
	
	

	@Query("select u from ParameterJPA u where u.state = 1 and u.group = 'percentagesale' and u.description = ?1")
	public ParameterJPA findPorcVentaProductActive(String reference);
	
	@Query("select u from ParameterJPA u where u.name = ?1")
	public ParameterJPA findByName(String name);
	
	@Query("select u from ParameterJPA u where u.group = ?1")
	public List<ParameterJPA> findByGroup(String group);
	
	
}
