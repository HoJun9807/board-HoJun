package idusw.springboot.boardHoJun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication  //(exclude = DataSourceAutoConfiguration.class)
@EnableJpaAuditing // JPA Auditing 을 활성화한다.
public class BoardHoJunApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardHoJunApplication.class, args);
    }

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {return new HiddenHttpMethodFilter();}
}
