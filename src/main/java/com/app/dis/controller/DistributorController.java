package com.app.dis.controller;

import com.app.dis.domain.vo.DistributorVO;
import com.app.dis.service.DistributorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/distributor/*")
public class DistributorController {

    private final DistributorService distributorService;

//    회원가입 페이지
    @GetMapping("distributor-join")
    public void join(Model model, HttpSession session) {
        DistributorVO distributorVO = DistributorVO.builder().build();
        session.invalidate();
        model.addAttribute(distributorVO);
    }

//    회원 가입
    @PostMapping("join")
    public RedirectView join(DistributorVO distributorVO){
        distributorService.join(distributorVO);
        return new RedirectView("/main/login?distributorJoin=true");
    }

//    로그인
    @PostMapping("distributor-login")
    public RedirectView login(DistributorVO distributorVO, HttpSession session){
        boolean check = false;
        Long distributorId = distributorService.login(distributorVO);

        if(distributorId != null){
            check = true;
            session.setAttribute("distributorId", distributorId);
        }

        return new RedirectView("/main/login?distributorLoginSuccess=" + check);
    }

//    로그아웃
    @GetMapping("logout")
    public RedirectView logout(HttpSession session){
        session.invalidate();
        return new RedirectView("/main/login");
    }

}
