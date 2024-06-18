function allCheck() {
    let trueCount = check.filter(e => e === true).length;
    if (trueCount === check.length) {
        $(".join-button").attr("disabled", false);
        $(".join-button").addClass("join-button-active");
    } else {
        $(".join-button").attr("disabled", true);
        $(".join-button").removeClass("join-button-active");
    }
}