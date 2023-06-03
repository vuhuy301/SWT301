<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="common/plugins/link.jsp" />
        <title>Posting</title>
    </head>
    <body>
        <!--// Main Wrapper \\-->
        <div class="sportsmagazine-main-wrapper">

            <!--// Header \\-->
            <jsp:include page="common/header/header.jsp" />
            <!--// Header \\-->

            <jsp:useBean class="DAL.CommonForJSP" id="common" />
            <jsp:useBean class="DAL.AccountDAO" id="ad" />
            <jsp:useBean class="DAL.PostDAO" id="postDAO" />


            <!--// Main Content \\-->
            <div class="sportsmagazine-main-content">

                <!--// Main Section \\-->
                <div class="sportsmagazine-main-section sportsmagazine-bloglarge-full">
                    <div class="container">
                        <div class="row">

                            <!--// SideBar \\-->
                            <aside class="col-md-3">

                                <!--// Widget Popular Post \\-->
                                <div class="sportsmagazine-widget-heading"><h2>Popular Posts</h2></div>
                                <div class="widget widget_popular_post">
                                    <ul>
                                        <c:forEach items="${postDAO.getTopXPopularPost(5)}" var="item">
                                            <li>
                                                <div class="sportsmagazine-popular-post">
                                                    <figure><a href="postdetail?id=${item.id}"><img style="height: 70px; width: 70px" src="${item.image.size() != 0 ? item.image.get(0).url : ''}" alt="Ảnh Post :> Bị lỗi rồi khỏi xem đi"></figure>
                                                    <div class="sportsmagazine-popular-post-text">
                                                        <h5><a href="blog-detail.html">${item.title}</a></h5>
                                                        <time datetime="2008-02-14 20:00">${common.formatDate(item.createDate, 'dd/MM/yyyy')}</time>
                                                    </div>
                                                    <span></span>
                                                </div>
                                            </li>
                                        </c:forEach> 


                                    </ul>
                                </div>
                                <!--// Widget Popular Post \\-->

                                <!--// Widget Flicker Images \\-->
                                <div class="sportsmagazine-widget-heading"><h2>Flicker Images</h2></div>
                                <div class="widget widget_gallery">
                                    <ul>
                                        <li><a data-fancybox-group="group" href="views/extra-images/flicker-image-1.jpg" class="fancybox"><img src="views/extra-images/flicker-image-1.jpg" alt=""><i class="fa fa-angle-double-right"></i></a></li>
                                        <li><a data-fancybox-group="group" href="views/extra-images/flicker-image-2.jpg" class="fancybox"><img src="views/extra-images/flicker-image-2.jpg" alt=""><i class="fa fa-angle-double-right"></i></a></li>
                                        <li><a data-fancybox-group="group" href="views/extra-images/flicker-image-3.jpg" class="fancybox"><img src="views/extra-images/flicker-image-3.jpg" alt=""><i class="fa fa-angle-double-right"></i></a></li>
                                        <li><a data-fancybox-group="group" href="views/extra-images/flicker-image-4.jpg" class="fancybox"><img src="views/extra-images/flicker-image-4.jpg" alt=""><i class="fa fa-angle-double-right"></i></a></li>
                                        <li><a data-fancybox-group="group" href="views/extra-images/flicker-image-5.jpg" class="fancybox"><img src="views/extra-images/flicker-image-5.jpg" alt=""><i class="fa fa-angle-double-right"></i></a></li>
                                        <li><a data-fancybox-group="group" href="views/extra-images/flicker-image-6.jpg" class="fancybox"><img src="views/extra-images/flicker-image-6.jpg" alt=""><i class="fa fa-angle-double-right"></i></a></li>
                                        <li><a data-fancybox-group="group" href="views/extra-images/flicker-image-7.jpg" class="fancybox"><img src="views/extra-images/flicker-image-7.jpg" alt=""><i class="fa fa-angle-double-right"></i></a></li>
                                        <li><a data-fancybox-group="group" href="views/extra-images/flicker-image-8.jpg" class="fancybox"><img src="views/extra-images/flicker-image-8.jpg" alt=""><i class="fa fa-angle-double-right"></i></a></li>
                                        <li><a data-fancybox-group="group" href="views/extra-images/flicker-image-9.jpg" class="fancybox"><img src="views/extra-images/flicker-image-9.jpg" alt=""><i class="fa fa-angle-double-right"></i></a></li>
                                    </ul>
                                </div>
                                <!--// Widget Flicker Images \\-->

                            </aside>
                            <!--// SideBar \\-->

                            <div class="col-md-9">
                                <div class="sportsmagazine-blog sportsmagazine-bloglarge">
                                    <ul class="row">
                                        <c:forEach items="${data}" var="item">
                                            <li class="col-md-12">
                                                <figure><a href="postdetail?id=${item.id}"><img style="height: 60vh" src="${item.image.size() != 0 ? item.image.get(0).url : ''}" alt="Ảnh Post :> Bị lỗi rồi khỏi xem đi"><i class="fa fa-link"></i></a></figure>
                                                <div class="sportsmagazine-bloglarge-text">
                                                    <time datetime="2008-02-14 20:00">${common.formatDate(item.createDate, 'dd/MM/yyyy')}</time>
                                                    <h3 ><a href="postdetail?id=${item.id}">${item.title}</a></h3>
                                                    <p class="hidden-content">${item.detail}</p>
                                                    <a href="postdetail?id=${item.id}" class="sportsmagazine-readmore-btn">READ MORE <i class="fa fa-arrow-circle-o-right"></i></a>
                                                    <ul class="sportsmagazine-article-options">
                                                        <li><a href="#404.html"><i class="fa fa-thumbs-o-up"></i> ${item.like}</a></li>
                                                        <li><a href="#404.html"><i class="fa fa-eye"></i> ${item.view}</a></li>
                                                        <li><a href="#404.html"><i class="fa fa-user"></i> ${ad.getAccountByID(item.ownerID).fullName}</a></li>
                                                    </ul>
                                                </div>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                                <!--// Pagination \\-->
                                <div class="sportsmagazine-pagination">
                                    <ul class="page-numbers">
                                        <li>
                                            <a class="previous page-numbers" href="post?page=${page > 1 ? page - 1 : page }">
                                                <span aria-label="Prev"><i class="fa fa-angle-left"></i></span>
                                            </a>
                                        </li>
                                        <c:forEach begin="1" end="${numberOfPage}" var="i">
                                            <li><a class="page-numbers ${i == page ? 'current' : ''}" href="post?page=${i}">${i}</a></li>
                                            </c:forEach>
                                        <li>
                                            <a class="next page-numbers" href="post?page=${page < numberOfPage ? page + 1 : page }">
                                                <span aria-label="Next"><i class="fa fa-angle-right"></i></span>
                                            </a></li>
                                    </ul>
                                </div>
                                <!--// Pagination \\-->
                            </div>


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
