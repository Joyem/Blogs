package com.example.demo.BlogService;
import com.example.demo.Blog.blog;
import com.example.demo.BlogDao.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.*;
import java.util.List;

@Component
public class blogservice {
    @Autowired
    public blogdao blogdao;

    public List<blog> getcategorylist(String category){
        return blogdao.getcategorylist(category);
    }

    public List<String> getcategory(){
        return blogdao.getcategory();
    }

    public boolean addblog(String title, String brief,  String content, String pic){
        return blogdao.addblog(title,brief,content,pic);
    }

    public List<blog> getblogs(){
        return blogdao.getblogs();
    }

    public List<blog> getlatest3blog(){
        return blogdao.getlatest3blog();
    }

    public blog getblog(int id){
        return blogdao.getblog(id);
    }
}
