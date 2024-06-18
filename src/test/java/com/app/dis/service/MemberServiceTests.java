package com.app.dis.service;

import com.app.dis.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MemberServiceTests {

    @Autowired
    private MemberService memberService;

//  회원 가입 테스트
    @Test
    public void joinTest(){
        MemberVO memberVO = MemberVO.builder()
                .memberIdentification("a11455")
                .memberName("이름456")
                .memberNickname("닉네임47")
                .memberPassword("hello")
                .memberPhoneNumber("0101231416")
                .build();

        memberService.join(memberVO);
    }

//    아이디 중복 체크
    @Test
    public void checkIdTest(){
        memberService.checkMemberIdentification("12312312");
    }

//    닉네임 중복 체크
    @Test
    public void checkMemberNicknameTest(){
        memberService.checkMemberNickname("호랑이");
    }

//    핸드폰 중복 체크
    @Test
    public void checkMemberPhoneNumberTest(){
        memberService.checkMemberPhoneNumber("01012341234");
    }

//    로그인
    @Test
    public void loginTest(){
        MemberVO memberVO = MemberVO.builder()
                .memberIdentification("a11455")
                .memberPassword("hello1")
                .build();

    }
}
