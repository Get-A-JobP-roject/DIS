package com.app.dis.service;

import com.app.dis.domain.vo.DistributorVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Base64;

@SpringBootTest
@Slf4j
public class DistributorServiceTests {
    
    @Autowired
    private DistributorService distributorService;
    
//    회원가입 테스트
    @Test
    public void joinTest(){
        DistributorVO distributorVO = DistributorVO.builder()
                .distributorEmail("test123456@naver.com")
                .distributorName("탕탕이2")
                .distributorPassword(new String(Base64.getEncoder().encode("hello".getBytes())))
                .distributorPhoneNumber("01012341237")
                .build();

        distributorService.join(distributorVO);
    }

//    이메일 중복 체크
    @Test
    public void emailCheckTest(){
        Long distributorId = distributorService.emailCheck("test124@naver.com");
        log.info(distributorId + " ");
    }

//    전화번호 중복 체크
    @Test
    public void phoneNumberCheck(){
        log.info(distributorService.phoneNumberCheck("0212341234") + "");
    }

//    로그인
    @Test
    public void loginTEst(){
        DistributorVO distributorVO = DistributorVO.builder()
                .distributorEmail("test@naver.com")
                .distributorPassword("test1234")
                .build();

        log.info("번호 : " + distributorService.login(distributorVO));
    }
}
