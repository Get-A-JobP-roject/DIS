package com.app.dis.mapper;

import com.app.dis.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    // 회원 가입
    public void insertMember(MemberVO memberVO);

//    아이디 중복 체크
    public Long findByMemberIdentification(String memberIdentification);
    
//    닉네임 중복 체크
    public Long findByMemberNickname(String memberNickname);

//    핸드폰 중복 체크
    public Long findByMemberPhoneNumber(String memberPhoneNumber);

//    로그인
    public Long selectByMemberIdentificationAndMemberPassword(MemberVO memberVO);
}
