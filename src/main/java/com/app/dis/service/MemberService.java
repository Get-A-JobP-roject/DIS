package com.app.dis.service;

import com.app.dis.domain.vo.MemberVO;

public interface MemberService {

//    회원 가입
    public void join(MemberVO memberVO);

//    아이디 중복 체크
    public Long checkMemberIdentification(String memberIdentification);

//    닉네임 중복 체크
    public Long checkMemberNickname(String memberNickname);

//    핸드폰 중복 체크
    public Long checkMemberPhoneNumber(String memberPhoneNumber);

//    로그인
    public Long login(MemberVO memberVO);


}
