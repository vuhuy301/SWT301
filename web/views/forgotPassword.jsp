<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <jsp:include page="common/plugins/link.jsp" />
        <title>Register</title>
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
                <div class="sportsmagazine-main-section sportsmagazine-login-form-full">
                    <div class="container">
                        <div class="row d-flex justify-content-center ">


                            <div class="col-md-6">
                                <div class="sportsmagazine-login-form sportsmagazine-register-form">
                                    <h4>Forgot Password !</h4>
                                    <form action="" method="POST">
                                        <ul>
                                            <li>
                                                <label class="form-label">Your Email:</label>
                                                <input type="email" placeholder="Enter Your Email" name="email" required>
                                            </li>


                                            <c:if test="${message != null }">
                                                <h5 >${message}</h5>
                                            </c:if>
                                            <li class="d-flex justify-content-center">
                                                <label class="submit-border">
                                                    <input type="submit" value="Send">
                                                    <span></span>
                                                </label>
                                            </li>
                                        </ul>
                                    </form>
                                    <span style="float: right">Not A Member Yet ?<a href="register"> Sign - Up Now !</a></span>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
                <!--// Main Section \\-->

            </div>
            <!--// Main Content \\-->


            <jsp:include page="common/footer/footer.jsp" />
            <div class="clearfix"></div>
        </div>
        <!--// Main Wrapper \\-->
        <jsp:include page="common/plugins/script.jsp" />

    </body>

</html>
