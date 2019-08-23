package time.SpringBootConfig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import time.SpringBootConfig.model.Person;

/**
 * @author Time
 * @created 2019/8/22
 */
@Controller
public class HelloController {
    @Autowired
    private Person person;

    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return person.getName() + "------------" + person.getGender();
    }
}
