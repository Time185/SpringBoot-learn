package time.SpringbootCache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 使用缓存
 * 步骤：
 *      1. 开启基于注解的缓存 @EnableCaching
 *      2. 标注缓存注解即可
 *            @Cacheable
 *            @CachePut
 *            @CacheEvict
 *
 */
@EnableCaching
@SpringBootApplication
public class CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheApplication.class, args);
    }

}
