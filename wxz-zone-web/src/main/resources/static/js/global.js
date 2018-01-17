layui.use(['element', 'layer', 'util', 'form'], function () {
    var $ = layui.jquery;

    var layer = layui.layer;

    var form = layui.form;

    $('#login').on('click', function () {
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
    });

    $('#sign').on('click', function () {
        $('#user-sign').removeClass('layui-hide');
        layer.open(
            {
                area: ['500px'],
                title: '注册',
                shadeClose: true, //点击遮罩关闭层
                type: 1,
                content: $('#user-sign')
            }
        );
    });

    $('#logout').on('click', function () {
        $.ajax({
            url: 'user/logout',
            type: 'POST',
            success: function (data) {
                if (data.code == 0) {
                    layer.msg('成功退出啦~正在跳转中...')
                }
                location.href = 'home';
            }
        });
    });

    form.verify({

        password: function (value) {
            if (!/^[\S]{6,12}$/.test(value)) {
                return '密码必须6到12位，且不能出现空格'
            }
        }, name: function (value) {
            if (value.length < 4) {
                return '昵称请输入至少4个字符'
            } else if (/^\d+\d+\d$/.test(value)) {
                return '昵称不能全为数字';
            } else if (!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)) {
                return '昵称不能有特殊字符';
            }
        }, rePassword: function (value) {
            var passwordValue = $('input[name=password]').val();
            if (!/^[\S]{6,12}$/.test(value)) {
                return '密码必须6到12位，且不能出现空格'
            } else if (!new RegExp(passwordValue).test(value)) {
                return '两次输入的密码不一致!';
            }
        },
        nameRepeat: function (value) {
            if (value.length >= 4 && !/^\d+\d+\d$/.test(value)) {
//TODO: ajax 表单验证问题
                $.ajax({
                    url: 'user/nameRepeat',
                    type: 'POST',
                    async: false,
                    data: {name: value},
                    success: function (data) {
                        if (data.code == -1 || data.code == '-1') {
                            console.log(data.code);
                            return "该昵称已经被使用";
                        }
                    }
                })
            }
        },
        mobileRepeat: function (value) {
            var json = JSON.stringify(value);
            if (/^1[3|4|5|7|8]\d{9}$/.test(value)) {
                $.ajax({
                    url: 'user/mobileRepeat',
                    type: 'POST',
                    async: false,
                    data: {mobile: value},
                    success: function (data) {
                        if (data.code == -1) {
                            return "该号码已经被使用";
                        }
                    }
                })
            }
        }
    });

    form.on('submit(user-login)', function (data) {
        var json = JSON.stringify(data.field);
        $.ajax({
            url: 'user/login',
            type: 'POST',
            data: {userLogin: json},
            dataType: 'json',
            success: function (data) {
                layer.closeAll();
                if (data.code == 0) {
                    layer.msg('成功登录啦~正在跳转中...')
                }
                location.href = 'home';
            }
        });
        return false;

    });


    form.on('submit(user-sign)', function (data) {
        var json = JSON.stringify(data.field);
        $.ajax({
            url: 'user/sign',
            type: 'POST',
            data: {userSign: json},
            dataType: 'json',
            success: function (data) {
                layer.closeAll();
                if (data.code == 0) {
                    layer.msg('成功注册啦~正在跳转中...')
                }
                location.href = 'home';
            }
        });

        return false;
    });

    //模拟QQ登陆
    // $('.blog-user').click(function () {
    //     var user = this;
    //     var index = layer.load(1);
    //     setTimeout(function () {
    //         layer.close(index);
    //         $(user).toggleClass('layui-hide').siblings('a.blog-user').toggleClass('layui-hide');
    //     }, 800);
    // });


    //分享工具
    layui.util.fixbar({
        bar1: '&#xe641;',
        click: function (type) {
            if (type === 'bar1') {
                var sear = new RegExp('layui-hide');
                if (sear.test($('.blog-share').attr('class'))) {
                    shareIn();
                } else {
                    shareOut();
                }
            }
        }
    });

    //子栏目导航点击事件
    $('.child-nav span').click(function () {
        layer.msg('切换到相应栏目');
        $(this).addClass('child-nav-btn-this').siblings().removeClass('child-nav-btn-this');
    });

    //侧边导航开关点击事件
    $('.blog-navicon').click(function () {
        var sear = new RegExp('layui-hide');
        if (sear.test($('.blog-nav-left').attr('class'))) {
            leftIn();
        } else {
            leftOut();
        }
    });
    //侧边导航遮罩点击事件
    $('.blog-mask').click(function () {
        leftOut();
    });
    //blog-body和blog-footer点击事件，用来关闭百度分享和类别导航
    $('.blog-body,.blog-footer').click(function () {
        shareOut();
        categoryOut();
    });
    //类别导航开关点击事件
    $('.category-toggle').click(function (e) {
        e.stopPropagation();    //阻止事件冒泡
        categroyIn();
    });
    //类别导航点击事件，用来关闭类别导航
    $('.article-category').click(function () {
        categoryOut();
    });
    //具体类别点击事件
    $('.article-category > a').click(function (e) {
        e.stopPropagation(); //阻止事件冒泡
    });

    //显示百度分享
    function shareIn() {
        $('.blog-share').unbind('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend');
        $('.blog-share').removeClass('shareOut');
        $('.blog-share').addClass('shareIn');
        $('.blog-share').removeClass('layui-hide');
        $('.blog-share').addClass('layui-show');
    }

    //隐藏百度分享
    function shareOut() {
        $('.blog-share').on('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function () {
            $('.blog-share').addClass('layui-hide');
        });
        $('.blog-share').removeClass('shareIn');
        $('.blog-share').addClass('shareOut');
        $('.blog-share').removeClass('layui-show');
    }

    //显示侧边导航
    function leftIn() {
        $('.blog-mask').unbind('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend');
        $('.blog-nav-left').unbind('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend');

        $('.blog-mask').removeClass('maskOut');
        $('.blog-mask').addClass('maskIn');
        $('.blog-mask').removeClass('layui-hide');
        $('.blog-mask').addClass('layui-show');

        $('.blog-nav-left').removeClass('leftOut');
        $('.blog-nav-left').addClass('leftIn');
        $('.blog-nav-left').removeClass('layui-hide');
        $('.blog-nav-left').addClass('layui-show');
    }

    //隐藏侧边导航
    function leftOut() {
        $('.blog-mask').on('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function () {
            $('.blog-mask').addClass('layui-hide');
        });
        $('.blog-nav-left').on('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function () {
            $('.blog-nav-left').addClass('layui-hide');
        });

        $('.blog-mask').removeClass('maskIn');
        $('.blog-mask').addClass('maskOut');
        $('.blog-mask').removeClass('layui-show');

        $('.blog-nav-left').removeClass('leftIn');
        $('.blog-nav-left').addClass('leftOut');
        $('.blog-nav-left').removeClass('layui-show');
    }

    //显示类别导航
    function categroyIn() {
        $('.category-toggle').addClass('layui-hide');
        $('.article-category').unbind('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend');

        $('.article-category').removeClass('categoryOut');
        $('.article-category').addClass('categoryIn');
        $('.article-category').addClass('layui-show');
    }

    //隐藏类别导航
    function categoryOut() {
        $('.article-category').on('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function () {
            $('.article-category').removeClass('layui-show');
            $('.category-toggle').removeClass('layui-hide');
        });

        $('.article-category').removeClass('categoryIn');
        $('.article-category').addClass('categoryOut');
    }

});


//百度分享插件
window._bd_share_config = {
    "common": {
        "bdSnsKey": {},
        "bdText": "",
        "bdStyle": "0",
        "bdSize": "32"
    },
    "share": {}
};
with (document) 0[(getElementsByTagName('head')[0] || body).appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion=' + ~(-new Date() / 36e5)];
