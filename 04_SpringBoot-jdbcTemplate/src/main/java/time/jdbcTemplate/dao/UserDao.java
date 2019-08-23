package time.jdbcTemplate.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import time.jdbcTemplate.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Time
 * @created 2019/8/23
 */
@Repository
public class UserDao {
    // 将jdbc模板注入，这里的数据源已经有springboot设置完成，直接注入即可使用
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User getUser(int id){
        User user  = jdbcTemplate.queryForObject("select * from user where uid = ?",new UserRowMapper(),id);
        return user;
    }

    // 继承rowMapper 重新封装数据到User中
    class UserRowMapper implements RowMapper<User>{
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setUid(resultSet.getInt("uid"));
            user.setName(resultSet.getString("name"));
            user.setAge(resultSet.getInt("age"));
            return user;
        }
    }
}
