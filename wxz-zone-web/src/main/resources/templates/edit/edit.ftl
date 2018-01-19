<!DOCTYPE html>
<html>
<#import "/common/common.ftl" as netCommon>
<#import "/common/commonNav.ftl" as netCommonNav>

<@netCommon.commonHtml />

<head>
<@netCommon.commonStyle />
    <!-- 本页样式表 -->
    <link href="${cxt.contextPath}/css/home.css" rel="stylesheet"/>
</head>
<body>

<@netCommonNav.commonNavNormal/>

<!-- 主体（一般只改变这里的内容） -->
<div class="blog-body">

    <!-- 这个一般才是真正的主体内容 -->
    <div class="blog-container">
        <div class="blog-main">
        <@netCommon.commonTips/>
            <!--左边文章列表-->
            <div class="blog-main-left">
                <textarea id="layer-edit""></textarea>
            </div>


            <!--右边小栏目-->
            <div class="blog-main-right">
                <!--占位-->
                <div></div>

            <@netCommon.commonHotArticle/>

            <@netCommon.commonYiLuZouLai/>

            <@netCommon.commonHouTaiJiLu/>

            <@netCommon.commonLink/>
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

<!-- 本页脚本 -->
<@netCommon.commonScript/>
<script src="${cxt.contextPath}/js/edit.js"></script>

<@netCommon.commonSign/>
<@netCommon.commonLogin/>
<@netCommon.commonUserCenter/>
</body>
</html>