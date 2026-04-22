package com.myapp.cms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Blog {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String content;
    private String author;

    public void setName(String name){
        this.name = name;
    }

    public void setContent(String content){
        this.content = content;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getName(){
        return  this.name;
    }

     public String getContent(){
        return  this.content;
    }

     public String getAuthor(){
        return  this.author;
    }
}
