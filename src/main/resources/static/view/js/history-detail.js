var app = new Vue(
    {
        el: '#app',
        data: {
            items: [],
            checkValueForQMS:"1",
            checkValueForHLS:"2",
            checkValueForHA:"3",
            checkValueForLDS:"4",
            checkValueForAD:"5"
        },
        mounted: function () {

            var that = this;
            var chid = sessionStorage.getItem("chid");
            // alert("chid"+chid);
                $.ajax({
                    url: '/history/searchByChid',
                    method: 'post',
                    dataType: 'json',
                    data: {
                        cHId: chid
                    },
                    success: function (data) {
                        console.log(data);
                        that.items = data;


                        var allergyArr = JSON.parse(that.items.allergy);
                        that.items.otherForallergy = allergyArr[allergyArr.length-1];
                        console.log("items:" + that.items);
                        console.log(that.items.otherForallergy);

                    }
                })

        },
        methods:{

            isChecked:function (allergyList,allergyValue) {

                var flag = "";

                if( allergyList.indexOf(allergyValue)!=-1)
                {
                     flag="checked";
                }

                return flag;
            }


        }
    }
)