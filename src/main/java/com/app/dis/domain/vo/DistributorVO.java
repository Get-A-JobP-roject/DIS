package com.app.dis.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Builder @ToString
public class DistributorVO {

    private Long distributorId;
    private String distributorName;
    private String distributorEmail;
    private String distributorPassword;
    private String distributorPhoneNumber;
    private String distributorAddress;
    private Long distributorEmployeesCount;
    private String distributorConsultationTime;
    private LocalDateTime distributorJoinDate;

}
