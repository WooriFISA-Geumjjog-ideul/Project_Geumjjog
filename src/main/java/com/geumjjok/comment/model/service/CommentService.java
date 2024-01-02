package com.geumjjok.comment.model.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.geumjjok.comment.model.CommentDTO;
import com.geumjjok.comment.model.entity.Comment;
import com.geumjjok.comment.model.repository.CommentRepository;
import com.geumjjok.member.model.entity.Member;
import com.geumjjok.member.model.repository.MemberRepository;
import com.geumjjok.post.model.PostDTO;
import com.geumjjok.post.model.entity.Post;
import com.geumjjok.post.model.repository.PostRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commmentRepository;
	
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	private CommentDTO convertToDto(Comment comment) {
		return CommentDTO.builder().commentId(comment.getCommentId()).content(comment.getContent())
				.createdAt(comment.getCreatedAtAsString()).build();
	}
	
	
	public List<CommentDTO> findCommentList(int postId) {
		List<Comment> comments = commmentRepository.findAll();
		return comments.stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	
	//댓글 추가 
	public CommentDTO addComment(int postId, CommentDTO commentDTO) {
		Optional <Post> optionalPost = postRepository.findById(postId); //게시물 1번
		Post post = optionalPost.orElse(null);
		
		Optional<Member> optionalMember = memberRepository.findById(1); // @FIXME - to get memberId from session
		Member member = optionalMember.orElse(null);
		
		return convertToDto(commmentRepository.save(commentDTO.toEntity(member,post)));
		
	}
	
}