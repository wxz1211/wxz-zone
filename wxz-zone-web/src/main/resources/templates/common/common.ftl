<#macro commonStyle>
<link rel="stylesheet" type="text/css" href="${cxt.contextPath}/layui/css/layui.css">
<link rel="stylesheet" type="text/css" href="${cxt.contextPath}/layui/css/layui.mobile.css">
<meta http-equiv="Content-Type" content="text/html; Charset=gb2312">
<meta http-equiv="Content-Language" content="zh-CN">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no"/>

<link rel="shortcut icon" href="${cxt.contextPath}/images/favicon.ico" type="image/x-icon">
<link rel="bookmark" type="image/x-icon" href="${cxt.contextPath}/images/favicon.ico">
<!--全局样式表-->
<link rel="stylesheet" type="text/css" href="${cxt.contextPath}/css/global.css"/>
<!--font-awesome-->
<link rel="stylesheet" type="text/css" href="${cxt.contextPath}/font-awesome/css/font-awesome.min.css"/>
<!--animate.min-->
<link rel="stylesheet" type="text/css" href="${cxt.contextPath}/css/animate.min.css"/>
<title>你个死肥宅ヾ(=^▽^=)ノ</title>
</#macro>

<#macro commonHtml>
<html class="no-js lt-ie9 lt-ie8 lt-ie7">
<html class="no-js lt-ie9 lt-ie8">
<html class="no-js lt-ie9">
<html class="no-js">
</#macro>

<#macro commonScript>
<script src="${cxt.contextPath}/layui/layui.js"></script>
<!-- 全局脚本 -->
<script src="${cxt.contextPath}/js/global.js"></script>

</#macro>

<#macro commonHeader>
</#macro>

<#macro commonFooter>
<!-- 底部 -->
<footer class="blog-footer">
    <p><span>Copyright</span><span>&copy;</span><span>2018</span><a
            href="javascript:;">lost</a><span>Design By WXZ</span>
    </p>
    <p><a href="javascript:;" target="_blank">5201314备案</a></p>
</footer>
</#macro>


<#macro commonLeft>
<!--侧边导航-->
<ul class="layui-nav layui-nav-tree layui-nav-side blog-nav-left layui-hide" lay-filter="nav">
    <li class="layui-nav-item layui-this">
        <a href="home"><i class="fa fa-home fa-fw"></i>&nbsp;网站首页</a>
    </li>
    <li class="layui-nav-item">
        <a href="article"><i class="fa fa-file-text fa-fw"></i>&nbsp;文章列表</a>
    </li>
    <li class="layui-nav-item">
        <a href="resource"><i class="fa fa-tags fa-fw"></i>&nbsp;资源分享</a>
    </li>
    <li class="layui-nav-item">
        <a href="timeline"><i class="fa fa-road fa-fw"></i>&nbsp;点点滴滴</a>
    </li>
    <li class="layui-nav-item">
        <a href="about"><i class="fa fa-info fa-fw"></i>&nbsp;关于我</a>
    </li>
</ul>
</#macro>

<#macro commonShare>
<!--分享窗体-->
<div class="blog-share layui-hide">
    <div class="blog-share-body">
        <div style="width: 200px;height:100%;">
            <div class="bdsharebuttonbox">
                <a class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a>
                <a class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a>
                <a class="bds_weixin" data-cmd="weixin" title="分享到微信"></a>
                <a class="bds_sqq" data-cmd="sqq" title="分享到QQ好友"></a>
            </div>
        </div>
    </div>
</div>
<!--遮罩-->
<div class="blog-mask animated layui-hide"></div>
</#macro>

<#macro commonIntroduce>
<!--个人介绍-->
<div class="blogerinfo shadow">
    <div class="blogerinfo-figure">
        <img src="http://www.wangxianzhi.xyz/static/2017_07_29181936_4b9tttt.jpg" class="touxiangImg" style="border-radius: 75%;
    width: 120px;height: 120px;" alt="absolutely"/>
    </div>
    <p class="blogerinfo-nickname">${user.name}</p>
    <p class="blogerinfo-introduce">做一只安安静静的废宅~~</p>
    <p class="blogerinfo-location"><i class="fa fa-location-arrow"></i>&nbsp;上海 - 宝山</p>
    <hr/>
    <div class="blogerinfo-contact">
        <a target="_blank" title="豆瓣交流" href="https://www.douban.com/people/wxz1211/"><i
                class="fa  fa-slideshare fa-lg"></i> 豆瓣交流</a>
        <a target="_blank" title="相亲专用" href="https://www.zhihu.com/people/wangxianzhi1211/activities"><i
                class="fa fa-openid fa-lg"></i> 相亲专用</a>

    </div>
    <div class="blogerinfo-contact">
        <a target="_blank" title="相亲简介" href="http://www.wangxianzhi.xyz/do/about"><i
                class="fa fa-twitch fa-lg"></i> 相亲简介</a>
        <a target="_blank" title="基佬专用" href="https://github.com/wxz1211"><i
                class="fa  fa-yelp  fa-lg"></i> 基佬专用</a>
    </div>

</div>
</#macro>


<#macro commonTips>
<!-- 网站公告提示 -->
<div class="home-tips shadow">
    <i style="float:left;line-height:19px;" class="fa fa-volume-up"></i>
    <div class="home-tips-container">
        <span style="color: #009688">不求回报去爱一个人通常可以如愿以偿,因为真的没有回报.</span>
        <span style="color: #6c8dff">生活不止眼前的苟且,还有读不懂的诗和到不了的远方.</span>
        <span style="color: #736dff">人们希望你做的更好,但一般不希望你超过他.<a href="javascript:;"
                                                             target="_blank"
                                                             style="color:#01AAED">点我前往</a></span>
        <span style="color: #009688">lost &nbsp;—— &nbsp;一个废宅程序员的个人博客</span>
    </div>
