// 비밀번호 표시 숨김
$passwordShowButton = $(".password-show-button");

$passwordInput = $(".input-password");
$passwordShowButton.click(() => {
    if ($passwordShowButton.hasClass("show")) {
        $passwordInput.attr("type", "text");
        $passwordShowButton.removeClass("show");
        $passwordShowButton.text("숨김");
    } else {

        $passwordShowButton.addClass("show");
        $passwordInput.attr("type", "password");
        $passwordShowButton.text("표시");
    }
});