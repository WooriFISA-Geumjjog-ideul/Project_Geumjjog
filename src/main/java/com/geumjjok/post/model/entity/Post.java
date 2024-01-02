package com.geumjjok.post.model.entity;

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
import com.geumjjok.member.model.entity.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
@Getter
@DynamicUpdate
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private int postId;

	@NonNull
	@Column(length = 50, nullable = false)
	private String title;

	@NonNull
	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;

	@Column(name = "created_at")
	@CreatedDate
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	@LastModifiedDate
	private LocalDateTime updatedAt;

	@Column(name = "is_deleted", columnDefinition = "boolean default false")
	private boolean isDeleted;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id", nullable = false)
	private Member memberId;

	@OneToMany(mappedBy = "postId")
	private List<Comment> comments = new ArrayList<>();

	@OneToMany(mappedBy = "postId")
	private List<PostLike> likes = new ArrayList<>();

	@Builder
	public Post(@NonNull String title, @NonNull String content, Member memberId) {
		this.title = title;
		this.content = content;
		this.memberId = memberId;
	}
	
	public void updateIsDeleted() {
		this.isDeleted = true;
	}

	public String getCreatedAtAsString() {
		return formatDateTime(this.createdAt);
	}

	public String getUpdatedAtAsString() {
		return formatDateTime(this.updatedAt);
	}

	public String getMemberName(Member member) {
		return member != null ? member.getName() : null;
	}

	private String formatDateTime(LocalDateTime dateTime) {
		if (dateTime == null) {
			return null;
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return dateTime.format(formatter);
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

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
