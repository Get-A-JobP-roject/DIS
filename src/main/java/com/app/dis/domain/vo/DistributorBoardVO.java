package com.app.dis.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Builder
@Getter @ToString
public class DistributorBoardVO {

    private Long distributorBoardId;
    private DistributorVO distributorVO;
    private String distributorBoardContent;
    private LocalDateTime distributorBoardRegisterTime;
    private LocalDateTime distributorBoardUpdateTime;
}
