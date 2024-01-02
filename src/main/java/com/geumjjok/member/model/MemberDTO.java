package com.geumjjok.member.model;

import com.geumjjok.member.model.entity.Member;

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
public class MemberDTO {
	private int memberId;

	private String name;

	private String nickName;

	private String password;

	private String email;

	private String createdAt;

	private String updatedAt;

	private boolean isDeleted;

	public Member toEntity() {
		return Member.builder().name(this.name).nickName(this.nickName).password(this.password).email(this.email).build();
	}

}
