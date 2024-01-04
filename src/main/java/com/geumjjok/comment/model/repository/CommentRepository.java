package com.geumjjok.comment.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geumjjok.comment.model.entity.Comment;
import com.geumjjok.post.model.entity.Post;

@Repository

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByPostId(Post post);
}
