<%-- 
    Document   : profile
    Created on : 23-05-2023, 18:37:06
    Author     : phanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <jsp:include page="common/plugins/link.jsp" />
        <title>Profiles</title>

    </head>
    <body>
        <jsp:useBean class="DAL.CommonForJSP" id="C"/>
        <!--// Main Wrapper \\-->
        <div class="sportsmagazine-main-wrapper">

            <!--// Header \\-->
            <jsp:include page="common/header/header.jsp" />
            <!--// Header \\-->

            <!--// Main Content \\-->
            <div class="sportsmagazine-main-content">
                <!--// Main Section \\-->
                <div class="sportsmagazine-main-section sportsmagazine-account-full">
                    <div class="container">
                        <div class="row">

                            <div class="col-md-12">
                                <!--// Tabs \\-->
                                <div class="sportsmagazine-account-tabs">
                                    <!-- Nav tabs -->
                                    <ul class="nav-tabs d-flex justify-content-center" role="tablist" >
                                        <li role="presentation" class="active">
                                            <a href="#changePass" aria-controls="changePass" role="tab" data-toggle="tab">
                                                Change Password
                                            </a>
                                        </li>
                                    </ul>
                                    <!-- Tab panes -->
                                    <div class="tab-content">
                                        <div role="tabpanel" class="tab-pane active" id="changePass">
                                            <div class="sportsmagazine-account">
                                                <form action="" method="POST" id="formChange">

                                                    <ul >
                                                        <li>
                                                            <label>Old Password</label>
                                                            <input placeholder="Enter Your Old Password"  id="oldpass" type="password" required
                                                                   onchange="checkOldPassword()">
                                                            <label id="messageOldPass"></label>
                                                        </li>
                                                        <li >
                                                            <label>New Password</label>
                                                            <input placeholder="Enter Your New Password" name="newPassword" id="newpass" type="password" required
                                                                   onchange="checkNewPassword()"
                                                                   >
                                                            <label id="messageNewPass"></label>
                                                        </li>

                                                        <li >
                                                            <label>Confirm Password</label>
                                                            <input placeholder="Enter Your New Password"  id="comfirmpass" type="password" required
                                                                   onchange="checkComfirmPassword()"
                                                                   >
                                                            <label id="messageComfirmPass"></label>
                                                        </li>
                                                        <li >
                                                            <span style="color: ${message == 'Something wrong !' ? 'red' : 'green'}">
                                                                ${message}
                                                            </span>
                                                        </li>
                                                        <br>
                                                        <li class="" style="float: unset; margin-right: auto; margin-left: auto; width: fit-content;">

                                                            <input value="Save" type="button" onclick=" checkSubmit()">

                                                        </li>
                                                    </ul>
                                                </form>
                                            </div>
                                        </div>


                                    </div>
                                </div>
                                <!--// Tabs \\-->
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
