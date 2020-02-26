package co.com.todo1.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.com.todo1.jpa.jpa.ProductJPA;

@Repository
public interface ProductRepository extends JpaRepository<ProductJPA, String> {
	
	@Query("select u from ProductJPA u where u.reference = ?1")
	public ProductJPA findByReference(String reference);
}
