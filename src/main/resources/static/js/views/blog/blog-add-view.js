/**
 * Created by jack on 2017/3/29.
 */

define(function (require) {
    "use strict";
    require('meditor');

    $(function () {
        //meditor
        var mditor = Mditor.fromTextarea(document.getElementById('blogContentEditor'));

        //是否打开分屏
        mditor.split = true;	//打开
        //是否打开预览
        mditor.preivew = true;	//打开
        //是否全屏
        mditor.fullscreen = false;	//关闭

        //获取或设置编辑器的值
        mditor.on('ready', function () {
            mditor.value = '#Restfeel';
        });


        //写文章
        $("#addBlogBtn").on("click", function () {
            $.ajax({
                url: 'saveBlog',
                type: 'POST',
                data: $('#addBlogForm').serialize(),
                success: function (res) {
                    if (res) {
                        alert('保存成功');
                        location.href = 'blogs.do';
                    } else {
                        alert(res);
                    }
                },
                error: function (res) {
                    alert(res);
                }

            });
        });
    });

});


