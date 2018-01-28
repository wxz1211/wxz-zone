prettyPrint();
layui.use(['form', 'layedit'], function () {
    var form = layui.form;
    var $ = layui.jquery;
    var layedit = layui.layedit;

    //评论和留言的编辑器
    var editIndex = layedit.build('remarkEditor', {
        height: 100,
        tool: ['face', 'left', 'center', 'right', 'link'],
    });

    //评论和留言的编辑器的验证
    form.verify({
        content: function (value) {
            value = $.trim(layedit.getText(editIndex));
            if (value == "") return "最少得有一个字吧";
            if (value.length > 680) return "最多680个字哦！";
            layedit.sync(editIndex);
        }
    });


    //监听评论提交
    form.on('submit(formRemark)', function (data) {
        var index = layer.load(1);
        var userMemo = {
            memo: data.field.editorContent,
            parent: 0,
            aid: $("#aid").val(),
            type: 0
        };
        $.ajax({
            type: 'post',
            url: 'article/addMemo',
            data: {userMemo: JSON.stringify(userMemo)},
            success: function (data) {
                layer.close(index);
                if (data.code == 0) {
                    layer.msg(data.msg, {icon: 5});
                    setTimeout(function () {
                        window.location.reload();
                    }, 300);
                } else if (data.code == -1) {
                    layer.msg('程序异常，请重试或联系作者', {icon: 6});
                } else {
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
                }

            },
            error: function (data) {
                layer.close(index);
                layer.msg("请求异常", {icon: 2});
            }
        });
        return false;

    });


    //监听留言回复提交
    form.on('submit(formReply)', function (data) {
        var index = layer.load(1);
        var memo = data.field.replyContent;
        if ($.trim(memo) == null || $.trim(memo) == '') {
            layer.msg('回复内容不能为空', {icon: 5});
            return;
        }
        var userMemo = {
            floor: 0,
            memo: memo,
            parent: data.field.parent_key,
            aid: $("#aid").val(),
            type: 0
        };
        //留言回复
        $.ajax({
            type: 'post',
            url: 'article/addMemo',
            data: {
                userMemo: JSON.stringify(userMemo)
            },
            success: function (data) {
                layer.close(index);
                if (data.code == 0) {
                    layer.msg(data.msg, {icon: 5});
                    setTimeout(function () {
                        window.location.reload();
                    }, 300);
                } else if (data.code == -2) {
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
                } else {
                    layer.msg('程序异常，请重试或联系作者', {icon: 6});
                }

            },
            error: function (data) {
                layer.close(index);
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
            }
        });

        return false;
    });
});

function btnReplyClick(elem) {
    var $ = layui.jquery;
    //$(elem).parent('p').parent('.comment-parent').siblings('.replycontainer').toggleClass('layui-hide');
    var replyContainer = $(elem).parent('p').parent('.comment-parent').siblings('.replycontainer');
    var name = $(elem).parent('p').parent('.comment-parent').find('.info-common-parent .username').text();
    var flag = replyContainer.hasClass('layui-hide');
    if (flag) {
        replyContainer.removeClass('layui-hide');
    }
    replyContainer.find('textarea').text('@' + name + ':');
    replyContainer.focus();
}


function btnReplyClickChild(elem) {
    var $ = layui.jquery;
    //$(elem).parent('.info').parent('.comment-child').parent('.comment-parent').siblings('.replycontainer').toggleClass('layui-hide');
    var replyContainer = $(elem).parent('.info').parent('.comment-child').siblings('.replycontainer');
    var name = $(elem).parent('.info').parent('.comment-child').find('.username').text();
    var flag = replyContainer.hasClass('layui-hide');
    if (flag) {
        replyContainer.removeClass('layui-hide');
    }
    replyContainer.find('textarea').text('@' + name + ':')
    replyContainer.focus();
}