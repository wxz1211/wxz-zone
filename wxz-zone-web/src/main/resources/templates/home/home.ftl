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
            canvas.height = window.innerHeight * 1 / 3;
        } else {
            canvas.height = window.innerHeight * 2 / 7;
        }
    </script>
    <!-- 这个一般才是真正的主体内容 -->
    <div class="blog-container">
        <div class="blog-main">
        <@netCommon.commonTips/>
            <!--左边文章列表-->
            <div class="blog-main-left">

                <div class="article shadow">
                    <div class="article-left">
                        <img src="${cxt.contextPath}/images/cover/201703181909057125.jpg"
                             alt="标题"/>
                    </div>
                    <div class="article-right">
                        <div class="article-title">
                            <a href="detail">标题</a>
                        </div>
                        <div class="article-abstract">
                            文章内容简介
                        </div>
                    </div>
                    <div class="clear"></div>
                    <div class="article-footer">
                        <span><i class="fa fa-clock-o"></i>&nbsp;&nbsp;2017-03-18</span>
                        <span class="article-author"><i class="fa fa-user"></i>&nbsp;&nbsp;wxz</span>
                        <span><i class="fa fa-tag"></i>&nbsp;&nbsp;<a href="#">分类</a></span>
                        <span class="article-viewinfo"><i class="fa fa-eye"></i>&nbsp;0</span>
                        <span class="article-viewinfo"><i class="fa fa-commenting"></i>&nbsp;4</span>
                    </div>
                </div>

                <div class="article shadow">
                    <div class="article-left">
                        <img src="${cxt.contextPath}/images/cover/201703181909057125.jpg"
                             alt="标题"/>
                    </div>
                    <div class="article-right">
                        <div class="article-title">
                            <a href="detail">标题</a>
                        </div>
                        <div class="article-abstract">
                            文章内容简介
                        </div>
                    </div>
                    <div class="clear"></div>
                    <div class="article-footer">
                        <span><i class="fa fa-clock-o"></i>&nbsp;&nbsp;2017-03-18</span>
                        <span class="article-author"><i class="fa fa-user"></i>&nbsp;&nbsp;wxz</span>
                        <span><i class="fa fa-tag"></i>&nbsp;&nbsp;<a href="#">分类</a></span>
                        <span class="article-viewinfo"><i class="fa fa-eye"></i>&nbsp;0</span>
                        <span class="article-viewinfo"><i class="fa fa-commenting"></i>&nbsp;4</span>
                    </div>
                </div>
            </div>


            <!--右边小栏目-->
            <div class="blog-main-right">
            <@netCommon.commonIntroduce/>
                <!--占位-->
                <div></div>

            <@netCommon.commonHotArticle/>

            <@netCommon.commonRecentShare/>

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