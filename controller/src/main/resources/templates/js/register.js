function el_hide() {

    // zapros na validaciu
    $('.error_register_placeholder').hide();
    $('.popup_form').hide();
}

$(document).ready(el_hide)

function send_mail() {
    let xhr = new XMLHttpRequest();
    xhr.open("POST", window.location.href.replace('register', '') + "user/create", true); // configuration interface at https://webhook.site/#!/5c7a5049-9c5e-4bf7-b1cf-0e05f6503bfa/e14fc471-4bc4-410f-b16a-0755a231fb12/1
    xhr.setRequestHeader("Content-Type", "application/json");
    $('.password_input').type='text'
    let data = JSON.stringify({'username' : $('.username_input').val(), 'password': $('.password_input').val()});
    xhr.send(data);

    xhr.onreadystatechange = function() {
    if (xhr.readyState == XMLHttpRequest.DONE) {
        if (xhr.status == 400) {
            $('.error_register_placeholder').text(xhr.responseText);
            $('.error_register_placeholder').show();
        } else {
            $('form').submit();
        }
    }
}

    // $('.popup_form').show();
}