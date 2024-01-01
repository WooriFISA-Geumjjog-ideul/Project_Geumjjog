package com.geumjjok.like.model.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.geumjjok.member.model.entity.Member;
import com.geumjjok.post.model.entity.Post;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "post_like")
public class PostLike {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "like_id")
	private int likeId;

	@Column(name = "created_at")
	@CreatedDate
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	@LastModifiedDate
	private LocalDateTime updatedAt;

	@Column(name = "is_deleted", columnDefinition = "boolean default false")
	private boolean isDeleted;
	
	@NonNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="post_id", nullable = false)
	private Post postId;

	@NonNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="member_id", nullable = false)
	private Member memberId;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Like [likeId=");
		builder.append(likeId);
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
