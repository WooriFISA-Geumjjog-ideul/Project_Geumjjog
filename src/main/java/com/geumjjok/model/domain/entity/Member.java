package com.geumjjok.model.domain.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

	@NonNull
	@Column(name = "created_at")
	private String createdAt;

	@Column(name = "updated_at")
	private String updatedAt;

	@Column(name = "is_deleted", columnDefinition = "boolean default false")
	private boolean isDeleted;

	@OneToMany(mappedBy = "memberId")
	private List<Post> posts = new ArrayList<>();

	@OneToMany(mappedBy = "memberId")
	private List<Comment> comments = new ArrayList<>();

	@OneToMany(mappedBy = "memberId")
	private List<PostLike> likes = new ArrayList<>();

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
