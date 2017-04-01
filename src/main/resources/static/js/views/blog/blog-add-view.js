/**
 * Created by jack on 2017/3/29.
 */

define(function (require) {
    "use strict";
    require('meditor');

    jQuery(function () {
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
        jQuery("#addBlogBtn").on("click", function () {
            jQuery.ajax({
                url: 'saveBlog',
                type: 'POST',
                data: $('#addBlogForm').serialize(),
                async: false,
                success: function (data) {
                    if (data) {
                        alert('保存成功');
                        // location.href = 'blogs.do';
                        window.opener = null;
                        window.open('', '_self');
                        window.close();

                    } else {
                        alert(data);
                    }
                },
                error: function (data) {
                    alert(data);
                }

            });
        });
    });

});


