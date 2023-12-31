package com.geumjjok.comment.model.entity;

import com.geumjjok.member.model.entity.Member;
import com.geumjjok.post.model.entity.Post;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {
	@Id
	@Column(name = "comment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentId;

	@NonNull
	@Column(name = "content", columnDefinition = "TEXT", nullable = false)
	private String content;

	@NonNull
	@Column(name = "created_at")
	private String createdAt;

	@Column(name = "updated_at")
	private String updatedAt;

	@Column(name = "is_deleted", columnDefinition = "boolean default false")
	private boolean isDeleted;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id", nullable = false)
	private Post postId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id", nullable = false)
	private Member memberId;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Comment [commentId=");
		builder.append(commentId);
		builder.append(", content=");
		builder.append(content);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append(", updatedAt=");
		builder.append(updatedAt);
		builder.append(", isDeleted=");
		builder.append(isDeleted);
		builder.append("]");
		return builder.toString();
	}

}
