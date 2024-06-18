package com.app.dis.controller;

import com.app.dis.service.DistributorService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest-distributor/*")
@RequiredArgsConstructor
public class DistributorRestController {

    private final DistributorService distributorService;

//    이메일 중복 체크
    @GetMapping("email-check/{distributorEmail}")
    public Long emailCheck(@PathVariable String distributorEmail) {
        return distributorService.emailCheck(distributorEmail);
    }

//    전화번호 중복 체크
    @GetMapping("phone-number-check/{distributorPhoneNumber}")
    public Long phoneNumberCheck(@PathVariable String distributorPhoneNumber){
        return distributorService.phoneNumberCheck(distributorPhoneNumber);
    }
}
