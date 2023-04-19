package idusw.springboot.boardlhj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  //(exclude = DataSourceAutoConfiguration.class)
public class BoardlhjApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardlhjApplication.class, args);
    }

}
