package time.SpringbootCache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import time.SpringbootCache.entity.User;
import time.SpringbootCache.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RedisTemplate redisTemplate; //  key - value 都是对象
    @Autowired
    StringRedisTemplate stringRedisTemplate; // key - value  都是字符串
    @Autowired
    RedisTemplate<Object, User> userRedisTemplate;  // 设置序列化器之后的template

    /**
     * redis可操作的数据类型：String  List  Set  Hash(散列)  ZSet
     *      stringRedisTemplate.opsForValue() 操作字符串
     *      stringRedisTemplate.opsForList() 操作列表
     *      stringRedisTemplate.opsForSet() 操作集合
     *      stringRedisTemplate.opsForHash() 操作散列
     *      stringRedisTemplate.opsForZSet() 操作有序集合
     *
     *  同理，redisTemplate也有如上的方法
     */
    @Test
    public void contextLoads() {
        // 给redis保存数据
        stringRedisTemplate.opsForValue().append("msg","hello");
        System.out.println(stringRedisTemplate.opsForValue().get("msg"));

    }

    // 测试保存对象，使用的是jdk的序列化器，生成一堆十六进行的文件，可以自己配置json的序列化器
    @Test
    public void test1(){
        User user = userMapper.getUser(7);
        userRedisTemplate.opsForValue().set("07user",user);
    }

}
