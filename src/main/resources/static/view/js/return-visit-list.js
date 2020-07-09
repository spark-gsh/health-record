layui.use(['jquery', 'table'], function (exports) {
    var $ = layui.$,
        table = layui.table;

    //查找体检信息
    table.render({
        elem: '#tblResult',
        url: '/return/search',
        where: {rVId: $('#tbxVisitId').val()},
        method: 'get',
        page: true,
        cols: [[
            {type: 'checkbox', fixed: 'center', width: 50},
            {field: 'rVId', title: '体检编号', hide: true},
            {
                title: '姓名', templet: function (d) {

                    return d.basicRecord!=null?d.basicRecord.name:'';
                }
            },
            {field: 'administrative', title: '科室'},

            {
                title: '身份证号', templet: function (d) {

                    return d.basicRecord!=null?d.basicRecord.idNumber:'';
                }
            },
            {
                title: '性别', templet: function (d) {

                    return d.basicRecord!=null?d.basicRecord.gender:'';
                }
            },
            {
                title: '联系方式', templet: function (d) {

                    return d.basicRecord!=null?d.basicRecord.tele:'';
                }
            },
            {field: 'disease', title: '诊断结果'},
            {field: 'recovery', title: '康复情况'},
            {field: 'returnDate', title: '回访时间'},
            {
                title: '总体评价', width: 117, templet: function (a) {

                    return a.returnEvaluation.desc;
                }
            },
            {field: 'advice', title: '意见或建议'},
            {title: '操作', toolbar: '#barDemo'},
        ]],
        id:'testReload',

        done: function (res, curr, count) {
            $("[data-field='rVId']").css('display', 'none');
        }
    });

    //根据编号搜索，显示内容
    $('#search').click(function () {
        // alert($('#tbxUserName').val());
        table.render({
            elem: '#tblResult',
            url: '/return/search',
            where: {rVId: $('#tbxVisitId').val()},
            method: 'get',
            page: true,
            cols: [[
                {type: 'checkbox', fixed: 'center', width: 50},
                {field: 'rVId', title: '体检编号', hide: true},
                {
                    title: '姓名', templet: function (d) {

                        return d.basicRecord!=null?d.basicRecord.name:'';
                    }
                },
                {field: 'administrative', title: '科室'},

                {
                    title: '身份证号', templet: function (d) {

                        return d.basicRecord!=null?d.basicRecord.idNumber:'';
                    }
                },
                {
                    title: '性别', templet: function (d) {

                        return d.basicRecord!=null?d.basicRecord.gender:'';
                    }
                },
                {
                    title: '联系方式', templet: function (d) {

                        return d.basicRecord!=null?d.basicRecord.tele:'';
                    }
                },
                {field: 'disease', title: '诊断结果'},
                {field: 'recovery', title: '康复情况'},
                {field: 'returnDate', title: '回访时间'},
                {
                    title: '总体评价', width: 117, templet: function (a) {

                        return a.returnEvaluation.desc;
                    }
                },
                {field: 'advice', title: '意见或建议'},
                {title: '操作', toolbar: '#barDemo'},
            ]],
            id:'testReload',

            done: function (res, curr, count) {
                $("[data-field='rVId']").css('display', 'none');
            }
        });

    });

    //编辑回访信息
    table.on('tool(test)', function (obj) {
        var data = obj.data;

        if (obj.event === 'edit') {
            var rVId = data["rVId"];
            var brid = data["bRId"];
            var name = data["basicRecord"]["name"];

            // alert("name:" + name);
            $('#name').attr("readonly", "readonly").val(name);
            $('#rvid').attr("readonly", "readonly").val(rVId);

            layer.open({
                type: 1,
                title: '编辑回访记录',
                skin: 'layui-layer-molv', //加上边框
                area: ['690px', '581px'], //宽高
                content: $('#model_frame'),
                btn: ['更改', '取消'],
                yes: function (index, layero) {
                    var n_administration = $('#administration').val();
                    var n_returndate = $('#date').val();
                    var n_disease = $('#disease').val();
                    var n_recovery = $('#recovery').val();
                    var n_advice = $('#advice').val();
                    var evaluation =$('input[name="evaluation"]:checked').val();
                    $.ajax({
                        url: '/return/update',
                        type: 'post',
                        dataType: 'json',
                        data: {
                            rVId: rVId,
                            bRId:brid,
                            administrative:n_administration,
                            disease:n_disease,
                            recovery:n_recovery,
                            returnDate:n_returndate,
                            evaluation:evaluation,
                            advice:n_advice
                        },
                        success: function (data) {
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
        }


    })

});


//显示数据条目数
$(document).ready(function () {
    $.ajax({
        url: '/return/searchNum',
        type: 'get',
        dataType: 'json',
        success: function (data) {
            // alert(data);
            $('#searchNum').text("共有数据：" + data + "条");
        }
    });
});

//增加回访信息
function openModel() {

    layer.open({
        type: 1,
        title: '新建回访记录',
        skin: 'layui-layer-molv', //加上边框
        area: ['587px', '581px'], //宽高
        content: $('#model_frame'),
        btn: ['增加', '取消'],
        yes: function (index, layero) {

            var name = $('#name').val();
            // alert("name:" + name);

            $.ajax({
                url: '/history/basic/name',
                type: 'get',
                dataType: 'json',
                data: {
                    name: name
                },
                success: function (data) {
                    var brid = data.bRId;
                    // alert("brid"+brid);
                    if (brid != null) {
                        var administration = $('#administration').val();
                        var returndate = $('#date').val();
                        var disease = $('#disease').val();
                        var recovery = $('#recovery').val();
                        var advice = $('#advice').val();
                        var evaluation =$('input[name="evaluation"]:checked').val();
                        // alert("evaluation"+evaluation);

                        $.ajax({
                            url:'/return/insert',
                            type:'post',
                            dataType:'json',
                            data:{
                                bRId:brid,
                                administrative:administration,
                                disease:disease,
                                recovery:recovery,
                                returnDate:returndate,
                                evaluation:evaluation,
                                advice:advice
                            },
                            success:function (data) {
                                if (data != null) {
                                    layer.msg("增加成功");
                                    $('#model_frame').css('display', 'none');
                                    location.reload();

                                }
                            }
                        })

                    } else {
                        layer.msg("无档案信息，请先创建档案")
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
                ids += data[i].rVId+",";
            }
        }
        layer.confirm('确认删除吗？',function (index) {

            $.ajax({
                url:'/return/delete',
                type:'post',
                data:{"rVIds":ids},
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


