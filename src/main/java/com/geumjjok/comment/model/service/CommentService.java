package com.geumjjok.comment.model.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geumjjok.comment.model.CommentDTO;
import com.geumjjok.comment.model.entity.Comment;
import com.geumjjok.comment.model.repository.CommentRepository;
import com.geumjjok.member.model.entity.Member;
import com.geumjjok.member.model.repository.MemberRepository;
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
				.postId(comment.getPostId().getPostId()).memberNickname(comment.getMemberId().getNickName())
				.createdAt(comment.getCreatedAtAsString()).build();
	}

	// ~1.3 기존 코드
//	public List<CommentDTO> findCommentList(int postId) {
//		List<Comment> comments = commmentRepository.findAll();
//		return comments.stream().map(this::convertToDto).collect(Collectors.toList());
//	}

	// 특정 게시판 댓글 조회하는 기능
	/*
	 * Optional<Post> optionalPost = postRepository.findById(postId);:
	 * postRepository를 사용하여 주어진 postId에 해당하는 게시물을 조회합니다.
	 * 
	 * Optional을 사용하여 조회한 결과를 감싸서 null인 경우에 대한 안전성을 확보합니다. Post post =
	 * optionalPost.orElse(null);: optionalPost에서 게시물을 꺼내오는데, 만약 게시물이 존재하지 않으면 null을
	 * 반환합니다.
	 * 
	 * if (post != null) { ... } else { ... }: post가 null이 아닌 경우, 즉 게시물이 존재하는 경우에
	 * 댓글을 조회하고 DTO로 변환합니다. 게시물이 존재하지 않는 경우, 빈 리스트를 반환합니다. Collections.emptyList()는
	 * 빈 리스트를 생성하는 메소드로, 댓글이 없을 때 빈 리스트를 반환하여 null 등을 피하고자 사용됩니다. return
	 * comments.stream().map(this::convertToDto).collect(Collectors.toList());: 조회한
	 * 댓글 목록을 stream으로 변환하고, 각 댓글을 DTO로 변환한 후, 리스트로 모아 반환합니다. 마지막으로
	 * Collections.emptyList(): 게시물이 존재하지 않는 경우에 해당하는 처리로 빈 리스트를 반환합니다. 이를 통해
	 * 클라이언트에서 댓글 목록이 없음을 확인할 수 있습니다.
	 * 
	 */
	public List<CommentDTO> findCommentList(int postId) {
		Optional<Post> optionalPost = postRepository.findById(postId);
		Post post = optionalPost.orElse(null);

		if (post != null) {
			List<Comment> comments = commmentRepository.findByPostId(post);
			return comments.stream().map(this::convertToDto).collect(Collectors.toList());
		} else {
			// postId에 해당하는 게시물이 없는 경우에 대한 처리를 추가할 수 있습니다.
			return Collections.emptyList(); // 또는 null을 리턴하거나 예외를 던지는 등의 방식으로 처리 가능
		}
	}

	// 댓글 추가
	public CommentDTO addComment(int postId, CommentDTO commentDTO) {
		Optional<Post> optionalPost = postRepository.findById(postId); // 게시물 1번
		Post post = optionalPost.orElse(null);

		Optional<Member> optionalMember = memberRepository.findById(1); // @FIXME - to get memberId from session
		Member member = optionalMember.orElse(null);

		return convertToDto(commmentRepository.save(commentDTO.toEntity(member, post)));

	}

}