package time.SpringbootCache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import time.SpringbootCache.entity.User;
import time.SpringbootCache.mapper.UserMapper;

/**
 * @author Time
 * @created 2019/8/25
 */
/**
 * 注解@Cacheble：将方法的运行结果进行缓存，如果在查询相同的数据，则直接从缓存中获取,
 * CacheManager管理多个Cache组件，对缓存真的CRUD的操作在cache组件中，每一个缓存组件有自己唯一的名字
 *          属性：
 *              cacheNames/value: 缓存组件的名字
 *              key: 缓存组件中存储数据使用的key，默认是使用方法参数的值，也可用spel表达式
 *              keyGenerator:key的生成器，可以自己指定key的生成器的组件
 *              cacheManager:指定缓存管理器  如： condition = "#id>0" 即请求参数大于0才进行缓存
 *              condition:符合指定添加才缓存
 *              unless: 不满足某一个条件
 *              sysn: 是否异步，默认是同步，将方法返回的结果以同步的方式存到缓存中，设置成异步时，不再支持unless属性
 *
 *   注解@CachePut:即调用方法，又跟新缓存数据，如修改了每个数据库的数据，同时跟新缓存
 *              运行时机：1、先调用目标方法   2、将目标方法的结果存储起来
 *
 *   注解@CacheEvict:清除缓存，当删除了一个数据表时，可能缓存中还存在，加上该注解删除掉缓存中的数据
 *              CacheNames:删除指定缓存组件的名字
 *              key: 删除指定缓存组件中为key的元素
 *              allEntities:删除缓存组件中所有的数据
 *              beforeInvocation: 缓存的清除在方法执行之前执行，默认为方法执行之后
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Cacheable(cacheNames = "user",key = "#uid")
    public User getUser(int uid){
       User user = userMapper.getUser(uid);
        return user;
    }
    @CachePut(cacheNames = "user",key = "#user.uid")
    public User updateUser(User user){
        userMapper.updateUser(user);
        return user;
    }

    public void insertUser(User user){
        userMapper.insertUser(user);
    }
    @CacheEvict(cacheNames = "user",key = "#uid")
    public void deleteUser(int uid){
        userMapper.deleteUser(uid);
    }
}
