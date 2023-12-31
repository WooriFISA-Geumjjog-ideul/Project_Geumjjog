package com.geumjjok.post.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geumjjok.post.model.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
	
	public String findPostList() {
		return "";
	}
	
	public String findPostDetails(int postId) {
		return "";
	}

	public String addPost() {
		return "";
	}
	
	public String removePost() {
		return "";
	}
	
	public String modifyPost() {
		return "";
	}
}
