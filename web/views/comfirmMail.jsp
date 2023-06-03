
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <jsp:include page="common/plugins/link.jsp" />
        <title>Comfirm Mail</title>

    </head>
    <body>

        <!--// Main Wrapper \\-->
        <div class="sportsmagazine-main-wrapper">

            <!--// Header \\-->
            <jsp:include page="common/header/header.jsp" />
            <!--// Header \\-->

            <jsp:useBean class="DAL.CommonForJSP" id="common"/>


            <!--// Main Content \\-->
            <div class="sportsmagazine-main-content">

                <!--// Main Section \\-->
                <div class="sportsmagazine-main-section sportsmagazine-contactus-full">
                    <div class="container">
                        <div class="row">

                            <div class="col-md-12">
                                <div class="sportsmagazine-fancy-title-two"><h2>Confirm Mail <span></span></h2></div>
                            </div>
                            <div class="col-md-9">
                                <div class="sportsmagazine-contact-form">
                                    <form action="" method="POST">
                                        <ul>

                                            <li>
                                                <label>Email:</label>
                                                <p>
                                                    <input placeholder="Enter Your Email" name="email" id="emailConfirm" type="text" required>
                                                    <span><i class="fa fa-envelope"></i></span>
                                                </p>
                                            </li>
                                            <li>
                                                <label>Code: </label>
                                                <p>
                                                    <input placeholder="Enter Code on Your Email" name="code"  type="text" required>
                                                    <span><i class="fa fa-keyboard-o"></i></span>
                                                </p>
                                            </li>

                                            <c:if test="${message != null}" >
                                                <span>${message}</span>

                                            </c:if> 

                                            <li class="d-flex ">
                                                <p><label><input value="Confirm" type="submit"></label></p>
                                                <!--<input value="Send Code Again !" type="button" onclick="sendMail()">-->


                                            </li>
                                        </ul>
                                    </form>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <ul class="sportsmagazine-contact-us-text">
                                    <li>
                                        <h4>Send Us Message !!!</h4>
                                        <p>Lorem ipsum dolor sit amet, consectet adipiscing elit. Ut ac malesuada antes urabitur lacinia</p>
                                    </li>
                                    <li>
                                        <h4>Open Practices</h4>
                                        <p>Lorem ipsum dolor sit amet, consectet adipiscing elit. Ut ac malesuada antes urabitur lacinia</p>
                                        <time datetime="2008-02-14 20:00">Timings: <span>9:00am to 12:00pm</span></time>
                                    </li>
                                </ul>
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
