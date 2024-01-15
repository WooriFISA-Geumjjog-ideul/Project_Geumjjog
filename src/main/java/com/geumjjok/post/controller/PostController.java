package com.geumjjok.post.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geumjjok.post.exception.PostNotFoundException;
import com.geumjjok.post.model.PostDTO;
import com.geumjjok.post.model.PostRequestDTO;
import com.geumjjok.post.model.service.PostService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "/post", description = "게시글 API")
@RequestMapping("/post")
@RestController
public class PostController {

	@Autowired
	private PostService postService;

	@GetMapping("/list") // 게시글 목록 조회
	public List<PostDTO> postList() {
		return postService.findPostList();
	}

	@GetMapping("/detail/{postId}") // 게시글 상세 조회
	public ResponseEntity<?> postDetails(@PathVariable int postId) {
		System.out.println("postDetails");
		try {
			PostDTO postDTO = postService.findPostDetails(postId);
			return ResponseEntity.ok(postDTO);
		} catch (PostNotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@PostMapping() // 게시글 등록
	public PostDTO postAdd(@RequestBody PostRequestDTO postRequestDTO) {
		System.out.println("postAdd");
		return postService.addPost(postRequestDTO);
	}

	@DeleteMapping("{postId}") // 게시글 삭제
	public String postRemove(@PathVariable int postId) {
		System.out.println("postRemove");
		try {
			postService.removePost(postId);
			return "게시글 삭제 성공";
		} catch (PostNotFoundException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	@PutMapping("{postId}") // 게시글 수정
	public String postModify(@PathVariable int postId, @RequestBody PostRequestDTO postRequestDTO) {
		System.out.println("postModify");
		try {
			postService.modifyPost(postId, postRequestDTO);
			return "게시글 수정 성공";
		} catch (PostNotFoundException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

}
