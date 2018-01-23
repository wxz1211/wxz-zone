layui.use(['element', 'jquery', 'form', 'layedit'], function () {
    var element = layui.element;
    var form = layui.form;
    var $ = layui.jquery;
    var layedit = layui.layedit;


    //评论和留言的编辑器
    var editIndex = layedit.build('remarkEditor', {
        height: 150,
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


    //Hash地址的定位
    var layid = location.hash.replace(/^#tabIndex=/, '');
    if (layid == "") {
        element.tabChange('tabAbout', 1);
    }
    element.tabChange('tabAbout', layid);

    element.on('tab(tabAbout)', function (elem) {
        location.hash = 'tabIndex=' + $(this).attr('lay-id');
    });


    //监听留言提交
    form.on('submit(formLeaveMessage)', function (data) {
        var index = layer.load(1);

        var userMemo = {
            memo: data.field.editorContent,
            parent: 0,
            aid: 0,
            type: 1
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

        //
        //
        // //模拟留言提交
        // setTimeout(function () {
        //     layer.close(index);
        //     var content = data.field.editorContent;
        //     var html = '<li><div class="comment-parent"><img src="../images/logo_40.png"alt="模拟留言"/><div class="info"><span class="username">模拟留言</span></div><div class="content">' + content + '</div><p class="info info-footer"><span class="time">2017-03-18 18:09</span><a class="btn-reply"href="javascript:;" onclick="btnReplyClick(this)">回复</a></p></div><!--回复表单默认隐藏--><div class="replycontainer layui-hide"><form class="layui-form"action=""><div class="layui-form-item"><textarea name="replyContent"lay-verify="replyContent"placeholder="请输入回复内容"class="layui-textarea"style="min-height:80px;"></textarea></div><div class="layui-form-item"><button class="layui-btn layui-btn-mini"lay-submit="formReply"lay-filter="formReply">提交</button></div></form></div></li>';
        //     $('.blog-comment').append(html);
        //     $('#remarkEditor').val('');
        //     editIndex = layui.layedit.build('remarkEditor', {
        //         height: 150,
        //         tool: ['face', '|', 'left', 'center', 'right', '|', 'link'],
        //     });
        //     layer.msg("留言成功", {icon: 1});
        // }, 500);
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
            aid: 0,
            type: 1
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
    $(elem).parent('p').parent('.comment-parent').siblings('.replycontainer').toggleClass('layui-hide');
    if ($(elem).text() == '回复') {
        $(elem).text('收起')
    } else {
        $(elem).text('回复')
    }
}

systemTime();

function systemTime() {
    //获取系统时间。
    var dateTime = new Date();
    var year = dateTime.getFullYear();
    var month = dateTime.getMonth() + 1;
    var day = dateTime.getDate();
    var hh = dateTime.getHours();
    var mm = dateTime.getMinutes();
    var ss = dateTime.getSeconds();
    //分秒时间是一位数字，在数字前补0。
    mm = extra(mm);
    ss = extra(ss);

    //将时间显示到ID为time的位置，时间格式形如：19:18:02
    document.getElementById("time").innerHTML = year + "-" + month + "-" + day + " " + hh + ":" + mm + ":" + ss;
    //每隔1000ms执行方法systemTime()。
    setTimeout("systemTime()", 1000);
}

//补位函数。
function extra(x) {
    //如果传入数字小于10，数字前补一位0。
    if (x < 10) {
        return "0" + x;
    }
    else {
        return x;
    }
}