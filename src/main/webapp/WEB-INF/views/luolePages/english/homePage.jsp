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
    <title>Tsuntien precison CO.,LTD</title>
    <!-- Bootstrap -->
    <link href="${ctxStatic}/css/bootstrap.min.css" rel="stylesheet">
    <!--common.css-->
    <link href="${ctxStatic}/css/common-en.css" rel="stylesheet">
    <!--index.css-->
    <link href="${ctxStatic}/css/index.css" rel="stylesheet">
    <!--iconfont.css-->
    <link href="${ctxStatic}/fonts/iconfont.css" rel="stylesheet">
    <!--swiper.min.css--->
    <link href="${ctxStatic}/css/swiper.min.css" rel="stylesheet">
    <!--video.js-->
    <link href="${ctxStatic}/css/video-js.min.css" rel="stylesheet">

    <link rel="shortcut icon" href="${ctxStatic}/images/logo4.png" type="image/x-icon" />

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${ctxStatic}/js/jquery-1.10.1.min.js"></script>

    <!-- 加载 Bootstrap 的所有 JavaScript 插件。-->
    <script src="${ctxStatic}/js/bootstrap.min.js"></script>

    <!--首页幻灯片swiper 插件-->
    <script src="${ctxStatic}/js/swiper.min.js"></script>

    <!--video.min.js-->
    <script src="${ctxStatic}/js/video.min.js"></script>

    <script src="${ctxStatic}/js/index.js"></script>

    <!--page js-->
    <script src="${ctxStatic}/js/query.js"></script>
    <script src="${ctxStatic}/js/paging.js"></script>

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
                    <span class="navbar-text">Tsuntien precison CO.,LTD</span>
                </a>
            </div>

            <div class="collapse navbar-collapse" id="nav-menu">
                <ul class="nav navbar-nav text-center nav-list navbar-right">
                    <li class="active"><a href="${pageContext.request.contextPath}/f/englishIndex">Home</a></li>
                    <li><a href="${pageContext.request.contextPath}/f/englishAbout">About</a></li>
                    <li><a href="${pageContext.request.contextPath}/f/englishNewsList">News</a></li>
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
                        <a href="${pageContext.request.contextPath}/f/englishIndex" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                            English<span class="caret triangle"></span>
                        </a>
                        <ul class="dropdown-menu text-center language-list">
                            <li class="text-center"><a href="${pageContext.request.contextPath}/f/cnComplexIndex">Traditional</a></li>
                            <li class="text-center"><a href="${pageContext.request.contextPath}/f/cnSimpleIndex">Simplified</a></li>
                            <li class="text-center"><a href="${pageContext.request.contextPath}/f/englishIndex">English</a></li>
                        </ul>
                    </li>
                </ul>

            </div>
        </div>
    </nav>

    <!--banner-->
    <section class="banner swiper-container">
        <div class="swiper-wrapper">
            <c:forEach items="${indexImgs}" var="bean" varStatus="status">
                <div class="swiper-slide banner-item">
                    <img src="${pageContext.request.contextPath}/userfiles/1/images/homePage-english/${bean.imgName}${bean.imgSuffix}" alt="banner" class="img-responsive">
                </div>
            </c:forEach>

        </div>
        <!-- 如果需要分页器 -->
        <div class="swiper-pagination"></div>
    </section>

    <!--about-->
    <section class="about content-wrap">
        <div class="container-fluid">
            <div class="title text-center">
                <h3>Company Introduction</h3>
               <%-- <p>公司简介</p>--%>
            </div>
            <div class="row about-content">
                <div class="col-md-5 about-video">
                    <video id="aboutVideo" class="video-js vjs-default-skin" controls poster="${ctxStatic}/images/about-cover.png" preload="auto" webkit-playsinline="true" playsinline="true" x-webkit-airplay="allow"  x5-video-player-type="h5" x5-video-player-fullscreen="true" x5-video-orientation="portraint">
                        <source src="${pageContext.request.contextPath}/userfiles/1/files/video/about.mp4" type="video/mp4">
                    </video>
                </div>
                <div class="col-md-7 about-describe">
                    ${indexCompanyIntroduce.content}
                    <a href="${pageContext.request.contextPath}/f/englishAbout" class="btn btn-default">More</a>
                </div>
            </div>
        </div>
    </section>

    <!--products-->
    <section class="products content-wrap bg-gray">
        <div class="container-fluid">
            <div class="title text-center">
                <h3>Product Center</h3>
                <%--<p>产品中心</p>--%>
            </div>
            <div class="row main-content">
                <div class="col-md-5 products-video">
                    <div class="products-video-wrap">
                        <video id="productsVideo" class="video-js vjs-default-skin" controls poster="${ctxStatic}/images/products-cover.png">
                            <source src="${pageContext.request.contextPath}/userfiles/1/files/video/products.mp4" type="video/mp4">
                        </video>
                        <div class="row">
                            <div class="col-md-6 col-xs-12 col-sm-12 products-directory">
                                <h3>TSUNTIEN Products Series</h3>
                                <ul class="list-unstyled">
                                    <c:forEach items="${TSUNTIENproducts}" var="product">
                                        <li><a href="${pageContext.request.contextPath}/f/englishProductDetails/${product.id}">${product.title}</a></li>
                                    </c:forEach>
                                </ul>
                                <a href="${pageContext.request.contextPath}/f/englishProductList" class="btn btn-default">More</a>
                            </div>
                            <div class="col-md-6 col-xs-12 col-sm-12 data-download">
                                <!--点击下载跳转到下载页面-->
                                <h3>Download</h3>
                                <p>Products Catalogue、Maintenance Manual</p>
                                <a href="${pageContext.request.contextPath}/f/englishDirectoryList" class="btn btn-default">Download</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-7">
                    <ul class="row products-list list-unstyled">
                        <c:forEach items="${products}" var="product">
                            <li class="products-item col-md-4 col-xs-12 col-sm-6">
                                <a href="${pageContext.request.contextPath}/f/englishProductDetails/${product.id}">
                                    <div class="products-wrap">
                                        <img src="${pageContext.request.contextPath}/userfiles/1/images/ProductCenter/${product.description}" alt="${product.imgName}" class="img-responsive">
                                        <p>${product.imgName}</p>
                                    </div>
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </section>

    <!--news-->
    <section class="news content-wrap">
        <div class="container-fluid">
            <div class="title text-center">
                <h3>News Center</h3>
                <%--<p>新闻中心</p>--%>
            </div>
            <div class="content">
                <c:forEach items="${news}" var="bean">
                    <div class="row news-item">
                        <div class="col-lg-3 col-md-3 col-xs-12 col-sm-12 news-cover">
                            <a href="${pageContext.request.contextPath}/f/englishNewsDetails/${bean.id}"><img src="${pageContext.request.contextPath}/userfiles/1/images/news/${bean.description}" alt=""></a>
                        </div>
                        <div class="col-lg-9 col-md-9 col-xs-12 col-sm-12 news-body">
                            <p class="post-time"><fmt:formatDate pattern="yyyy-MM-dd" value="${bean.updateDate}"/></p>
                            <a href="${pageContext.request.contextPath}/f/englishNewsDetails/${bean.id}"><h4>${bean.title}</h4></a>
                            <a href="${pageContext.request.contextPath}/f/englishNewsDetails/${bean.id}" class="news-content-wrap">
                                <p class="news-content">${bean.articleData.content}</p>
                            </a>
                        </div>
                    </div>
                </c:forEach>

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
                        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 addr">
                            <div class="clearfix">
                                <p class="pull-left"><span class="iconfont icon-gongsi"></span></p>
                                <p>TSUNTIEN Precision Co.,Ltd</p>
                            </div>
                            <div class="clearfix">
                                <p class="pull-left"><span class="iconfont icon-dizhi1"></span></p>
                                <p>No.312,Sec.1,Zhongshan Rd,Dajia Dist,Taichung</p>
                            </div>
                            <div class="clearfix">
                                <p class="pull-left"><span class="iconfont icon-iconfontdianhua4"></span></p>
                                <p>04-26888973</p>
                            </div>
                            <div class="clearfix">
                                <p class="pull-left"><span class="iconfont icon-zuoji-"></span></p>
                                <p>04-26888973</p>
                            </div>
                            <div class="clearfix">
                                <p class="pull-left"><span class="iconfont icon-youjian"></span></p>
                                <p>support@tsuntien.com.tv</p>
                            </div>
                            <div class="clearfix">
                                <p class="pull-left"><span class="iconfont icon-wangzhi"></span></p>
                                <p><a href="http://www.tsuntien.com/">www.tsuntien.com</a></p>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 addr">
                            <div class="clearfix">
                                <p class="pull-left"><span class="iconfont icon-gongsi"></span></p>
                                <p>Jiangsu ROLA drive Co.,Ltd ( TSUNTIEN precision Kunshan factory )</p>
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
                        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 addr">
                            <div class="clearfix">
                                <p class="pull-left"><span class="iconfont icon-gongsi"></span></p>
                                <p>South China Sales Department</p>
                            </div>
                            <div class="clearfix">
                                <p class="pull-left"><span class="iconfont icon-dizhi1"></span></p>
                                <p>Address: 2nd Floor, No. 19, Liguang Industrial Zone, Guanlan Street, Longhua District, Shenzhen</p>
                            </div>
                            <div class="clearfix">
                                <p class="pull-left"><span class="iconfont icon-iconfontdianhua4"></span></p>
                                <p>Phone：0755-23311144</p>
                            </div>
                            <div class="clearfix">
                                <p class="pull-left"><span class="iconfont icon-shouji"></span></p>
                                <p>Contact mobile：18021291668（Mr Qiao）</p>
                            </div>
                            <div class="clearfix">
                                <p class="pull-left"><span class="iconfont icon-youjian"></span></p>
                                <p>E-mail：George.qiao@tsuntien.com</p>
                            </div>
                            <div class="clearfix">
                                <p class="pull-left"><span class="iconfont icon-wangzhi"></span></p>
                                <p><a href="http://www.tsuntien.com/">www.tsuntien.com</a></p>
                            </div>
                        </div>
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
<script>
    document.body.addEventListener('touchstart', function(){ });
</script>
</body>
</html>