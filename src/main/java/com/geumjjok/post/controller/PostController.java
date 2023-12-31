package com.geumjjok.post.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geumjjok.post.model.entity.Post;
import com.geumjjok.post.model.service.PostService;

@RequestMapping("/post")
@RestController
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@GetMapping("/list")
	public List<Post> postList(@RequestParam String sort) {
		System.out.println("postList");
		return null;
	}

	@GetMapping("/detail/{postId}")
	public Post postDetails(@PathVariable int postId) {
		System.out.println("postDetails");
		return null;
	}

	@PostMapping() // 게시글 등록
	public String postAdd() {
		System.out.println("postAdd");
		return null;
	}

	@DeleteMapping("{postId}")
	public String postRemove(@PathVariable int postId) {
		System.out.println("postRemove");
		return null;
	}

	@PutMapping("{postId}")
	public String postModify(@PathVariable int postId) {
		System.out.println("postModify");
		return null;
	}

}
