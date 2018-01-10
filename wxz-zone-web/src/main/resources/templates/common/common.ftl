<#macro commonStyle>
<link rel="stylesheet" type="text/css" href="${cxt.contextPath}/layui/css/layui.css">
<link rel="stylesheet" type="text/css" href="${cxt.contextPath}/layui/css/layui.mobile.css">
<!--全局样式表-->
<link rel="stylesheet" type="text/css" href="${cxt.contextPath}/css/global.css"/>
<!--font-awesome-->
<link rel="stylesheet" type="text/css" href="${cxt.contextPath}/font-awesome/css/font-awesome.min.css"/>
<!--animate.min-->
<link rel="stylesheet" type="text/css" href="${cxt.contextPath}/css/animate.min.css"/>
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
<meta http-equiv="Content-Type" content="text/html; Charset=gb2312">
<meta http-equiv="Content-Language" content="zh-CN">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no"/>
<title>ヾ(=^▽^=)ノlost❤</title>
<link rel="shortcut icon" href="${cxt.contextPath}/images/logo_40.png" type="image/x-icon">
</#macro>

<#macro commonFooter>
<!-- 底部 -->
<footer class="blog-footer">
    <p><span>Copyright</span><span>&copy;</span><span>2017</span><a
            href="javascript:;">lost</a><span>Design By WXZ</span>
    </p>
    <p><a href="http://www.miibeian.gov.cn/" target="_blank">蜀ICP备16029915号-1</a></p>
</footer>
</#macro>


<#macro commonLeft>
<!--侧边导航-->
<ul class="layui-nav layui-nav-tree layui-nav-side blog-nav-left layui-hide" lay-filter="nav">
    <li class="layui-nav-item layui-this">
        <a href="home"><i class="fa fa-home fa-fw"></i>&nbsp;网站首页</a>
    </li>
    <li class="layui-nav-item">
        <a href="article"><i class="fa fa-file-text fa-fw"></i>&nbsp;文章专栏</a>
    </li>
    <li class="layui-nav-item">
        <a href="resource"><i class="fa fa-tags fa-fw"></i>&nbsp;资源分享</a>
    </li>
    <li class="layui-nav-item">
        <a href="timeline"><i class="fa fa-road fa-fw"></i>&nbsp;点点滴滴</a>
    </li>
    <li class="layui-nav-item">
        <a href="about"><i class="fa fa-info fa-fw"></i>&nbsp;关于本站</a>
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
        <img src="http://www.wangxianzhi.xyz/static/2017_07_29181936_4b9tttt.jpg" alt="absolutely"/>
    </div>
    <p class="blogerinfo-nickname">absolutely</p>
    <p class="blogerinfo-introduce">一只废宅~~</p>
    <p class="blogerinfo-location"><i class="fa fa-location-arrow"></i>&nbsp;上海 - 宝山</p>
    <hr/>
    <div class="blogerinfo-contact">
        <a target="_blank" title="QQ交流" href="javascript:layer.msg('dd')"><i
                class="fa fa-qq fa-2x"></i></a>
        <a target="_blank" title="给我写信" href="javascript:layer.msg('dd')"><i
                class="fa fa-envelope fa-2x"></i></a>
        <a target="_blank" title="新浪微博" href="javascript:layer.msg('dd')"><i
                class="fa fa-weibo fa-2x"></i></a>
        <a target="_blank" title="git" href="javascript:layer.msg('dd')"><i
                class="fa fa-git fa-2x"></i></a>
    </div>
</div>
</#macro>


<#macro commonTips>
<!-- 网站公告提示 -->
<div class="home-tips shadow">
    <i style="float:left;line-height:17px;" class="fa fa-volume-up"></i>
    <div class="home-tips-container">
        <span style="color: #009688">偷偷告诉大家，本博客的后台管理也正在制作，为大家准备了游客专用账号！</span>
        <span style="color: red">网站新增留言回复啦！使用QQ登陆即可回复，人人都可以回复！</span>
        <span style="color: red">如果你觉得网站做得还不错，来Fly社区点个赞吧！<a href="javascript:;"
                                                            target="_blank"
                                                            style="color:#01AAED">点我前往</a></span>
        <span style="color: #009688">lost &nbsp;—— &nbsp;一个废宅程序员的个人博客,采用Layui为前端框架</span>
    </div>
</div>
</#macro>
<#macro commonHotArticle>
<!--热文排行-->
<div class="blog-module shadow">
    <div class="blog-module-title">热文排行</div>
    <ul class="fa-ul blog-module-ul">
        <li><i class="fa-li fa fa-hand-o-right"></i><a href="detail">Web安全之跨站请求伪造CSRF</a></li>
        <li><i class="fa-li fa fa-hand-o-right"></i><a href="detail">MVC 防范跨站请求伪造（CSRF）</a>
        </li>
        <li><i class="fa-li fa fa-hand-o-right"></i><a href="detail">常用正则表达式</a></li>
        <li><i class="fa-li fa fa-hand-o-right"></i><a href="detail">数据迁移常用指令</a></li>
        <li><i class="fa-li fa fa-hand-o-right"></i><a href="detail">浅谈Framework基元类型</a></li>
        <li><i class="fa-li fa fa-hand-o-right"></i><a href="detail">基础知识回顾-扩展方法</a></li>
        <li><i class="fa-li fa fa-hand-o-right"></i><a href="detail">一步步制作时光轴（一）（HTML篇）</a></li>
        <li><i class="fa-li fa fa-hand-o-right"></i><a href="detail">一步步制作时光轴（二）（CSS篇）</a></li>
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