function address(){
    new daum.Postcode({
        oncomplete: function(data) {
           $(".address-input").val(data.address); 
        }
    }).open();
}