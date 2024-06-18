$memberLogin = $(".member-login");
$distributorLogin = $(".distributor-login");
$selectMemberLoginButton = $(".select-member");
$selectDistributorLoginButton = $(".select-distributor");
$inputIdentification = $(".input-identification");
$inputPassword = $(".input-password");
$inputEmail = $(".input-email");
$idError = $(".id-error");
$emailError = $(".email-error");
$passwordError = $(".password-error");
$loginForm = $(".login-form");

// 일반 로그인 버튼 클릭 
$selectMemberLoginButton.click((e) =>{
    if(!$(e).hasClass("select-login-button-active")){
        $selectMemberLoginButton.addClass("select-login-button-active");
        $selectDistributorLoginButton.removeClass("select-login-button-active");

        $memberLogin.show();
        $distributorLogin.hide();

        $inputEmail.val("");
        $inputPassword.val("");

        $loginForm.attr("action", "/member/member-login");
    }
});

// 유통업체 로그인 버튼
$selectDistributorLoginButton.click((e) =>{
    if(!$(e).hasClass("select-login-button-active")){
        $selectDistributorLoginButton.addClass("select-login-button-active");
        $selectMemberLoginButton.removeClass("select-login-button-active");

        $distributorLogin.show();
        $memberLogin.hide();

        $inputIdentification.val("");
        $inputPassword.val("");

        $loginForm.attr("action", "/distributor/distributor-login");
    }
});

// 아이디 입력 확인
$inputIdentification.blur(() => {
    if(!$inputIdentification.val()){
        $idError.text("아이디를 입력해주세요.");
    }else {
        $idError.text("");
    }
});

//  이메일 입력 확인
$inputEmail.blur(() => {
    if(!$inputEmail.val()){
        $emailError.text("이메일을 입력해주세요.");
    }else {
        $emailError.text("");
    }
});

// 비밀번호 입력 확인
$inputPassword.each((i, e) => {
    $(e).blur(() => {
        if(!$(e).val()){
            $passwordError.eq(i).text("비밀번호를 입력해주세요.");
        }else {
            $passwordError.eq(i).text("");
        }
    });
});