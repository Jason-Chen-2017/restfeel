/**
 * @license Copyright (c) 2003-2016, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

// CKEDITOR.editorConfig = function( config ) {
// 	// Define changes to default configuration here. For example:
// 	// config.language = 'fr';
// 	// config.uiColor = '#AADC6E';
// };

/**
 * @license Copyright (c) 2003-2016, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function (config) {
    // config.toolbar = 'MyToolbar';
    config.toolbar = [{
        name: 'clipboard',
        items: ['Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'Undo', 'Redo']
    }, {name: 'editing', items: ['Scayt']}, {name: 'links', items: ['Link', 'Unlink', 'Anchor','Image']},
        {
            name: 'insert',
            // items: ['Table', 'HorizontalRule', 'SpecialChar']
            items: ['HorizontalRule', 'SpecialChar']
        }, {name: 'tools', items: ['Maximize']},
        // {
        //     name: 'document',
        //     items: ['Source']
        // },
        // '/',
        {
            name: 'basicstyles',
            items: ['Bold', 'Italic', 'Underline', 'Strike', '-', 'RemoveFormat']
        }, {
            name: 'paragraph',
            items: ['NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', '-', 'Blockquote']
        }, {
            // name: 'styles', items: ['Format', 'Styles', 'FontSize', 'Font']
            //name: 'styles', items: ['Format', 'Styles', 'FontSize']
        },
        {
            name: 'colors',
            items: ['TextColor', 'BGColor']
        }];

};
