//增加档案信息
function openModel() {

    layer.open({
        type: 1,
        title: '新建档案',
        skin: 'layui-layer-molv', //加上边框
        area: ['587px', '581px'], //宽高
        content: $('#model_frame'),
        btn: ['增加', '取消'],
        yes: function (index, layero) {
            var typeId = $('#typeid').val();
            var name = $('#name').val();
            var idNumber = $('#idNumber').val();
            var vartityId = $('#vartityId').val();
            var areaId = $('#areaId').val();
            //获取户口类型
            var admini = $('input[name="admini"]:checked').val();
            var gender = $('input[name="gender"]:checked').val();
            var tele = $('#tele').val();

            var birth = $('#birth').val();
            var nation = $('#nation').val();
            var country = $('#country').val();
            var address = $('#address').val();

            var blood = $('input[name="blood"]:checked').val();
            var culture = $('#culture').val();
            var job = $('#job').val();

            var marital = $('input[name="marital"]:checked').val();

            // alert(birth);
            // alert(name+idNumber+vartityId+areaId+admini+birth);

            $.ajax({
                url: '/basic/add',
                type: 'post',
                dataType: 'json',
                data: {
                    bRId: 'HR02.02.007',
                    vartityId: vartityId,
                    name: name,
                    idNumber: idNumber,
                    rprType: admini,
                    gender: gender,
                    birth: birth,
                    nation: nation,
                    country: country,
                    address: address,
                    bloodType: blood,
                    culture: culture,
                    job: job,
                    maritalStatus: marital,
                    areaId: areaId,
                    tele: tele,
                    rTId:typeId
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
    layui.use(['table'], function () {
        var $ = layui.$;
        var table = layui.table;

        var checkStatus = table.checkStatus('testReload'), data = checkStatus.data;
        if (data == "") {
            layer.msg("至少选择一项", {icon: 2});
            return;
        }
        var ids = "";
        if (data.length > 0) {
            for (var i = 0; i < data.length; i++) {
                ids += data[i].bRId + ",";
            }
        }
        layer.confirm('确认删除吗？', function (index) {

            $.ajax({
                url: '/basic/delete',
                type: 'post',
                dataType: 'json',
                data: {"bRIds": ids},
                success: function (data) {
                    if (data != 0) {
                        // alert("data"+data);
                        layer.msg("删除成功");
                        location.reload();
                    }
                }
            })
        })
    })

}