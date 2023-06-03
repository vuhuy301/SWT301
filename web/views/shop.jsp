<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <jsp:include page="common/plugins/link.jsp" />
        <title>Shopping</title>
    </head>
    <body>

        <jsp:useBean class="DAL.CommonForJSP" id="common" />
        <jsp:useBean class="DAL.CategoryDAO" id="cd"/>
        <jsp:useBean class="DAL.PostDAO" id="postDao" />
        <jsp:useBean class="DAL.AccountDAO" id="ad" />

        <!--// Main Wrapper \\-->
        <div class="sportsmagazine-main-wrapper">

            <!--// Header \\-->
            <jsp:include page="common/header/header.jsp" />
            <!--// Header \\-->

            <!--// Main Content \\-->
            <div class="sportsmagazine-main-content">

                <!--// Main Section \\-->
                <div class="sportsmagazine-main-section sportsmagazine-shop-gridfull">
                    <div class="container">
                        <div class="row">

                            <!--// SideBar \\-->
                            <aside class="col-md-3">

                                <!--// Widget Cetagories \\-->
                                <div class="sportsmagazine-widget-heading"><h2>Categories</h2></div>
                                <div class="widget widget_cetagories">
                                    <c:set var="category" value="${cd.all}"/>
                                    <form action="">
                                        <ul>
                                            <c:forEach begin="0" end="${category.size() - 1}" var="i">
                                                <li>
                                                    <a href="shop?cid=${category.get(i).id}">
                                                        <input type="checkbox" name="cid" value="${category.get(i).id}"
                                                               ${categoryCheck[i] ? 'checked' : ''} onclick="this.form.submit()"
                                                               style="margin-right: 1rem">${category.get(i).title} 
                                                    </a>
                                                </li>
                                            </c:forEach>
                                        </ul>
                                    </form>
                                </div>
                                <!--// Widget Cetagories \\-->

                                <!--// Widget Popular Post \\-->
                                <div class="sportsmagazine-widget-heading"><h2>Popular Posts</h2></div>
                                <div class="widget widget_popular_post">
                                    <ul>
                                        <c:forEach items="${postDao.getTopXPopularPost(3)}" var="item">
                                            <li>
                                                <div class="sportsmagazine-popular-post">
                                                    <figure><a href="postdetail?id=${item.id}"><img src="${item.image.size() != 0 ? item.image.get(0).url : ''}" alt=""></a></figure>
                                                    <div class="sportsmagazine-popular-post-text">
                                                        <h5 ><a href="postdetail?id=${item.id}">${item.title}</a></h5>
                                                        <time datetime="2008-02-14 20:00">${common.formatDate(item.createDate, 'dd/MM/yyyy')}</time>
                                                    </div>
                                                    <span></span>
                                                </div>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                                <!--// Widget Popular Post \\-->

                            </aside>
                            <!--// SideBar \\-->

                            <div class="col-md-9">
                                <div class="sportsmagazine-shop sportsmagazine-shop-grid">
                                    <ul class="row">
                                        <c:forEach items="${data}" var="item">
                                            <li class="col-md-4">
                                                <figure>
                                                    <a href="addToCart?id=${item.id}&quantity=1&size=size&color=color"><img src="views/extra-images/shop-grid-img1.jpg" alt=""><i class="fa fa-shopping-cart"></i></a>
                                                    <div class="star-rating"><span class="star-rating-box" style="width:69%"></span></div>
                                                </figure>
                                                <section>
                                                    <h5><a href="shopdetail?id=${item.id}">${item.name}</a></h5>
                                                    <span class="price-cart"><del>${item.formatPriceFake} VND </del> ${item.formatPrice} VND</span>
                                                    <span></span>
                                                </section>
                                            </li>
                                        </c:forEach>

                                    </ul>
                                </div>
                                <!--// Pagination \\-->
                                <div class="sportsmagazine-pagination">
                                    <ul class="page-numbers">
                                        <li>
                                            <a class="previous page-numbers" href="shop?page=${page > 1 ? page - 1 : page}${categoryS != null ? "&cid=" : ""}${categoryS != null ? categoryS : ""}">
                                                <span aria-label="Next"><i class="fa fa-angle-left"></i></span></a>
                                        </li>
                                        <c:forEach begin="1" end="${numberPage}" var="i">
                                            <li><a class="page-numbers ${(page == i) ? 'current' : ''}" href="shop?page=${i}${categoryS != null ? "&cid=" : ""}${categoryS != null ? categoryS : ""}">${i}</a></li>

                                        </c:forEach>

                                        <li>
                                            <a class="next page-numbers" href="shop?page=${page < numberPage ? page + 1 : page}${categoryS != null ? "&cid=" : ""}${categoryS != null ? categoryS : ""}">
                                                <span aria-label="Next"><i class="fa fa-angle-right"></i></span>
                                            </a>
                                        </li>
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
