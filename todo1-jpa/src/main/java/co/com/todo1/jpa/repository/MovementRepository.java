package co.com.todo1.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.com.todo1.jpa.jpa.MovementJPA;
import co.com.todo1.jpa.jpa.ProductJPA;

@Repository
public interface MovementRepository extends JpaRepository<MovementJPA, String>{

	@Query("select u from MovementJPA u where u.summary.product = ?1 ")
	public List<MovementJPA> findAllByProduct(ProductJPA jpa);
}
