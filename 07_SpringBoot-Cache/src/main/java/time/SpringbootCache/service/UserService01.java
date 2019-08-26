package time.SpringbootCache.service;

/**
 * 默认使用的缓存管理器是ConcurrentMapCacheManager，缓存是 ConcurrentMapCache:数据保存在ConcurrentMap的hashmap中。
 * 实际开发中，使用的是一些缓存中间件：redis、memcached、ehcache
 * @author Time
 * @created 2019/8/26
 *
 * 该类整合redis作为缓存中间件
 * Redis是一个开源的，内存中的数据结构存储系统，它可以用作数据库、缓存和消息中间件
 *  1、安装redis
 *  2、引入redis的starter
 *  3、配置redis，比较简单，在配置文件中指定redis的主机地址
 *          配置结束后，redis将会自动配置，并向容器中输入两个bean，其作用和JdbcTemplate作用相似
 *          (1) StringRedisTemplate
 *          (2) RedisTemplate
 *  4、测试缓存
 *          （1）引入redis的Starter时，容器中自动帮我们保存的是RedisCacheManager
 *          （2） RedisCacheManager帮我们创建RedisCache来作为缓存组件。RedisCache通过操作redis缓存数据
 *          （3） 默认保存数据 k --v都是object 利用序列化保存
 *          （4） 自定义CacheManager
 */
public class UserService01 {

}
