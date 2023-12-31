package com.geumjjok.comment.model;

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
public class CommentDTO {

	private int commentId;

	private String content;

	private String createdAt;

	private String updatedAt;

	private boolean isDeleted;

}
