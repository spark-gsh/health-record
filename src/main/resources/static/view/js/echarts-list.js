// 基于准备好的dom，初始化echarts实例
var myChart = echarts.init(document.getElementById('bar'));
// 使用刚指定的配置项和数据显示图表。
myChart.setOption({
    title: {
        text: '行政区域人数统计表'
    },
    tooltip: {},
    legend: {
        data: ['人数']
    },
    xAxis: {
        data: []
    },
    yAxis: {},
    series: [{
        name: '人数',
        type: 'bar',
        data: []
    }]
});

searchArea();
groupByNum();

function searchArea() {
    $.ajax({
        url:'/area/searchAll',
        type:'get',
        dataType:'json',
        success:function (data) {
            myChart.setOption({
                xAxis: {
                    data: data.desc
                }
            });
        }
    });
}

function groupByNum() {
    $.ajax({
        url:'/basic/searchCount',
        type:'get',
        dataType:'json',
        success:function (data) {
            myChart.setOption({
                series: [{
                    name: '人数',
                    type: 'bar',
                    data: data.recordCount
                }]
            })
        }
    })

}

// 基于准备好的dom，初始化echarts实例
var Chart = echarts.init(document.getElementById('main'));
// 指定图表的配置项和数据
Chart.setOption({
    title : {
        text: '分类疾病人数统计表',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient: 'vertical',
        left: 'left',
        data: searchRecord()
    },
    series : [
        {
            name: '分类疾病人数',
            type: 'pie',
            radius: '55%',
            data:[
                {name: '肺结核', value: 11},
                {name: '病毒性肝炎', value: 9},
                {name: '梅毒', value: 2},
                {name: '艾滋病', value: 5},
                {name: '高血压', value: 7},
                {name: '糖尿病', value: 23},
                {name: '恶性肿瘤', value: 7},
                {name: '心脑血管疾病', value: 14},
                {name: '神经异常/精神病', value: 6}



            ]
        }
    ]
})

function searchRecord() {
    $.ajax({
        url:'/record/searchAll',
        type:'get',
        dataType:'json',
        success:function (data) {
            Chart.setOption({
                legend: {
                    data: data.desc
                }
            });
        }
    });
}




