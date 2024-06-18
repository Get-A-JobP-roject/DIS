package com.app.dis.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Builder
@ToString
@Getter
public class DistributorBoardReplyVO {

    Long distributorBoardReplyId;
    Long distributorBoardId;
    Long memberId;
    Long distributorId;
    String distributorBoardReplyContent;
    LocalDateTime distributorBoardReplyRegisterDate;
    LocalDateTime distributorBoardReplyUpdateDate;
}
