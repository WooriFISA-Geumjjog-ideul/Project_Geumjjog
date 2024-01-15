package com.geumjjok.post.model.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.geumjjok.comment.model.CommentDTO;
import com.geumjjok.comment.model.entity.Comment;
import com.geumjjok.post.model.PostDTO;
import com.geumjjok.post.model.entity.Post;

public class PostMapper {

	public static PostDTO toPostDTO(Post post) {
		if (post == null) {
			return null;
		}

		List<CommentDTO> commentDTOs = post.getComments().stream().map(PostMapper::toCommentDTO)
				.collect(Collectors.toList());

		return PostDTO.builder().postId(post.getPostId())
				.memberNickName(post.getMemberId() != null ? post.getMemberId().getNickName() : null).title(post.getTitle())
				.content(post.getContent()).comments(commentDTOs).createdAt(post.getCreatedAtAsString())
				.updatedAt(post.getUpdatedAtAsString()).isDeleted(post.isDeleted()).build();
	}

	private static CommentDTO toCommentDTO(Comment comment) {
		if (comment == null) {
			return null;
		}

		String memberNickName = comment.getMemberId() != null ? comment.getMemberId().getNickName() : null;
		int postId = comment.getPostId() != null ? comment.getPostId().getPostId() : null;

		return new CommentDTO(comment.getCommentId(), memberNickName, postId, comment.getContent(),
				comment.getCreatedAtAsString(), comment.getUpdatedAtAsString(), comment.isDeleted());
	}
}
