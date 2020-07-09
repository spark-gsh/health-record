layui.use(['jquery', 'table'], function (exports) {
    var $ = layui.$,
        table = layui.table;
    var m = sessionStorage.getItem('m');
    // alert(m);
    //体检
    table.render({
        elem: '#tblResult',
        url: '/examination/search',
        where: {mCId: m},
        method: 'get',
        page: true,
        skin: 'line', //行边框风格
        even: true,
        cols: [[
            {type: 'checkbox', fixed: 'left', width: 120},
            {field: 'mCId', title: '编号', hide: true},
            {
                title: '姓名', templet: function (d) {

                    return d.basicRecord!=null?d.basicRecord.name:'';
                }
            },
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
            {
                title: '地址', templet: function (d) {

                    return d.basicRecord!=null?d.basicRecord.address:'';
                }
            },
            {title: '操作', width: 140, toolbar: '#barDemo'},
        ]],
        id:'testReload',
        done: function (res, curr, count) {
            $("[data-field='mCId']").css('display', 'none');
        }
    });

    //根据编号搜索，显示内容
    $('#search').click(function () {
        // alert($('#tbxUserName').val());
        table.render({
            elem: '#tblResult',
            url: '/examination/search',
            where: {mCId: $('#tbxExaminationId').val()},
            method: 'get',
            page: true,
            skin: 'line', //行边框风格
            even: true, //开启隔行背景
            cols: [[
                {type: 'checkbox', fixed: 'left', width: 120},
                {field: 'mCId', title: '编号', hide: true},
                {
                    title: '姓名', templet: function (d) {

                        return d.basicRecord!=null?d.basicRecord.name:'';
                    }
                },
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
                {
                    title: '地址', templet: function (d) {

                        return d.basicRecord!=null?d.basicRecord.address:'';
                    }
                },
                {title: '操作', width: 140, toolbar: '#barDemo'},
            ]],
            id:'testReload',
            done: function (res, curr, count) {
                $("[data-field='mCId']").css('display', 'none');
            }
        });


    });

    //编辑体检信息
    table.on('tool(test)',function (obj) {
        var data = obj.data;

        if (obj.event === 'edit') {
            var mCId = data["mCId"];
            var brid = data["bRId"];
            var name = data["basicRecord"]["name"];

            // alert("name:" + name);

            $("#mcid").attr("readonly", "readonly").val(mCId);
            $('#name').attr("readonly", "readonly").val(name);

            layer.open({
                type: 1,
                title: '编辑体检记录',
                skin: 'layui-layer-molv', //加上边框
                area: ['690px', '581px'], //宽高
                content: $('#model_frame'),
                btn: ['更改', '取消'],
                yes: function (index, layero) {
                    var n_internal = $('#internal').val();
                    var n_date = $('#date').val();
                    var n_surgery = $('#surgery').val();
                    var n_eye = $('#eye').val();
                    var n_fiveSense = $('#five-sense').val();


                    var n_neurology = $('#neurology').val();
                    var n_blood = $('#blood').val();
                    var n_blood_biochemistry = $('#blood_biochemistry').val();
                    var n_urine = $('#urine').val();
                    var n_radiate = $('#radiate').val();
                    var n_ECG = $('#ECG').val();
                    var n_physical_result = $('#physical_result').val();
                    var n_physical_advice = $('#physical_advice').val();
                    var n_doctor = $('#doctor').val();


                    $.ajax({
                        url: '/examination/update',
                        type: 'post',
                        dataType: 'json',
                        data: {
                            mCId:mCId,
                            bRId:brid,
                            internal:n_internal,
                            surgery:n_surgery,
                            eye:n_eye,
                            fiveSense:n_fiveSense,
                            neurology:n_neurology,
                            blood:n_blood,
                            bloodBiochemistry:n_blood_biochemistry,
                            urine:n_urine,
                            radiate:n_radiate,
                            ecg:n_ECG,
                            physicalResult:n_physical_result,
                            physicalAdvice:n_physical_advice,
                            physicalTime:n_date,
                            physicalDoctor:n_doctor
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
        if (obj.event === 'look') {
            debugger;
            var mcid = data["mCId"];
            // alert(mcid);
            sessionStorage.setItem("mcid", mcid);
            location.href = 'health-examination-detail.html';
        }
    })


});

//显示数据条目数
$(document).ready(function () {
    $.ajax({
        url: '/examination/searchNum',
        type: 'get',
        dataType: 'json',
        success: function (data) {
            // alert(data);
            $('#searchNum').text("共有数据：" + data + "条");
        }
    });
});

//增加体检信息
function openModel() {

    layer.open({
        type: 1,
        title: '新增体检记录',
        skin: 'layui-layer-molv', //加上边框
        area: ['580px', '390px'], //宽高
        content: $('#model_frame'),
        btn: ['增加', '取消'],
        yes: function (index, layero) {

            var name = $('#name').val();

            $.ajax({
                url: '/history/basic/name',
                type: 'get',
                dataType: 'json',
                data: {
                    name:name
                },
                success: function (data) {
                    // alert(data);
                  var brid = data.bRId;
                  if (brid != null){
                      var internal = $('#internal').val();
                      var surgery = $('#surgery').val();
                      var eye = $('#eye').val();
                      var fiveSense = $('#five-sense').val();
                      var neurology = $('#neurology').val();
                      var blood = $('#blood').val();
                      var blood_biochemistry = $('#blood_biochemistry').val();
                      var urine = $('#urine').val();
                      var radiate = $('#radiate').val();
                      var ECG = $('#ECG').val();
                      var physical_result = $('#physical_result').val();
                      var physical_advice = $('#physical_advice').val();
                      var date = $('#date').val();
                      var doctor = $('#doctor').val();
                      $.ajax({
                          url: '/examination/insert',
                          type: 'post',
                          dataType: 'json',
                          data: {
                              bRId:brid,
                              internal:internal,
                              surgery:surgery,
                              eye:eye,
                              fiveSense:fiveSense,
                              neurology:neurology,
                              blood:blood,
                              bloodBiochemistry:blood_biochemistry,
                              urine:urine,
                              radiate:radiate,
                              ecg:ECG,
                              physicalResult:physical_result,
                              physicalAdvice:physical_advice,
                              physicalTime:date,
                              physicalDoctor:doctor
                          },
                          success:function (data) {
                              if (data != null) {
                                  layer.msg("增加成功");
                                  $('#model_frame').css('display', 'none');
                                  $.ajax({
                                      url:'/examination/searchBybRId',
                                      type:'get',
                                      dataType:'json',
                                      data:{
                                          bRId:brid
                                      },
                                      success:function (data) {
                                          var insert_mcid=data.mCId;
                                          var insert_bird = data.bRId;
                                          $.ajax({
                                              url:'/basic/updatemCId',
                                              type:'post',
                                              dataType:'json',
                                              data:{
                                                  bRId:insert_bird,
                                                  mCId:insert_mcid
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
                      }else {
                      layer.msg("无档案信息，请先创建档案")
                  }
                  }
            })
        }
    });

}

//批量删除体检信息
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
                ids += data[i].mCId+",";
            }
        }
        layer.confirm('确认删除吗？',function (index) {

            $.ajax({
                url:'/examination/delete',
                type:'post',
                data:{"mCIds":ids},
                success:function (data) {
                    if (data != 0){
                        // alert("data"+data);
                        layer.msg("删除成功");
                        location.reload()
                    }
                }
            })
        })
    })

}
