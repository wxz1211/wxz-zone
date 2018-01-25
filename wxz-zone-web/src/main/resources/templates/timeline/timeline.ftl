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
<@netCommonNav.commonNav/>
<!-- 主体（一般只改变这里的内容） -->
<div class="blog-body">
    <div class="blog-container">
        <blockquote class="layui-elem-quote sitemap layui-breadcrumb shadow">
            <a href="home" title="网站首页">首页</a>
            <a href="timeline" title="一路走来">一路走来</a>
            <a><cite>发展历程</cite></a>
        </blockquote>
        <div class="blog-main">
            <div class="child-nav shadow">
                <span class="child-nav-btn child-nav-btn-this">一路走来</span>
                <span class="child-nav-btn">笔记墙</span>
            </div>
            <div class="timeline-box shadow">
                <div class="timeline-main">
                    <h1><i class="fa fa-clock-o"></i>发展历程<span> —— 记录生活点点滴滴</span></h1>
                    <div class="timeline-line"></div>
                    <div id="time_line">

                    </div>
                </div>
                <h1 align="center" style="
                padding-top:4px;padding-bottom:2px;margin-top:40px;"><i
                        class="fa fa-hourglass-end"></i>THE
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
                    if (data.code != 0) {
                        return;
                    }
                    var yearMap = data.data;
                    var html = '';
                    for (var year in yearMap) {
                        html += '  <div class="timeline-year">';
                        html += '   <h2><a class="yearToggle" href="javascript:;">' + year;
                        html += '年</a><i class="fa fa-caret-down fa-fw"></i> </h2>';
                        var monthMap = yearMap[year];
                        for (var month in monthMap) {
                            html += '  <div class="timeline-month">';
                            html += '  <h3 class=" animated fadeInLeft"><a class="monthToggle" href="javascript:;">' + month.substring(4) + '月</a>';
                            html += '<i class="fa fa-caret-down fa-fw"></i></h3>';
                            html += '<ul>';
                            var list = monthMap[month];
                            for (var i = 0; i < list.length; i++) {
                                html += '<li class=" ">';
                                html += '  <div class="h4  animated fadeInLeft">';
                                html += ' <p class="date">' + timeTrans(list[i].create) + '</p> </div>';
                                html += '<p class="dot-circle animated "><i class="fa fa-dot-circle-o"></i></p>';
                                html += '<div class="content animated fadeInRight">' + list[i].content + '</div>';
                                html += '<div class="clear"></div> </li>'
                            }
                            html += ' </ul> </div>';
                        }
                        html += '</div>';
                    }
                    $('#time_line').html(html);
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

    function timeTrans(date) {
        var date = new Date(date);//如果date为13位不需要乘1000
        var Y = date.getFullYear() + '-';
        var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
        var D = (date.getDate() < 10 ? '0' + (date.getDate()) : date.getDate()) + ' ';
        var h = (date.getHours() < 10 ? '0' + date.getHours() : date.getHours()) + ':';
        var m = (date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes()) + ':';
        var s = (date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds());
        return Y + M + D + h + m + s;
    }
</script>
</body>
<@netCommon.commonSign/>
<@netCommon.commonLogin/>
<@netCommon.commonUserCenter/>
</html>