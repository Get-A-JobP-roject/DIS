package com.app.dis.service;

import com.app.dis.domain.dao.DistributorDAO;
import com.app.dis.domain.vo.DistributorVO;
import com.app.dis.encry.EncryptUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class DistributorServiceImpl implements DistributorService {

    private final DistributorDAO distributorDAO;

//    회원 가입
    @Override
    @Transactional  // 회원가입 시에 오류 발생 시 롤백 위함
    public void join(DistributorVO distributorVO) {
        DistributorVO distributor = DistributorVO.builder()
                .distributorEmail(distributorVO.getDistributorEmail())
                .distributorName(distributorVO.getDistributorName())
                .distributorPassword(EncryptUtils.sha256(distributorVO.getDistributorPassword()))
                .distributorPhoneNumber(distributorVO.getDistributorPhoneNumber())
                .build();

        distributorDAO.insertDistributor(distributor);
    }

//    이메일 중복 체크
    @Override
    public Long emailCheck(String distributorEmail) {
        return nullTo0(distributorDAO.findByDistributorEmail(distributorEmail));
    }

    @Override
    public Long phoneNumberCheck(String distributorPhoneNumber) {
        return nullTo0(distributorDAO.findByDistributorPhoneNumber(distributorPhoneNumber));
    }

    @Override
    public Long login(DistributorVO distributorVO) {
        Long distributorId = null;

        DistributorVO distributor = DistributorVO.builder()
                .distributorEmail(distributorVO.getDistributorEmail())
                .distributorPassword(EncryptUtils.sha256(distributorVO.getDistributorPassword()))
                .build();

        distributorId = distributorDAO.selectByDistributorEmailAndDistributorPassword(distributor);

        if(distributor != null){
            return distributorId;
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
