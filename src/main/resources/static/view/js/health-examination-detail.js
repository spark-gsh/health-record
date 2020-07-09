var app = new Vue(
    {
        el: '#app',
        data: {
            items: [],
        },
        mounted: function () {

            var that = this;
            var mcid = sessionStorage.getItem("mcid");
            // alert("mcid"+mcid);
            $.ajax({
                url: '/examination/searchBymCId',
                method: 'post',
                dataType: 'json',
                data: {
                    mCId: mcid
                },
                success: function (data) {
                    console.log(data);
                    that.items = data;
                }
            })

        }

    }
)