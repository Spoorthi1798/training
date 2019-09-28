package calculaor;

import javax.servlet.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller  
public class Calculator 
{  
    @RequestMapping("/hello")  
    public ModelAndView calculator(HttpServletRequest req,HttpServletResponse res)
    {  
        int a=Integer.parseInt(req.getParameter("a"));
        int b=Integer.parseInt(req.getParameter("b"));       
        String c=req.getParameter("cal");
       if(c.equals("ADD"))
        {  
    	int add=a+b;
        String message = "result is"+add;  
        return new ModelAndView("result", "message", message);  
        }  
        else if(c.equals("SUB"))
        {  
    	int sub=a-b;
        String message = "result is"+sub;  
        return new ModelAndView("result", "message", message);  
        }  
        else if(c.equals("MUL"))
        {  
    	int mul=a*b;
        String message = "result is"+mul;  
        return new ModelAndView("result", "message", message);  
        }  
        else if(c.equals("DIV"))
        {  
    	int div=a/b;
        String message = "result is"+div;  
        return new ModelAndView("result", "message", message);  
        }  
        else {
        	return null;
        }
    }
}





