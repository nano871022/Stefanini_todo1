package co.com.todo1.todo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import co.com.todo1.todo1.jpa.ProductUserJPA;
@Service
public interface ProductUserRepository extends JpaRepository<ProductUserJPA, String> {

}
