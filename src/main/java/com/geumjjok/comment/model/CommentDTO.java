package com.geumjjok.comment.model;

import com.geumjjok.comment.model.entity.Comment;
import com.geumjjok.member.model.entity.Member;
import com.geumjjok.post.model.entity.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CommentDTO {

	private int commentId;

	private String memberName;

	private int postId;

	private String content;

	private String createdAt;

	private String updatedAt;

	private boolean isDeleted;

	public Comment toEntity(Member member, Post post) {
		return Comment.builder().memberId(member).postId(post).content(this.content).build();
	}

}
