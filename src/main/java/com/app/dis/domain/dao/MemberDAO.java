package com.app.dis.domain.dao;

import com.app.dis.domain.vo.MemberVO;
import com.app.dis.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberDAO {

    private final MemberMapper memberMapper;

    //    회원 가입
    public void insertMember(MemberVO memberVO) {
        memberMapper.insertMember(memberVO);
    }

    //  아이디 중복 검사
    public Long findByMemberIdentification(String memberIdentification){
        return memberMapper.findByMemberIdentification(memberIdentification);
    }
    
//    닉네임 중복 검사
    public Long findByMemberNickName(String memberNickname) {
        return memberMapper.findByMemberNickname(memberNickname);
    }

//    핸드폰 중복 검사
    public Long findByMemberPhoneNumber(String memberPhoneNumber){
        return memberMapper.findByMemberPhoneNumber(memberPhoneNumber);
    }

//    로그인
    public Long selectByMemberIdentificationAndMemberPassword(MemberVO memberVO) {
        return memberMapper.selectByMemberIdentificationAndMemberPassword(memberVO);
    }

}
