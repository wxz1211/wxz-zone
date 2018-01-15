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

<@netCommonNav.commonNav/>

<!-- 主体（一般只改变这里的内容） -->
<div class="blog-body">
    <!-- canvas -->
    <canvas id="canvas-banner" style="background: #393D49;"></canvas>
    <!--为了及时效果需要立即设置canvas宽高，否则就在home.js中设置-->
    <script type="text/javascript">
        var canvas = document.getElementById('canvas-banner');
        canvas.width = window.document.body.clientWidth - 10;//减去滚动条的宽度
        if (screen.width >= 992) {
            canvas.height = window.innerHeight * 1 / 4;
        } else {
            canvas.height = window.innerHeight * 2 / 9;
        }
    </script>
    <!-- 这个一般才是真正的主体内容 -->
    <div class="blog-container">
        <div class="blog-main">
        <@netCommon.commonTips/>
            <!--左边文章列表-->
            <div class="blog-main-left">
            <#list article.dataList as item>
                <div class="article shadow">
                    <div class="article-left">
                        <img src="${item.img!}"
                             alt="标题" style="width: 100% ;height: 100%"/>
                    </div>
                    <div class="article-right">
                        <div class="article-title">
                            <a href="detail"> ${ item.title!}</a>
                        </div>
                        <div class="article-abstract">
                            <#if item.content?exists>${item.content?substring(0,1)}</#if>
                        </div>
                    </div>
                    <div class="clear"></div>
                    <div class="article-footer">
                        <span><i class="fa fa-clock-o"></i>&nbsp;&nbsp;${item.create?string('yyyy-MM-dd')}</span>
                        <span class="article-author"><i class="fa fa-user"></i>&nbsp;&nbsp;${item.uName}</span>
                        <span><i class="fa fa-tag"></i>&nbsp;&nbsp;<a href="#">${item.tag}</a></span>
                        <span class="article-viewinfo"><i class="fa fa-eye"></i>&nbsp;0</span>
                        <span class="article-viewinfo"><i class="fa fa-commenting"></i>&nbsp;4</span>
                    </div>
                </div>
            </#list>
                <div style="align-content: center;font-size: inherit">查看更多.....</div>
            </div>


            <!--右边小栏目-->
            <div class="blog-main-right">
            <@netCommon.commonIntroduce/>
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

<@netCommon.commonScript/>
<!-- 本页脚本 -->

<script src="${cxt.contextPath}/js/home.js"></script>

</body>
</html>