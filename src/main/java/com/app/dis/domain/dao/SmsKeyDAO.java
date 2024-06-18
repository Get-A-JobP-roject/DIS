package com.app.dis.domain.dao;

import com.app.dis.domain.vo.SmsKeyVO;
import com.app.dis.mapper.SmsKeyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SmsKeyDAO {

    private final SmsKeyMapper smsKeyMapper;


    public SmsKeyVO getSmsKey(){
        return smsKeyMapper.getSmsKey();
    }
}
