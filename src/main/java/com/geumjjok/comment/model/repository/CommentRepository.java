package com.geumjjok.comment.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geumjjok.comment.model.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{
	

}
