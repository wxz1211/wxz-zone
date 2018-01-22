layui.use(['layer', 'jquery', 'element', 'layedit', 'form', 'upload'], function () {

    var edit = layui.layedit;
    var $ = layui.jquery;
    var upload = layui.upload;
    var formArticle = layui.form;
    edit.set({
        uploadImage: {
            url: 'image/addImage' //接口url
            , type: 'post' //默认post
        }
    });


    var index = edit.build('layer-edit', {
        height: 500,

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
    $('.layui-layedit').css("margin-left", "35px");


    //普通图片上传
    var uploadInst = upload.render({
        elem: '#article_upload_img'
        , url: 'image/addImage'
        , before: function (obj) {

            //预读本地文件示例，不支持ie8
            /* obj.preview(function (index, file, result) {
             $('#article_img').attr('src', result); //图片链接（base64）
             });*/
        }
        , done: function (res) {
            console.log(res);

            //如果上传失败
            if (res.code == -2) {
                $('#user-login').removeClass('layui-hide');
                layer.open(
                    {
                        area: ['400px'],
                        title: '登录',
                        shadeClose: true, //点击遮罩关闭层
                        type: 1,
                        content: $('#user-login')
                    }
                );
                return;
            } else if (res.code == -1) {
                return layer.msg(res.data);
            }
            //$("#article_upload_img").addClass('layui-btn-disabled')
            $('#article_img').attr('src', res.data.src);
            //上传成功
        }
        , error: function () {
            //演示失败状态，并实现重传
            var demoText = $('#article_img_text');
            demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
            demoText.find('.demo-reload').on('click', function () {
                uploadInst.upload();
            });
        }
    });

    formArticle.verify({
        article_title: function (value) {
            if (!/^[\S]{6,30}$/.test(value)) {
                return '文章标题必须6到30位，且不能出现空格'
            } else if (!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)) {
                return '文章标题不能有特殊字符'
            }
        }
    });

    formArticle.on('submit(add_article_form)', function (data) {
        var chk_tag = [];
        $('input[name="article_tag"]:checked').each(function () {
            var id = $(this).attr('id');
            chk_tag.push(id.substring(id.length - 1, id.length));
        });

        if (chk_tag.length < 1) {
            layer.msg("文章标签需最少选中一个")
            return;
        }

        var imgSrc = $("#article_img").attr("src");
        //imgSrc = "http://www.wangxianzhi.xyz/static/2017_08_27164813_251735527958942.jpg";
        if (imgSrc == null || imgSrc == '' || imgSrc.length == 0) {
            layer.msg("请先上传文章图片")
            return;
        }
        var content = edit.getContent(index);
        var sent = edit.getText(index);
        if (sent == null || sent == '' || sent.length == 0
            || content == null || content == '' || content.length == 0) {
            layer.msg('请先输入内容');
            return;
        }

        var top = $('input[name="article_top"]').val();
        var chosen = $('input[name="article_chosen"]').val();
        if (chosen == null || chosen == '' || chosen == 'off') {
            chosen = 0;
        } else {
            chosen = 1;
        }
        if (top == null || top == '' || top == 'off') {
            top = 0;
        } else {
            top = 1;
        }
        var title = $('input[name="article_title"]').val();
        var category = $('select[name="article_category"] option:selected').val();

        var userArticle = {
            title: title,
            category: category,
            tag: chk_tag,
            top: top,
            chosen:chosen,
            img: imgSrc,
            content: content,
            sent: sent
        }

        $.ajax({
            url: 'article/addArticle',
            type: 'POST',
            data: {userArticle: JSON.stringify(userArticle)},
            success: function (data) {
                layer.closeAll();
                if (data.code == 0) {
                    layer.msg('发表文章成功啦~正在跳转中...')
                } else {
                    layer.msg('发表文章失败啦~正在跳转中...')
                }
                location.href = 'home';
            }
        });
        return false;

    });

});
