package com.gcit.training.hibernatejpaapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gcit.training.hibernatejpaapp.entity.Author;

@Repository
public interface AuthorDao extends JpaRepository<Author, Integer> {

}
