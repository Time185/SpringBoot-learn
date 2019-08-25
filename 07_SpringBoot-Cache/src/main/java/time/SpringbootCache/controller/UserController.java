package time.SpringbootCache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import time.SpringbootCache.entity.User;
import time.SpringbootCache.mapper.UserMapper;
import time.SpringbootCache.service.UserService;

/**
 * @author Time
 * @created 2019/8/25
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;
    // 查询用户
    @RequestMapping("getUser/{uid}")
    @ResponseBody
    public String getUser(@PathVariable int uid){
        User user = userService.getUser(uid);
        System.out.println("uid = " + uid);
        return user.toString();
    }

    // 修改用户
    @RequestMapping("updateUser")
    @ResponseBody
    public String updateUser(User user){
        userService.updateUser(user);

        return "修改用户成功";
    }


    // 添加用户
    @RequestMapping("insertUser")
    @ResponseBody
    public String insertUser(User user){
        userService.insertUser(user);
        return "插入数据成功";
    }

    // 删除用户
    @RequestMapping("deleteUser/{uid}")
    @ResponseBody
    public String deleteUser(@PathVariable int uid){
        userService.deleteUser(uid);
        return "删除数据成功";
    }
}
