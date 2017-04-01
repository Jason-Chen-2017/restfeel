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

        //写文章
        jQuery("#editBlogBtn").on("click", function () {
            jQuery.ajax({
                type: 'POST',
                url: 'editBlog',
                data: jQuery('#editBlogForm').serialize(),
                //dataType: 'json',
                async: false,
                //在请求之前调用的函数
                beforeSend: function () {
                },
                success: function (data) {
                    if (data) {
                        alert('保存成功');
                        history.go(-1);
                    } else {
                        alert(data);
                    }
                },
                //调用执行后调用的函数
                complete: function (XMLHttpRequest, textStatus) {
                },
                error: function (data) {
                    alert(data);
                }

            });
        });
    });

});


