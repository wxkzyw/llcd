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
    <!--style.css-->
    <link href="${ctxStatic}/css/style-en.css" rel="stylesheet">
    <!--iconfont.css-->
    <link href="${ctxStatic}/fonts/iconfont.css" rel="stylesheet">
    <!--swiper.min.css--->
    <link href="${ctxStatic}/css/swiper.min.css" rel="stylesheet">
    <!--video.csss-->
    <link href="${ctxStatic}/css/video-js.min.css" rel="stylesheet">
    <!--page.css-->
    <link rel="stylesheet" href="${ctxStatic}/css/paging.css">

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
                    <span class="navbar-text">Tsuntien precison CO.,LTD</span>
                </a>
            </div>

            <div class="collapse navbar-collapse" id="nav-menu">
                <ul class="nav navbar-nav text-center nav-list navbar-right">
                    <li><a href="${pageContext.request.contextPath}/f/englishIndex">Home</a></li>
                    <li><a href="${pageContext.request.contextPath}/f/englishAbout">About</a></li>
                    <li><a href="${pageContext.request.contextPath}/f/englishNewsList">News</a></li>
                    <li class="active"><a href="${pageContext.request.contextPath}/f/englishProductList">Products</a></li>
                    <li><a href="${pageContext.request.contextPath}/f/englishProductApplicaiton">Application</a></li>
                    <li><a href="${pageContext.request.contextPath}/f/englishcontact">Contact</a></li>
                    <li class="dropdown">
                        <a href="${pageContext.request.contextPath}/f/englishDirectoryList" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                            Download
                        </a>
                        <ul class="dropdown-menu text-center download">
                            <li class="text-center"><a href="${pageContext.request.contextPath}/f/englishDirectoryList">Directory</a></li>
                            <li class="text-center"><a href="${pageContext.request.contextPath}/f/englishManualList">Manual</a></li>
                        </ul>
                    </li>
                    <li class="dropdown" id="language">
                        <a href="${pageContext.request.contextPath}/f/englishProductDetails/${productid}" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                            English<span class="caret triangle"></span>
                        </a>
                        <ul class="dropdown-menu text-center language-list">
                            <li class="text-center"><a href="${pageContext.request.contextPath}/f/cnComplexProductDetails/${productIntros.ft}">Traditional</a></li>
                            <li class="text-center"><a href="${pageContext.request.contextPath}/f/cnSimpleProductDetails/${productIntros.jt}">Simplified</a></li>
                            <li class="text-center"><a href="${pageContext.request.contextPath}/f/englishProductDetails/${productid}">English</a></li>
                        </ul>
                    </li>
                </ul>

            </div>
        </div>
    </nav>

    <!--products - banner-->
    <section class="banner">
        <img src="${ctxStatic}/images/aboutenglish.png" alt="Details" class="img-responsive">
    </section>

    <!--products details-->
    <section class="products content-wrap">
        <div class="container-fluid">
            <div class="title-bread">
                <p>
                    <a href="${pageContext.request.contextPath}/f/englishIndex">Home</a> >
                    <a href="${pageContext.request.contextPath}/f/englishProductList">Products</a>>
                    <a href="${pageContext.request.contextPath}/f/englishProductDetails/${productid}">Details</a>
                </p>
            </div>
            <div class="main-content">
                <ul id="productsTab" class="list-unstyled list-inline switch-tab">
                    <li class="active">
                        <a href="#proIntroduce" data-toggle="tab">
                            Products introduction
                        </a>
                    </li>
                    <li>
                        <a href="#proParameter" data-toggle="tab">
                            Technical parameters
                        </a>
                    </li>
                    <li>
                        <a href="#proCase" data-toggle="tab">
                            Products case
                        </a>
                    </li>
                </ul>
                <div id="productsContent" class="tab-content">
                    <!--产品简介-->
                    <div class="tab-pane fade in active" id="proIntroduce">
                        <div class="row">
                            <c:choose>

                                <c:when test="${introduction.imgName!=null&&introduction.articleData.content!=null}">
                                    <div class="col-md-4 col-sm-12 col-xs-12 products-details-cover">
                                        <c:if test="${newSeriesName==null}">
                                            <img src="${pageContext.request.contextPath}/userfiles/1/files/productSeries/english/${seriesName}/images/productIntroduce/${introduction.description}" alt="${introduction.imgName}" class="img-responsive">
                                        </c:if>
                                        <c:if test="${newSeriesName!=null}">
                                            <img src="${pageContext.request.contextPath}/userfiles/1/files/productSeries/english/${newSeriesName}/images/productIntroduce/${introduction.description}" alt="${introduction.imgName}" class="img-responsive">
                                        </c:if>
                                    </div>
                                    <div class="col-md-8 col-sm-12 col-xs-12">
                                            ${introduction.articleData.content}
                                    </div>
                                </c:when>

                                <c:otherwise>
                                    <div class="col-xs-12 parameter-item">
                                        <div class="text-center parameter-title">
                                            <h4>Please upload the relevant information of the product profile!</h4>
                                        </div>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>

                    <!--技术参数-->
                    <div class="tab-pane fade" id="proParameter">
                        <div class="row">
                            <c:if test="${parameter!=null&&fn:length(parameter)>0}">
                                <c:forEach items="${parameter}" var="bean">

                                    <c:choose>

                                        <c:when test="${bean.imgName=='pro-pt-1'}">

                                            <div class="col-xs-12 parameter-item">
                                                <div class="text-center parameter-title">
                                                    <h4>Ordering Instructions</h4>
                                                    <p>订购说明</p>
                                                </div>
                                                <c:if test="${newSeriesName==null}">
                                                    <img src="${pageContext.request.contextPath}/userfiles/1/files/productSeries/english/${seriesName}/images/productParameter/${bean.imgName}${bean.imgSuffix}" alt="订购说明" class="img-responsive">
                                                </c:if>
                                                <c:if test="${newSeriesName!=null}">
                                                    <img src="${pageContext.request.contextPath}/userfiles/1/files/productSeries/english/${newSeriesName}/images/productParameter/${bean.imgName}${bean.imgSuffix}" alt="订购说明" class="img-responsive">
                                                </c:if>
                                            </div>
                                        </c:when>

                                        <c:when test="${bean.imgName=='pro-pt-2'}">

                                            <div class="col-xs-12 parameter-item">
                                                <div class="text-center parameter-title">
                                                    <h4>Explosion Drawing Of Roller Reducer</h4>
                                                    <p>滚柱减速机部品名称</p>
                                                </div>
                                                <c:if test="${newSeriesName==null}">
                                                    <img src="${pageContext.request.contextPath}/userfiles/1/files/productSeries/english/${seriesName}/images/productParameter/${bean.imgName}${bean.imgSuffix}" alt="订购说明" class="img-responsive">
                                                </c:if>
                                                <c:if test="${newSeriesName!=null}">
                                                    <img src="${pageContext.request.contextPath}/userfiles/1/files/productSeries/english/${newSeriesName}/images/productParameter/${bean.imgName}${bean.imgSuffix}" alt="订购说明" class="img-responsive">
                                                </c:if>
                                            </div>
                                        </c:when>

                                        <c:when test="${bean.imgName=='pro-pt-3'}">

                                            <div class="col-xs-12 parameter-item">
                                                <div class="text-center parameter-title">
                                                    <h4>Motor Mounting selections</h4>
                                                    <p>安装方式选项 </p>
                                                </div>
                                                <c:if test="${newSeriesName==null}">
                                                    <img src="${pageContext.request.contextPath}/userfiles/1/files/productSeries/english/${seriesName}/images/productParameter/${bean.imgName}${bean.imgSuffix}" alt="安装方式选项" class="img-responsive">
                                                </c:if>
                                                <c:if test="${newSeriesName!=null}">
                                                    <img src="${pageContext.request.contextPath}/userfiles/1/files/productSeries/english/${newSeriesName}/images/productParameter/${bean.imgName}${bean.imgSuffix}" alt="安装方式选项" class="img-responsive">
                                                </c:if>
                                            </div>
                                            d                                </c:when>

                                        <c:when test="${bean.imgName=='pro-pt-4'}">

                                            <div class="col-xs-12 parameter-item">
                                                <div class="text-center parameter-title">
                                                    <h4>${seriesName}Technical Specification</h4>
                                                    <p> ${seriesName}性能表</p>
                                                </div>
                                                <c:if test="${newSeriesName==null}">
                                                    <img src="${pageContext.request.contextPath}/userfiles/1/files/productSeries/english/${seriesName}/images/productParameter/${bean.imgName}${bean.imgSuffix}" alt="${seriesName}性能表" class="img-responsive">
                                                </c:if>
                                                <c:if test="${newSeriesName!=null}">
                                                    <img src="${pageContext.request.contextPath}/userfiles/1/files/productSeries/english/${newSeriesName}/images/productParameter/${bean.imgName}${bean.imgSuffix}" alt="${seriesName}性能表" class="img-responsive">
                                                </c:if>
                                            </div>
                                        </c:when>

                                        <c:when test="${bean.imgName=='pro-pt-5'}">
                                            <div class="col-xs-12 parameter-item">
                                                <div class="text-center parameter-title">
                                                    <h4>Drawing&Dimension</h4>
                                                    <p>${seriesName}尺寸图</p>
                                                </div>
                                                <c:if test="${newSeriesName==null}">
                                                    <img src="${pageContext.request.contextPath}/userfiles/1/files/productSeries/english/${seriesName}/images/productParameter/${bean.imgName}${bean.imgSuffix}" alt="${seriesName}尺寸图" class="img-responsive">
                                                </c:if>
                                                <c:if test="${newSeriesName!=null}">
                                                    <img src="${pageContext.request.contextPath}/userfiles/1/files/productSeries/english/${newSeriesName}/images/productParameter/${bean.imgName}${bean.imgSuffix}" alt="${seriesName}尺寸图" class="img-responsive">
                                                </c:if>
                                            </div>
                                        </c:when>

                                        <c:when test="${bean.imgName=='pro-pt-6'}">

                                            <div class="col-xs-12 parameter-item">
                                                <div class="text-center parameter-title">
                                                    <h4>Assembly Precision</h4>
                                                    <p>装配精度需求</p>
                                                </div>
                                                <c:if test="${newSeriesName==null}">
                                                    <img src="${pageContext.request.contextPath}/userfiles/1/files/productSeries/english/${seriesName}/images/productParameter/${bean.imgName}${bean.imgSuffix}" alt="订购说明" class="img-responsive">
                                                </c:if>
                                                <c:if test="${newSeriesName!=null}">
                                                    <img src="${pageContext.request.contextPath}/userfiles/1/files/productSeries/english/${newSeriesName}/images/productParameter/${bean.imgName}${bean.imgSuffix}" alt="订购说明" class="img-responsive">
                                                </c:if>
                                            </div>
                                        </c:when>

                                    </c:choose>

                                </c:forEach>
                            </c:if>
                            <c:if test="${parameter==null||fn:length(parameter)==0}">
                                <div class="col-xs-12 parameter-item">
                                    <div class="text-center parameter-title">
                                        <h4>The specific technical parameters is customized ,therefore , please feel free  contact us at any time . Thanks.</h4>
                                    </div>
                                </div>
                            </c:if>
                        </div>
                    </div>

                    <!--产品案例-->
                    <div class="tab-pane fade" id="proCase">

                        <c:if test="${fn:length(casesVideos)>0}">
                            <!--视频案例-->
                            <div class="row text-center case-video">
                                <c:forEach items="${casesVideos}" var="bean">
                                    <div class="col-md-3 col-sm-4 col-xs-12">
                                        <div class="pro-case-wrap">
                                            <video class="video-js vjs-default-skin" controls poster="${ctxStatic}/images/products-cover.png" preload="auto" webkit-playsinline="true" playsinline="true" x-webkit-airplay="allow"  x5-video-player-type="h5" x5-video-player-fullscreen="true" x5-video-orientation="portraint">
                                                <c:if test="${newSeriesName==null}">
                                                    <source src="${pageContext.request.contextPath}/userfiles/1/files/productSeries/english/${seriesName}/video/${bean.fileName}${bean.fileSuffix}" type="video/mp4">
                                                </c:if>

                                                <c:if test="${newSeriesName!=null}">
                                                    <source src="${pageContext.request.contextPath}/userfiles/1/files/productSeries/english/${newSeriesName}/video/${bean.fileName}${bean.fileSuffix}" type="video/mp4">
                                                </c:if>
                                            </video>
                                            <p>${bean.fileName}</p>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </c:if>

                        <c:if test="${fn:length(casesImgs)>0}">
                            <!--图片案例-->
                            <div class="row">
                                <c:forEach items="${casesImgs}" var="bean">
                                    <div class="col-md-3 col-sm-4 col-xs-12">
                                        <div class="pro-case-wrap">
                                            <c:if test="${newSeriesName==null}">
                                                <img src="${pageContext.request.contextPath}/userfiles/1/files/productSeries/english/${seriesName}/images/productCase/${bean.imgName}${bean.imgSuffix}" alt="产品案例" class="img-responsive">
                                            </c:if>
                                            <c:if test="${newSeriesName!=null}">
                                                <img src="${pageContext.request.contextPath}/userfiles/1/files/productSeries/english/${newSeriesName}/images/productCase/${bean.imgName}${bean.imgSuffix}" alt="产品案例" class="img-responsive">
                                            </c:if>
                                            <p>${bean.imgName}</p>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </c:if>
                        <c:if test="${fn:length(casesVideos)==0&&fn:length(casesImgs)==0}">
                            <div class="col-xs-12 parameter-item">
                                <div class="text-center parameter-title">
                                    <h4>Customer cases should not be made public!</h4>
                                </div>
                            </div>
                        </c:if>

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

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="${ctxStatic}/js/jquery-1.10.1.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。-->
<script src="${ctxStatic}/js/bootstrap.min.js"></script>
<!-- style.js-->
<script src="${ctxStatic}/js/style.js"></script>
<!--page js-->
<script src="${ctxStatic}/js/query.js"></script>
<script src="${ctxStatic}/js/paging.js"></script>
<script>
    document.body.addEventListener('touchstart', function(){ });
</script>

</body>
</html>