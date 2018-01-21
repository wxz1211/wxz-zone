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
                        <span>浏览量：12</span>
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
                        <li>
                            <div class="comment-parent">
                                <img src="${cxt.contextPath}/images/Absolutely.jpg" alt="absolutely"/>
                                <div class="info">
                                    <span class="username">Absolutely</span>
                                    <span class="time">2017-03-18 18:46:06</span>
                                </div>
                                <div class="content">
                                    我为大家做了模拟评论功能！还有，这个评论功能也可以改成和留言一样，但是目前没改，有兴趣可以自己改
                                </div>
                            </div>
                        </li>
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