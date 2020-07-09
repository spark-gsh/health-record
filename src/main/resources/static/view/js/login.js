$(document).ready(function () {

    $('#login').click(function () {

        var radio_val = $('input[name="role"]:checked').val();
        // alert(radio_val);

        $.ajax({
            url:'/login/searchByName',
            type:'get',
            dataType:'json',
            data:{
                username:$('#username').val(),
                password:$('#password').val(),
                sDId:radio_val
            },
            success:function (res) {

                console.log(res.error_code);

                if (res.error_code === 1){
                    //将用户名保存在sessionstorage中
                    sessionStorage.setItem("username",username.value);

                    sessionStorage.setItem("logintime",new Date());

                    sessionStorage.setItem("role",radio_val);
                    // alert("登录成功");
                    location.href = 'index.html';
                }else {
                    alert("登录失败");
                }

            }

        })
    })
})