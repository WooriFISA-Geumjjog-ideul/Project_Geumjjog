package com.geumjjok.like.model;

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
public class LikeDTO {

	private int likeId;

	private String createdAt;

	private String updatedAt;

	private boolean isDeleted;
	
}
