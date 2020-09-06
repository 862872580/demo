package valication.handlers;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import valication.beans.Student;

import javax.validation.Valid;

@Controller //表示当前类是一个处理器
@RequestMapping("/test")  //命名空间
public class MyController{

    @RequestMapping("/register.do")
    public ModelAndView doRegister(@Valid Student student, BindingResult br){

        ModelAndView mv = new ModelAndView();
        mv.addObject("student", student);
        mv.setViewName("/WEB-INF/jsp/welcome.jsp");

        int errorCount = br.getErrorCount();
        if(errorCount > 0){
            FieldError nameError = br.getFieldError("name");
            FieldError scoreError = br.getFieldError("score");
            FieldError mobileError = br.getFieldError("mobile");

            if(nameError != null){
                String nameErrorMSG = nameError.getDefaultMessage();
                mv.addObject("nameErrorMSG", nameErrorMSG);
            }
            if(scoreError != null){
                String scoreErrorMSG = scoreError.getDefaultMessage();
                mv.addObject("scoreErrorMSG", scoreErrorMSG);
            }
            if(mobileError != null){
                String mobileErrorMSG = mobileError.getDefaultMessage();
                mv.addObject("mobileErrorMSG", mobileErrorMSG);
                mv.setViewName("/index.jsp");
            }
        }

        return mv;
    }

}
