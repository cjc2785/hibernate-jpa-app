package com.gcit.training.hibernatejpaapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_author")
public class Author {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int authorId;

    @Column
    private  String authorName;
    
    
    public Author() { }

    public Author(Integer auth, String authName){
    	authorId = auth;
    	authorName = authName;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
