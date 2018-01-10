﻿<!DOCTYPE html>
<html>

<#import "/common/common.ftl" as netCommon>
<#import "/common/commonNav.ftl" as netCommonNav>

<@netCommon.commonHtml />

<head>
<@netCommon.commonStyle />
    <link href="${cxt.contextPath}/css/article.css" rel="stylesheet"/>
</head>
<body>
<!-- 导航 -->
<@netCommonNav.commonNav1/>

<!-- 主体（一般只改变这里的内容） -->
<div class="blog-body">
    <div class="blog-container">
        <blockquote class="layui-elem-quote sitemap layui-breadcrumb shadow">
            <a href="../home/home.ftl" title="网站首页">网站首页</a>
            <a><cite>文章专栏</cite></a>
        </blockquote>
        <div class="blog-main">
            <div class="blog-main-left">
                <div class="shadow"
                     style="text-align:center;font-size:16px;padding:40px 15px;background:#fff;margin-bottom:15px;">
                    未搜索到与【<span style="color: #FF5722;">keywords</span>】有关的文章，随便看看吧！
                </div>
                <div class="article shadow">
                    <div class="article-left">
                        <img src="${cxt.contextPath}/images/cover/201703181909057125.jpg"
                             alt="基于laypage的layui扩展模块（pagesize.js）！"/>
                    </div>
                    <div class="article-right">
                        <div class="article-title">
                            <a href="../detail/detail.ftl">基于laypage的layui扩展模块（pagesize.js）！</a>
                        </div>
                        <div class="article-abstract">
                            该模块主要是针对当前版本laypage没有页容量控制功能而制作，使用该模块后即可实现每页显示多少条数据的控制！本人原创，但是可能有可能只对本人的分页写法有用！
                        </div>
                    </div>
                    <div class="clear"></div>
                    <div class="article-footer">
                        <span><i class="fa fa-clock-o"></i>&nbsp;&nbsp;2017-03-18</span>
                        <span class="article-author"><i class="fa fa-user"></i>&nbsp;&nbsp;Absolutely</span>
                        <span><i class="fa fa-tag"></i>&nbsp;&nbsp;<a href="#">Web前端</a></span>
                        <span class="article-viewinfo"><i class="fa fa-eye"></i>&nbsp;0</span>
                        <span class="article-viewinfo"><i class="fa fa-commenting"></i>&nbsp;4</span>
                    </div>
                </div>
                <div class="article shadow">
                    <div class="article-left">
                        <img src="${cxt.contextPath}/images/cover/201703181909057125.jpg"
                             alt="基于laypage的layui扩展模块（pagesize.js）！"/>
                    </div>
                    <div class="article-right">
                        <div class="article-title">
                            <a href="../detail/detail.ftl">基于laypage的layui扩展模块（pagesize.js）！</a>
                        </div>
                        <div class="article-abstract">
                            该模块主要是针对当前版本laypage没有页容量控制功能而制作，使用该模块后即可实现每页显示多少条数据的控制！本人原创，但是可能有可能只对本人的分页写法有用！
                        </div>
                    </div>
                    <div class="clear"></div>
                    <div class="article-footer">
                        <span><i class="fa fa-clock-o"></i>&nbsp;&nbsp;2017-03-18</span>
                        <span class="article-author"><i class="fa fa-user"></i>&nbsp;&nbsp;Absolutely</span>
                        <span><i class="fa fa-tag"></i>&nbsp;&nbsp;<a href="#">Web前端</a></span>
                        <span class="article-viewinfo"><i class="fa fa-eye"></i>&nbsp;0</span>
                        <span class="article-viewinfo"><i class="fa fa-commenting"></i>&nbsp;4</span>
                    </div>
                </div>
            </div>
            <div class="blog-main-right">
                <div class="blog-search">
                    <form class="layui-form" action="">
                        <div class="layui-form-item">
                            <div class="search-keywords  shadow">
                                <input type="text" name="keywords" lay-verify="required" placeholder="输入关键词搜索"
                                       autocomplete="off" class="layui-input">
                            </div>
                            <div class="search-submit  shadow">
                                <a class="search-btn" lay-submit="formSearch" lay-filter="formSearch"><i
                                        class="fa fa-search"></i></a>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="article-category shadow">
                    <div class="article-category-title">分类导航</div>
                    <a href="javascript:layer.msg(&#39;切换到相应分类&#39;)">ASP.NET MVC</a>
                    <a href="javascript:layer.msg(&#39;切换到相应分类&#39;)">SQL Server</a>
                    <a href="javascript:layer.msg(&#39;切换到相应分类&#39;)">Entity Framework</a>
                    <a href="javascript:layer.msg(&#39;切换到相应分类&#39;)">Web前端</a>
                    <a href="javascript:layer.msg(&#39;切换到相应分类&#39;)">C#基础</a>
                    <a href="javascript:layer.msg(&#39;切换到相应分类&#39;)">杂文随笔</a>
                    <div class="clear"></div>
                </div>
                <div class="blog-module shadow">
                    <div class="blog-module-title">作者推荐</div>
                    <ul class="fa-ul blog-module-ul">
                        <li><i class="fa-li fa fa-hand-o-right"></i><a href="../detail/detail.ftl">Web安全之跨站请求伪造CSRF</a></li>
                        <li><i class="fa-li fa fa-hand-o-right"></i><a href="../detail/detail.ftl">ASP.NET MVC 防范跨站请求伪造（CSRF）</a>
                        </li>
                        <li><i class="fa-li fa fa-hand-o-right"></i><a href="../detail/detail.ftl">C#基础知识回顾-扩展方法</a></li>
                        <li><i class="fa-li fa fa-hand-o-right"></i><a href="../detail/detail.ftl">一步步制作时光轴（一）（HTML篇）</a></li>
                        <li><i class="fa-li fa fa-hand-o-right"></i><a href="../detail/detail.ftl">一步步制作时光轴（二）（CSS篇）</a></li>
                        <li><i class="fa-li fa fa-hand-o-right"></i><a href="../detail/detail.ftl">一步步制作时光轴（三）（JS篇）</a></li>
                        <li><i class="fa-li fa fa-hand-o-right"></i><a href="../detail/detail.ftl">写了个Win10风格快捷菜单！</a></li>
                        <li><i class="fa-li fa fa-hand-o-right"></i><a href="../detail/detail.ftl">ASP.NET MVC自定义错误页</a></li>
                        <li><i class="fa-li fa fa-hand-o-right"></i><a href="../detail/detail.ftl">ASP.NET
                            MVC制作404跳转（非302和200）</a></li>
                        <li><i class="fa-li fa fa-hand-o-right"></i><a href="../detail/detail.ftl">基于laypage的layui扩展模块（pagesize.js）！</a>
                        </li>
                    </ul>
                </div>
                <div class="blog-module shadow">
                    <div class="blog-module-title">随便看看</div>
                    <ul class="fa-ul blog-module-ul">
                        <li><i class="fa-li fa fa-hand-o-right"></i><a href="../detail/detail.ftl">一步步制作时光轴（一）（HTML篇）</a></li>
                        <li><i class="fa-li fa fa-hand-o-right"></i><a href="../detail/detail.ftl">ASP.NET
                            MVC制作404跳转（非302和200）</a></li>
                        <li><i class="fa-li fa fa-hand-o-right"></i><a href="../detail/detail.ftl">ASP.NET MVC 防范跨站请求伪造（CSRF）</a>
                        </li>
                        <li><i class="fa-li fa fa-hand-o-right"></i><a href="../detail/detail.ftl">一步步制作时光轴（三）（JS篇）</a></li>
                        <li><i class="fa-li fa fa-hand-o-right"></i><a href="../detail/detail.ftl">基于laypage的layui扩展模块（pagesize.js）！</a>
                        </li>
                        <li><i class="fa-li fa fa-hand-o-right"></i><a href="../detail/detail.ftl">一步步制作时光轴（二）（CSS篇）</a></li>
                        <li><i class="fa-li fa fa-hand-o-right"></i><a href="../detail/detail.ftl">写了个Win10风格快捷菜单！</a></li>
                        <li><i class="fa-li fa fa-hand-o-right"></i><a href="../detail/detail.ftl">常用正则表达式</a></li>
                    </ul>
                </div>
                <!--右边悬浮 平板或手机设备显示-->
                <div class="category-toggle"><i class="fa fa-chevron-left"></i></div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>
<!-- 底部 -->
<@netCommon.commonFooter/>
<!--侧边导航-->
<@netCommon.commonLeft/>
<!--分享窗体 遮罩-->
<@netCommon.commonShare/>

</body>
</html>