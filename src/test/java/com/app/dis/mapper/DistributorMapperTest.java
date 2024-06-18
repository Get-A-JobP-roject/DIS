package com.app.dis.mapper;

import com.app.dis.domain.vo.DistributorVO;
import com.app.dis.encry.EncryptUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class DistributorMapperTest {

    @Autowired
    private DistributorMapper distributorMapper;

//    회원가입 테스트
    @Test
    public void insertDistributorTest() {
        DistributorVO distributorVO = DistributorVO.builder()
                .distributorEmail("test@naver.com")
                .distributorName("테스트")
                .distributorPassword(EncryptUtils.sha256("test1234"))
                .distributorPhoneNumber("0212341234")
                .build();

        distributorMapper.insertDistributor(distributorVO);
    }

//    이메일 중복 확인
    @Test
    public void findByDistributorEmailTest(){
        log.info(distributorMapper.findByDistributorEmail("test1234@naver.com").toString());
    }

//    전화번호 확인
    @Test
    public void findByDistributorPhoneNumberTest(){
        log.info(distributorMapper.findByDistributorPhoneNumber("0212341234") + "");
    }

//    로그인
    @Test
    public void selectByDistributorEmailAndDistributorPasswordTest(){
        DistributorVO distributorVO = DistributorVO.builder()
                .distributorEmail("test@naver.com")
                .distributorPassword(EncryptUtils.sha256("test1234"))
                .build();

        Long distributorId = distributorMapper.selectByDistributorEmailAndDistributorPassword(distributorVO);

        log.info("번호 : " + distributorId);
    }
}
