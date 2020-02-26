package co.com.todo1.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.todo1.jpa.jpa.ProductUserJPA;
@Repository
public interface ProductUserRepository extends CrudRepository<ProductUserJPA, String> {

}
