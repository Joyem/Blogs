package com.example.demo.UserController;

import com.example.demo.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/admin/index",method = {RequestMethod.GET,RequestMethod.POST})
    public String adminindex(HttpServletRequest request, HttpSession session) {
        if(request.getParameter("login") == null || !Boolean.parseBoolean(request.getParameter("login"))){
            String error = "你还没有登陆，请登陆";
            session.setAttribute("error",error);
            return "blog/admin/login";
        }else{
            return "blog/admin/index";
        }
    }
    @RequestMapping(value = "/admin/comment",method = {RequestMethod.GET,RequestMethod.POST})
    public String admincomment(HttpServletRequest request, HttpSession session) {
        if(request.getParameter("login") == null || !Boolean.parseBoolean(request.getParameter("login"))){
            String error = "你还没有登陆，请登陆";
            session.setAttribute("error",error);
            return "blog/admin/login";
        }else{
            return "blog/admin/comment";
        }
    }
    @RequestMapping(value = "/admin/category",method = {RequestMethod.GET,RequestMethod.POST})
    public String admincategory(HttpServletRequest request, HttpSession session) {
        if(request.getParameter("login") == null || !Boolean.parseBoolean(request.getParameter("login"))){
            String error = "你还没有登陆，请登陆";
            session.setAttribute("error",error);
            return "blog/admin/login";
        }else{
            return "blog/admin/category";
        }
    }

    @RequestMapping(value = "/admin/article",method = {RequestMethod.GET,RequestMethod.POST})
    public String adminarticle(HttpServletRequest request, HttpSession session) {
        if(request.getParameter("login") == null || !Boolean.parseBoolean(request.getParameter("login"))){
            String error = "你还没有登陆，请登陆";
            session.setAttribute("error",error);
            return "blog/admin/login";
        }else{
            return "blog/admin/article";
        }
    }
    
    //登陆
    @RequestMapping(value = "/admin",method = {RequestMethod.GET,RequestMethod.POST})
    public String login(HttpServletRequest request, HttpSession session){
        boolean login = false;
        session.setAttribute("login",login);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //String error="";
        if(username == "" || password == ""){
            session.setAttribute("error","用户名和密码不能为空，请重新输入");
            return "blog/admin/login";
        }
        String error = userService.login(username,password);
        session.setAttribute("username",username);
        if(error == null || error == ""){
            session.setAttribute("error","用户名或密码错误，请重新登陆");
            return "blog/admin/login";
        }
        else{
            login = true;
            session.setAttribute("login",login);
            return "blog/admin/index";
        }

        //return "blog/admin/login";
    }
    //@RequestMapping("")
    public String regis(){
        return "register";
    }
    //注册
    @RequestMapping(value ="/registerpage",method = {RequestMethod.GET,RequestMethod.POST})
    public String register(HttpServletRequest request,HttpSession session){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        if(username == null){
            return "register";
        }
        if(!userService.check(username).equals(null))    {
            session.setAttribute("error","用户名已存在，请重新输入");
            return "register";
        }
        if(!password.equals(repassword)){
            session.setAttribute("error","密码输入不一致，请重新输入");
            return "register";
        }
        session.setAttribute("username",username);
         return "index";

    }


}
