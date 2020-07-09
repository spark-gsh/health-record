initTable('MX.01');


function initTable(diseaseType) {
    layui.use(['jquery', 'table'], function (exports) {
        var $ = layui.$,
            table = layui.table;

        //查找档案信息
        table.render({
            elem: '#tblResult',
            url: '/disease/hypertension',
            where: {
                name: $('#tbxRecordId').val(),
                rTId: diseaseType
            },
            skin: 'row',
            method: 'get',
            page: true,
            cols: [[
                {type: 'checkbox', fixed: 'center', width: 50},
                {field: 'bRId', title: '档案编号', hide: true},
                {
                    title: '所属疾病类别', width: 162, style: 'font-size: large', templet: function (d) {

                        return d.recordType.desc;
                    }
                },
                {field: 'name', title: '姓名'},
                {field: 'idNumber', title: '身份证号', width: 183},
                {
                    title: '人群类型编号', width: 117, templet: function (d) {

                        return d.sysDict.desc;
                    }
                },
                {
                    title: '划分区域编号', width: 218, templet: function (d) {

                        return d.areaDivide.desc;
                    }
                },

                {field: 'rprType', title: '户口类型', width: 107},
                {field: 'gender', title: '性别'},
                {field: 'birth', title: '出生年月', width: 120},
                {field: 'tele', title: '联系方式', width: 128},
                {field: 'nation', title: '民族'},
                {field: 'country', title: '国籍'},
                {field: 'address', title: '详细地址', width: 225},
                {field: 'bloodType', title: '血型', width: 82},
                {field: 'culture', title: '文化程度', width: 94},
                {field: 'job', title: '职业'},
                {field: 'maritalStatus', title: '婚姻状态', width: 94},

                {title: '体检报告', width: 91, toolbar: '#toolCheck'},
                {title: '病例', width: 65, toolbar: '#toolCase'},
                {title: '操作', width: 61, toolbar: '#barDemo'}
            ]],
            id: 'testReload',

            done: function (res, curr, count) {
                $("[data-field='bRId']").css('display', 'none');
            }
        });

        //根据编号搜索，显示内容
        $('#search').click(function () {
            // alert($('#tbxUserName').val());
            table.render({
                elem: '#tblResult',
                url: '/disease/hypertension',
                where: {
                    name: $('#tbxRecordId').val(),
                    rTId: diseaseType
                },
                skin: 'row',
                method: 'get',
                page: true,
                cols: [[
                    {type: 'checkbox', fixed: 'center', width: 50},
                    {field: 'bRId', title: '档案编号', hide: true},
                    {
                        title: '所属疾病类别',
                        width: 162,
                        style: 'font-size: large',
                        templet: function (d) {

                            return d.recordType.desc;
                        }
                    },
                    {field: 'name', title: '姓名'},
                    {field: 'idNumber', title: '身份证号', width: 183},
                    {
                        title: '人群类型编号', width: 117, templet: function (d) {

                            return d.sysDict.desc;
                        }
                    },
                    {
                        title: '划分区域编号', width: 218, templet: function (d) {

                            return d.areaDivide.desc;
                        }
                    },

                    {field: 'rprType', title: '户口类型', width: 107},
                    {field: 'gender', title: '性别'},
                    {field: 'birth', title: '出生年月', width: 120},
                    {field: 'tele', title: '联系方式', width: 128},
                    {field: 'nation', title: '民族'},
                    {field: 'country', title: '国籍'},
                    {field: 'address', title: '详细地址', width: 225},
                    {field: 'bloodType', title: '血型', width: 82},
                    {field: 'culture', title: '文化程度', width: 94},
                    {field: 'job', title: '职业'},
                    {field: 'maritalStatus', title: '婚姻状态', width: 94},

                    {title: '体检报告', width: 91, toolbar: '#toolCheck'},
                    {title: '病例', width: 65, toolbar: '#toolCase'},
                    {title: '操作', width: 61, toolbar: '#barDemo'},
                ]],
                id: 'testReload',

                done: function (res, curr, count) {
                    $("[data-field='bRId']").css('display', 'none');
                }
            });


        });

        //编辑用户信息
        table.on('tool(test)', function (obj) {
            var data = obj.data;

            if (obj.event === 'edit') {
                var bRId = data["bRId"];
                var name = data["name"];
                var idNumber = data["idNumber"];

                // alert(bRId);

                $("#bRId").attr("readonly", "readonly").val(bRId);
                $('#name').attr("readonly", "readonly").val(name);
                $('#idNumber').attr("readonly", "readonly").val(idNumber);


                layer.open({
                    type: 1,
                    title: '编辑档案',
                    skin: 'layui-layer-molv', //加上边框
                    area: ['587px', '581px'], //宽高
                    content: $('#model_frame'),
                    btn: ['更改', '取消'],
                    yes: function (index, layero) {

                        var n_typeId = $('#typeid').val();
                        var n_vartityId = $('#vartityId').val();
                        var n_areaId = $('#areaId').val();
                        //获取户口类型
                        var n_admini = $('input[name="admini"]:checked').val();
                        var n_gender = $('input[name="gender"]:checked').val();
                        var n_tele = $('#tele').val();
                        var n_birth = $('#birth').val();
                        var n_nation = $('#nation').val();
                        var n_country = $('#country').val();
                        var n_address = $('#address').val();

                        var n_blood = $('input[name="blood"]:checked').val();
                        var n_culture = $('#culture').val();
                        var n_job = $('#job').val();

                        var n_marital = $('input[name="marital"]:checked').val();

                        // alert(n_blood);


                        $.ajax({
                            url: '/basic/update',
                            type: 'post',
                            dataType: 'json',
                            data: {
                                bRId: bRId,
                                vartityId: n_vartityId,
                                name: name,
                                idNumber: idNumber,
                                rprType: n_admini,
                                gender: n_gender,
                                birth: n_birth,
                                nation: n_nation,
                                country: n_country,
                                address: n_address,
                                bloodType: n_blood,
                                culture: n_culture,
                                job: n_job,
                                maritalStatus: n_marital,
                                areaId: n_areaId,
                                tele: n_tele,
                                rTId: n_typeId

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
            if (obj.event === 'lookCase') {
                var c = data["cHId"];
                // alert(c);
                sessionStorage.setItem("c", c);
                location.href = 'history-list.html';
            }
            if (obj.event === 'lookCheck'){
                // alert(data);
                var m = data["mFId"];
                // alert("m:"+m);
                sessionStorage.setItem("m",m);
                location.href = 'health-examination-list.html';
            }
            if (obj.event === 'toolReturn'){
                // alert(data);
                var r = data["rVId"];
                // alert("r:"+r);
                sessionStorage.setItem("r",r);
                location.href = 'return-visit-list.html';
            }
        })

    });

}


layui.use('element', function () {
    var element = layui.element;

    element.on('tab(demo)', function (data) {
        var type = $(this).attr('data-status');
        initTable(type)

    });
});









