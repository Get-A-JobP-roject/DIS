package com.app.dis.dao;

import com.app.dis.domain.dao.MemberDAO;
import com.app.dis.domain.vo.MemberVO;
import com.app.dis.encry.EncryptUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Base64;

@SpringBootTest
@Slf4j
public class MemberDAOTests {

    @Autowired
    private MemberDAO memberDAO;
    
//    회원가입 테스트
    @Test
    public void insertMemberTest(){
        MemberVO memberVO = MemberVO.builder()
                .memberIdentification("15555")
                .memberName("이름")
                .memberNickname("닉네임3")
                .memberPassword(new String(Base64.getEncoder().encode(("hello").getBytes())))
                .memberPhoneNumber("01012341236")
                .build();

        memberDAO.insertMember(memberVO);
    }

//    아이디 중복 체크
    @Test
    public void findMemberIdentificationTest(){
        memberDAO.findByMemberIdentification("12312312");
    }

//    닉네임 중복 체크
    @Test
    public void findByMemberNickNameTest(){
        memberDAO.findByMemberNickName("호랑이");
    }

//    핸드폰 중복 체크
    @Test
    public void findByMemberPhoneNumberTest(){
        memberDAO.findByMemberPhoneNumber("01012341234");
    }

//    로그인
    @Test
    public void selectByMemberIdentificationAndMemberPasswordTest(){
        MemberVO memberVO = MemberVO.builder()
                .memberIdentification("a11455")
                .memberPassword(EncryptUtils.sha256("hello"))
                .build();

        Long memberId = memberDAO.selectByMemberIdentificationAndMemberPassword(memberVO);
        log.info("memberId = " + memberId);
    }
}
