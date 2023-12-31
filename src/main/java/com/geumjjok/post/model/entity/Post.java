package com.geumjjok.post.model.entity;

import java.util.ArrayList;
import java.util.List;

import com.geumjjok.comment.model.entity.Comment;
import com.geumjjok.like.model.entity.PostLike;
import com.geumjjok.member.model.entity.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "post")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private int postId;

	@NonNull
	@Column(nullable = false)
	private String title;

	@NonNull
	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;

	@NonNull
	@Column(name = "created_at")
	private String createdAt;

	@Column(name = "updated_at")
	private String updatedAt;

	@Column(name = "is_deleted", columnDefinition = "boolean default false")
	private boolean isDeleted;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id", nullable = false)
	private Member memberId;
	
	@OneToMany(mappedBy="postId")
	private List<Comment> comments = new ArrayList<>();

	@OneToMany(mappedBy="postId")
	private List<PostLike> likes = new ArrayList<>();
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Post [postId=");
		builder.append(postId);
		builder.append(", title=");
		builder.append(title);
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
