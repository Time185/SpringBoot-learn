package time.SpringBootMybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import time.SpringBootMybatis.entity.User;
import time.SpringBootMybatis.mapper.UserMapper;
import time.SpringBootMybatis.mapper.UserXml;

/**
 * @author Time
 * @created 2019/8/22
 */
@Service
public class UserService {
    @Autowired
    UserXml userXml;
    public User getUser(int id){
        return userXml.getUser(id);
    }
}
