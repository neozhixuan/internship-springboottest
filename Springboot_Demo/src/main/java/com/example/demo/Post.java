package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.NotNull;

@Table(name="Post")
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Post implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String body;

    Post(){}

    Post(String title, String body){
        this.title = title;
        this.body = body;
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getBody(){
        return body;
    }

    public void setBody(String body){
        this.body = body;
    }

    // @Override
    // public String toString() {
    //     return "Value{" +
    //         "id=" + id +
    //         ", title='" + title + '\'' +
    //         '}';
    // }
}