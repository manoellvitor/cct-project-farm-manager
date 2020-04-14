package ie.cct.farmmanager;

/*
 * @author: Manoel Vitor Nascimento Lopes
 * @college: CCT College Dublin
 * @studentID: 2019286
 * */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ie.cct.farmmanager*")
public class FarmManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmManagerApplication.class, args);
	}

}
