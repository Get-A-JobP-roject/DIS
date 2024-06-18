package com.app.dis.service;

import com.app.dis.domain.vo.DistributorVO;

public interface DistributorService {
    
//    회원가입
    public void join(DistributorVO distributorVO);

//    이메일 중복 확인
    public Long emailCheck(String distributorEmail);

//    전화번호 중복 확인
    public Long phoneNumberCheck(String distributorPhoneNumber);

//    로그인
    public Long login(DistributorVO distributorVO);
}
