package org.big;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.big.mapper")
public class APortfolioProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(APortfolioProjectApplication.class, args);
	}

}
