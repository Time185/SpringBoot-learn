package time.jdbcTemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import time.jdbcTemplate.dao.UserDao;

/**
 * @author Time
 * @created 2019/8/23
 */
@Controller
public class UserController {
    @Autowired
    UserDao userDao;

    @RequestMapping("getUser/{uid}")
    @ResponseBody
    public String getUser(@PathVariable int uid){
       return  userDao.getUser(uid).toString();
    }
}
