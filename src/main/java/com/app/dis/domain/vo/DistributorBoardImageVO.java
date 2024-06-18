package com.app.dis.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class DistributorBoardImageVO {

    private Long distributorBoardImageId;
    private Long distributorBoardId;
    private String distributorBoardImageOriginalName;
    private String distributorBoardImagePath;
    private String distributorBoardImageUuid;

}
