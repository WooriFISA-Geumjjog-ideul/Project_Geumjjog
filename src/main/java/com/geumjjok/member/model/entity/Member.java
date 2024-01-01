package com.geumjjok.member.model.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.geumjjok.comment.model.entity.Comment;
import com.geumjjok.like.model.entity.PostLike;
import com.geumjjok.post.model.entity.Post;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "member")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private int memberId;

	@NonNull
	@Column(length = 10, nullable = false)
	private String name;

	@NonNull
	@Column(name = "nick_name", length = 20, nullable = false)
	private String nickName;

	@NonNull
	@Column(nullable = false)
	private String password;

	@NonNull
	@Column(length = 50, nullable = false)
	private String email;

	@Column(name = "created_at")
	@CreatedDate
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	@LastModifiedDate
	private LocalDateTime updatedAt;

	@Column(name = "is_deleted", columnDefinition = "boolean default false")
	private boolean isDeleted;

	@OneToMany(mappedBy = "memberId")
	private List<Post> posts = new ArrayList<>();

	@OneToMany(mappedBy = "memberId")
	private List<Comment> comments = new ArrayList<>();

	@OneToMany(mappedBy = "memberId")
	private List<PostLike> likes = new ArrayList<>();

	@Builder
	public Member(int memberId, @NonNull String name, @NonNull String nickName, @NonNull String password,
			@NonNull String email, LocalDateTime createdAt, LocalDateTime updatedAt, boolean isDeleted,
			List<Post> posts, List<Comment> comments, List<PostLike> likes) {
		this.memberId = memberId;
		this.name = name;
		this.nickName = nickName;
		this.password = password;
		this.email = email;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.isDeleted = isDeleted;
		this.posts = posts;
		this.comments = comments;
		this.likes = likes;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Member [id=");
		builder.append(memberId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", nickName=");
		builder.append(nickName);
		builder.append(", password=");
		builder.append(password);
		builder.append(", email=");
		builder.append(email);
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
