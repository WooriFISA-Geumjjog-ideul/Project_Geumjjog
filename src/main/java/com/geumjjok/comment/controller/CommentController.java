package com.geumjjok.comment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geumjjok.comment.model.CommentDTO;
import com.geumjjok.comment.model.entity.Comment;
import com.geumjjok.comment.model.service.CommentService;
import com.geumjjok.post.exception.PostNotFoundException;
import com.geumjjok.post.model.PostDTO;

@RequestMapping("/comment")
@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;

	// 댓글 조회
	@GetMapping("/list/{postId}")
	public List<CommentDTO> commentList(@PathVariable int postId) {
		System.out.println("commentList");
		return commentService.findCommentList(postId);
	}

	// 댓글 등록
	@PostMapping("{postId}")
	public CommentDTO commentAdd(@PathVariable int postId, @RequestBody CommentDTO commentDTO) {
		System.out.println("commentAdd");
		return commentService.addComment(postId,commentDTO);
	}

}
