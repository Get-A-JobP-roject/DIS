package com.app.dis.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
@Getter
public class DistributorBoardLikeVO {

    private Long distributorBoardLikeId;
    private Long distributorBoardId;
    private Long memberId;

}
