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
<@netCommonNav.commonNav/>
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
                    <li lay-id="1">关于本站</li>
                    <li lay-id="2">关于作者</li>
                    <li lay-id="3" id="frinedlink">友情链接</li>
                    <li lay-id="4">留言墙</li>
                </ul>
                <div class="layui-tab-content">
                    <div class="layui-tab-item">
                        <div class="aboutinfo">
                            <div class="aboutinfo-figure">
                                <img src="http://www.wangxianzhi.xyz/static/2018_01_25142659342_6_20180125141748.png"
                                     style="width: 100px;height: 100px" alt="cool"/>
                            </div>
                            <p class="aboutinfo-nickname">Cool</p>
                            <p class="aboutinfo-introduce">肥宅又做错了什么</p>
                            <p class="aboutinfo-location"><i class="fa fa-link"></i>&nbsp;&nbsp;
                                <a target="_blank" href="home">www.wangxianzhi.xyz/wxz-zone/home</a>
                            </p>
                            <hr/>
                            <div class="aboutinfo-contact">
                                <a target="_blank" title="网站首页" href="home"><i class="fa fa-home fa-2x"
                                                                               style="font-size:2.5em;position:relative;top:3px"></i></a>
                                <a target="_blank" title="博客列表" href="article"><i
                                        class="fa fa-file-text fa-2x"></i></a>
                                <a target="_blank" title="资源分享" href="resource"><i
                                        class="fa fa-tags fa-2x"></i></a>
                                <a target="_blank" title="一路走来" href="timeline"><i
                                        class="fa fa-hourglass-half fa-2x"></i></a>
                            </div>

                            <fieldset class="layui-elem-field layui-field-title">
                                <legend>简介</legend>
                                <div class="layui-field-box aboutinfo-abstract">
                                ${siteIntroduce.content}
                                </div>
                            </fieldset>
                        </div>
                    </div><!--关于网站End-->
                    <div class="layui-tab-item">
                        <div class="aboutinfo">
                            <div class="aboutinfo-figure">
                                <img src="http://www.wangxianzhi.xyz/static/2018_01_25142659342_6_20180125141748.png"
                                     style="width: 100px;height: 100px" alt="shijia"/>
                            </div>
                            <p class="aboutinfo-nickname">做个小肥宅吧</p>
                            <p class="aboutinfo-introduce">做个小肥宅吧</p>
                            <p class="aboutinfo-location"><i class="fa fa-location-arrow"></i>&nbsp;上海 - 宝山</p>
                            <hr/>

                            <div class="blogerinfo-contact" style="padding: 0px 0 15px 0px;">
                                <a target="_blank" title="豆瓣交流" href="https://www.douban.com/people/wxz1211/"><i
                                        class="fa  fa-slideshare fa-lg"></i> 豆瓣交流</a>&nbsp;&nbsp;&nbsp;
                                <a target="_blank" title="相亲专用"
                                   href="https://www.zhihu.com/people/wangxianzhi1211/activities"><i
                                        class="fa fa-openid fa-lg"></i> 相亲专用</a>

                            </div>

                            <div class="blogerinfo-contact" style="padding: 0px 0 10px 0px;">
                                <a target="_blank" title="相亲简介"
                                   href="http://tieba.baidu.com/home/main?un=%E9%9B%B7%E7%A5%AD%E7%9A%84%E5%AD%98%E5%9C%A8&fr=home"><i
                                        class=" fa fa-twitch fa-lg"></i> 相亲简介</a>&nbsp;&nbsp;&nbsp;
                                <a target="_blank" title="基佬专用" href="https://github.com/wxz1211"><i
                                        class="fa  fa-yelp  fa-lg"></i> 基佬专用</a>
                            </div>

                            <fieldset class="layui-elem-field layui-field-title">
                                <legend>简介</legend>
                                <div class="layui-field-box aboutinfo-abstract abstract-bloger">
                                ${authorIntroduce.content}
                                </div>
                            </fieldset>
                        </div>
                    </div><!--关于作者End-->
                    <div class="layui-tab-item">
                        <div class="aboutinfo">
                            <div class="aboutinfo-figure">
                                <img src="http://www.wangxianzhi.xyz/static/2018_01_25142659342_6_20180125141748.png"
                                     style="width: 100px;height: 100px" alt="友情链接"/>
                            </div>
                            <p class="aboutinfo-nickname">友情链接</p>
                            <p class="aboutinfo-introduce">Name：你个死肥宅~&nbsp;Site:http://www.wangxianzhi.xyz/wxz-zone/home</p>
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
                                    </ul>
                                </div>
                            </fieldset>
                        </div>
                    </div><!--友情链接End-->
                    <div class="layui-tab-item">
                        <div class="aboutinfo">
                            <div class="aboutinfo-figure">
                                <img src="http://www.wangxianzhi.xyz/static/2018_01_25142659342_6_20180125141748.png"
                                     style="width: 100px;height: 100px" alt="留言墙"/>
                            </div>
                            <p class="aboutinfo-nickname">留言墙</p>
                            <p class="aboutinfo-introduce">本页面可留言、吐槽、提问等！</p>
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
                                        <#list leaveMessageDO.leaveMsgDOList as leaveMessageDO>
                                            <li>

                                                <div class="comment-parent">
                                                    <img src="${leaveMessageDO.img}"
                                                         alt="${leaveMessageDO.uName}"/>
                                                    <div class="info info-common-parent">
                                                        <span class="username">${leaveMessageDO.uName}</span>
                                                    </div>
                                                    <div class="content">
                                                        &nbsp;&nbsp;${leaveMessageDO.memo}
                                                    </div>
                                                    <p class="info info-footer"><span
                                                            class="time"></span> ${leaveMessageDO.create?string('yyyy-MM-dd HH:mm:ss')}

                                                        <a
                                                                class="btn-reply"
                                                                href="javascript:;"
                                                                onclick="btnReplyClick(this)"> <i
                                                                class="fa fa-commenting"></i>&nbsp;回复</a>
                                                    </p>
                                                </div>

                                                <hr/>
                                                <#list leaveMessageDO.leaveMsgScdDOList as leaveMsgScdDO>
                                                    <div class="comment-child">
                                                        <img src="${leaveMsgScdDO.img}"
                                                             alt="${leaveMsgScdDO.uName}"/>
                                                        <div class="info">
                                                            <span class="username">${leaveMsgScdDO.uName}</span>
                                                            <span>&nbsp;${leaveMsgScdDO.memo}</span>
                                                        </div>
                                                        <p class="info">
                                                            <span class="time">${leaveMsgScdDO.create?string('yyyy-MM-dd HH:mm:ss')}</span>

                                                            <a class="btn-reply"
                                                               href="javascript:;"
                                                               onclick="btnReplyClickChild(this)"><i
                                                                    class="fa fa-commenting"></i>&nbsp;回复</a>
                                                        </p>
                                                    </div>
                                                </#list>
                                                <!-- 回复表单默认隐藏 -->
                                                <div class="replycontainer layui-hide">
                                                    <form class="layui-form" action="">
                                                        <input type="hidden" name="parent_key"
                                                               value="${leaveMessageDO.id}">
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
                                        </#list>
                                            <div class="layui-flow-more">还没有更多的人评论~QAQ</div>
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