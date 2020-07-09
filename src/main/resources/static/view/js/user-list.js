layui.use(['jquery', 'table'], function (exports) {
    var $ = layui.$,
        table = layui.table;
    //查找用户信息
    table.render({
        elem: '#tblResult',
        url: '/user/search',
        where: {sMId: $('#tbxUserName').val()},
        method: 'get',
        page: true,
        cols: [[
            {type: 'checkbox', fixed: 'left', width: 120},
            {field: 'sMId', title: '编号', hide: true},
            {field: 'username', title: '用户名'},
            {field: 'creatTime', title: '创建时间'},
            {
                title: '账号类别', templet: function (d) {

                    return d.roleManage.role;
                }
            },
            {title: '操作', width: 120, toolbar: '#barDemo'},
        ]],
        id:'testReload',
        done: function (res, curr, count) {
            $("[data-field='sMId']").css('display', 'none');
        }
    });

    //根据编号搜索，显示内容
    $('#search').click(function () {
        // alert($('#tbxUserName').val());
        table.render({
            elem: '#tblResult',
            url: '/user/search',
            where: {sMId: $('#tbxUserName').val()},
            method: 'get',
            page: true,
            cols: [[
                {type: 'checkbox', fixed: 'left', width: 120},
                {field: 'sMId', title: '编号', hide: true},
                {field: 'username', title: '用户名'},
                {field: 'creatTime', title: '创建时间'},
                {
                    title: '账号类别', templet: function (d) {

                        return d.roleManage.role;
                    }
                },
                {title: '操作', width: 120, toolbar: '#barDemo'},
            ]],
            id:'testReload',
            done: function (res, curr, count) {
                $("[data-field='sMId']").css('display', 'none');
            }
        });


    });

    //编辑用户信息
    table.on('tool(test)',function (obj) {
        var data = obj.data;

        var smid = data["sMId"];
        var username = data["username"];
        var password = data["password"];
        var role_val = data["SDId"];

        // alert(smid);

        $("#smid").attr("readonly", "readonly").val(smid);
        $('#username').attr("readonly", "readonly").val(username);

        layer.open({
            type: 1,
            title: '编辑用户',
            skin: 'layui-layer-molv', //加上边框
            area: ['580px', '390px'], //宽高
            content: $('#model_frame'),
            btn: ['更改', '取消'],
            yes: function (index, layero) {

                var n_username = $('#username').val();
                var n_role_val = $('input[name="role"]:checked').val();
                var n_pwd = $('#L_pass').val();
                var n_repwd = $('#L_repass').val();

                // alert(n_username);
                // alert(n_role_val);
                // alert(n_pwd);

                $.ajax({
                    url:'/user/update',
                    type:'post',
                    dataType:'json',
                    data:{
                        'sMId':smid,
                        'username': n_username,
                        'password': n_pwd,
                        'sDId': n_role_val
                    },
                    success:function (data) {
                        // alert(data);
                        if (data > 0) {
                            layer.msg("更改成功");
                            $('#model_frame').css('display', 'none');
                            location.reload();
                        }

                    }
                })

            }
        });



    })


});

//显示数据条目数
$(document).ready(function () {
    $.ajax({
        url: '/user/searchNum',
        type: 'get',
        dataType: 'json',
        success: function (data) {
            // alert(data);
            $('#searchNum').text("共有数据：" + data + "条");
        }
    });

});

//增加用户信息
function openModel() {

    layer.open({
        type: 1,
        title: '增加用户',
        skin: 'layui-layer-molv', //加上边框
        area: ['580px', '390px'], //宽高
        content: $('#model_frame'),
        btn: ['增加', '取消'],
        yes: function (index, layero) {

            var username = $('#username').val();
            var role_val = $('input[name="role"]:checked').val();
            var pwd = $('#L_pass').val();
            var repwd = $('#L_repass').val();
            // alert(username);
            // alert(role_val);
            // alert(pwd);

            $.ajax({
                url: '/user/save',
                type: 'post',
                dataType: 'json',
                data: {
                    'username': username,
                    'password': pwd,
                    'sDId': role_val
                },
                success: function (data) {
                    // alert(data);
                    if (data) {
                        layer.msg("增加成功");
                        $('#model_frame').css('display', 'none');
                        location.reload();
                    }
                }
            })


        }
    });

}

//批量删除用户信息

function getCheckData() {
    layui.use(['table'],function () {
        var $ = layui.$;
        var table = layui.table;

        var checkStatus = table.checkStatus('testReload'),data = checkStatus.data;
        if (data == ""){
            layer.msg("至少选择一项",{icon:2});
            return;
        }
        var ids = "";
        if (data.length>0){
            for (var i = 0;i<data.length;i++){
                ids += data[i].sMId+",";
            }
        }
        layer.confirm('确认删除吗？',function (index) {

            $.ajax({
                url:'/user/delete',
                type:'post',
                data:{"sMIds":ids},
                success:function (data) {
                    if (data != 0){
                        // alert("data"+data);
                        layer.msg("删除成功");
                        location.reload();
                    }
                }
            })
        })
    })

}
