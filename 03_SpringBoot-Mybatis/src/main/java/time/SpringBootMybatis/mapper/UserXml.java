package time.SpringBootMybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author Time
 * @created 2019/8/23
 * 采用xml的方式配置：
 *          配置比较繁琐，需要在类路径下配置：（1）Mybatis全局配置文件
 *                                            （2）类映射文件
 */
@Mapper
public interface UserXml {
    time.SpringBootMybatis.entity.User getUser(int uid);
}
