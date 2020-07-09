
    layui.use(['jquery', 'table'], function (exports) {
        var $ = layui.$,
            table = layui.table;
        var c = sessionStorage.getItem('c');
        //查找病历信息
        table.render({
            elem: '#tblResult',
            url: '/history/search',
            where: {cHId: c},
            method: 'get',
            page: true,
            cols: [[
                {type: 'checkbox', fixed: 'center', width: 50},
                {field: 'cHId', title: '档案编号', hide: true},
                {
                    title: '姓名', templet: function (d) {

                        return d.basicRecord != null ? d.basicRecord.name : '';
                    }
                },
                {field: 'administrative', title: '科室'},

                {
                    title: '身份证号', templet: function (d) {

                        return d.basicRecord != null ? d.basicRecord.idNumber : '';
                    }
                },
                {
                    title: '性别', templet: function (d) {

                        return d.basicRecord != null ? d.basicRecord.gender : '';
                    }
                },
                {
                    title: '联系方式', templet: function (d) {

                        return d.basicRecord != null ? d.basicRecord.tele : '';
                    }
                },
                {
                    title: '地址', templet: function (d) {

                        return d.basicRecord != null ? d.basicRecord.address : '';
                    }
                },
                {title: '操作', toolbar: '#barDemo', width: 140},
            ]],
            id: 'testReload',

            done: function (res, curr, count) {
                $("[data-field='cHId']").css('display', 'none');
            }
        });

        //根据编号搜索，显示内容
        $('#search').click(function () {
            // alert($('#tbxUserName').val());
            table.render({
                elem: '#tblResult',
                url: '/history/search',
                where: {cHId: $('#tbxCaseId').val()},
                method: 'get',
                page: true,
                cols: [[
                    {type: 'checkbox', fixed: 'center', width: 50},
                    {field: 'cHId', title: '档案编号', hide: true},
                    {
                        title: '姓名', templet: function (d) {

                            return d.basicRecord.name;
                        }
                    },
                    {field: 'administrative', title: '科室'},

                    {
                        title: '身份证号', templet: function (d) {

                            return d.basicRecord.idNumber;
                        }
                    },
                    {
                        title: '性别', templet: function (d) {

                            return d.basicRecord.gender;
                        }
                    },
                    {
                        title: '联系方式', templet: function (d) {

                            return d.basicRecord.tele;
                        }
                    },
                    {
                        title: '地址', templet: function (d) {

                            return d.basicRecord.address;
                        }
                    },
                    {title: '操作', toolbar: '#barDemo', width: 140},
                ]],
                id: 'testReload',

                done: function (res, curr, count) {
                    $("[data-field='cHId']").css('display', 'none');
                }
            });


        });

        //编辑病历信息
        table.on('tool(test)', function (obj) {
            var data = obj.data;

            if (obj.event === 'edit') {
                var cHid = data["cHId"];
                var brid = data["bRId"];
                var name = data["basicRecord"]["name"];
                var idNumber = data["basicRecord"]["idNumber"];

                // alert("name:" + name);

                $("#chid").attr("readonly", "readonly").val(cHid);
                $('#name').attr("readonly", "readonly").val(name);
                $('#idNumber').attr("readonly", "readonly").val(idNumber);

                layer.open({
                    type: 1,
                    title: '编辑病历',
                    skin: 'layui-layer-molv', //加上边框
                    area: ['690px', '581px'], //宽高
                    content: $('#model_frame'),
                    btn: ['更改', '取消'],
                    yes: function (index, layero) {
                        var n_administration = $('#administration').val();
                        var date = $('#date').val();
                        var n_cc = $('#cc').val();
                        var n_hpi = $('#hpi').val();
                        var n_pmh = $('#pmh').val();
                        // alert("listVal：" + n_administration);
                        //                     // alert("listVal：" + date);
                        //                     // alert("listVal：" + n_cc);


                        //获取过敏信息
                        var listVal = [];
                        $('input[name="allergy"]:checked').each(function () {
                            listVal.push($(this).val());
                        });
                        if ($('#other').val() != null) {
                            listVal.push($('#other').val());
                        }

                        // alert("listVal：" + listVal);

                        var n_physical_check = $('#physical_check').val();
                        var n_a_e = $('#a_e').val();
                        var n_primary = $('#primary').val();
                        var n_processing = $('#processing').val();
                        var n_doctor = $('#doctor').val();


                        $.ajax({
                            url: '/history/update',
                            type: 'post',
                            dataType: 'json',
                            data: {
                                cHId: cHid,
                                bRId: brid,
                                administrative: n_administration,
                                historyDate: date,
                                cc: n_cc,
                                hpi: n_hpi,
                                pmh: n_pmh,
                                allergy: JSON.stringify(listVal),
                                physicalCheck: n_physical_check,
                                auxiliaryExamination: n_a_e,
                                primaryDiagnosis: n_primary,
                                processingOpinion: n_processing,
                                doctor: n_doctor
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
            else if (obj.event === 'look') {
                var chid = data["cHId"];
                // alert(chid);
                sessionStorage.setItem("chid", chid);
                location.href = 'history-detail.html';
            }


        })

    });



//显示数据条目数
$(document).ready(function () {
    $.ajax({
        url: '/history/searchNum',
        type: 'get',
        dataType: 'json',
        success: function (data) {
            // alert(data);
            $('#searchNum').text("共有数据：" + data + "条");
        }
    });
});

//增加病历信息
function openModel() {

    layer.open({
        type: 1,
        title: '新建病历',
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
                    var idnumber = data.idNumber;
                    var chid = data.cHId;

                    // alert("brid+idnumber" + brid + idnumber)
                    if (idnumber != null) {
                        $('#idNumber').val(idnumber);
                        var administrative = $('#administration').val();
                        var historydate = $('#date').val();
                        var cc = $('#cc').val();
                        var hpi = $('#hpi').val();
                        var pmh = $('#pmh').val();

                        //获取过敏信息
                        var listVal = [];
                        $('input[name="allergy"]:checked').each(function () {
                            listVal.push($(this).val());
                        });
                        if ($('#other').val() != null) {
                            listVal.push($('#other').val());
                        }

                        var physicalCheck = $('#physical_check').val();
                        var a_e = $('#a_e').val();
                        var primary = $('#primary').val();
                        var processing = $('#processing').val();
                        var doctor = $('#doctor').val();

                        $.ajax({
                            url:'/history/insert',
                            type:'post',
                            dataType:'json',
                            data:{
                                bRId:brid,
                                administrative:administrative,
                                historyDate:historydate,
                                cc:cc,
                                hpi:hpi,
                                pmh:pmh,
                                allergy:JSON.stringify(listVal),
                                physicalCheck:physicalCheck,
                                auxiliaryExamination:a_e,
                                primaryDiagnosis:primary,
                                processingOpinion:processing,
                                doctor:doctor
                            },
                            success:function (data) {
                                if (data != null) {
                                    layer.msg("增加成功");
                                    $('#model_frame').css('display', 'none');
                                    // alert("brid:"+brid);
                                    $.ajax({
                                        url:'/history/searchBybRId',
                                        type:'get',
                                        dataType:'json',
                                        data:{
                                            bRId:brid
                                        },
                                        success:function (data) {
                                            //插入到basicrecord中
                                            var insert_chid = data.cHId;
                                            var insert_bird = data.bRId;
                                            // alert(insert_chid+"   "+insert_bird);
                                            $.ajax({
                                                url:'/basic/updatecHId',
                                                type:'post',
                                                dataType:'json',
                                                data:{
                                                    bRId:insert_bird,
                                                    cHId:insert_chid
                                                },
                                                success:function (data) {
                                                    if (data != null){
                                                        location.reload();
                                                    }
                                                }
                                            })
                                        }
                                    })

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
                ids += data[i].cHId+",";
            }
        }
        layer.confirm('确认删除吗？',function (index) {

            $.ajax({
                url:'/history/delete',
                type:'post',
                data:{"cHIds":ids},
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


