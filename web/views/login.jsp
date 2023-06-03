<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <jsp:include page="common/plugins/link.jsp" />
        <title>SportsMagazine login register</title>

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

                            <div class="col-md-6 ">
                                <div class="sportsmagazine-login-form">
                                    <h4>Login To Your Account</h4>
                                    <form action="" method="post">
                                        <ul>
                                            <li>
                                                <input type="text" placeholder="Enter Your UserName*" name="userName" required></li>
                                            <li>
                                                <input type="password" placeholder="Enter Your Password*" name="password" required>
                                                <a href="forgot-password">Forget Password?</a></li>
                                            <li class="d-flex justify-content-center">
                                                <label class="submit-border">
                                                    <input type="submit" value="Sign In">
                                                    <span></span>
                                                </label>
                                            </li>
                                            <c:if test="${requestScope.error != null}">
                                                <li>
                                                    <span style="font-size: 20px; color: red">${requestScope.error}</span>
                                                </li>
                                            </c:if>
                                        </ul>
                                    </form>

                                    <span>Not A Member Yet ?<a href="register"> Sign - Up Now !</a></span>
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
