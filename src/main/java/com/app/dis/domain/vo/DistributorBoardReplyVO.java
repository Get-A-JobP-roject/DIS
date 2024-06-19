package com.app.dis.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Builder
@ToString
@Getter
public class DistributorBoardReplyVO {

    private Long distributorBoardReplyId;
    private DistributorBoardVO distributorBoard;
    private MemberVO memberVO;
    private DistributorVO distributorVO;
    private String distributorBoardReplyContent;
    private LocalDateTime distributorBoardReplyRegisterDate;
    private LocalDateTime distributorBoardReplyUpdateDate;

}
