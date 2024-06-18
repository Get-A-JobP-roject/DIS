package com.app.dis.mapper;

import com.app.dis.domain.vo.SmsKeyVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class SmsKeyMapperTest {

    @Autowired
    private SmsKeyMapper smsKeyMapper;

    @Test
    public void getSmsKeyTest(){
        SmsKeyVO smsKey = smsKeyMapper.getSmsKey();
        log.info(smsKey.getSmsApiKey());
        log.info(smsKey.getSmsSecretKey());
        log.info(smsKey.getSmsSendPhoneNumber());

    }
}
