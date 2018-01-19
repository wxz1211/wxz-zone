layui.use(['layer', 'jquery', 'element', 'layedit'], function () {

    var layedit = layui.layedit;
    var $ = layui.jquery;

    layedit.set({
        uploadImage: {
            url: 'image/addImage' //接口url
            , type: 'post' //默认post
        }
    });


    layedit.build('layer-edit', {
        height: 400,

        tool: ['face'//表情
            , 'strong' //加粗
            , 'italic' //斜体
            , 'underline' //下划线
            , 'del' //删除线
            , '|' //分割线
            , 'left' //左对齐
            , 'center' //居中对齐
            , 'right' //右对齐
            , 'link' //超链接
            , 'unlink' //清除链接
            , 'image' //插入图片
            , 'help' //帮助
        ]
    });

    $('.layui-layedit').css("background-color", "white");


});
