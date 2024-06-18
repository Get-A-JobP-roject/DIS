package com.app.dis.dao;

import com.app.dis.domain.dao.SmsKeyDAO;
import com.app.dis.domain.vo.SmsKeyVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class SmsKeyDAOTest {

    @Autowired
    private SmsKeyDAO smsKeyDAO;

    @Test
    public void getSmsKeyTest(){
        SmsKeyVO smsKeyVO = smsKeyDAO.getSmsKey();

        log.info(smsKeyVO.getSmsApiKey());
        log.info(smsKeyVO.getSmsSecretKey());
        log.info(smsKeyVO.getSmsSendPhoneNumber());
    }
}
