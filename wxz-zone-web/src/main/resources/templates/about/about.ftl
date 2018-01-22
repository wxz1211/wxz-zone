<!DOCTYPE html>
<html>

<#import "/common/common.ftl" as netCommon>
<#import "/common/commonNav.ftl" as netCommonNav>

<@netCommon.commonHtml />

<head>
<@netCommon.commonStyle />
    <!-- 本页样式表 -->
    <link href="${cxt.contextPath}/css/about.css" rel="stylesheet"/>
</head>

<body>
<!-- 导航 -->
<@netCommonNav.commonNav4/>
<!-- 主体（一般只改变这里的内容） -->
<div class="blog-body">
    <div class="blog-container">
        <blockquote class="layui-elem-quote sitemap layui-breadcrumb shadow">
            <a href="home" title="网站首页">网站首页</a>
            <a><cite>关于本站</cite></a>
        </blockquote>
        <div class="blog-main">
            <div class="layui-tab layui-tab-brief shadow" lay-filter="tabAbout">
                <ul class="layui-tab-title">
                    <li lay-id="1">关于博客</li>
                    <li lay-id="2">关于作者</li>
                    <li lay-id="3" id="frinedlink">友情链接</li>
                    <li lay-id="4">留言墙</li>
                </ul>
                <div class="layui-tab-content">
                    <div class="layui-tab-item">
                        <div class="aboutinfo">
                            <div class="aboutinfo-figure">
                                <img src="http://www.wangxianzhi.xyz/static/before0720/shijia.jpg" alt="lost"/>
                            </div>
                            <p class="aboutinfo-nickname">lost</p>
                            <p class="aboutinfo-introduce">肥宅又做错了什么</p>
                            <p class="aboutinfo-location"><i class="fa fa-link"></i>&nbsp;&nbsp;<a target="_blank"
                                                                                                   href="home">www.wangxianzhi.xyz/wxz-zone/home</a>
                            </p>
                            <hr/>
                            <div class="aboutinfo-contact">
                                <a target="_blank" title="网站首页" href="home"><i class="fa fa-home fa-2x"
                                                                               style="font-size:2.5em;position:relative;top:3px"></i></a>
                                <a target="_blank" title="文章专栏" href="article"><i
                                        class="fa fa-file-text fa-2x"></i></a>
                                <a target="_blank" title="资源分享" href="resource"><i
                                        class="fa fa-tags fa-2x"></i></a>
                                <a target="_blank" title="点点滴滴" href="timeline"><i
                                        class="fa fa-hourglass-half fa-2x"></i></a>
                            </div>

                            <fieldset class="layui-elem-field layui-field-title">
                                <legend>简介</legend>
                                <div class="layui-field-box aboutinfo-abstract">
                                    <p style="text-align:center;"></p>
                                    <h1>第一个版本</h1>
                                    <p>
                                    </p>
                                    <h1>第二个版本</h1>
                                    <p></p>
                                    <h1>当前版本</h1>
                                    <p>
                                    </p>
                                    <h1 style="text-align:center;">The End</h1>
                                </div>
                            </fieldset>
                        </div>
                    </div><!--关于网站End-->
                    <div class="layui-tab-item">
                        <div class="aboutinfo">
                            <div class="aboutinfo-figure">
                                <img src="http://www.wangxianzhi.xyz/static/before0720/shijia.jpg" alt="shijia"/>
                            </div>
                            <p class="aboutinfo-nickname">废宅</p>
                            <p class="aboutinfo-introduce">废宅</p>
                            <p class="aboutinfo-location"><i class="fa fa-location-arrow"></i>&nbsp;上海 - 宝山</p>
                            <hr/>
                            <div class="aboutinfo-contact">
                                <a target="_blank" title="QQ交流" href="javascript:layer.msg('启动QQ会话窗口')"><i
                                        class="fa fa-qq fa-2x"></i></a>
                                <a target="_blank" title="给我写信" href="javascript:layer.msg('启动邮我窗口')"><i
                                        class="fa fa-envelope fa-2x"></i></a>
                                <a target="_blank" title="新浪微博" href="javascript:layer.msg('转到你的微博主页')"><i
                                        class="fa fa-weibo fa-2x"></i></a>
                                <a target="_blank" title="码云" href="javascript:layer.msg('转到你的github主页')"><i
                                        class="fa fa-git fa-2x"></i></a>
                            </div>
                            <fieldset class="layui-elem-field layui-field-title">
                                <legend>简介</legend>
                                <div class="layui-field-box aboutinfo-abstract abstract-bloger">
                                    <p style="text-align:center;"></p>
                                    <h1>个人信息</h1>
                                    <p>暂无</p>
                                    <h1>个人介绍</h1>
                                    <p>没什么介绍......</p>
                                    <h1 style="text-align:center;">The End</h1>
                                </div>
                            </fieldset>
                        </div>
                    </div><!--关于作者End-->
                    <div class="layui-tab-item">
                        <div class="aboutinfo">
                            <div class="aboutinfo-figure">
                                <img src="${cxt.contextPath}/images/handshake.png" alt="友情链接"/>
                            </div>
                            <p class="aboutinfo-nickname">友情链接</p>
                            <p class="aboutinfo-introduce">Name：&nbsp;&nbsp;&nbsp;&nbsp;Site:www.wangxianzhi.xyz/wxz-zone/home</p>
                            <p class="aboutinfo-location">
                                <i class="fa fa-close"></i>经常宕机&nbsp;
                                <i class="fa fa-close"></i>不合法规&nbsp;
                                <i class="fa fa-close"></i>插边球站&nbsp;
                                <i class="fa fa-close"></i>红标报毒&nbsp;
                                <i class="fa fa-check"></i>原创优先&nbsp;
                                <i class="fa fa-check"></i>技术优先
                            </p>
                            <hr/>
                            <div class="aboutinfo-contact">
                                <p style="font-size:2em;">互换友链，携手并进！</p>
                            </div>
                            <fieldset class="layui-elem-field layui-field-title">
                                <legend>Friend Link</legend>
                                <div class="layui-field-box">
                                    <ul class="friendlink">
                                        <li>
                                            <a target="_blank" href="http://www.layui.com/" title="Layui"
                                               class="friendlink-item">
                                                <p class="friendlink-item-pic"><img
                                                        src="http://www.layui.com/favicon.ico" alt="Layui"/></p>
                                                <p class="friendlink-item-title">Layui</p>
                                                <p class="friendlink-item-domain">layui.com</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a target="_blank" href="http://www.pagemark.cn/" title="页签"
                                               class="friendlink-item">
                                                <p class="friendlink-item-pic"><img
                                                        src="http://pm.lyblogs.cn/Images/logo-png.png" alt="页签"/></p>
                                                <p class="friendlink-item-title">页签</p>
                                                <p class="friendlink-item-domain">pagemark.cn</p>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </fieldset>
                        </div>
                    </div><!--友情链接End-->
                    <div class="layui-tab-item">
                        <div class="aboutinfo">
                            <div class="aboutinfo-figure">
                                <img src="${cxt.contextPath}/images/messagewall.png" alt="留言墙"/>
                            </div>
                            <p class="aboutinfo-nickname">留言墙</p>
                            <p class="aboutinfo-introduce">本页面可留言、吐槽、提问。欢迎灌水，杜绝广告！</p>
                            <p class="aboutinfo-location">
                                <i class="fa fa-clock-o"></i>&nbsp;<span id="time"></span>
                            </p>
                            <hr/>
                            <div class="aboutinfo-contact">
                                <p style="font-size:2em;">沟通交流，拉近你我！</p>
                            </div>
                            <fieldset class="layui-elem-field layui-field-title">
                                <legend>Leave a message</legend>
                                <div class="layui-field-box">
                                    <div class="leavemessage" style="text-align:initial">
                                        <form class="layui-form blog-editor" action="">
                                            <div class="layui-form-item">
                                                <textarea name="editorContent" lay-verify="content" id="remarkEditor"
                                                          placeholder="请输入内容"
                                                          class="layui-textarea layui-hide"></textarea>
                                            </div>
                                            <div class="layui-form-item">
                                                <button class="layui-btn" lay-submit="formLeaveMessage"
                                                        lay-filter="formLeaveMessage">提交留言
                                                </button>
                                            </div>
                                        </form>
                                        <ul class="blog-comment">
                                            <li>
                                                <div class="comment-parent">
                                                    <img src="http://www.wangxianzhi.xyz/static/before0720/shijia.jpg"
                                                         alt="ddd"/>
                                                    <div class="info">
                                                        <span class="username"></span>
                                                    </div>
                                                    <div class="content">
                                                        模拟留言与回复
                                                    </div>
                                                    <p class="info info-footer"><span
                                                            class="time">2017-03-18 18:09</span><a class="btn-reply"
                                                                                                   href="javascript:;"
                                                                                                   onclick="btnReplyClick(this)">回复</a>
                                                    </p>
                                                </div>
                                                <hr/>
                                                <div class="comment-child">
                                                    <img src="http://www.wangxianzhi.xyz/static/before0720/shijia.jpg"
                                                         alt="Absolutely"/>
                                                    <div class="info">
                                                        <span class="username">a</span><span>这是用户回复内容</span>
                                                    </div>
                                                    <p class="info"><span class="time">2017-03-18 18:26</span></p>
                                                </div>
                                                <div class="comment-child">
                                                    <img src="http://www.wangxianzhi.xyz/static/before0720/shijia.jpg"
                                                         alt="Absolutely"/>
                                                    <div class="info">
                                                        <span class="username">a</span><span>这是第二个用户回复内容</span>
                                                    </div>
                                                    <p class="info"><span class="time">2017-03-18 18:26</span></p>
                                                </div>
                                                <!-- 回复表单默认隐藏 -->
                                                <div class="replycontainer layui-hide">
                                                    <form class="layui-form" action="">
                                                        <div class="layui-form-item">
                                                            <textarea name="replyContent" lay-verify="replyContent"
                                                                      placeholder="请输入回复内容" class="layui-textarea"
                                                                      style="min-height:80px;"></textarea>
                                                        </div>
                                                        <div class="layui-form-item">
                                                            <button class="layui-btn layui-btn-mini"
                                                                    lay-submit="formReply" lay-filter="formReply">提交
                                                            </button>
                                                        </div>
                                                    </form>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </fieldset>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- 底部 -->
<@netCommon.commonFooter/>
<!--侧边导航-->
<@netCommon.commonLeft/>
<!--分享窗体 遮罩-->
<@netCommon.commonShare/>

<@netCommon.commonScript/>
<!-- 本页脚本 -->
<script src="${cxt.contextPath}/js/about.js"></script>
</body>
<@netCommon.commonSign/>
<@netCommon.commonLogin/>
<@netCommon.commonUserCenter/>
</html>