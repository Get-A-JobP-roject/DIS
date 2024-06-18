package com.app.dis.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@Builder
@ToString
public class MemberVO {

    private Long memberId;
    private String memberIdentification;
    private String memberPassword;
    private String memberName;
    private String memberNickname;
    private String memberPhoneNumber;
    private Date memberRegisterDate;

}
