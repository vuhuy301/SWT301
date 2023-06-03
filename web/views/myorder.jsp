
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <jsp:include page="common/plugins/link.jsp" />
        <title>My Orders</title>
    </head>
    <body>

        <!--// Main Wrapper \\-->
        <div class="sportsmagazine-main-wrapper">

            <!--// Header \\-->
            <jsp:include page="common/header/header.jsp" />
            <!--// Header \\-->

            <jsp:useBean class="DAL.CommonForJSP" id="common" />


            <!--// Main Content \\-->
            <div class="sportsmagazine-main-content">

                <!--// Main Section \\-->
                <div class="sportsmagazine-main-section sportsmagazine-wishlist-full">
                    <div class="container">
                        <div class="row">

                            <div class="col-md-12">
                                <div class="sportsmagazine-wishlist">

                                    <c:if test="${data.size() == 0}">
                                        <h2 style="text-align: center">Bạn Chưa Có Đơn Nào Hàng !</h2>
                                    </c:if>

                                    <c:if test="${data.size() != 0}">
                                        <h4>My Order (${data.size()})</h4>
                                        <div class="sportsmagazine-wishlist-graph">
                                            <ul>
                                                <li>Order ID</li>
                                                <li>Time</li>
                                                <li>Price</li>
                                                <li>Status</li>
                                            </ul>

                                            <c:forEach items="${data}" var="item">
                                                <ul class="wishlist-graph">
                                                    <li style="text-align: unset!important">
                                                        <section>
                                                            <h6>${item.oid}</h6>
                                                        </section>
                                                    </li>
                                                    <li><p>${item.createDate}</p></li>
                                                    <li style="text-align: unset!important">
                                                        ${common.getFormatPrice(item.price)} đ
                                                    </li>
                                                    <li style="text-align: unset!important; color: ${item.status == 1 ? 'green' : item.status == 2 ? 'yellow' : '#843534'}">${item.status == 1 ? 'Paid' : item.status == 2 ? 'Pending' : 'Not Yet'}</li>
                                                </ul>
                                            </c:forEach>
                                        </div>
                                    </c:if>

                                </div>
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
