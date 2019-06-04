package com.example.demo.Blog;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Timestamp;
@Component
public class blog {
    private int id;
    private String title;
    private String brief;
    private String content;
    private Timestamp time;
    private String pic;
    private int watch;
    private String category;

    public int getWatch() {
        return watch;
    }

    public void setWatch(int watch) {
        this.watch = watch;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public blog(){}

    public blog(int id, String title, String brief, String content, Timestamp time, String pic,String category,int watch) {
        this.id = id;
        this.title = title;
        this.brief = brief;
        this.content = content;
        this.time = time;
        this.pic = pic;
        this.category = category;
        this.watch = watch;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }


    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }


}
