/**
 * Created by jack on 2017/3/29.
 */

define(function (require) {
    "use strict";
    require('datatables')

    $(function () {

        //写文章
        $("#writeBlogFormSubmitBtn").unbind("click").bind("click", function () {
            $.ajax({
                url: 'saveBlog',
                type:'POST',
                data: $('#writeBlogForm').serialize(),
                success: function (res) {
                    if(res){
                        alert('保存成功');
                        location.href = 'blogs.do';
                    }else{
                        alert(res);
                    }
                },
                error: function (res) {
                    alert(res);
                }

            });
        });

        // 文章列表
        var aLengthMenu = [10, 20, 50, 100, 200];
        var dataTableOptions = {
            bDestroy: true,
            dom: 'lfrtip',
            paging: true,
            lengthChange: true,
            searching: true,
            ordering: true,
            autoWidth: true,
            processing: true,
            stateSave: true,
            responsive: true,
            fixedHeader: false,
            order: [[3, "asc"]],
            aLengthMenu: aLengthMenu,
            language: {
                search: "<div style='border-radius:10px;margin-left:auto;margin-right:2px;width:760px;'>_INPUT_ &nbsp;<span class='btn btn-primary'>搜索</span></div>",
                paginate: {//分页的样式内容
                    previous: "上一页",
                    next: "下一页",
                    first: "第一页",
                    last: "最后"
                }
            },
            zeroRecords: "没有内容",//table tbody内容为空时，tbody的内容。
            //下面三者构成了总体的左下角的内容。
            info: "总计 _TOTAL_ 条,共 _PAGES_ 页，_START_ - _END_ ",//左下角的信息显示，大写的词为关键字。
            infoEmpty: "0条记录",//筛选为空时左下角的显示。
            infoFiltered: ""//筛选之后的左下角筛选提示
        }

        $('#blogsTable').dataTable(dataTableOptions)
    });

});


