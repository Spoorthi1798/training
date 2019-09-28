package com.registration;

import java.sql.*;

import javax.servlet.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller  
public class register
{  
    @RequestMapping("/hello")  
    public ModelAndView register(HttpServletRequest req,HttpServletResponse res) throws Throwable
    { 
    	String a=  req.getParameter("no");
    	String b=  req.getParameter("name");
    	String c=  req.getParameter("sal");
    	String d=  req.getParameter("desg");
    	String e=  req.getParameter("submit");
    	
    		Class.forName("oracle.jdbc.driver.OracleDriver");
    		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456789");
    		
    	
    	if(e.equals("insert"))
    	{
    		PreparedStatement st= con.prepareStatement("insert into emp123 values(?,?,?,?)");
    		st.setString(1, a);
    		st.setString(2, b);
    		st.setString(3, c);
    		st.setString(4, d);
    		st.execute();
    		String message = "empno: "+a+" Name: "+ b+" salary: "+c+ " Designation: "+d;
    		 return new ModelAndView("insert", "message", message);  
    		
    	}
    	if(e.equals("update"))
    	{
    		PreparedStatement st= con.prepareStatement("update emp123 set name=?, salary=?,designation=? where empno=?");
    		st.setString(1, b);
    		st.setString(2, c);
    		st.setString(3,d);
    		st.setString(4, a);
    		st.execute();
    		String message = "empno: "+a+" Name: "+ b+" salary: "+c+ " Designation: "+d;
    		 return new ModelAndView("insert", "message", message);  
    		
    	}
    	if(e.equals("delete"))
    	{
    		PreparedStatement st= con.prepareStatement("delete from emp123 where empno=?");
    		st.setString(1, a);
    		st.execute();
    		String message = "EMpno: "+a+ "is deleted";
    		 return new ModelAndView("insert", "message", message);  
    		
    	}
    	if(e.equals("select"))
    	{
    		
    		String message = "employee details";
    		 return new ModelAndView("select", "message", message);  
    		
    	}
    	
    	else
    		return null;
    	
    
    	
    	
    }
    }