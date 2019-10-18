package com.gcit.training.hibernatejpaapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gcit.training.hibernatejpaapp.entity.Publisher;

@Repository
public interface PublisherDao extends JpaRepository<Publisher, Integer> {

}
