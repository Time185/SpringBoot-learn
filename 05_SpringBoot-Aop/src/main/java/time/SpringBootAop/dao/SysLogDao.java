package time.SpringBootAop.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Time
 * @created 2019/8/25
 */
public class SysLogDao {
    @Autowired
    JdbcTemplate jdbcTemplate;


}
