package shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {
    @RequestMapping("index")
    @ResponseBody
    public String index(){
        return "success";
    }

    //跳转jsp并传递参数
    @RequestMapping("testThymeleaf")
    public String testThymeleaf(HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("name","张三");
        //返回test.jsp
        return "test";
    }
}
