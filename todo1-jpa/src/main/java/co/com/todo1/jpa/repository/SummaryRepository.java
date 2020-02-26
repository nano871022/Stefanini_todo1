package co.com.todo1.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.com.todo1.jpa.jpa.ProductJPA;
import co.com.todo1.jpa.jpa.SummaryJPA;
@Repository
public interface SummaryRepository extends JpaRepository<SummaryJPA, String> {

	@Query("select u from SummaryJPA u where u.product = ?1")
	public SummaryJPA findByProduct(ProductJPA product);
}
