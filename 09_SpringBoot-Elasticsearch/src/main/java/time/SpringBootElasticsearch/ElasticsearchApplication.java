package time.SpringBootElasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Springboot默认支持三种技术来和ES交互
 *  1.Jest 默认不生效，需要导包
 *  2.SpringData
 *      （1）自动配置了： 节点信息 clusterNodes ; 集群名字clusterName
 *      （2）ElasticsearchTemplate 操作es
 *      （3）编写一个ElasticsearchRepository的子接口操作ES
 *
 *      // springData - elasticsearch需要版本匹配   不匹配会出现问题
 *  3.rest
 *
 */
@SpringBootApplication
public class ElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchApplication.class, args);
    }

}
