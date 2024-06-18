package com.app.dis.mapper;

import com.app.dis.domain.vo.DistributorVO;
import com.app.dis.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DistributorMapper {

    // 회원 가입
    public void insertDistributor(DistributorVO distributorVO);

//    이메일 중복 확인
    public Long findByDistributorEmail(String distributorEmail);

//    전화번호 확인
    public Long findByDistributorPhoneNumber(String distributorPhoneNumber);

//    로그인
    public Long selectByDistributorEmailAndDistributorPassword(DistributorVO distributorVO);
}
