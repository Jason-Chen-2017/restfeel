/**
 * Created by jack on 2017/3/29.
 */

define(function (require) {
    "use strict";
    require('meditor');

    $(function () {
        var parser = new Mditor.Parser();
        // var blogContent = document.getElementById('blogContent').innerHTML;//这个遇到<>等特殊字符会被转译
        var blogContent = document.getElementById('blogContent').value; //直接取原本的字符串。不会被转译，默认html页面中textarea区域text需要escape编码
        blogContent = unescape(blogContent);//unescape解码
        var html = parser.parse(blogContent);

        $('#rest-blog-body').append(html);


        hljs.initHighlightingOnLoad();
        //源码高亮
        $('pre code').each(function(i, block) {
            hljs.highlightBlock(block);
        });


        //编辑文章
        $('#goEditBlog').on('click',function () {
            var blogId = $('#blogId').val();
            location.href = 'goEditBlog?id=' + blogId;
        });

    });

});


