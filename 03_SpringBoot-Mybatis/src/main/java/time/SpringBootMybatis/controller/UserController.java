package time.SpringBootMybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import time.SpringBootMybatis.service.UserService;

/**
 * @author Time
 * @created 2019/8/22
 *
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("getUser/{uid}")
    @ResponseBody
    public String getUser(@PathVariable int uid){
        return userService.getUser(uid).toString();
    }

}
