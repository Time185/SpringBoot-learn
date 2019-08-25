package time.SpringbootThymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Time
 * @created 2019/8/25
 */
@Controller
public class HelloController {
    @RequestMapping("/index")
    public String index(){
        System.out.println("访问成功");
        return "index";
    }
}
