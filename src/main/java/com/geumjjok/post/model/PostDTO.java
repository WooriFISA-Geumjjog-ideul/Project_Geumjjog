package com.geumjjok.post.model;

import java.util.List;

import com.geumjjok.comment.model.CommentDTO;

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

	private String memberNickName;

	private String title;

	private String content;
	
	private List<CommentDTO> comments;

	private String createdAt;

	private String updatedAt;

	private boolean isDeleted;
}
