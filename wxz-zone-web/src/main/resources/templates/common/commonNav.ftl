<#macro commonNav>
<!-- 导航 -->
<nav class="blog-nav layui-header">
    <div class="blog-container">
        <!-- 不落阁 -->
        <a class="blog-logo" href="home">Cool</a>
        <!-- 导航菜单 -->
        <ul class="layui-nav" lay-filter="nav">
            <li class="layui-nav-item">
                <a href="home"><i class="fa fa-home fa-fw"></i>&nbsp;首页</a>
            </li>
            <li class="layui-nav-item">
                <a href="article"><i class="fa fa-file-text fa-fw"></i>&nbsp;博客列表</a>
            </li>
            <li class="layui-nav-item">
                <a href="resource"><i class="fa fa-tags fa-fw"></i>&nbsp;资源分享</a>
            </li>
            <li class="layui-nav-item">
                <a href="timeline"><i class="fa fa-hourglass-half fa-fw"></i>&nbsp;一路走来</a>
            </li>
            <li class="layui-nav-item">
                <a href="about"><i class="fa fa-info fa-fw"></i>&nbsp;关于我</a>
            </li>
            <li style="left:10%" class="layui-nav-item">
                <#if currentUser?exists>
                    <a href="javascript:;"><i class="layui-icon" style="font-size: 20px; color: rgba(59,175,255,0.78);">&#xe60c;</i>&nbsp;${currentUser.name}
                    </a>
                    <dl class="layui-nav-child"> <!-- 二级菜单 -->
                        <dd><a id="userCenter" href="javascript:;">个人中心</a></dd>
                        <dd><a id="logout" href="javascript:;">退出</a></dd>
                    </dl>
                <#else>
                    <a href="javascript:;"><i class="layui-icon" style="font-size: 20px; color:rgba(59,175,255,0.78);">&#xe6af;</i>&nbsp;来呀&nbsp;快活啊</a>
                    <dl class="layui-nav-child">
                        <dd><a id="login" href="javascript:;">登录</a></dd>
                        <dd><a id="sign" href="javascript:">注册</a></dd>
                    </dl>
                </#if>
            </li>
        </ul>
        <!-- 手机和平板的导航开关 -->
        <a class="blog-navicon" href="javascript:;">
            <i class="fa fa-navicon"></i>
        </a>
    </div>
</nav>
</#macro>