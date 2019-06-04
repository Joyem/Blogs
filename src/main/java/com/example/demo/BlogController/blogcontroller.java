package com.example.demo.BlogController;

import com.example.demo.Blog.blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.demo.BlogService.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Controller
public class blogcontroller {
    @Autowired
    public blogservice blogservice;


    public String getcategorylist(HttpServletRequest request,HttpSession session){
        String category = request.getParameter("category");
        List<blog> categorylist = blogservice.getcategorylist(category);
        session.setAttribute("categorylist",categorylist);
        return "blog/blog";
    }

    @RequestMapping(value={"/index","/"},method = {RequestMethod.GET,RequestMethod.POST})
    public String getlatest3blog(HttpServletRequest request, HttpSession session){
        List<blog> list = blogservice.getlatest3blog();
        session.setAttribute("list",list);

        System.out.println(list.get(0).getBrief());
        return "blog/index";
    }
    @RequestMapping(value = "/blogs",method = {RequestMethod.GET,RequestMethod.POST})
    public String getblogs(HttpServletRequest request,HttpSession session){
        String category = request.getParameter("category") == null?"":request.getParameter("category");
        List<blog> categorylist = null;
        if(category.equals("") || category == null){
            category = "All Blogs";
            categorylist = blogservice.getblogs();
        }else {
            categorylist = blogservice.getcategorylist(category);
        }
        session.setAttribute("category",category);
        List<String> categorys = blogservice.getcategory();
        session.setAttribute("categorys",categorys);

        session.setAttribute("categorylist",categorylist);

        return "blog/blog";
    }

    @RequestMapping(value = "/blog",method = {RequestMethod.GET,RequestMethod.POST})
    public String getblog(HttpServletRequest request,HttpSession session){
        System.out.println("blog-id:"+request.getParameter("blogid"));
        int id =  Integer.parseInt(request.getParameter("blogid").toString());
        blog blog = blogservice.getblog(id);
        session.setAttribute("blog",blog);
        System.out.println("正在浏览的博客："+blog.getTitle());
        return "blog/single-post";
    }
}
