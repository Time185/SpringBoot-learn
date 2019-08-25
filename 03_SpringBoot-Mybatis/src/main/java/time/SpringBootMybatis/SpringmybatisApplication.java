package time.SpringBootMybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("time.SpringBootMybatis.mapper")
@SpringBootApplication
public class SpringmybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringmybatisApplication.class, args);
    }

}
