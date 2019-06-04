package com.example.demo.BlogDao;
import com.example.demo.Blog.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface blogdao {
    @Insert("insert into blog(title,brief,content)values(#{title},#{brief},#{content})")
    public boolean addblog(@Param("title")String title,@Param("brief") String brief, @Param("content") String content,@Param("pic") String pic);

    @Select("select * from blog where category=#{category}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "title",column = "title"),
            @Result(property = "brief",column = "brief"),
            @Result(property = "content",column = "content"),
            @Result(property = "time",column = "time"),
            @Result(property = "pic",column = "pic"),
            @Result(property = "watch",column = "watch"),
            @Result(property = "category",column = "category")
    })
    public List<blog> getcategorylist(String category);

    @Select("select distinct category from blog")
    @Results({
            @Result(property = "category",column = "category")
    })
    public List<String> getcategory();

    //public boolean deleteblog(@Param(""))
    @Select("select * from blog order by time desc limit 3")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "title",column = "title"),
            @Result(property = "brief",column = "brief"),
            @Result(property = "content",column = "content"),
            @Result(property = "time",column = "time"),
            @Result(property = "pic",column = "pic"),
            @Result(property = "watch",column = "watch"),
            @Result(property = "category",column = "category")
    })
    public List<blog> getlatest3blog();


    @Select("select * from blog")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "title",column = "title"),
            @Result(property = "brief",column = "brief"),
            @Result(property = "content",column = "content"),
            @Result(property = "time",column = "time"),
            @Result(property = "pic",column = "pic")
    })
    public List<blog> getblogs();

    @Select("select * from blog where id=#{id}")
    public blog getblog(@Param("id") int id);

}
