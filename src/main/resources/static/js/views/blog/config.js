/**
 * 入口文件config.js。它一般用来对requirejs进行配置，并且载入真正的程序模块。
 */

require.config({
    baseUrl: '/js',

    paths: {
        jquery: 'libs/jquery-2.1.4.min',
        jqueryUi: 'libs/jquery-ui.min',
        bootstarp: 'libs/bootstrap.min',
        datatables: 'plugin/datatables/jquery.dataTables',
        jsonview: 'plugin/jsonview/jquery.jsonview',
        bootstrapDialog: 'plugin/bootstrap-dialog/bootstrap-dialog',
        meditor: 'plugin/mditor-master/dist/js/mditor.min',
    },
    shim: {
        'jqueryUi': {
            deps: ['jquery']
        },
        'bootstarp': {
            deps: ['jquery', 'jqueryUi']
        },
        'datatables': {
            deps: ['jquery']
        },
        'jsonview': {
            deps: ['jquery']
        },
        'bootstrapDialog': {
            deps: ['jquery']
        },
        'meditor': {
            deps: ['jquery']
        }
    }
});

