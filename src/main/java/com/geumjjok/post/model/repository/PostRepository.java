package com.geumjjok.post.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geumjjok.post.model.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

}