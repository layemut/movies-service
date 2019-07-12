package tr.com.layemut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        System.out.println("Test test!");
        SpringApplication.run(Application.class, args);
    }
}
