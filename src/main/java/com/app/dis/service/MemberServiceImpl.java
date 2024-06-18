package com.app.dis.service;

import com.app.dis.domain.dao.MemberDAO;
import com.app.dis.domain.vo.MemberVO;
import com.app.dis.encry.EncryptUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.MessageDigest;
import java.util.Base64;


@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;

    @Override
    public void join(MemberVO memberVO) {
        MemberVO member = MemberVO.builder()
                .memberIdentification(memberVO.getMemberIdentification())
                .memberPhoneNumber(memberVO.getMemberPhoneNumber())
                .memberNickname(memberVO.getMemberNickname())
                .memberPassword(EncryptUtils.sha256(memberVO.getMemberPassword()))
                .memberName(memberVO.getMemberName())
                .build();

        memberDAO.insertMember(member);
    }

    @Override
    public Long checkMemberIdentification(String memberIdentification) {
        return nullTo0(memberDAO.findByMemberIdentification(memberIdentification));
    }

    @Override
    public Long checkMemberNickname(String memberNickname) {
        return nullTo0(memberDAO.findByMemberNickName(memberNickname));
    }

    @Override
    public Long checkMemberPhoneNumber(String memberPhoneNumber) {
        return nullTo0(memberDAO.findByMemberPhoneNumber(memberPhoneNumber));
    }

    @Override
    @Transactional
    public Long login(MemberVO memberVO) {
        Long memberId = null;
        MemberVO member = MemberVO.builder()
                .memberPassword(EncryptUtils.sha256(memberVO.getMemberPassword()))
                .memberIdentification(memberVO.getMemberIdentification())
                .build();

        memberId = memberDAO.selectByMemberIdentificationAndMemberPassword(member);

        if(memberId != null){
            return memberId;
        }
        return null;
    }

    private Long nullTo0(Long value){
        long data = 0L;
        if(value != null){
            data = 1L;
        }
        return data;
    }

}
