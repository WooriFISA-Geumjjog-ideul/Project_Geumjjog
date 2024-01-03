package com.geumjjok.post.model;

import com.geumjjok.member.model.entity.Member;
import com.geumjjok.post.model.entity.Post;

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
public class PostRequestDTO {
	private String title;

	private String content;
	
	public Post toEntity(Member member) {
		return Post.builder().memberId(member).title(this.title).content(this.content).build();
	}
}
