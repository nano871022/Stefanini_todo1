package co.com.todo1.kardex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"co.com.todo1.jpa.jpa"})
@EnableJpaRepositories(basePackages = {"co.com.todo1.jpa.repository","co.com.todo1.jpa.jpa"})
@SpringBootApplication(scanBasePackages={"co.com.todo1","co.com.todo1.jpa.repository","co.com.todo1.jpa.jpa"})
public class KardexApplication {

	public static void main(String[] args) {
		SpringApplication.run(KardexApplication.class, args);
	}

}
