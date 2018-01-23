<!DOCTYPE html>

<!DOCTYPE html>
<html>

<#import "/common/common.ftl" as netCommon>
<#import "/common/commonNav.ftl" as netCommonNav>

<@netCommon.commonHtml />

<head>
<@netCommon.commonStyle />
    <!-- 比较好用的代码着色插件 -->
    <link href="${cxt.contextPath}/css/prettify.css" rel="stylesheet"/>
    <!-- 本页样式表 -->
    <link href="${cxt.contextPath}/css/detail.css" rel="stylesheet"/>
</head>

<body>
<!-- 导航 -->
<@netCommonNav.commonNav1/>
<!-- 主体（一般只改变这里的内容） -->
<div class="blog-body">
    <div class="blog-container">
        <blockquote class="layui-elem-quote sitemap layui-breadcrumb shadow">
            <a href="home" title="网站首页">网站首页</a>
            <a href="article" title="文章专栏">文章专栏</a>
            <input type="hidden" value="${articleDO.id}" id="aid">
            <a><cite>${articleDO.title}</cite></a>
        </blockquote>
        <div class="blog-main">
            <div class="blog-main-left">
                <div class="article-detail shadow">
                    <div class="article-detail-title">
                    ${articleDO.title}
                    </div>

                    <div class="article-detail-info">
                        <span>发表时间：${articleDO.create?string('yyyy-MM-dd HH:mm:ss')}</span>
                        <span>作者：${articleDO.uName}</span>
                        <span>浏览量：${articleDO.accessCount}</span>
                    </div>

                    <div class="article-detail-content">

                    ${articleDO.content}

                        <p>
                            <br/>
                        </p>
                        <p>
                            &nbsp; &nbsp; 关注我的github：<a href="javascript:;" target="_blank"><span
                                style="color:#337FE5;">求star求fork</span></a>
                        </p>
                        <hr/>
                    </div>
                </div>


                <!-- 评论区域 -->
                <div class="blog-module shadow" style="box-shadow: 0 1px 8px #a6a6a6;">
                    <fieldset class="layui-elem-field layui-field-title" style="margin-bottom:0">
                        <legend>来说两句吧</legend>
                        <div class="layui-field-box">
                            <form class="layui-form blog-editor" action="">
                                <div class="layui-form-item">
                                    <textarea name="editorContent" lay-verify="content" id="remarkEditor"
                                              placeholder="请输入内容" class="layui-textarea layui-hide"></textarea>
                                </div>
                                <div class="layui-form-item">
                                    <button class="layui-btn" lay-submit="formRemark" lay-filter="formRemark">提交评论
                                    </button>
                                </div>
                            </form>
                        </div>
                    </fieldset>
                    <div class="blog-module-title">最新评论</div>
                    <ul class="blog-comment">
                    <#list articleDO.articleMemoDOList as articleMemoDO>
                        <li>

                            <div class="comment-parent">
                                <img src="${articleMemoDO.img}" alt="${articleMemoDO.uName}"/>
                                <div class="info">
                                    <span class="username">${articleMemoDO.uName}</span>

                                </div>
                                <div class="content">
                                ${articleMemoDO.memo}
                                </div>
                                <p class="info info-footer">
                                    <span class="time">${articleMemoDO.create?string('yyyy-MM-dd HH:mm:ss')}</span>
                                    &nbsp;
                                    <a class="btn-reply" href="javascript:;" onclick="btnReplyClick(this)">回复</a>
                                </p>
                            </div>
                            <hr>
                            <#list articleMemoDO.articleMemoSecondDOList as articleMemoSecondDO>
                                <div class="comment-child">
                                    <img src="${articleMemoSecondDO.img}"
                                         alt="${articleMemoSecondDO.uName}">
                                    <div class="info"><span
                                            class="username">${articleMemoSecondDO.uName}</span><span>${articleMemoSecondDO.memo}</span>
                                    </div>
                                    <p class="info"><span
                                            class="time">${articleMemoSecondDO.create?string('yyyy-MM-dd HH:mm:ss')}</span>
                                    </p>
                                </div>

                            </#list>
                            <div class="replycontainer layui-hide">
                                <form class="layui-form" action="">
                                    <input type="hidden" name="parent_key"
                                           value="${articleMemoDO.id}">

                                    <div class="layui-form-item">
                                            <textarea name="replyContent" lay-verify="replyContent"
                                                      placeholder="请输入内容"
                                                      class="layui-textarea"
                                                      style="min-height:80px;"></textarea>
                                    </div>

                                    <div class="layui-form-item">
                                        <button class="layui-btn layui-btn-mini" lay-submit="formReply"
                                                lay-filter="formReply">提交
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


            <div class="blog-main-right">
                <!--右边悬浮 平板或手机设备显示-->
                <div class="category-toggle"><i class="fa fa-chevron-left"></i></div>
                <!--这个div位置不能改，否则需要添加一个div来代替它或者修改样式表-->
                <div class="article-category shadow">
                    <div class="article-category-title">分类导航</div>
                <#list articleCategoryList as articleCategory>
                    <a href="javascript:layer.msg(&#39;${articleCategory.name}&#39;)">${articleCategory.name}</a>
                </#list>
                    <div class="clear"></div>
                </div>

            <@netCommon.commonHotArticle/>


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

<@netCommon.commonScript/>
<!-- 比较好用的代码着色插件 -->
<script src="${cxt.contextPath}/js/prettify.js"></script>
<!-- 本页脚本 -->
<script src="${cxt.contextPath}/js/detail.js"></script>

</body>
<@netCommon.commonSign/>
<@netCommon.commonLogin/>
<@netCommon.commonUserCenter/>
</html>