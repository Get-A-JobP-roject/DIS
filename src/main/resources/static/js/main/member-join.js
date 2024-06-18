// ---------------------------회원 가입 검사-------------------------------------------
// 이름 (0) -> 닉네임 (1) -> 아이디 (2) -> 비밀번호 (3) -> 핸드폰번호 (4) -> 인증 번호 (5)


let check = [false, false, false, false, false, false];
let $errorMsg = $(".error-msg");
let $input = $(".input-text");

// 이름 (0) 검사
let $inputName = $input.eq(0);
// 이름 정규식 -- 한글 이름 2 - 4자 이내
const regName = /^[가-힣]{2,4}$/;

$inputName.blur(() => {
    check[0] = false;
    if (!$inputName.val()) {
        $errorMsg.eq(0).text("이름을 입력하세요.");

    } else if (!regName.test($inputName.val())) {
        $errorMsg.eq(0).text("한글 이름 2~4자 이내 입력하세요.");

    } else {
        $errorMsg.eq(0).text("");
        check[0] = true;
    }
    allCheck();
});

// 닉네임 (1) 검사
let $inputNickname = $input.eq(1);
$inputNickname.blur(() => {
    check[1] = false;

    joinService.checkNickname($inputNickname.val(), function (result) {
        if (!$inputNickname.val()) {
            $errorMsg.eq(1).text("닉네임을 입력하세요.");
        } else if (result) {
            $errorMsg.eq(1).text("중복된 닉네임입니다.");
        } else {
            $errorMsg.eq(1).text("");
            check[1] = true;
        }
        allCheck();
    });

});


// 아이디 (2) 검사
let $inputIdentification = $input.eq(2);
const regIdentification = /^[A-Za-z0-9]{4,12}$/;

$inputIdentification.blur(() => {
    check[2] = false;
    joinService.checkIdentification($inputIdentification.val(), function (result) {
        if (!$inputIdentification.val()) {
            $errorMsg.eq(2).text("아이디를 입력하세요.");

        } else if (!regIdentification.test($inputIdentification.val())) {
            $errorMsg.eq(2).text("4자 이상 12자 이하의 대,소문자 , 숫자로 입력해주세요.");

        } else if (result) {
            $errorMsg.eq(2).text("중복된 아이디입니다.");

        } else {
            $errorMsg.eq(2).text("");
            check[2] = true;
        }
        allCheck();
    });
});

// 비밀번호(3) 검사
let $inputPassword = $input.eq(3);
const regPassword = /^(?=.*[a-zA-Z])(?=.*[0-9]).{8,25}$/;

$inputPassword.blur(() => {
    check[3] = false;
    if (!$inputPassword.val()) {
        $errorMsg.eq(3).text("비밀번호를 입력해주세요.");

    } else if (!regPassword.test($inputPassword.val())) {
        $errorMsg.eq(3).text("영문+숫자 조합 8자리 이상 입력해주세요.");
    } else {
        $errorMsg.eq(3).text("");
        check[3] = true;
    }
    allCheck();
});

// 핸드폰 번호 (4) 검사
let $inputPhoneNumber = $input.eq(4);
const regPhoneNumber = /^01\d{9}$/;

$inputPhoneNumber.keyup(() => {
    check[4] = false;
    $(".certification-button").hide();

    joinService.checkPhoneNumber($inputPhoneNumber.val(), function (result) {
        if (!$inputPhoneNumber.val()) {
            $errorMsg.eq(4).text("핸드폰 번호를 입력해주세요.")

        } else if (!regPhoneNumber.test($inputPhoneNumber.val())) {
            $errorMsg.eq(4).text("(-) 하이픈을 뺀 11자리로 입력해주세요.");

        } else if (result) {
            $errorMsg.eq(4).text("이미 등록된 핸드폰번호입니다.");

        } else {
            $errorMsg.eq(4).text("");
            check[4] = true;
            $(".certification-button").show();
        }
        allCheck();
    });

});

//     인증번호 발송
const $certificationButton = $(".certification-button");

$certificationButton.click(() => {
    let $phoneNumberInput = $(".input-phoneNumber");
    $phoneNumberInput.attr("readonly", true);
    $phoneNumberInput.css("cursor", "auto");
    $(".code-box").show();
    $certificationButton.hide();
    joinService.sendCode($phoneNumberInput.val());
});

// 인증 번호 검증
const $checkCodeButton = $(".check-code-button");
let $inputCode = $(".input-code");
$checkCodeButton.click(() => {
    if (globalThis.code != $inputCode.val()) {
        $(".code-error").text("인증번호가 틀렸습니다.");
        $(".code-error").removeClass("code-active");
        check[5] = false;
    } else {
        $(".code-error").text("인증 성공");
        $(".code-error").addClass("code-active");
        check[5] = true;
    }
    allCheck();
});


