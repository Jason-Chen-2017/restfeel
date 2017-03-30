/**
 * 真正的入口文件main.js。它一般用来对requirejs进行配置，并且载入真正的程序模块。
 */

require.config({

    paths: {
        jquery: 'libs/jquery-2.1.4.min',
        jqueryUi: 'libs/jquery-ui.min',
        underscore: 'libs/underscore-min',
        backbone: 'libs/backbone-min',
        bootstarp: 'libs/bootstrap.min',
        fancytree: 'libs/jquery.fancytree-all.min',
        selectize: 'libs/selectize.min',
        mCustomScrollbar: 'libs/jquery.mCustomScrollbar.concat.min',
        text: 'libs/require/text',
        typeahead: 'libs/typeahead.bundle.min',
        bloodhound: 'libs/typeahead.bundle.min',
        bootpag: 'libs/bootpag.min',
        moment: 'libs/moment',
        datatables: 'plugin/datatables/jquery.dataTables',
        jsonview: 'plugin/jsonview/jquery.jsonview',
        bootstrapDialog: 'plugin/bootstrap-dialog/bootstrap-dialog'

    },
    shim: {
        'underscore': {
            exports: '_'
        },
        'jqueryUi': {
            deps: ['jquery']
        },
        'bootstarp': {
            deps: ['jquery', 'jqueryUi']
        },
        'fancytree': {
            deps: ['jquery', 'jqueryUi']
        },
        'common/base': {
            deps: ['underscore']
        },
        'views/conversation-view/': {
            deps: ['jquery']
        },
        'views/app-view/': {
            deps: ['jquery']
        },
        'typeahead': {
            deps: ['jquery', 'bloodhound']
        },
        'datatables': {
            deps: ['jquery']
        },
        'jsonview': {
            deps: ['jquery']
        },
        'bootstrapDialog': {
            deps: ['jquery']
        }

    }
});


define(['app'], function (app) {
    app.initialize();
});
