<%-- 
    Document   : contact
    Created on : 27-05-2023, 18:49:33
    Author     : phanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <jsp:include page="common/plugins/link.jsp" />
        <title>Contact</title>

        <style>
            span {
                color: #999999;
            }
        </style>
    </head>
    <body>

        <!--// Main Wrapper \\-->
        <div class="sportsmagazine-main-wrapper">

            <!--// Header \\-->
            <jsp:include page="common/header/header.jsp" />
            <!--// Header \\-->

            <!--// Main Content \\-->
            <div class="sportsmagazine-main-content">

                <!--// Main Section \\-->
                <div class="sportsmagazine-main-section sportsmagazine-player-listfull">
                    <div class="container">
                        <div class="row">

                            <div class="col-md-12">
                                <div class="sportsmagazine-player sportsmagazine-player-list">
                                    <ul class="row">
                                        <c:forEach items="${data}" var="item">
                                            <li class="col-md-6">
                                                <figure><a href="#!"><img style="max-height: 286px; min-height: 286px" src="${item.images}" alt=""><i class="fa fa-link"></i></a></figure>
                                                <div class="sportsmagazine-player-list-text">

                                                    <h5><a href="#!">${item.storeName}</a></h5>
                                                    <span>Địa Chỉ: ${item.storeAddress}</span><br/>
                                                    <span>Điện Thoại: ${item.storePhone}</span><br/>
                                                    <span>Time: ${item.startWorking} - ${item.endWorking}</span>

                                                    <ul class="sportsmagazine-player-social">
                                                        <li><a href="https://www.facebook.com/phanhieu000" target="_blank" class="icon-facebook2"></a></li>
                                                        <li><a href="https://plus.google.com/" class="icon-google-plus2"></a></li>
                                                        <li><a href="#!" class=" icon-linkedin"></a></li>
                                                        <li><a href="#!" class="icon-social62"></a></li>
                                                    </ul>
                                                </div>
                                            </li>
                                        </c:forEach>
                                    </ul>
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
