layui.use(['layer', 'jquery', 'element', 'layedit'], function () {

    var edit = layui.layedit;
    var $ = layui.jquery;

    edit.set({
        uploadImage: {
            url: 'image/addImage' //接口url
            , type: 'post' //默认post
        }
    });


    var index = edit.build('layer-edit', {
        height: 600,

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


    $('#submit').on('click', function () {
        var content = edit.getContent(index);
        var sent = edit.getText(index);
        if (sent == null || sent == '' || sent.length == 0
            || content == null || content == '' || content.length == 0) {
            layer.alert('请先输入内容');
            return;
        }



    })

});
