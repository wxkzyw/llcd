<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/WEB-INF/views/modules/cms/front/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>江苏罗乐传动有限公司</title>
    <!-- Bootstrap -->
    <link href="${ctxStatic}/css/bootstrap.min.css" rel="stylesheet">
    <!--common.css-->
    <link href="${ctxStatic}/css/common.css" rel="stylesheet">
    <!--index.css-->
    <link href="${ctxStatic}/css/index.css" rel="stylesheet">
    <!--style.css-->
    <link href="${ctxStatic}/css/style.css" rel="stylesheet">
    <!--iconfont.css-->
    <link href="${ctxStatic}/fonts/iconfont.css" rel="stylesheet">
    <!--swiper.min.css--->
    <link href="${ctxStatic}/css/swiper.min.css" rel="stylesheet">
    <!--video.js-->
    <link href="${ctxStatic}/css/video-js.min.css" rel="stylesheet">

    <link rel="shortcut icon" href="${ctxStatic}/images/logo4.png" type="image/x-icon" />

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->

</head>
<body ontouchstart="">
<div class="index-wrap">
    <!--nav-->
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed nav-menu" data-toggle="collapse" data-target="#nav-menu" aria-expanded="false">
                    <span class="sr-only">导航</span>
                    <span class="iconfont icon-caidandaohang" id="icon-menu"></span>
                </button>
                <a class="navbar-brand navbar-left" href="${pageContext.request.contextPath}/f/cnSimpleIndex">
                    <img src="${ctxStatic}/images/logo.png" alt="logo" class="img-responsive">
                    <span class="navbar-text">江苏罗乐传动有限公司</span>
                </a>
            </div>

            <div class="collapse navbar-collapse" id="nav-menu">
                <ul class="nav navbar-nav text-center nav-list navbar-right">
                    <li><a href="${pageContext.request.contextPath}/f/cnSimpleIndex">首页</a></li>
                    <li><a href="${pageContext.request.contextPath}/f/cnSimpleAbout">关于罗乐</a></li>
                    <li><a href="${pageContext.request.contextPath}/f/cnSimpleNewsList">新闻中心</a></li>
                    <li class="active"><a href="${pageContext.request.contextPath}/f/cnSimpleProductList">产品中心</a></li>
                    <li><a href="${pageContext.request.contextPath}/f/cnSimpleProductApplicaiton">产品应用</a></li>
                    <li><a href="${pageContext.request.contextPath}/f/contact">联系我们</a></li>
                    <li class="dropdown">
                        <a href="${pageContext.request.contextPath}/f/cnSimpleDirectoryList" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                            资料下载
                            <!--资料下载 <span class="caret triangle"></span>-->
                        </a>
                        <ul class="dropdown-menu text-center download">
                            <li class="text-center"><a href="${pageContext.request.contextPath}/f/cnSimpleDirectoryList">产品目录</a></li>
                            <li class="text-center"><a href="${pageContext.request.contextPath}/f/cnSimpleManualList">保养手册</a></li>
                        </ul>
                    </li>
                    <li class="dropdown" id="language">
                        <a href="${pageContext.request.contextPath}/f/cnSimpleProductList" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                            简体<span class="caret triangle"></span>
                        </a>
                        <ul class="dropdown-menu text-center language-list">
                            <li class="text-center"><a href="${pageContext.request.contextPath}/f/cnComplexProductList">繁体</a></li>
                            <li class="text-center"><a href="${pageContext.request.contextPath}/f/cnSimpleProductList">简体</a></li>
                            <li class="text-center"><a href="${pageContext.request.contextPath}/f/englishProductList">英文</a></li>
                        </ul>
                    </li>
                </ul>

            </div>
        </div>
    </nav>

    <!--products - banner-->
    <section class="banner">
        <img src="${ctxStatic}/images/aboutcnsimple.png" alt="产品中心" class="img-responsive">
    </section>

    <!--products list-->
    <section class="products content-wrap">
        <div class="container-fluid">
            <div class="title-bread">
                <p>
                    <a href="${pageContext.request.contextPath}/f/cnSimpleIndex">首页</a> >
                    <a href="${pageContext.request.contextPath}/f/cnSimpleProductList">产品中心</a>
                </p>
            </div>
            <div class="main-content">
                <ul class="products-list row list-unstyled">
                    <c:forEach items="${products}" var="product">
                        <li class="products-item col-lg-4 col-md-6 col-sm-6 col-xs-12">
                            <a href="${pageContext.request.contextPath}/f/cnSimpleProductDetails/${product.id}">
                                <div class="products-wrap products-item-wrap">
                                    <img src="http://www.tsuntien.com/userfiles/1/images/ProductCenter/${product.description}" alt="${product.imgName}" class="img-responsive">
                                    <p class="">${product.imgName}</p>
                                </div>
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </section>

    <!--footer-->
    <footer class="footer bg-gray">
        <!--<ul class="footer-top list-inline">-->
        <!--<li><a href="index.html">首页</a></li>-->
        <!--<li><a href="about.html">关于村田</a></li>-->
        <!--<li><a href="news-list.html">新闻中心</a></li>-->
        <!--<li><a href="#">产品中心</a></li>-->
        <!--<li><a href="#">产品应用</a></li>-->
        <!--<li><a href="#">联系我们</a></li>-->
        <!--<li><a href="#">资料下载</a></li>-->
        <!--<li><a href="#">网站地图</a></li>-->
        <!--</ul>-->
        <div class="footer-body">
            <div class="row">
                <div class="footer-contact col-lg-12 col-md-12 col-sm-12">
                    <div class="row">
                        <%--<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 addr">--%>
                            <%--<div class="clearfix">--%>
                                <%--<p class="pull-left"><span class="iconfont icon-gongsi"></span></p>--%>
                                <%--<p>村田精密股份有限公司</p>--%>
                            <%--</div>--%>
                            <%--<div class="clearfix">--%>
                                <%--<p class="pull-left"><span class="iconfont icon-dizhi1"></span></p>--%>
                                <%--<p>43750台中市大甲区中山路一段312路</p>--%>
                            <%--</div>--%>
                            <%--<div class="clearfix">--%>
                                <%--<p class="pull-left"><span class="iconfont icon-iconfontdianhua4"></span></p>--%>
                                <%--<p>04-26888973</p>--%>
                            <%--</div>--%>
                            <%--<div class="clearfix">--%>
                                <%--<p class="pull-left"><span class="iconfont icon-zuoji-"></span></p>--%>
                                <%--<p>04-26888973</p>--%>
                            <%--</div>--%>
                            <%--<div class="clearfix">--%>
                                <%--<p class="pull-left"><span class="iconfont icon-youjian"></span></p>--%>
                                <%--<p>support@tsuntien.com.tv</p>--%>
                            <%--</div>--%>
                            <%--<div class="clearfix">--%>
                                <%--<p class="pull-left"><span class="iconfont icon-wangzhi"></span></p>--%>
                                <%--<p><a href="http://www.tsuntien.com/">www.tsuntien.com</a></p>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 addr">
                            <div class="clearfix">
                                <p class="pull-left"><span class="iconfont icon-gongsi"></span></p>
                                <p>江苏罗乐传动有限公司（村田精密昆山工厂）</p>
                            </div>
                            <div class="clearfix">
                                <p class="pull-left"><span class="iconfont icon-dizhi1"></span></p>
                                <p>地址：江苏省昆山市城北西路2888号</p>
                            </div>
                            <div class="clearfix">
                                <p class="pull-left"><span class="iconfont icon-iconfontdianhua4"></span></p>
                                <p>电话：0512-57758288</p>
                            </div>
                            <div class="clearfix">
                                <p class="pull-left"><span class="iconfont icon-zuoji-"></span></p>
                                <p>传真：0512-57758282</p>
                            </div>
                            <div class="clearfix">
                                <p class="pull-left"><span class="iconfont icon-shouji"></span></p>
                                <p>联系人手机：18021291668（乔先生）</p>
                            </div>
                            <div class="clearfix">
                                <p class="pull-left"><span class="iconfont icon-youjian"></span></p>
                                <p>E-Mail：George.qiao@tsuntien.com</p>
                            </div>
                            <div class="clearfix">
                                <p class="pull-left"><span class="iconfont icon-wangzhi"></span></p>
                                <p><a href="http://www.tsuntien.com/">www.tsuntien.com</a></p>
                            </div>
                        </div>
                        <%--<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 addr">--%>
                            <%--<div class="clearfix">--%>
                                <%--<p class="pull-left"><span class="iconfont icon-gongsi"></span></p>--%>
                                <%--<p>村田精密华南营业部</p>--%>
                            <%--</div>--%>
                            <%--<div class="clearfix">--%>
                                <%--<p class="pull-left"><span class="iconfont icon-dizhi1"></span></p>--%>
                                <%--<p>地址：深圳市龙华区观澜街道黎光工业区19号2楼</p>--%>
                            <%--</div>--%>
                            <%--<div class="clearfix">--%>
                                <%--<p class="pull-left"><span class="iconfont icon-iconfontdianhua4"></span></p>--%>
                                <%--<p>电话：0755-23311144</p>--%>
                            <%--</div>--%>
                            <%--<div class="clearfix">--%>
                                <%--<p class="pull-left"><span class="iconfont icon-shouji"></span></p>--%>
                                <%--<p>联系人手机：18021291668（乔先生）</p>--%>
                            <%--</div>--%>
                            <%--<div class="clearfix">--%>
                                <%--<p class="pull-left"><span class="iconfont icon-youjian"></span></p>--%>
                                <%--<p>E-mail：George.qiao@tsuntien.com</p>--%>
                            <%--</div>--%>
                            <%--<div class="clearfix">--%>
                                <%--<p class="pull-left"><span class="iconfont icon-wangzhi"></span></p>--%>
                                <%--<p><a href="http://www.tsuntien.com/">www.tsuntien.com</a></p>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    </div>
                </div>

                <!--<div class="footer-ecode col-lg-4 col-md-4 col-sm-4">-->
                <!--<div class="ecode-img">-->
                <!--<div>-->
                <!--<img src="images/ecode-lianxi.png" alt="联系人微信" class="">-->
                <!--<p class="">联系人微信</p>-->
                <!--</div>-->
                <!--</div>-->
                <!--</div>-->
            </div>
        </div>

        <p class="footer-bottom text-center">
            Copyright © 2019 江苏罗乐传动有限公司 All Rights Reserved<br />
            <a href=" http://www.beian.miit.gov.cn/" target="_blank">苏ICP备19025059号-1</a>
        </p>
    </footer>

    <!--return top-->
    <div id="back-top">
        <span class="iconfont icon-dingbu"> </span>
    </div>
</div>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="${ctxStatic}/js/jquery-1.10.1.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。-->
<script src="${ctxStatic}/js/bootstrap.min.js"></script>
<!-- style.js-->
<script src="${ctxStatic}/js/style.js"></script>
<script>
    document.body.addEventListener('touchstart', function(){ });
</script>
</body>
</html>