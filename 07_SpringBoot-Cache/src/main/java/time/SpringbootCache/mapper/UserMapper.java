package time.SpringbootCache.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import time.SpringbootCache.entity.User;

/**
 * @author Time
 * @created 2019/8/25
 */
@Mapper
public interface UserMapper {

    @Select("select * from user where uid = #{uid}")
    public User getUser(int uid);

    @Update("update user set name = #{name}, age = #{age} where uid = #{uid}")
    void updateUser(User user);
    @Insert("insert into user(name,age) values(#{name},#{age})")
    void insertUser(User user);
    @Delete("delete from user where uid = #{uid}")
    void deleteUser(int uid);
}
