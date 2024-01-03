package com.geumjjok.post.model;

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
public class PostDTO {
	private int postId;

	private String memberName;

	private String title;

	private String content;

	private String createdAt;

	private String updatedAt;

	private boolean isDeleted;
}
