package time.SpringBootConfig.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Time
 * @created 2019/8/22
 * 通过配置文件将提前设置好的键值对注入到bean中
 */
@Component

public class Person {
    @Value("${time.name}")
    private String name;
    @Value("${time.gender}")
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
