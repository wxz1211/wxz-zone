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
    #add_article_submit {
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

<@netCommonNav.commonNav/>

<!-- 主体（一般只改变这里的内容） -->
<div class="blog-body">

    <!-- 这个一般才是真正的主体内容 -->
    <div class="blog-container">
        <div class="blog-main">
            <div style="margin: 30px 0 20px;">
                <fieldset style="padding: 0;border-top: 1px solid #eee;border: none;">
                    <legend style="margin-left: 20px;padding: 0 10px;font-size: 22px;font-weight: 300;">
                        <a style="color: #333;text-decoration: none;">发表文章</a>
                    </legend>
                </fieldset>
            </div>

            <div>
                <form id="add_article_form" class="layui-form" onsubmit="return false;">
                    <div class="layui-form-item">
                        <label class="layui-form-label">文章标题</label>
                        <div class="layui-input-block">
                            <input type="text" name="article_title" lay-verify="article_title"
                                   placeholder="请输入文章标题"
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">文章分类</label>
                        <div class="layui-input-block">
                            <select name="article_category" lay-verify="required">
                                <option value=""></option>
                            <#list articleCategoryList as item>
                                <option value="${item.id}">${item.name}</option>
                            </#list>
                            </select>
                        </div>
                    </div>


                    <div class="layui-form-item">
                        <label class="layui-form-label">文章标签</label>
                        <div class="layui-input-block">
                        <#list articleTagList as item>
                            <input type="checkbox" name="article_tag" title="${item.name}" id="tag${item.id}"
                                  >
                        </#list>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">是否精品</label>
                        <div class="layui-input-block">
                            <input name="article_chosen" lay-skin="switch" lay-text="ON|OFF" type="checkbox">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">是否置顶</label>
                        <div class="layui-input-block">
                            <input name="article_top" lay-skin="switch" lay-text="ON|OFF" type="checkbox">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <div class="layui-upload">
                            <button style="margin: 10px 0px 0px 40px;" type="button" class="layui-btn"
                                    id="article_upload_img">上传文章图片
                            </button>
                            <legend style="margin: 10px 0px 0px 40px;">图片尺寸应小于800*800，且上传图片宽度应小于高度</legend>
                            <div class="layui-upload-list" style="margin: 10px 0px 0px 40px;">
                                <img class="layui-upload-img" id="article_img">
                                <p id="article_img_text"></p>
                            </div>
                        </div>
                    </div>


                    <!--左边文章列表-->
                    <div style="margin: 0px 0px">
                        <textarea id="layer-edit"></textarea>

                    </div>
                    <div class="layui-form-item p">

                        <button id="add_article_submit" lay-submit lay-filter="add_article_form" class="layui-btn">
                            发表
                        </button>
                    </div>


                    <div class="clear"></div>
                </form>
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