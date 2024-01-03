package com.geumjjok.post.model.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geumjjok.member.model.entity.Member;
import com.geumjjok.member.model.repository.MemberRepository;
import com.geumjjok.post.exception.PostNotFoundException;
import com.geumjjok.post.model.PostDTO;
import com.geumjjok.post.model.PostRequestDTO;
import com.geumjjok.post.model.entity.Post;
import com.geumjjok.post.model.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;

	@Autowired
	private MemberRepository memberRepository;

	private PostDTO convertToDto(Post post) {
		return PostDTO.builder().postId(post.getPostId()).title(post.getTitle()).content(post.getContent())
				.memberName(post.getMemberName(post.getMemberId())).createdAt(post.getCreatedAtAsString())
				.updatedAt(post.getUpdatedAtAsString()).isDeleted(post.isDeleted()).build();
	}

	public List<PostDTO> findPostList() {
		List<Post> posts = postRepository.findAll();
		return posts.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	public PostDTO findPostDetails(int postId) throws PostNotFoundException {
		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new PostNotFoundException("존재하지 않는 게시글 ID 입니다: " + postId));
		return convertToDto(post);
	}

	public PostDTO addPost(PostRequestDTO postRequestDTO) {
		Optional<Member> optionalMember = memberRepository.findById(1); // @FIXME - to get memberId from session
		Member member = optionalMember.orElse(null);
		return convertToDto(postRepository.save(postRequestDTO.toEntity(member)));
	}

	@Transactional
	public void removePost(int postId) throws PostNotFoundException {
		Post post = postRepository.findPostByPostIdAndIsDeletedIsFalse(postId)
				.orElseThrow(() -> new PostNotFoundException("존재하지 않는 게시글 ID 입니다: " + postId));
		System.out.println(post);
		post.updateIsDeleted();
	}

	public void modifyPost(int postId, PostRequestDTO postRequestDTO) throws PostNotFoundException {
		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new PostNotFoundException("존재하지 않는 게시글 ID 입니다: " + postId));
		post.setTitle(postRequestDTO.getTitle());
		post.setContent(postRequestDTO.getContent());
		postRepository.save(post);
	}
}
