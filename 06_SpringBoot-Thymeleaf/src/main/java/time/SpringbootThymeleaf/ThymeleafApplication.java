package time.SpringbootThymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot 使用thymeleaf 模板引擎
 *         （1）springboot 默认不支持jsp  ,推荐使用thymeleaf 模板
 *         （2） 添加Thymeleaf starter ,将相应的页面放在类路径下的templates文件夹下，即可使用
 */
@SpringBootApplication
public class ThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThymeleafApplication.class, args);
    }

}
