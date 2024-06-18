package com.app.dis.mapper;

import com.app.dis.domain.vo.SmsKeyVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SmsKeyMapper {

//    API 키 Secret KEY, 보내는 번호 가져오기
    public SmsKeyVO getSmsKey();
}
