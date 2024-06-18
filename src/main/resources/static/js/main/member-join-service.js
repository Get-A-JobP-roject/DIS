let joinService = (function () {

    //  닉네임 중복 검사
    function checkNickname(memberNickname, callback) {
        $.ajax({
            url: "/rest-member/check-nickname",
            type: "get",
            data: {"memberNickname": memberNickname},
            success: function (result) {
                callback(result);
            }
        });
    }

    function checkIdentification(identification, callback) {
        $.ajax({
            url: "/rest-member/check-identification",
            type: "get",
            data: {"memberIdentification": identification},
            success: function (result) {
                callback(result);
            }
        });
    }

    function checkPhoneNumber(phoneNumber, callback) {
        $.ajax({
            url: "/rest-member/check-phonenumber",
            type: "get",
            data: {"memberPhoneNumber": phoneNumber},
            success: function (result) {
                callback(result);
            }
        });
    }

    function sendCode(phoneNumber) {
        $.ajax({
            url: "/rest-member/send-code",
            type: "get",
            data: {"memberPhoneNumber": phoneNumber},
            success: function (result) {
                globalThis.code = result;
                console.log(result);
            }
        });
    }

    return {
        checkNickname: checkNickname,
        checkIdentification: checkIdentification,
        checkPhoneNumber: checkPhoneNumber,
        sendCode : sendCode
    }
})();
