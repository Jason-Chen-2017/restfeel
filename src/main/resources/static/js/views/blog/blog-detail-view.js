/**
 * Created by jack on 2017/3/29.
 */

define(function (require) {
    "use strict";
    require('meditor');

    $(function () {
        var parser = new Mditor.Parser();
        var blogContent = document.getElementById('blogContent').innerHTML;
        var html = parser.parse(blogContent);
        $('.markdown-body').append(html);
    });

});


