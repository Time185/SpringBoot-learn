package time.SpringBootMybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import time.SpringBootMybatis.entity.User;

/**
 * @author Time
 * @created 2019/8/22
 * 直接使用注解的方式：
 *          比较简便，无需xml文件，在接口中的方法上写相应的sql语句即可完成
 */
@Mapper
public interface UserMapper {
    @Select("select * from user where uid = #{uid}")
    User getUser(int uid);
}
