<%-- 
    Document   : home
    Created on : 22-05-2023, 21:52:18
    Author     : phanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <jsp:include page="common/plugins/link.jsp" />
        <title>Home</title>
    </head>
    <body>

        <jsp:useBean class="DAL.PostDAO" id="postDAO" />
        <jsp:useBean class="DAL.CommonForJSP" id="common"/>
        <jsp:useBean class="DAL.AccountDAO" id="ad" />

        <!--// Main Wrapper \\-->
        <div class="sportsmagazine-main-wrapper">

            <!--// Header \\-->
            <jsp:include page="common/header/header.jsp"/>
            <!--// Header \\-->

            <!--// Main Banner \\-->
            <div class="sportsmagazine-banner">

                <!--// Slider \\-->
                <div class="sportsmagazine-banner-one">
                    <div class="sportsmagazine-banner-one-layer">
                        <img src="https://theme.hstatic.net/1000061481/1001035882/14/slideshow_3.jpg?v=144" alt="">
                    </div>
                    <div class="sportsmagazine-banner-one-layer">
                        <img src="https://theme.hstatic.net/1000061481/1001035882/14/slideshow_1.jpg?v=144" alt="">
                    </div>
                </div>
                <!--// Slider \\-->

            </div>
            <!--// Main Banner \\-->

            <!--// Main Content \\-->
            <div class="sportsmagazine-main-content">

                <!--// Main Section \\-->
                <div class="sportsmagazine-main-section">
                    <div class="container">
                        <div class="row">

                            <!--// Fixture Slider \\-->
                            <div class="col-md-12">
                                <div class="sportsmagazine-fixture-slider">
                                    <c:forEach items="${product}" var="item">
                                        <div class="sportsmagazine-fixture-slider-layer">
                                            <time datetime="2008-02-14 20:00">${item.name}</time>
                                            <ul class="sportsmagazine-bgcolor">
                                                <li class="first-child">Price: <span>${item.formatPrice} Đ</span></li>
                                                

                                            </ul>
                                        </div>
                                    </c:forEach> 
                                </div>
                            </div>
                            <!--// Fixture Slider \\-->

                            <!--// Content \\-->
                            <div class="col-md-8">

                                <!--// Fancy Title \\--> <div class="sportsmagazine-fancy-title"><h2>New Product</h2></div> <!--// Fancy Title \\-->
                                <!--// Featured Slider \\-->
                                <div class="sportsmagazine-featured-slider">
                                    <c:forEach items="${product}" var="item">
                                        <div class="sportsmagazine-featured-slider-layer">
                                            <img class="img-slider" src="views/extra-images/featured-slider-1.jpg" alt="">
                                            <span class="sportsmagazine-black-transparent"></span>
                                            <div class="sportsmagazine-featured-caption">
                                                <h2>${item.name} - ${item.category.title}</h2>
                                                <span class="sportsmagazine-color">${item.formatPrice} vnd / 1</span>
                                            </div>
                                        </div>
                                    </c:forEach>


                                </div>
                                <!--// Featured Slider \\-->

                                <!--// Fancy Title \\--> <div class="sportsmagazine-fancy-title"><h2>Latest Posts</h2></div> <!--// Fancy Title \\-->
                                <!--// Blog's \\-->
                                <div class="sportsmagazine-blog sportsmagazine-blog-grid">
                                    <ul class="row">
                                        <c:forEach items="${postDAO.getXNewPost(4)}" var="item">
                                            <li class="col-md-6">
                                                <figure>
                                                    <a href="postdetail?id=${item.id}"><img style="max-height: 30vh" src="${item.image.size() != 0 ? item.image.get(0).url : 'views/extra-images/latest-blog-3.jpg'}" alt="ss"></a>
                                                    <figcaption>
                                                        <span><small>New</small></span>
                                                        <a href="postdetail?id=${item.id}" class="sportsmagazine-link-btn"><i class="fa fa-link"></i></a>
                                                    </figcaption>
                                                </figure>
                                                <section>
                                                    <h2><a href="postdetail?id=${item.id}">${item.title}</a></h2>
                                                    <p class="hidden-content">${item.detail}</p>
                                                </section>
                                                <div class="sportsmagazine-blog-grid-options">
                                                    <a href="postdetail?id=${item.id}" class="sportsmagazine-blog-grid-thumb">Author: ${ad.getAccountByID(item.ownerID).fullName}</a>
                                                    <ul>
                                                        <li><i class="fa fa-thumbs-o-up"></i> <a href="404.html">${item.like}</a></li>
                                                        <li><i class="fa fa-eye"></i> <a href="404.html">${item.view}</a></li>
                                                    </ul>
                                                </div>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>

                                <!--// Blog's \\-->

                            </div>
                            <!--// Content \\-->

                            <!--// SideBaar \\-->
                            <aside class="col-md-4">

                                <!--// Widget TeamRanking \\-->
                                <div class="widget widget_team_ranking">
                                    <div class="sportsmagazine-fancy-title"><h2>Top Product Seller</h2></div>
                                    <div class="ranking-title-table">
                                        <ul class="ranking-title-row">
                                            <li>Name</li>
                                            <li>Price</li>
                                            <li>Seller</li>
                                        </ul>
                                    </div>
                                    <c:forEach items="${product}" var="item">
                                        <div class="ranking-content-table">
                                            <ul class="ranking-content-row">
                                                <li>${item.name}</li>
                                                <li>${item.formatPrice}</li>
                                                <li>08</li>
                                            </ul>
                                        </div>
                                    </c:forEach>


                                </div>
                                <!--// Widget TeamRanking \\-->

                                <!--// Widget Popular News \\-->
                                <div class="widget widget_popular_news">
                                    <div class="sportsmagazine-fancy-title"><h2>Popular Post</h2></div>
                                    <ul>
                                        <c:set var="no" value="0"/> 
                                        <c:forEach items="${postDAO.getTopXPopularPost(5)}" var="item">
                                            <c:set var="no" value="${no+1}"/>
                                            <li>
                                                <span>${no}</span>
                                                <div class="popular_news_text">
                                                    <a href="blog-detail.html">${item.title}</a>
                                                    <time datetime="2008-02-14 20:00">${common.formatDate(item.createDate, 'MMMM, dd-yyyy')}</time>
                                                </div>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                                <!--// Widget Popular News \\-->

                                <!--// Widget Add \\-->
                                <div class="widget widget_add">
                                    <img src="views/extra-images/add.jpg" alt="">
                                </div>
                                <!--// Widget Add \\-->

                            </aside>
                            <!--// SideBaar \\-->

                        </div>
                    </div>
                </div>
                <!--// Main Section \\-->

            </div>
            <!--// Main Content \\-->

            <!--// Footer \\-->
            <jsp:include page="common/footer/footer.jsp" />
            <!--// Footer \\-->

            <div class="clearfix"></div>
        </div>
        <!--// Main Wrapper \\-->

        <jsp:include page="common/plugins/script.jsp" />
    </body>

</html>
