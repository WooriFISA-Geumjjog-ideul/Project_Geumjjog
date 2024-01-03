package com.geumjjok.like.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geumjjok.like.model.service.LikeService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "/like", description = "좋아요 API")
@RequestMapping("/like")
@RestController
public class LikeController {
	
	@Autowired
	private LikeService likeService;
	
	@PostMapping("{postId}")
	public String likeAdd(@PathVariable int postId) {
		System.out.println("likeAdd");
		return null;
	}

	@PutMapping("{postId}")
	public String likeModify(@PathVariable int postId) {
		System.out.println("likeModify");
		return null;
	}
}
