package com.geumjjok.post.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PostDTO {
	private int postId;

	private String title;

	private String content;

	private String createdAt;

	private String updatedAt;

	private boolean isDeleted;

}
