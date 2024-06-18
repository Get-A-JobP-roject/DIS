package com.app.dis.domain.vo;

import lombok.Getter;

@Getter
public class SmsKeyVO {

    private Integer smsKeyId;
    private String smsApiKey;
    private String smsSecretKey;
    private String smsSendPhoneNumber;
}
