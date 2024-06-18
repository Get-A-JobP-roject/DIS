package com.app.dis.dao;

import com.app.dis.domain.dao.DistributorDAO;
import com.app.dis.domain.vo.DistributorVO;
import com.app.dis.encry.EncryptUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Base64;

@SpringBootTest
@Slf4j
public class DistributorDAOTests {
    
    @Autowired
    private DistributorDAO distributorDAO;
    
//    회원가입 테스트
    @Test
    public void insertDistributorTest(){
        DistributorVO distributorVO = DistributorVO.builder()
                .distributorEmail("test12345@naver.com")
                .distributorName("탕탕이1")
                .distributorPassword(new String(Base64.getEncoder().encode("hello".getBytes())))
                .distributorPhoneNumber("01012341235")
                .build();

        distributorDAO.insertDistributor(distributorVO);
    }
    
//    이메일 중복 확인
    @Test
    public void findByDistributorEmailTest(){
        log.info(distributorDAO.findByDistributorEmail("test1234@naver.com").toString());
    }

//    전화번호 중복 확인
    @Test
    public void findByDistributorPhoneNumberTest(){
        log.info(distributorDAO.findByDistributorPhoneNumber("0213412344") + "");
    }

//    로그인
    @Test
    public void selectByDistributorEmailAndDistributorPasswordTest(){
        DistributorVO distributorVO = DistributorVO.builder()
                .distributorEmail("test@naver.com")
                .distributorPassword(EncryptUtils.sha256("test1234"))
                .build();

        Long distributorId = distributorDAO.selectByDistributorEmailAndDistributorPassword(distributorVO);

        log.info("번호 = " + distributorId);
    }
    
}