</div>
</#macro>
<#macro commonHotArticle>
<!--热文排行-->
<div class="blog-module shadow">
    <div class="blog-module-title">文章推荐</div>
    <ul class="fa-ul blog-module-ul">
        <li><i class="fa-li fa fa-hand-o-right"></i><a href="detail">文章1</a></li>
        <li><i class="fa-li fa fa-hand-o-right"></i><a href="detail">文章2</a></li>
        <li><i class="fa-li fa fa-hand-o-right"></i><a href="detail">文章3</a></li>
    </ul>
</div>
</#macro>


<#macro commonRecentShare>
<div class="blog-module shadow">
    <div class="blog-module-title">最近分享</div>
    <ul class="fa-ul blog-module-ul">
        <li><i class="fa-li fa fa-hand-o-right"></i><a href="javascript:;"
                                                       target="_blank">Canvas</a></li>
        <li><i class="fa-li fa fa-hand-o-right"></i><a href="javascript:;"
                                                       target="_blank">pagesize.js</a></li>
        <li><i class="fa-li fa fa-hand-o-right"></i><a href="javascript:;"
                                                       target="_blank">时光轴</a></li>
        <li><i class="fa-li fa fa-hand-o-right"></i><a href="javascript:;"
                                                       target="_blank">图片轮播</a></li>
    </ul>
</div></#macro>

<#macro commonYiLuZouLai>
<div class="blog-module shadow">
    <div class="blog-module-title">一路走来</div>
    <dl class="footprint">
        <dt>2017年03月12日</dt>
        <dd>新增留言回复功能！人人都可参与回复！</dd>
        <dt>2017年03月10日</dt>
        <dd>不落阁2.0基本功能完成，正式上线！</dd>
        <dt>2017年03月09日</dt>
        <dd>新增文章搜索功能！</dd>
        <dt>2017年02月25日</dt>
        <dd>QQ互联接入网站，可QQ登陆发表评论与留言！</dd>
    </dl>
</div></#macro>

<#macro commonHouTaiJiLu>
<div class="blog-module shadow">
    <div class="blog-module-title">后台记录</div>
    <dl class="footprint">
        <dt>2017年03月16日</dt>
        <dd>分页新增页容量控制</dd>
        <dt>2017年03月12日</dt>
        <dd>新增管家提醒功能</dd>
        <dt>2017年03月10日</dt>
        <dd>新增Win10快捷菜单</dd>
    </dl>
</div>
</#macro>

<#macro commonLink>

<div class="blog-module shadow">
    <div class="blog-module-title">友情链接</div>
    <ul class="blogroll">
        <li><a target="_blank" href="http://www.layui.com/" title="Layui">Layui</a></li>
        <li><a target="_blank" href="http://www.pagemark.cn/" title="页签">页签</a></li>
    </ul>
</div>
</#macro>



<!--注册-->
<#macro commonSign>

<form id="user-sign" class="layui-form layui-hide" onsubmit="return false;">
    <br>
    <div class="layui-form-item">
        <label class="layui-form-label">昵称&nbsp;<i style="color: red">*</i></label>
        <div class="layui-input-block">
            <input name="name" required lay-verify="name|nameRepeat" lay-verType="tips" placeholder="请输入昵称"
                   autocomplete="off"
                   class="layui-input" style="width: 75%;">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">手机号&nbsp;<i style="color: red">*</i></label>

        <div class="layui-input-block">
            <input name="mobile" required lay-verify="phone|mobileRepeat" lay-verType="tips" placeholder="请输入手机号码"
                   autocomplete="off"
                   class="layui-input" style="width: 75%;">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">邮箱&nbsp;<i style="color: red">*</i></label>
        <div class="layui-input-block">
            <input name="email" required lay-verify="email" lay-verType="tips" placeholder="请输入邮箱"
                   autocomplete="off"
                   class="layui-input" style="width: 75%;">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">密码&nbsp;<i style="color: red">*</i></label>
        <div class="layui-input-block">
            <input type="password" name="password" required lay-verify="password" lay-verType="tips" placeholder="请输入密码"
                   autocomplete="off"
                   class="layui-input" style="width: 75%;">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">确认密码&nbsp;<i style="color: red">*</i></label>
        <div class="layui-input-block">
            <input type="password" name="rePassword" required lay-verify="rePassword" lay-verType="tips"
                   placeholder="请确认密码"
                   autocomplete="off"
                   class="layui-input" style="width: 75%;">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">性别&nbsp;<i style="color: red">*</i></label>
        <div class="layui-input-inline">
            <input type="radio" name="sex" value="1" title="男" checked>
            <input type="radio" name="sex" value="0" title="女">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="user-sign">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

</#macro>


<!--登录-->
<#macro commonLogin>

<form id="user-login" class="layui-form layui-hide" onsubmit="return false;">
    <br>
    <div class="layui-form-item">
        <label class="layui-form-label">手机号&nbsp;<i style="color: red">*</i></label>

        <div class="layui-input-inline">
            <input name="mobile" required lay-verify="phone" lay-verType="tips" placeholder="请输入手机号码" autocomplete="off"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码&nbsp;<i style="color: red">*</i></label>

        <div class="layui-input-inline">
            <input type="password" name="password" lay-verType="tips" required lay-verify="password" placeholder="请输入密码"
                   autocomplete="off"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="user-login">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

</#macro>
