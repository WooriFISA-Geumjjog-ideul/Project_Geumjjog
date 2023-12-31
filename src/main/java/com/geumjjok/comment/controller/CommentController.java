package com.geumjjok.comment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geumjjok.comment.model.entity.Comment;
import com.geumjjok.comment.model.service.CommentService;

@RequestMapping("/comment")
@RestController
public class CommentController {
	
	@Autowired
	private CommentService commentService;

	@GetMapping("/list/{postId}")
	public List<Comment> commentList(@PathVariable int postId) {
		System.out.println("commentList");
		return null;
	}

	@PostMapping("{postId}")
	public String commentAdd(@PathVariable int postId) {
		System.out.println("commentAdd");
		return null;
	}
}
