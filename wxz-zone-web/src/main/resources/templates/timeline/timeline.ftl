<!DOCTYPE html>
<html>

<#import "/common/common.ftl" as netCommon>
<#import "/common/commonNav.ftl" as netCommonNav>

<@netCommon.commonHtml />

<head>
<@netCommon.commonStyle />
    <!-- 本页样式表 -->
    <link href="${cxt.contextPath}/css/timeline.css" rel="stylesheet"/>

</head>
<body>
<!-- 导航 -->
<@netCommonNav.commonNav3/>
<!-- 主体（一般只改变这里的内容） -->
<div class="blog-body">
    <div class="blog-container">
        <blockquote class="layui-elem-quote sitemap layui-breadcrumb shadow">
            <a href="home" title="网站首页">网站首页</a>
            <a href="timeline" title="点点滴滴">点点滴滴</a>
            <a><cite>时光轴</cite></a>
        </blockquote>
        <div class="blog-main">
            <div class="child-nav shadow">
                <span class="child-nav-btn child-nav-btn-this">时光轴</span>
                <span class="child-nav-btn">笔记墙</span>
            </div>
            <div class="timeline-box shadow">
                <div class="timeline-main">
                    <h1><i class="fa fa-clock-o"></i>时光轴<span> —— 记录生活点点滴滴</span></h1>
                    <div class="timeline-line"></div>
                    <div id="test">

                    </div>

                </div>

                <h1 style="padding-top:4px;padding-bottom:2px;margin-top:40px;"><i class="fa fa-hourglass-end"></i>THE
                    END</h1>
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
<script type="text/javascript">
    layui.use('jquery', function () {
        var $ = layui.jquery;
        $(function () {
            $.ajax({
                url: 'timelineAjax',
                type: 'POST',
                data: {pageNo: 1},
                dataType: 'json',
                success: function (data) {
                    console.log(data.data);
                    var  map = data.data;
                    for(var key in map){
                       var html = '  <div class="timeline-year">';
                       html+='   <h2><a class="yearToggle" href="javascript:;">'+key;
                       html+='年</a><i class="fa fa-caret-down fa-fw"></i> </h2>';


                    }

                <#list stringListMap?keys as key >


                    <#list stringListMap.get(year)?keys as month>
                            <div class="timeline-month">
                            <h3 class=" animated fadeInLeft"><a class="monthToggle" href="javascript:;">${month}月</a><i
                    class="fa fa-caret-down fa-fw"></i></h3>
                            <ul>
                        <#list stringListMap.get(year).get(month) as timeline>
                                <li class=" ">
                                <div class="h4  animated fadeInLeft">
                                <p class="date">${timeline.create?string('yyyy-MM-dd HH:mm:ss')}</p>
                                </div>
                                <p class="dot-circle animated "><i class="fa fa-dot-circle-o"></i></p>
                                <div class="content animated fadeInRight">${timeline.content}</div>
                                <div class="clear"></div>
                                </li>
                        </#list>
                            </ul>
                            </div>
                    </#list>
                </#list>


                }
            });

            $('.monthToggle').click(function () {
                $(this).parent('h3').siblings('ul').slideToggle('slow');
                $(this).siblings('i').toggleClass('fa-caret-down fa-caret-right');
            });
            $('.yearToggle').click(function () {
                $(this).parent('h2').siblings('.timeline-month').slideToggle('slow');
                $(this).siblings('i').toggleClass('fa-caret-down fa-caret-right');
            });
        });
    });
</script>
</body>
<@netCommon.commonSign/>
<@netCommon.commonLogin/>
<@netCommon.commonUserCenter/>
</html>