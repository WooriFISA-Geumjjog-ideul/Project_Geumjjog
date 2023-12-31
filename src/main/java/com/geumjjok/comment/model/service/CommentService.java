package com.geumjjok.comment.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geumjjok.comment.model.repository.CommentRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commmentRepository;
	
	public String findCommentList(int postId) {
		return "";
	}
	
	public String addComment(int postId) {
		return "";
	}
}