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
<style>
    #submit {
        position: relative;
        width: 206px;
        height: 60px;
        line-height: 60px;
        font-size: 26px;
        font-weight: 300;
    }

    .p {
        text-align: center;
        margin: 10px;
        font-size: 0;
        padding: 0;
        -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
    }
</style>
<body>

<@netCommonNav.commonNavNormal/>

<!-- 主体（一般只改变这里的内容） -->
<div class="blog-body">

    <!-- 这个一般才是真正的主体内容 -->
    <div class="blog-container">
        <div class="blog-main">
        <@netCommon.commonTips/>
            <!--左边文章列表-->
            <div style="margin: 5px 0px">
                <textarea id="layer-edit"></textarea>

            </div>
            <p class="p">
                <button id="submit" class="layui-btn">
                    发表
                </button>
            </p>


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