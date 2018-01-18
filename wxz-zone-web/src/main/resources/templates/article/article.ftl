<!DOCTYPE html>
<html>

<#import "/common/common.ftl" as netCommon>
<#import "/common/commonNav.ftl" as netCommonNav>

<@netCommon.commonHtml />

<head>
<@netCommon.commonStyle />
    <link href="${cxt.contextPath}/css/article.css" rel="stylesheet"/>
</head>
<body>
<!-- 导航 -->
<@netCommonNav.commonNav1/>

<!-- 主体（一般只改变这里的内容） -->
<div class="blog-body">
    <div class="blog-container">
        <blockquote class="layui-elem-quote sitemap layui-breadcrumb shadow">
            <a href="../home/home.ftl" title="网站首页">网站首页</a>
            <a><cite>文章专栏</cite></a>
        </blockquote>
        <div class="blog-main">
            <div class="blog-main-left">
                <div class="shadow"
                     style="text-align:center;font-size:16px;padding:40px 15px;background:#fff;margin-bottom:15px;">
                    未搜索到与【<span style="color: #FF5722;">keywords</span>】有关的文章，随便看看吧！
                </div>
                <div id="blog-main-left-body">


                </div>

            </div>
            <div class="blog-main-right">
                <div class="blog-search">
                    <form class="layui-form" action="">
                        <div class="layui-form-item">
                            <div class="search-keywords  shadow">
                                <input type="text" name="keywords" lay-verify="required" placeholder="输入关键词搜索"
                                       autocomplete="off" class="layui-input">
                            </div>
                            <div class="search-submit  shadow">
                                <a class="search-btn" lay-submit="formSearch" lay-filter="formSearch"><i
                                        class="fa fa-search"></i></a>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="article-category shadow">
                    <div class="article-category-title">分类导航</div>
                    <a href="javascript:layer.msg(&#39;切换到相应分类&#39;)">ASP.NET MVC</a>
                    <a href="javascript:layer.msg(&#39;切换到相应分类&#39;)">SQL Server</a>
                    <div class="clear"></div>
                </div>
                <div class="blog-module shadow">
                    <div class="blog-module-title">作者推荐</div>
                    <ul class="fa-ul blog-module-ul">
                        <li><i class="fa-li fa fa-hand-o-right"></i><a href="../detail/detail.ftl">Web安全之跨站请求伪造CSRF</a>
                        </li>
                        <li><i class="fa-li fa fa-hand-o-right"></i><a href="../detail/detail.ftl">ASP.NET MVC
                            防范跨站请求伪造（CSRF）</a>
                        </li>

                    </ul>
                </div>
                <div class="blog-module shadow">
                    <div class="blog-module-title">随便看看</div>
                    <ul class="fa-ul blog-module-ul">
                        <li><i class="fa-li fa fa-hand-o-right"></i><a
                                href="../detail/detail.ftl">一步步制作时光轴（一）（HTML篇）</a></li>
                        <li><i class="fa-li fa fa-hand-o-right"></i><a href="../detail/detail.ftl">ASP.NET
                            MVC制作404跳转（非302和200）</a></li>
                        <li><i class="fa-li fa fa-hand-o-right"></i><a href="../detail/detail.ftl">ASP.NET MVC
                            防范跨站请求伪造（CSRF）</a>
                        </li>

                    </ul>
                </div>
                <!--右边悬浮 平板或手机设备显示-->
                <div class="category-toggle"><i class="fa fa-chevron-left"></i></div>
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


<script>
    layui.use(['laypage', 'layer', 'jquery'], function () {
        var laypage = layui.laypage
                , layer = layui.layer
                , jquery = layui.jquery;
        paging(1);

        function paging(pageNo) {
            var index = layer.load(2, {shade: false});
            jquery.ajax({
                url: 'article/getArticleByPageNo',
                type: 'POST',
                data: {pageNo: pageNo},
                dataType: 'json',
                success: function (data) {

                    var totalCount = data.data.totalCount;
                    var dataList = data.data.dataList;
                    var currentPageNo = data.data.currentPageNo;
                    var html = '';
                    for (var i = 0; i < dataList.length; i++) {
                        html +=
                                '<div class="article shadow">'
                                + '<div class="article-left">';
                        if (dataList[i].img == null) {
                            html += '<img src="" alt="标题" style="width: 100% ;height: 100%"/>';
                        } else {
                            html += '<img src="' + dataList[i].img + '" alt="标题" style="width: 100% ;height: 100%"/>';
                        }

                        html += '</div> '
                                + '<div class="article-right"><div class="article-title">'
                                + '<a href="detail">' + dataList[i].title + '</a></div>'
                                + '<div class="article-abstract">'
                                //+ dataList[i].content
                                + 'linux写时复制技术'
                                + '</div></div>'
                                + '<div class="clear"></div><div class="article-footer">'
                                + '<span><i class="fa fa-clock-o"></i>&nbsp;&nbsp;' + dataList[i].create + '</span>'
                                + '<span class="article-author"><i class="fa fa-user"></i>&nbsp;&nbsp;' + dataList[i].uName + '</span>'
                                + '<span><i class="fa fa-tag"></i>&nbsp;&nbsp;<a href="#">' + dataList[i].tag + '</a></span>'
                                + '<span class="article-viewinfo"><i class="fa fa-eye"></i>&nbsp;0</span>'
                                + '<span class="article-viewinfo"><i class="fa fa-commenting"></i>&nbsp;4</span>'
                                + '</div> </div>'
                    }

                    html += '<div id="article" class="article"></div>';
                    layer.close(index);
                    jquery("#blog-main-left-body").html(html);


                    laypage.render({
                        elem: 'article'
                        , count: totalCount
                        , curr: currentPageNo || 1
                        , layout: ['count', 'prev', 'page', 'next', 'limit', 'skip']
                        , jump: function (obj, first) {
                            if (!first) {
                                paging(obj.curr);
                            }
                        }
                    })
                }
            });
        }


    });
</script>
</body>
<@netCommon.commonSign/>
<@netCommon.commonLogin/>
<@netCommon.commonUserCenter/>
</html>