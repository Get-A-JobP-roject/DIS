$menuOpenButton = $(".menu-open-btn");
$menu = $(".member-menu-open");
$menuBack= $(".member-menu-backgroud");
$menuOutButton = $(".member-menu-out-button");
$memberProfile = $(".header-member-menu-container");
$memberDropDown= $(".header-member-menu-dropdown");
$memberDropDownArrow= $(".header-member-picture-arrow");



// 모바일 메뉴 창 열기
$menuOpenButton.click(() => {
    $menuBack.fadeIn();
    $menu.css("transform", "translateX(0)");
    $menu.css("box-shadow", "0 0 6.25rem 0 rgba(0,0,0,.1)");
});

// 모바일 메뉴 창 닫기
$menuOutButton.click(() => {
    $menuBack.fadeOut();
    $menu.css("transform", "translateX(-100%)");
    $menu.css("box-shadow", "none");
});

$memberProfile.click(() => {

    if($memberDropDown.hasClass("check-arrow")){
        $memberDropDown.removeClass("check-arrow");
        $memberDropDown.slideUp();
        $memberDropDownArrow.attr("src", "/image/down-arrow-icon.png");
    }else {
        $memberDropDown.addClass("check-arrow");
        $memberDropDown.slideDown();
        $memberDropDownArrow.attr("src", "/image/up-arrow-icon.png");
    }
});