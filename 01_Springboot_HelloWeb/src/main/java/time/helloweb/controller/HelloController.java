package time.helloweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Time
 * @created 2019/8/21
 */
@Controller
public class HelloController {
    // 通常返回值为跳转的路径，加上@ResponseBody后，直接将返回的内容写入响应体中，可在页面直接显示出来，
    // 这一注释在异步获取json非常有用，会直接返回json数据
    @RequestMapping("/")
    @ResponseBody
    public String hello(){
        return "hello springboot!";
    }
}
