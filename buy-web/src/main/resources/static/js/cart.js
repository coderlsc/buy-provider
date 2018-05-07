//
//
//
// function getTotalPrice(URLPath){
//             alert("进来了！！！   ");
//         var array=[];
//         $(".itemId").each(function(i,e){
//         var _this = $(e);
//         if($(".check").eq(i).prop("checked")==true){
//             array.push({itemId:$(e).val(),number:parseInt(_this.siblings(".count-input").val())});
//        }
//     });
//         console.log(array);
//         var data={cartList:array};
//     window.location.href=URLPath+"/?items="+encodeURIComponent(JSON.stringify(data));
//     // $.ajax({
//     //     url: '/toPay',
//     //     dataType: 'json',
//     //     method: 'post',
//     //     contentType: "application/json;charset=utf-8",
//     //     data: data,
//     //     success: function(data) {
//     //         if (data.result == '1') {
//     //
//     //         }
//     //     },
//     //     error: function(xhr) {
//     //         // 导致出错的原因较多，以后再研究
//     //         alert('error:' + "请重新登录");
//     //         window.location.href=URLPath+"toLogin";
//     //     }
//     // })
// }