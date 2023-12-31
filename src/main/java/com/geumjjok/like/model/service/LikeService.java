package com.geumjjok.like.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geumjjok.like.model.repository.LikeRepository;

@Service
public class LikeService {
	@Autowired
	private LikeRepository LikeRepository;
	
	public String addLike(int postId) {
		return "";
	}
	
	public String modifyLike(int postId) {
		return "";
	}
}
