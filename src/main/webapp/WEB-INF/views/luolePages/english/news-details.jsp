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
    <title>Jiangsu ROLA drive CO.,LTD</title>
    <!-- Bootstrap -->
    <link href="${ctxStatic}/css/bootstrap.min.css" rel="stylesheet">
    <!--common.css-->
    <link href="${ctxStatic}/css/common-en.css" rel="stylesheet">
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
                    <span class="sr-only">Navigation</span>
                    <span class="iconfont icon-caidandaohang" id="icon-menu"></span>
                </button>
                <a class="navbar-brand navbar-left" href="${pageContext.request.contextPath}/f/englishIndex">
                    <img src="${ctxStatic}/images/logo.png" alt="logo" class="img-responsive">
                    <span class="navbar-text">Jiangsu ROLA drive CO.,LTD</span>
                </a>
            </div>

            <div class="collapse navbar-collapse" id="nav-menu">
                <ul class="nav navbar-nav text-center nav-list navbar-right">
                    <li><a href="${pageContext.request.contextPath}/f/englishIndex">Home</a></li>
                    <li><a href="${pageContext.request.contextPath}/f/englishAbout">About</a></li>
                    <li class="active"><a href="${pageContext.request.contextPath}/f/englishNewsList">News</a></li>
                    <li><a href="${pageContext.request.contextPath}/f/englishProductList">Products</a></li>
                    <li><a href="${pageContext.request.contextPath}/f/englishProductApplicaiton">Application</a></li>
                    <li><a href="${pageContext.request.contextPath}/f/englishcontact">Contact</a></li>
                    <li class="dropdown">
                        <a href="${pageContext.request.contextPath}/f/englishDirectoryList" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                            Download
                            <!--资料下载 <span class="caret triangle"></span>-->
                        </a>
                        <ul class="dropdown-menu text-center download">
                            <li class="text-center"><a href="${pageContext.request.contextPath}/f/englishDirectoryList">Directory</a></li>
                            <li class="text-center"><a href="${pageContext.request.contextPath}/f/englishManualList">Manual</a></li>
                        </ul>
                    </li>
                    <li class="dropdown" id="language">
                        <a href="${pageContext.request.contextPath}/f/englishNewsDetails/${article.id}" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                            English<span class="caret triangle"></span>
                        </a>
                        <ul class="dropdown-menu text-center language-list">
                            <li class="text-center"><a href="${pageContext.request.contextPath}/f/cnComplexNewsDetails/${complexArticleID}">Traditional</a></li>
                            <li class="text-center"><a href="${pageContext.request.contextPath}/f/cnSimpleNewsDetails/${simpleArticleID}">Simplified</a></li>
                            <li class="text-center"><a href="${pageContext.request.contextPath}/f/englishNewsDetails/${article.id}">English</a></li>
                        </ul>
                    </li>
                </ul>

            </div>
        </div>
    </nav>

    <!--news - banner-->
    <section class="banner">
        <img src="${ctxStatic}/images/aboutenglish.png" alt="Details" class="img-responsive">
    </section>

    <!--news list-->
    <section class="news content-wrap">
        <div class="container-fluid">
            <div class="title-bread">
                <p>
                    <a href="${pageContext.request.contextPath}/f/englishIndex">Home</a> >
                    <a href="${pageContext.request.contextPath}/f/englishNewsList">News</a>>
                    <a href="${pageContext.request.contextPath}/f/englishNewsDetails/${article.id}">Details</a>
                </p>
            </div>
            <div class="content">
                <div class="news-details">
                    <div class="news-title">
                        <h2>${article.title}</h2>
                        <p> Publication time：<span><fmt:formatDate value="${article.updateDate}"/></span></p>
                    </div>
                    <div class="news-content">
                        <img src="http://www.tsuntien.com/userfiles/1/images/news/${article.description}" alt="" class="text-center img-responsive">
                        ${article.articleData.content}
                    </div>
                    <div class="news-turn">
                        <div class="row">
                            <div class="col-md-5 col-sm-5 col-xs-12 prev">
                                <c:choose>
                                    <c:when test="${prev!=null}">
                                        <a href="${pageContext.request.contextPath}/f/cnSimpleNewsDetails/${prev.id}">
                                            Last article：
                                            <span>${prev.title}</span>
                                        </a>
                                    </c:when>
                                    <c:otherwise>
                                        Last article：none
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <div class="col-md-5 col-sm-5  col-md-offset-2 col-sm-offset-2 col-xs-12 next">
                                <c:choose>
                                    <c:when test="${next!=null}">
                                        <a href="${pageContext.request.contextPath}/f/cnSimpleNewsDetails/${next.id}">
                                            Next article：
                                            <span>${next.title}</span>
                                        </a>
                                    </c:when>
                                    <c:otherwise>
                                        Next article：none
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </div>
                </div>

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
                                <%--<p>TSUNTIEN Precision Co.,Ltd</p>--%>
                            <%--</div>--%>
                            <%--<div class="clearfix">--%>
                                <%--<p class="pull-left"><span class="iconfont icon-dizhi1"></span></p>--%>
                                <%--<p>No.312,Sec.1,Zhongshan Rd,Dajia Dist,Taichung</p>--%>
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
                                <p>Jiangsu ROLA drive Co.,Ltd</p>
                            </div>
                            <div class="clearfix">
                                <p class="pull-left"><span class="iconfont icon-dizhi1"></span></p>
                                <p>Address：No.2888, Chengbei West Road, Kunshan City, Jiangsu Province</p>
                            </div>
                            <div class="clearfix">
                                <p class="pull-left"><span class="iconfont icon-iconfontdianhua4"></span></p>
                                <p>Phone：0512-57758288</p>
                            </div>
                            <div class="clearfix">
                                <p class="pull-left"><span class="iconfont icon-zuoji-"></span></p>
                                <p>Fax：0512-57758282</p>
                            </div>
                            <div class="clearfix">
                                <p class="pull-left"><span class="iconfont icon-shouji"></span></p>
                                <p>Contact mobile：18021291668（Mr Qiao）</p>
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
                                <%--<p>South China Sales Department</p>--%>
                            <%--</div>--%>
                            <%--<div class="clearfix">--%>
                                <%--<p class="pull-left"><span class="iconfont icon-dizhi1"></span></p>--%>
                                <%--<p>Address: 2nd Floor, No. 19, Liguang Industrial Zone, Guanlan Street, Longhua District, Shenzhen</p>--%>
                            <%--</div>--%>
                            <%--<div class="clearfix">--%>
                                <%--<p class="pull-left"><span class="iconfont icon-iconfontdianhua4"></span></p>--%>
                                <%--<p>Phone：0755-23311144</p>--%>
                            <%--</div>--%>
                            <%--<div class="clearfix">--%>
                                <%--<p class="pull-left"><span class="iconfont icon-shouji"></span></p>--%>
                                <%--<p>Contact mobile：18021291668（Mr Qiao）</p>--%>
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
            Copyright © 2019 TSUNTIEN Precision Co.,Ltd All Rights Reserved<br />
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