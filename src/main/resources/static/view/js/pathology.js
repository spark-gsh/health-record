initTable('in');


function initTable(diseaseType) {
    layui.use(['jquery', 'table'], function (exports) {
        var $ = layui.$,
            table = layui.table;

        // alert("diseaseType:"+diseaseType);
        // alert("name"+$('#tbxDiseaseId').val());

        //查找档案信息
        table.render({
            elem: '#tblResult',
            url: '/pathology/name',
            where: {
                diseaseName: $('#tbxDiseaseId').val(),
                administration: diseaseType
            },
            skin: 'row',
            method: 'get',
            page: true,
            cols: [[
                {type: 'checkbox', fixed: 'center', width: 50},
                {field: 'pId', title: '病理编号', hide: true},
                {field: 'diseaseName', title: '名称'},
                {field: 'symptom', title: '症状'},
                {field: 'treat', title: '治疗方案'},
            ]],
            id: 'testReload',

            done: function (res, curr, count) {
                $("[data-field='pId']").css('display', 'none');
            }
        });

        //根据编号搜索，显示内容
        $('#search').click(function () {
            // alert($('#tbxUserName').val());

            // alert("diseaseType:"+diseaseType);
            // alert("name"+$('#tbxDiseaseId').val());
            table.render({
                elem: '#tblResult',
                url: '/pathology/name',
                where: {
                    diseaseName: $('#tbxDiseaseId').val(),
                    administration: diseaseType
                },
                skin: 'row',
                method: 'get',
                page: true,
                cols: [[
                    {type: 'checkbox', fixed: 'center', width: 50},
                    {field: 'pId', title: '病理编号', hide: true},
                    {field: 'diseaseName', title: '名称'},
                    {field: 'symptom', title: '症状'},
                    {field: 'treat', title: '治疗方案'},
                ]],
                id: 'testReload',

                done: function (res, curr, count) {
                    $("[data-field='pId']").css('display', 'none');
                }
            });


        });


    });

}


layui.use('element', function () {
    var element = layui.element;

    element.on('tab(demo)', function (data) {
        var type = $(this).attr('data-status');
        initTable(type)

    });
});









